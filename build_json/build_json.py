# coding=utf-8
import json
import os
import re

# Custom area
root_name = "103-一扫得福"
# 调试信息开关
isOn = True

projectName = re.sub(r'(^\d*-)', '', root_name)
num = re.search(r'(^\d*)', root_name).group()
caseCode = "Android_CASE%s" % num
case_tail_code = re.search(r'(\d*)$', caseCode).group()
_sep = os.sep
module_arr = []

root_dir = os.curdir + _sep + root_name
lessons_module = []
lessons_tasks = []


def pt(str):
    """调试"""
    if isOn:
        print(str)


def read_dir_as_list(path):
    """
    读取文件夹名列表
    :param path: 要读取的路径
    :return: 文件夹名列表
    """
    arr = []
    file_list = os.listdir(path)
    file_list.sort()

    for file_name in file_list:

        if file_name.__eq__(".DS_Store"):
            continue

        if file_name.__eq__("cases.json") or file_name.__eq__("cover"):
            continue

        arr.append(file_name)
    return arr


def write_json(str):
    with open('./result.json', 'w') as f:
        f.write(str)


class RootJSON:
    """json根结构"""

    def __init__(self):
        self.caseName = projectName
        self.caseCode = caseCode
        self.caseType = [
            3
        ]
        self.caseSystem = [
            3
        ]
        self.caseCatalog = 0
        self.caseVersion = "1.0"
        self.caseAuthor = "【制作教师】"
        self.caseField = "公共"
        self.caseScale = "1-2人"
        self.casePeriod = "1-2周"
        self.caseDevLang = "Android"
        self.caseModuleCount = -1
        self.caseTaskCount = -1
        self.caseCodeCount = "【去用工具统计该死的代码数量】"
        self.caseCover = "cover/case.png"
        self.caseDescription = "【项目简介】"
        self.modules = []


class Modules:
    """章"""

    def __init__(self, moduleName):
        self.moduleName = moduleName
        self.moduleDescription = "【章简介】"
        self.tasks = []


class Tasks:
    """节"""

    def __init__(self, taskCode, taskName, taskPpt, steps):
        self.taskCode = taskCode
        self.taskName = taskName
        self.taskPpt = taskPpt
        self.steps = []


class Steps:
    """知识点"""

    def __init__(self):
        self.stepName = "【知识点名】"
        self.stepPage = "【页数】"


class Errors:
    """错误信息"""

    def __init__(self):
        self.error = "错误"


def build_json():
    """构建json结构"""

    # 得到根json结构
    _rootjson = RootJSON()

    # 得到章的数组
    global module_arr
    module_arr = read_dir_as_list(root_dir)

    # 得到节的数组
    task_arr = None

    for i in range(len(module_arr)):

        # 根json-设置章个数
        _rootjson.caseModuleCount = len(module_arr)
        # 根json-设置节个数
        _rootjson.caseTaskCount = len(module_arr) * 7

        _module_dir = module_arr[i]
        pt(_module_dir)
        # 格式化章名称，去掉"第01章 "
        module_name = re.sub(r'^第\d\d章\s', '', _module_dir)

        # 根据章个数，构建章结构
        _modules = Modules(module_name)
        _rootjson.modules.append(_modules.__dict__)

        _module_path = root_dir + _sep + _module_dir
        task_arr = read_dir_as_list(_module_path)
        pt(task_arr)

        for j in range(len(task_arr)):
            # 构建节内容

            # 节code
            _taskCode = "%s_T%s_M%s_T%s" % (
                caseCode, case_tail_code, "0%s" % (i + 1) if (i + 1) < 10 else "%d" % (i + 1), "0%s" % (j + 1))

            _tasks_dir = task_arr[j]
            # 格式化节名称，去掉"第01节 "
            _tasks_name = re.sub(r'^第\d\d节\s', '', _tasks_dir)

            # ppt路径
            _ppt_path = "%s%s%s%sppt%s%s.pdf" % (_module_dir, _sep, _tasks_dir, _sep, _sep, _tasks_dir)
            pt(_ppt_path)

            tasks = Tasks(_taskCode, _tasks_name, _ppt_path, 1)

            # TODO 改造开始
            _video_dir = root_dir + _sep + _module_dir + _sep + _tasks_dir + _sep + "video" + _sep
            # pt(_video_dir)
            if os.path.exists(_video_dir):
                _video_arr = read_dir_as_list(_video_dir)
                if 0 != len(_video_arr):
                    # # 没有video
                    # # steps = Steps()
                    # tasks.steps.append(steps.__dict__)
                    # 有video
                    for _v in _video_arr:
                        steps = Steps()
                        _video_path = "%s%s%s%svideo%s" % (_module_dir, _sep, _tasks_dir, _sep, _sep)
                        _video = "%s%s" % (_video_path, _v)
                        # video 存在，添加键值对
                        steps.video = _video
                        pt("     【video】" + _video)
                        tasks.steps.append(steps.__dict__)
                else:
                    errors = Errors()
                    errors.errorMsg = "获取视频集错误，请检查"
                    return errors
            else:
                # 没有video
                steps = Steps()
                tasks.steps.append(steps.__dict__)

            # TODO 改造结束

            # # TODO 开始
            # _video_dir = root_dir + _sep + _module_dir + _sep + _tasks_dir + _sep + "video" + _sep
            # pt(_video_dir)
            # if os.path.exists(_video_dir):
            #     if os.path.isfile(_video_dir):
            #         _video_arr = read_dir_as_list(_video_dir)
            #         for _v in _video_arr:
            #             steps = Steps()
            #             _video_path = "%s%s%s%svideo%s" % (_module_dir, _sep, _tasks_dir, _sep, _sep)
            #             _video = "%s%s" % (_video_path, _v)
            #             # video 存在，添加键值对
            #             steps.video = _video
            #             pt("     【video】" + _video)
            #             tasks.steps.append(steps.__dict__)
            #     else:
            #         errors = Errors()
            #         errors.errorMsg = "检查路径是否有video文件，错误"
            #         return errors
            # else:
            #     steps = Steps()
            #     tasks.steps.append(steps.__dict__)
            # # TODO 结束

            _modules.tasks.append(tasks.__dict__)

    return _rootjson


if __name__ == '__main__':
    _root = build_json()

    # 最终结果写入json
    write_json(json.dumps(_root.__dict__, indent=4, ensure_ascii=False))
