package com.oz.config;

import com.oz.sdk.config.IActivityCfg;

public class ActivityImpl implements IActivityCfg {
    @Override
    public String getMainClassName() {
        return "${UITEMPLATE_STR}";
//        return "com.orange.fm.MainActivity";
//        return "com.orange.fm.SimpleMainActivity";
//        return "com.orange.fm.NewSimpleMainActivity";
    }
}
