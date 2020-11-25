# coding=UTF-8
import collections
import os
from pathlib2 import Path
import constant
import json
import copy_file as cf
from PIL import Image


class AndroidProjectMaker(object):

    def __init__(self, m_builder):
        self.base_dir = m_builder.path
        self.excel_json = m_builder.excel_json
        self.activity_return_pkg_name = {
            '1': 'com.orange.fm.MainActivity',
            '2': 'com.orange.fm.SimpleMainActivity',
            '3': 'com.orange.fm.NewSimpleMainActivity',
            '4': 'com.orange.fm.MainActivity',
        }
        self.icon = {
            'icon1': 'icon1.png',
            'icon2': 'icon2.png',
            'icon3': 'icon3.png',
            'icon4': 'icon4.png',
            'icon5': 'icon5.png',
            'icon6': 'icon6.png',
            'icon7': 'icon7.png',
            'icon8': 'icon8.png',
            'icon9': 'icon9.png',
            'icon10': 'icon10.png',
            'icon11': '300.png',
            'icon12': 'l_ad.png'
        }
        self.ad_template = {
            'msgdtks': 'msgdtks.json',
            'mstt': 'mstt.json'
        }

    class Builder(object):

        def __init__(self):
            self.path = None
            self.excel_json = None

        def build(self):
            return AndroidProjectMaker(self).build()

        def set_base_path(self, path):
            self.path = path
            return self

        def set_excel_json(self, excel_json):
            self.excel_json = excel_json
            return self

        def get_base_path(self):
            return self.excel_json

    def build(self):

        excel_json_str = self.excel_json

        try:
            self.rename_project_dir(excel_json_str)
            dir = os.path.join(constant.base_path, constant.apps_path, constant.project_name)
            self.itertor_dir(dir, json.loads(excel_json_str))
            self.replace_icon(json.loads(excel_json_str))

        except Exception, e:
            print e
        pass

    def rename_project_dir(self, excel_json_dict):
        file = self.base_dir + "/" + constant.temp_application_name
        # print file
        if Path(file).exists():
            print '存在，重命名'
            try:
                application_name = json.loads(excel_json_dict)['APPLICATION_NAME'].encode('utf-8')
                os.rename(file, os.path.join(constant.base_path, constant.apps_path, application_name))
                constant.project_name = application_name
                print constant.project_name
            except Exception, e:
                raise e

    def itertor_dir(self, dir_path, excel_json_dict):
        try:
            # print dir_path
            for files in os.listdir(dir_path):
                name = os.path.join(dir_path, files)
                if os.path.isfile(name):
                    # print name
                    # 找到每个文件名字了
                    self.replace(name, excel_json_dict)

                else:
                    self.itertor_dir(name, excel_json_dict)
        except Exception, e:
            raise e

    def replace(self, file_path, excel_json_dict):
        try:
            file = open(file_path)
            str = file.read()

            print 'file: %s' % file.name
            if os.path.splitext(file.name)[-1][1:] == 'png' or os.path.splitext(file.name)[-1][1:] == 'pro':
                # 是图片或者proguard-rules.pro
                return

            for key, value in excel_json_dict.items():
                placeholder = '${' + key + '}'
                # print placeholder
                # 特殊需要处理的文字

                if file.name.endswith('.DS_Store'):
                    continue

                if file.name.endswith('ActivityImpl.java'):
                    # 处理ActivityImpl.java整个类代码
                    if key.encode('utf-8') == 'UITEMPLATE_STR':
                        # 处理ActivityImpl.java整个类代码
                        value = self.activity_return_pkg_name.get(excel_json_dict['UITEMPLATE'].encode('utf-8'))

                if file.name.endswith('AdConfigureImpl.java'):
                    if key.encode('utf-8') == 'DEFAULTADC':
                        # 识别不同广告json模版
                        ad_template_file = self.ad_template['msgdtks']
                        ad_template_file_name = json.loads(self.excel_json)['AD_TEMPLATE'].encode('utf-8')
                        # print ad_template_file_name
                        for i in self.ad_template:
                            if i == ad_template_file_name:
                                # print '找到了'+ ad_template_file_name
                                ad_template_file = self.ad_template[i]
                                # print ad_template_file


                        adconfigmstt_file_path = os.path.join(constant.base_path, constant.apps_path,
                                                              constant.project_name,
                                                              'adtemplate', ad_template_file)
                        adfile = open(adconfigmstt_file_path)
                        value = json.dumps(adfile.read())

                str = str.replace(placeholder.encode('utf-8'), value.encode('utf-8'))
                file = open(file_path, 'w')
                file.write(str)

            file.close()
        except Exception, e:
            raise e

    def replace_icon(self, excel_json_dict):
        '''
        # 生成三张图片
        # drawable-xxhdpi
        # splash_icon.png

        # mipmap-xxxhdpi
        # ic_launcher.png 512x512
        # ic_launcher_round.png 512x512
        :param excel_json_dict:
        :return:
        '''

        name = excel_json_dict['APP_ICON'].encode('utf-8')

        for i in self.icon:
            if self.icon.get(i) == name:
                print name

                ic_path = os.path.join(constant.base_path, constant.apps_path, constant.project_name, 'icons')
                print ic_path

                mipmap_path = os.path.join(constant.base_path, constant.apps_path, constant.project_name, 'src', 'main',
                                           'res', 'mipmap-xxxhdpi', 'ic_launcher.png')
                mipmap_round_path = os.path.join(constant.base_path, constant.apps_path, constant.project_name, 'src',
                                                 'main', 'res', 'mipmap-xxxhdpi', 'ic_launcher_round.png')
                drawable_xxhdpi = os.path.join(constant.base_path, constant.apps_path, constant.project_name, 'src',
                                               'main', 'res', 'drawable-xxhdpi', 'splash_icon.png')

                cf.copy_file(os.path.join(ic_path, name), mipmap_path)
                cf.copy_file(os.path.join(ic_path, name), mipmap_round_path)
                cf.copy_file(os.path.join(ic_path, name), drawable_xxhdpi)

                img = Image.open(drawable_xxhdpi)
                img = img.resize((200, 200), Image.ANTIALIAS)
                img.save(drawable_xxhdpi)
                break
        pass
