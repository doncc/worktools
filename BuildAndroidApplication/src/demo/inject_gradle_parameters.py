#!/usr/bin/python2.7

import sys
import re
import os

JENKINS_AGENT = None
JENKINS_PLATFORM1 = None
JENKINS_PLATFORM2 = None
JENKINS_COUNT = None
JENKINS_SPECIFY_PACKAGE = None
GRADLE_PATH = None

if len(sys.argv) > 1:
    print'yes'
    JENKINS_AGENT = sys.argv[1]
    JENKINS_PLATFORM1 = sys.argv[2]
    JENKINS_PLATFORM2 = sys.argv[3]
    JENKINS_COUNT = sys.argv[4]
    JENKINS_SPECIFY_PACKAGE = sys.argv[5]
    GRADLE_PATH = sys.argv[6]
else:
    print 'no'
    GRADLE_PATH = './gradle.properties'

print JENKINS_AGENT
print JENKINS_PLATFORM1
print JENKINS_PLATFORM2
print JENKINS_COUNT
print JENKINS_SPECIFY_PACKAGE

agent = r'${JENKINS_AGENT}'
platform1 = r'${JENKINS_PLATFORM1}'
platform2 = r'${JENKINS_PLATFORM2}'
count = r'${JENKINS_COUNT}'
specify_package = r'${JENKINS_SPECIFY_PACKAGE}'

f1 = open(GRADLE_PATH, 'r+')
f2 = open(GRADLE_PATH + '_temp', 'w+')


def replace(oldStr, newStr, ss):
    if newStr == None:
        return ss
    else:
        return re.sub('\\' + oldStr, newStr, ss, flags=re.I | re.S)


def open():
    for ss in f1.readlines():
        if agent in ss:
            a = replace(agent, JENKINS_AGENT, ss)
            f2.write(a)
            continue
        elif platform1 in ss:
            a = replace(platform1, JENKINS_PLATFORM1, ss)
            f2.write(a)
            continue
        elif platform2 in ss:
            a = replace(platform2, JENKINS_PLATFORM2, ss)
            f2.write(a)
            continue
        elif count in ss:
            a = replace(count, JENKINS_COUNT, ss)
            f2.write(a)
            continue
        elif specify_package in ss:
            a = replace(specify_package, JENKINS_SPECIFY_PACKAGE, ss)
            f2.write(a)
            continue
        else:
            f2.write(ss)

    f1.close()
    f2.close()


def removeOldFile():
    if os.path.exists("gradle.properties"):
        os.remove("gradle.properties")
        print("The file remove success!")
    else:
        print("The file does not exist")


def mvNewFile():
    os.rename("gradle.properties_temp", "gradle.properties")
    print("The file rename success!")


if __name__ == '__main__':
    open()
    removeOldFile()
    mvNewFile()
