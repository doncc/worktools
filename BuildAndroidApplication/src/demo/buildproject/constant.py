import os
import __init__ as ini

base_path = '/Users/darkbug/Documents/Work/GitHub/worktools/BuildAndroidApplication/src/demo'

def get_base_path():
    return base_path

excel_file = os.path.join(get_base_path(), 'appTempFile', ini.file_name)
temp_application_name = 'apptemplate'
apps_path = 'apps'
old_path = os.path.join(get_base_path(), temp_application_name)
new_path = os.path.join(get_base_path(), apps_path)
project_name = ''

def set():
    global excel_file
    global temp_application_name
    global apps_path
    global old_path
    global new_path
    global project_name
    excel_file = os.path.join(get_base_path(), 'appTempFile', ini.file_name)
    temp_application_name = 'apptemplate'
    apps_path = 'apps'
    old_path = os.path.join(get_base_path(), temp_application_name)
    new_path = os.path.join(get_base_path(), apps_path)
    project_name = ''


