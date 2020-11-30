package com.oz.secure;

import com.orange.fm.ui.notification.NotificationService;
import com.oz.application.BaseApplication;
import com.oz.config.ActivityImpl;
import com.oz.config.AdConfigureImpl;
import com.oz.config.BaiduNewsImpl;
import com.oz.config.LoaderAdImpl;
import com.oz.config.WanpuImpl;
import com.oz.sdk.Sdk;
import com.oz.sdk.setting.Settings;

public class OzApplication extends BaseApplication {

    @Override
    protected void initConfig() {
        Sdk.initCfg(new ActivityImpl(), null, new WanpuImpl(),new LoaderAdImpl());
        Sdk.initNewsCfg(new BaiduNewsImpl());
        Settings.getInstance().setAutoInsertDelay(3500);

        if (Sdk.isPP()) {
//            Settings.getInstance().disableFunc(Settings.FUNC_AUTO);
            Settings.getInstance().disableFunc(Settings.FUNC_EV);
            Settings.getInstance().disableFunc(Settings.FUNC_SUGGEST_APP);
        }
    }

    @Override
    protected void initCloudConfig() {
        Sdk.initAdConfigureCtf(new AdConfigureImpl());
    }

    @Override
    protected void initNotificationService() {
        NotificationService.getInstance().init(this);

    }
}
