# coding=UTF-8
import xlrd
import json

import constant

def read_excel(file):
    data = xlrd.open_workbook(file)
    table = data.sheets()[0]
    nrows = table.nrows
    returnData = {}

    for i in range(nrows):
        content = table.row_values(i)

        # xlrd转换日期格式
        if content[0].strip() == 'CREATE_DATA':
            content[1] = str(xlrd.xldate.xldate_as_datetime(content[1], 0).strftime('%Y/%m/%d'))

        if isinstance(content[1], float):
            content[1] = str(int(content[1]))

        returnData[content[0]] = content[1]

    returnJson = json.dumps(returnData, ensure_ascii=False)
    returnJson = str(returnJson.encode('utf-8'))
    return returnJson

def temp_write_out_file(res_json):
    # 临时写入
    tempJsonFile = open('%s/appTempFile/excel.json' % (constant.base_path), 'w')
    tempJsonFile.writelines(res_json)
    tempJsonFile.close()
    # 临时写入-end
