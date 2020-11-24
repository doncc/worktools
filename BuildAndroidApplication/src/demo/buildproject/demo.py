# file = open('../apps/ShenduClearManager/src/main/assets/user1.html')
# value = file.read().replace('${APP_NAME}', 'DONG')
# file.close()
# file = open('../apps/ShenduClearManager/src/main/assets/user1.html', 'w')
# file.write(value)
# file.close()
# print value


import os

new_path = '/Users/darkbug/Documents/Work/JavaWorkspace/TestPython/src/demo/apps/ShenduClearManager/src/main/res/mipmap-xxxhdpi/ic_launcher.png'
new_path = new_path[0: new_path.rfind('/')]

if not os.path.exists(new_path):
    os.makedirs(new_path)
