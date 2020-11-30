# coding=UTF-8
import os
import shutil
import android_project_maker as am
import copy_file
import constant
import read_excel as re
import sys
import json

file_name = sys.argv[1]

if __name__ == "__main__":

    # 开始清理apps下所有生成过的工程
    print constant.base_path
    if not os.path.exists(constant.base_path):
        constant.base_path = os.path.abspath('..')
    constant.set()
    shutil.rmtree((os.path.join(constant.get_base_path(), constant.apps_path)))
    os.mkdir((os.path.join(constant.get_base_path(), constant.apps_path)))

    excel_json = re.read_excel(constant.excel_file,)
    re.temp_write_out_file(excel_json)
    copy_file.cpDirs(constant.old_path, constant.new_path)
    builder = am.AndroidProjectMaker.Builder().set_excel_json(excel_json).set_base_path(
        '%s/%s' % (constant.get_base_path(), constant.apps_path)).build()

    application_name = json.loads(builder.excel_json)['APPLICATION_NAME'].encode('utf-8')





    os.system('cd ../ && cd configure && ./build.sh ../apps/' + application_name)

