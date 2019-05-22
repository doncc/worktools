#!/bin/bash

echo -e "\033[34m
********************************
***       APK签名、上传工具  ***
***           Darkbug        ***
*** https://github.com/doncc ***
******************************** \033[0m"

ip=192.168.3.131 #//要上传的电视的ip

baseApk=HaierMember-TV_branch_release_1.0.0_16777216_20190327.apk.apk
newApk=HaierMemberTV.apk
signPath=/Users/doncc/Desktop/sign/input
pushApkErrorMsg="adb: error: failed to get feature set: device offline";

cd /Users/doncc/Documents/Work/Haier/zy/HaierMemberTV/app/build/outputs/apk/debug/HaierMember-TV_feature
echo "当前路径: $(pwd)"
echo "移动apk文件到 $signPath"
mv $baseApk $signPath
# echo "当前路径: $(pwd)"
cd $signPath
cd ..
echo "当前路径: $(pwd)，执行签名操作"
java -jar signapk.jar haier.platform.x509.pem haier.platform.pk8 input/$baseApk output/$newApk
cd output/
echo "签名完毕，内容：$(ll | grep 'HaierMemberTV.apk')"

echo "上传至海尔电视 $ip 的 /mnt/sdcard/a 路径"

result=$(adb -s $ip push $newApk /mnt/sdcard/a)

if [ "$result" != "$pushApkErrorMsg" ]; then
    echo "apk成功上传到电视 $ip 的 /mnt/sdcard/a 路径！"
    rm /Users/doncc/Desktop/sign/input/$baseApk
    rm /Users/doncc/Desktop/sign/output/$newApk
else
    echo "apk上传失败，adb已断开连接，需要重新连接"
fi

cd ~/Desktop
