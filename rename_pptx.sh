#!/bin/bash
pptxfile=$1

{
  for ((i=1; i <=7; i++))
  do
    if [ $i == 1 ]; then
      cp "$pptxfile" "第01节 前提条件.pptx"
    elif [ $i == 2 ]; then
      cp "$pptxfile" "第02节 任务描述.pptx"
    elif [ $i == 3 ]; then
      cp "$pptxfile" "第03节 实现步骤.pptx"
    elif [ $i == 4 ]; then
      cp "$pptxfile" "第04节 实现思路.pptx"
    elif [ $i == 5 ]; then
      cp "$pptxfile" "第05节 关联技术.pptx"
    elif [ $i == 6 ]; then
      cp "$pptxfile" "第06节 实现指导.pptx"
    elif [ $i == 7 ]; then
      cp "$pptxfile" "第07节 提升扩展.pptx"
    fi
  done

} || {
  echo "异常，拷贝停止"
}

rm $1
mv rename_pptx.sh ../
echo "重命名完毕！"
