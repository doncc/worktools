package com.oz.config;

import android.text.TextUtils;

import com.oz.ad.AdConfigure;
import com.oz.ad.AdPosition;
import com.oz.sdk.config.ILoaderAdCfg;

public class LoaderAdImpl extends ILoaderAdCfg {

    @Override
    public String getOuterInsertAdId() {
        String id = AdConfigure.getInstance().getAdId(AdPosition.OUTER_INSERT);
        if (!TextUtils.isEmpty(id)) {
            return id;
        }
        return null;
    }

    @Override
    public String getResultInsertId() {
        String id = AdConfigure.getInstance().getAdId(AdPosition.RESULT_INSERT);
        if (!TextUtils.isEmpty(id)) {
            return id;
        }
        return null;
    }

    public String getResultId() {
        String id = AdConfigure.getInstance().getAdId(AdPosition.RESULT);
        if (!TextUtils.isEmpty(id)) {
            return id;
        }
        return null;
    }

    @Override
    public String getAutoWorkId() {
        String id = AdConfigure.getInstance().getAdId(AdPosition.AUTO_WORK);
        if (!TextUtils.isEmpty(id)) {
            return id;
        }
        return null;
    }

    @Override
    public String getAutoResultId() {
        String id = AdConfigure.getInstance().getAdId(AdPosition.AUTO_RESULT);
        if (!TextUtils.isEmpty(id)) {
            return id;
        }
        return null;
    }

    @Override
    public String getAutoInsertId() {
        String id = AdConfigure.getInstance().getAdId(AdPosition.AUTO_INSERT);
        if (!TextUtils.isEmpty(id)) {
            return id;
        }
        return null;
    }

    @Override
    public String getBuNotifyAdId() {
        String id = AdConfigure.getInstance().getAdId(AdPosition.BU);
        if (!TextUtils.isEmpty(id)) {
            return id;
        }
        return null;
    }

    @Override
    public String getInstallUninstallId() {
        String id = AdConfigure.getInstance().getAdId(AdPosition.INSTALL_UNINSTALL);
        if (!TextUtils.isEmpty(id)) {
            return id;
        }
        return null;
    }

    @Override
    public String getPhoneOverId() {
        String id = AdConfigure.getInstance().getAdId(AdPosition.PHONE_OVER);
        if (!TextUtils.isEmpty(id)) {
            return id;
        }
        return null;
    }

    public String getNewsAdId(){
        String id = AdConfigure.getInstance().getAdId(AdPosition.NEWS);
        if (!TextUtils.isEmpty(id)) {
            return id;
        }
        return null;
    }

    @Override
    public String getNewsInsertAdId() {
        String id = AdConfigure.getInstance().getAdId(AdPosition.NEWS_INSERT);
        if (!TextUtils.isEmpty(id)) {
            return id;
        }
        return null;
    }

    @Override
    public String getUnlockId() {
        String id = AdConfigure.getInstance().getAdId(AdPosition.UNLOCK);
        if (!TextUtils.isEmpty(id)) {
            return id;
        }
        return null;
    }

    public String getLockFeedId(){
        String id = AdConfigure.getInstance().getAdId(AdPosition.LOCK);
        if (!TextUtils.isEmpty(id)) {
            return id;
        }
        return null;
    }

    @Override
    public String getHomeAdId() {
        String id = AdConfigure.getInstance().getAdId(AdPosition.HOME);
        if (!TextUtils.isEmpty(id)) {
            return id;
        }
        return null;
    }

    @Override
    public String getHome1AdId() {
        String id = AdConfigure.getInstance().getAdId(AdPosition.HOME1);
        if (!TextUtils.isEmpty(id)) {
            return id;
        }
        return getHomeAdId();
    }

    @Override
    public String getHome2AdId() {
        String id = AdConfigure.getInstance().getAdId(AdPosition.HOME2);
        if (!TextUtils.isEmpty(id)) {
            return id;
        }
        return getHomeAdId();
    }

    @Override
    public String getHome3AdId() {
        String id = AdConfigure.getInstance().getAdId(AdPosition.HOME3);
        if (!TextUtils.isEmpty(id)) {
            return id;
        }
        return getHomeAdId();
    }

    @Override
    public String getHome4AdId() {
        String id = AdConfigure.getInstance().getAdId(AdPosition.HOME4);
        if (!TextUtils.isEmpty(id)) {
            return id;
        }
        return getHomeAdId();
    }

    @Override
    public String getHome5AdId() {
        String id = AdConfigure.getInstance().getAdId(AdPosition.HOME5);
        if (!TextUtils.isEmpty(id)) {
            return id;
        }
        return getHomeAdId();
    }

    @Override
    public String getHome6AdId() {
        String id = AdConfigure.getInstance().getAdId(AdPosition.HOME6);
        if (!TextUtils.isEmpty(id)) {
            return id;
        }
        return getHomeAdId();
    }

    //--------------------------
    @Override
    public String getDialogAdId() {
        String id = AdConfigure.getInstance().getAdId(AdPosition.DIALOG);
        if (!TextUtils.isEmpty(id)) {
            return id;
        }
        return null;
    }
	
    @Override
    public String getFeedInsert() {
        String id = AdConfigure.getInstance().getAdId(AdPosition.FEED_INSERT);
        if (!TextUtils.isEmpty(id)) {
            return id;
        }
        return null;
    }
	
    @Override
    public String getFirstSplashId() {
        String id = AdConfigure.getInstance().getAdId(AdPosition.SPLASH);
        if (!TextUtils.isEmpty(id)) {
            return id;
        }
        return null;
    }

    @Override
    public String getSecondSplashId() {
        String id = AdConfigure.getInstance().getAdId(AdPosition.SPLASH2);
        if (!TextUtils.isEmpty(id)) {
            return id;
        }
        return null;
    }

    @Override
    public String getAutoBoosterAdId() {
        String id = AdConfigure.getInstance().getAdId(AdPosition.AUTO_BOOSTER);
        if (!TextUtils.isEmpty(id)) {
            return id;
        }
        return null;
    }

    @Override
    public String getPowerNotifyId() {
        String id = AdConfigure.getInstance().getAdId(AdPosition.POWER_NOTIFY);
        if (!TextUtils.isEmpty(id)) {
            return id;
        }
        return null;
    }

    @Override
    public String getWifiConnectId() {
        String id = AdConfigure.getInstance().getAdId(AdPosition.WIFI_CONNECT);
        if (!TextUtils.isEmpty(id)) {
            return id;
        }
        return null;
    }

    @Override
    public String getSoftwareManagerId() {
        String id = AdConfigure.getInstance().getAdId(AdPosition.SOFTWARE_MANAGER);
        if (!TextUtils.isEmpty(id)) {
            return id;
        }
        return getHomeAdId();
    }

    @Override
    public String getDiskCleanerId() {
        String id = AdConfigure.getInstance().getAdId(AdPosition.DISK_CLEANER);
        if (!TextUtils.isEmpty(id)) {
            return id;
        }
        return getSoftwareManagerId();
    }

    @Override
    public String getAntiVirusId() {
        String id = AdConfigure.getInstance().getAdId(AdPosition.ANTI_VIRUS);
        if (!TextUtils.isEmpty(id)) {
            return id;
        }
        return getSoftwareManagerId();
    }

    @Override
    public String getWifiAccelerateId() {
        String id = AdConfigure.getInstance().getAdId(AdPosition.WIFI_ACCELERATE);
        if (!TextUtils.isEmpty(id)) {
            return id;
        }
        return getHomeAdId();
    }

    @Override
    public String getMemoryAccelerateId() {
        String id = AdConfigure.getInstance().getAdId(AdPosition.MEMORY_ACCELERATE);
        if (!TextUtils.isEmpty(id)) {
            return id;
        }
        return getSoftwareManagerId();
    }

    @Override
    public String getEvNotifyAdId() {
        String id = AdConfigure.getInstance().getAdId(AdPosition.EV);
        if (!TextUtils.isEmpty(id)) {
            return id;
        }
        return null;
    }

    @Override
    public String getRewardId() {
        return null;
    }

    @Override
    public String getFullVideoId() {
        return null;
    }

    @Override
    public String getBeautyInsertUrl() {
        return null;
    }

    @Override
    public String getDoneAd() {
        String id = AdConfigure.getInstance().getAdId(AdPosition.DONE);
        if (!TextUtils.isEmpty(id)) {
            return id;
        }
        return null;
    }

    @Override
    public String getLockAd() {
        String id = AdConfigure.getInstance().getAdId(AdPosition.LOCK_AD);
        if (!TextUtils.isEmpty(id)) {
            return id;
        }
        return null;
    }

    @Override
    public String getNotifyInsertAd() {
        String id = AdConfigure.getInstance().getAdId(AdPosition.NOTIFY_INSERT);
        if (!TextUtils.isEmpty(id)) {
            return id;
        }
        return null;
    }
}
