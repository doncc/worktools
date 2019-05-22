#!/bin/bash

echo -e "\033[34m
********************************
***      APK内置进系统应用程序  ***
***           Darkbug        ***
*** https://github.com/doncc ***
******************************** \033[0m"

name=$1
upan=/storage/udisk0/a/

mount -o remount,rw /system
echo "已授权root"

mkdir -p /system/app/$name
echo $?

cd /system/app/$name
echo "当前路径：$(pwd)"

cp $upan$name.apk ./
echo "将[$upan$name.apk]已copy至路径：/system/app/$name/$name.apk"

chmod 777 $name.apk && chown root:root $name.apk
echo "apk已提权"

echo "当前路径：$(pwd)"
