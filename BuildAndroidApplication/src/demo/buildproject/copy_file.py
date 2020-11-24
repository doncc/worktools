# coding=UTF-8
import os
import shutil
import constant


# 通过校验MD5 判断B内的文件与A 不同
def get_MD5(file_path):
    files_md5 = os.popen('md5 %s' % file_path).read().strip()
    file_md5 = files_md5.replace('MD5 (%s) = ' % file_path, '')
    return file_md5


# 拷贝整个目录及内容至新目录
def cpDirs(old_path, new_path):
    if os.path.exists(os.path.join(new_path , constant.temp_application_name)):
        print 'apps下存在,不创建'
        return

    for files in os.listdir(old_path):
        name = os.path.join(old_path, files)
        back_name = os.path.join(new_path, files)
        if os.path.isfile(name):
            if os.path.isfile(back_name):
                if get_MD5(name) != get_MD5(back_name):
                    shutil.copy(name, back_name)
            else:
                shutil.copy(name, back_name)
        else:
            if not os.path.isdir(back_name):
                os.makedirs(back_name)
            cpDirs(name, back_name)


def copy_file(old_path, new_path):

    temp_path = new_path[0: new_path.rfind('/')]
    if not os.path.exists(temp_path):
        os.makedirs(temp_path)

    shutil.copy2(old_path, new_path)
