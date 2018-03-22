# coding=utf-8
# by Git@Darkbug
# Function: 批量移动ppt文件位置，并重命名文件
# Use: 请放在工程的根目录，py3执行本脚本
# 请在py3.3版本以上执行 #
# 此脚本是mvoe_ppt.py和rename_pptx.sh两个脚本的升级版
# -------------------------

import os.path
import shutil

BASE_PATH = os.path.abspath(os.curdir) + os.sep
DEL_DIRS_NAME = {'.idea', 'cover', '.DS_Store'}
NEW_FILE_NAMES = (
    '第01节 前提条件.pptx', '第02节 任务描述.pptx', '第03节 实现步骤.pptx', '第04节 实现思路.pptx', '第05节 关联技术.pptx', '第06节 实现指导.pptx',
    '第07节 提升扩展.pptx')


def get_all_pptx_file():
    pptfiles = [name for name in os.listdir(os.curdir)
                if name.endswith('.pptx')]

    pptfiles = sort_name_by_num(pptfiles)
    return pptfiles


def get_all_target_dir():
    dirs = [name for name in os.listdir(os.curdir)
            if os.path.isdir(os.path.join(os.curdir, name))]
    dirs = set(dirs)
    dirs = sort_name_by_num(dirs - DEL_DIRS_NAME)
    return dirs


def move_file_2_dir(ppts_list, dirs_list):
    count = 0

    if len(ppts_list) == len(dirs_list):
        for ppt, dir in zip(ppts_list, dirs_list):
            shutil.move(BASE_PATH + ppt, BASE_PATH + dir)
            # TODO 已经移动PPT完毕
            count += 1

        print('ppt文件移动完毕！共移动文件%d个' % count)
        rename_file(dirs_list)
    else:
        print('''读取ppt文件或文件夹失败！
        ppt数量：%s
        文件夹数量：%s
        脚本运行结束！''' % (len(ppts_list), len(dirs_list)))
        return None


def rename_file(dirs_list):
    count = 0

    for chapterdir in dirs_list:
        ppt_base_path = BASE_PATH + chapterdir + os.sep

        pptfiles = sort_name_by_num([name for name in os.listdir(ppt_base_path)
                                     if name.endswith('.pptx')])
        for newppt in NEW_FILE_NAMES:
            shutil.copy(ppt_base_path + pptfiles[0], ppt_base_path + newppt)
            count += 1

        os.remove(ppt_base_path + pptfiles[0])

    print('ppt文件重命名完毕！共重命名文件%d个' % count)


def sort_name_by_num(str_arr):
    return sorted(str_arr, key=lambda x: (x.isdigit() and int(x) % 2 == 0, x))


if __name__ == '__main__':
    ppts_list = get_all_pptx_file()
    dirs_list = get_all_target_dir()
    move_file_2_dir(ppts_list, dirs_list)
