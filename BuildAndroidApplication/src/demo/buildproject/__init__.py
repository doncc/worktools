# coding=UTF-8
import os
import sys

import android_project_maker as am
import constant
import copy_file
import read_excel as re

file_name = sys.argv[1] #excel文件全名
JENKINS_QUDAOS = sys.argv[2] #["HW","WX","GDT",2,-1];["XM","WX","GDT",1,-1]
IS_DEBUG_MODE = sys.argv[3] #true or false

if __name__ == "__main__":

    if not os.path.exists(constant.base_path):
        constant.base_path = os.path.abspath('')
    constant.set()

    # 开始清理apps下所有生成过的工程

    appAbsPath = os.path.join(constant.get_base_path(), constant.apps_path)

    if not os.path.exists(appAbsPath):
        os.makedirs(appAbsPath)
    else:
        print 'app path exist'

    excel_json = re.read_excel(constant.excel_file)

    re.temp_write_out_file(excel_json)
    copy_file.cpDirs(constant.old_path, constant.new_path)
    builder = am.AndroidProjectMaker.Builder().set_excel_json(excel_json).set_base_path(
        '%s/%s' % (constant.get_base_path(), constant.apps_path)).set_qudaos(JENKINS_QUDAOS).build(IS_DEBUG_MODE)

