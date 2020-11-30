#!/usr/bin/python2.7
# coding=utf-8
import os
import re


class inject(object):
    JENKINS_AGENT = None
    JENKINS_PLATFORM1 = None
    JENKINS_PLATFORM2 = None
    JENKINS_COUNT = None
    JENKINS_SPECIFY_PACKAGE = None
    JENKINS_GRADLE_FILE = './gradle.properties'
    JENKINS_GRADLE_FILE_TEMP = './gradle.properties_temp'

    agent = r'${JENKINS_AGENT}'
    platform1 = r'${JENKINS_PLATFORM1}'
    platform2 = r'${JENKINS_PLATFORM2}'
    count = r'${JENKINS_COUNT}'
    specify_package = r'${JENKINS_SPECIFY_PACKAGE}'

    def __init__(self):
        self._agent_list = ''
        self._platform1_list = ''
        self._platform2_list = ''
        self._count_list = ''
        self._specify_package_list = ''
        self.f1 = None
        self.f2 = None

    def replace(self, oldStr, newStr, ss):
        if newStr == None:
            return None
        else:
            return re.sub('\\' + oldStr, newStr, ss, flags=re.I | re.S)

    def open(self):
        for ss in self.f1.readlines():
            if inject.agent in ss:
                a = self.replace(inject.agent, inject.JENKINS_AGENT, ss)
                self.f2.write(a)
                continue
            elif inject.platform1 in ss:
                a = self.replace(inject.platform1, inject.JENKINS_PLATFORM1, ss)
                self.f2.write(a)
                continue
            elif inject.platform2 in ss:
                a = self.replace(inject.platform2, inject.JENKINS_PLATFORM2, ss)
                self.f2.write(a)
                continue
            elif inject.count in ss:
                a = self.replace(inject.count, inject.JENKINS_COUNT, ss)
                self.f2.write(a)
                continue
            elif inject.specify_package in ss:
                a = self.replace(inject.specify_package, inject.JENKINS_SPECIFY_PACKAGE, ss)
                self.f2.write(a)
                continue
            else:
                self.f2.write(ss)

        self.f1.close()
        self.f2.close()

    def removeOldFile(self):
        if os.path.exists(inject.JENKINS_GRADLE_FILE):
            os.remove(inject.JENKINS_GRADLE_FILE)
            print("The file remove success!")
        else:
            print("The file does not exist")

    def mvNewFile(self):
        os.rename(inject.JENKINS_GRADLE_FILE_TEMP, inject.JENKINS_GRADLE_FILE)
        print("The file rename success!")

    def inject_params(self, _qudaos=None):
        print _qudaos

        self.f1 = open(inject.JENKINS_GRADLE_FILE, 'r+')
        self.f2 = open(inject.JENKINS_GRADLE_FILE + '_temp', 'w+')

        self.set_gradle_params(_qudaos)
        self.open()
        self.removeOldFile()
        self.mvNewFile()

    def set_gradle_params(self, _qudaos=None):

        if _qudaos == '':
            inject.JENKINS_AGENT = ''
            inject.JENKINS_PLATFORM1 = ''
            inject.JENKINS_PLATFORM2 = ''
            inject.JENKINS_COUNT = ''
            inject.JENKINS_SPECIFY_PACKAGE = ''
            return

        list = _qudaos.split(';')

        for qudao in list:
            self._agent_list += qudao[1:-1].split(',')[0] + ','
            self._platform1_list += qudao[1:-1].split(',')[1] + ','
            self._platform2_list += qudao[1:-1].split(',')[2] + ','
            self._count_list += qudao[1:-1].split(',')[3] + ','
            self._specify_package_list += qudao[1:-1].split(',')[4] + ','

            # print qudao_list
        print '取到参数'
        print self._agent_list[:-1]
        print self._platform1_list[:-1]
        print self._platform2_list[:-1]
        print self._count_list[:-1]
        print self._specify_package_list[:-1]

        inject.JENKINS_AGENT = self._agent_list[:-1]
        inject.JENKINS_PLATFORM1 = self._platform1_list[:-1]
        inject.JENKINS_PLATFORM2 = self._platform2_list[:-1]
        inject.JENKINS_COUNT = self._count_list[:-1]
        inject.JENKINS_SPECIFY_PACKAGE = self._specify_package_list[:-1]

        pass
