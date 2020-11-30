# coding=UTF-8
import os
import sys

import android_project_maker as am
import constant
import copy_file
import read_excel as re

file_name = sys.argv[1]

if __name__ == "__main__":

    # 开始清理apps下所有生成过的工程
    if not os.path.exists(constant.base_path):
        constant.base_path = os.path.abspath('..')
    constant.set()

    appAbsPath = os.path.join(constant.get_base_path(), constant.apps_path)

    if not os.path.exists(appAbsPath):
        os.makedirs(appAbsPath)
    else:
        print 'app path exist'

    # shutil.rmtree((os.path.join(constant.get_base_path(), constant.apps_path)))
    # os.mkdir((os.path.join(constant.get_base_path(), constant.apps_path)))

    excel_json = re.read_excel(constant.excel_file,)
    re.temp_write_out_file(excel_json)
    copy_file.cpDirs(constant.old_path, constant.new_path)
    builder = am.AndroidProjectMaker.Builder().set_excel_json(excel_json).set_base_path(
        '%s/%s' % (constant.get_base_path(), constant.apps_path)).build()
