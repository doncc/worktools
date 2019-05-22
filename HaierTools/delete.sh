#!/bin/bash

pm uninstall com.haier.tv.hm
mount -o remount,rw /system && cd /system/app/HaierMemberTV
rm *
rm -rf /data/data/com.haier.tv.hm
rm -rf /data/app/com.haier.tv.hm-1
rm -rf /data/app/com.haier.tv.hm-2
rm /data/fh/com.haier.tv.hm
