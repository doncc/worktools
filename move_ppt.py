# coding=utf-8
# by Git@Darkbug
# Function: 批量移动文件位置
# Use: 放在要整理的文件夹的根目录，执行python move_ppt.py
#-------------------------
# 适用范围:
#   原格式：
# └── 第01章xxx设计
#    ├── 第01节
#    │   └── ppt
#    ├── 第01节.pptx
#    ├── 第02节
#    │   └── ppt
#    ├── 第02节.pptx
#
#   目标格式：
#└── 第01章xxx的设计
#    ├── 第01节
#    │   └── ppt
#    │       └── 第01节.pptx
#    └── 第02节
#        └── ppt
#            └── 第02节.pptx
#-------------------------

import os

root_path = './'
sep = os.path.sep


def get_dir_ppt_files():
    for root_dir in os.listdir(root_path):
        if root_dir.__eq__("move_ppt.py") or root_dir.__eq__(".DS_Store"):
            continue

        capter_dir = root_path + root_dir

        if os.path.exists(capter_dir):

            if os.path.isdir(capter_dir):

                ppt_files = [name for name in os.listdir(capter_dir)
                             if os.path.isfile(os.path.join(capter_dir, name))]

                if not ppt_files:
                    print("%s\tppt文件已转移完毕!" % (capter_dir.__str__()))
                    continue

                print("所有ppt文件：" + ppt_files.__str__())

                move_end_ppt_files_dir = [name for name in os.listdir(capter_dir)
                                          if os.path.isdir(os.path.join(capter_dir, name))]

                for ppt_file in ppt_files:

                    section_name = ppt_file.replace('.pptx', '')
                    if section_name in move_end_ppt_files_dir:

                        start_file = capter_dir + sep + ppt_file
                        end_file = capter_dir + sep + section_name + sep + "ppt" + sep

                        if not start_file and not end_file:
                            # 都为空,该停止执行
                            break
                        else:
                            shell_str = "mv '%s' '%s'" % (start_file, end_file)
                            print("shell：%s" % (shell_str))
                            os.system(shell_str)

        else:
            print("章不存在，结束")
            break


if __name__ == '__main__':
    get_dir_ppt_files()
