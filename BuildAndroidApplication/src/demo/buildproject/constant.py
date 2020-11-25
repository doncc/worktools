import os
import __init__ as ini

base_path = '/Users/darkbug/Documents/Work/GitHub/worktools/BuildAndroidApplication/src/demo'
excel_file = os.path.join(base_path, 'appTempFile', ini.file_name)
temp_application_name = 'apptemplate'
apps_path = 'apps'
old_path = os.path.join(base_path, temp_application_name)
new_path = os.path.join(base_path, apps_path)
project_name = ''
