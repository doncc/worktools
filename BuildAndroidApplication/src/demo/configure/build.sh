#!/bin/bash

export projectDir=$(cd $1; pwd)
buildDir="$projectDir/build"
echo "Build release official apk  buildDir=$buildDir"

# 以下构建release apk
cd $buildDir
# 记录当前时间文件
echo "Build release official apk  $projectDir"
cd $projectDir
# invoke gradlew to build the apk

targetApplicationName="$2"
agent="$3"
platform1="$4"
platform2="$5"
count="$6"
specify_package="$7"

rm -rf ../../jiagu/output/*


#--------------------------如果加固失败，注视掉下面两行编译命令，重新加固-------------------------------------------
touch timestampFile

../../gradlew -PtargetApplicationName=$targetApplicationName -PJENKINS_AGENT=$JENKINS_AGENT -PJENKINS_AGENT=$agent -PJENKINS_PLATFORM1=$platform1 -PJENKINS_PLATFORM2=$platform2 -PJENKINS_COUNT=$count -PJENKINS_SPECIFY_PACKAGE=$specify_package clean resguardRelease || exit 1
# 寻找构建完成的apk 并且对比时间，表明是此次最新构建apk

targetApk=$(find $buildDir -name "*release.apk" -newer $projectDir/timestampFile)
echo "Build release targetApk=$targetApk"

if [ ! -n "$targetApk" ]; then
  echo "Apk is not changed. Exit"
  exit 0
fi


cd ../../jiagu

# 360加固登陆并且开始加固（未作签名） 以下java命令为360加固官网提供，大家可以去查阅，有许多功能

java -jar jiagu.jar -login 袍泽汇鑫 paozehuixin2019
# remove unnecessary service config
java -jar jiagu.jar -config -
# process

mkdir -p output

echo "创建文件夹成功 $output"

#for file in $(find output -name "*"); do
#  rm $file;
#done
echo "Start process $targetApk"


for line in $targetApk
do
    echo "开始签名 $line"
    beforeApk="${line:0:${#line}-4}**"
    beforeApk=${beforeApk##*/}
    echo "开始签名  之前的apk=$beforeApk"

    java -jar jiagu.jar -jiagu $line output || exit 1
    enhancedApk=$(find output -name $beforeApk)
    echo "解析签名之前的apk=$enhancedApk"

    signApk="${enhancedApk:0:${#enhancedApk}-4}_sign.apk"

    echo "开始签名 $signApk"


    jarsigner -verbose -keystore oz.keystore  -signedjar $signApk $enhancedApk xie -digestalg SHA1 -sigalg MD5withRSA -storepass xie187166772

    rm $enhancedApk
done

#移动mapping路径
cd $projectDir
cd ../../appTempFile

app_name=cat excel.json | jq '.APPLICATION_NAME'
echo '找到工程名称:'$app_name
cp -r $projectDir/build/outputs/mapping/. $projectDir/../../jiagu/output/mapping/