package com.oz.config;

import com.oz.sdk.Sdk;
import com.oz.sdk.config.IAdConfigureCtg;

public class AdConfigureImpl extends IAdConfigureCtg {
    private static final int version = 0;
    private static final String testAdc = "";
    private static final String ppAdc = "";
    private static final String defaultAdc = ${DEFAULTADC};

    @Override
    public String getDefaultAdc() {
        if (Sdk.isTest()) {
            return testAdc;
        }
        if (Sdk.isPP() || Sdk.isStore()) {
            return null;
        }
        // mix
        return defaultAdc;
    }

    @Override
    public String getDefaultAdP() {
        return null;
    }

    @Override
    public String getDefaultAdG() {
        return null;
    }

    @Override
    public int getDefaultAdPVersion() {
        return 0;
    }

    @Override
    public int getDefaultAdGVersion() {
        return 0;
    }

    @Override
    public String getConfigureVersion() {
        if (version > 0) {
            return version + "." + super.getConfigureVersion();
        } else {
            return super.getConfigureVersion();
        }
    }
}
