package com.oz.config;

import com.oz.sdk.Sdk;
import com.oz.sdk.config.IAdConfigureCtg;

public class AdConfigureImpl extends IAdConfigureCtg {
    private static final int version = 0;
    private static final String testAdc = "";
    private static final String ppAdc = "";
    private static final String defaultAdc = "{\n  \"s_outer_ad_g\":\"0\",\n  \"s_inner_ad_g\":\"0\",\n  \"s_lock_ad_g\":\"0\",\n  \"s_unlock_ad_g\":\"0\",\n  \"s_Inter_ad_g\":\"0\",\n  \"s_auto_inter_ad_g\":\"0\",\n  \"s_auto_feed_ad_g\":\"0\",\n  \"s_news_ad_g\":\"0\",\n  \"s_ab_ad_guide\":\"0\",\n  \"s_po_ad_guide\":\"0\",\n  \"s_pn_ad_guide\":\"0\",\n  \"s_in_un_ad_guide\":\"0\",\n  \"s_result_ad_guide\":\"0\",\n  \"s_wifi_ad_guide\":\"0\",\n\n  \"a_i_tt\": \"\",\n  \"a_i_ks\": \"519700041\",\n  \"a_i_gdt\": \"1111242272\",\n  \"a_i_ms\": \"102783\",\n\n  \"ad_p_splash\":\"s_a_m_i_s:1016351\",\n  \"ad_p_splash2\":\"s_a_g_i_s:7071946420750136\",\n  \"ad_p_splash_inner\":\"s_a_g_i_s:7071946420750136=s_a_k_i_s:5197001465\",\n\n  \"ad_p_home\":\"n_a_m_f_o:1016354-n_a_m_f_o:1016354=n_a_g_n_o:8011045430957942-n_a_k_f_o:5197001470\",\n  \"ad_p_home1\":\"n_a_m_f_o:1016354-n_a_m_f_o:1016354=n_a_g_n_o:8011045430957942-n_a_k_f_o:5197001470\",\n  \"ad_p_home2\":\"n_a_m_f_o:1016354-n_a_m_f_o:1016354=n_a_g_n_o:8011045430957942-n_a_k_f_o:5197001470\",\n  \"ad_p_home3\":\"n_a_m_f_o:1016354-n_a_m_f_o:1016354=n_a_g_n_o:8011045430957942-n_a_k_f_o:5197001470\",\n  \"ad_p_home4\":\"n_a_m_f_o:1016354-n_a_m_f_o:1016354=n_a_g_n_o:8011045430957942-n_a_k_f_o:5197001470\",\n  \"ad_p_home5\":\"n_a_m_f_o:1016354-n_a_m_f_o:1016354=n_a_g_n_o:8011045430957942-n_a_k_f_o:5197001470\",\n  \"ad_p_home6\":\"n_a_m_f_o:1016354-n_a_m_f_o:1016354=n_a_g_n_o:8011045430957942-n_a_k_f_o:5197001470\",\n\n  \"ad_p_s_m\":\"n_a_m_f_o:1016354-n_a_m_f_o:1016354=n_a_k_f_o:5197001483-n_a_g_n_o:8011045430957942-n_a_k_f_o:5197001470\",\n  \"ad_p_result\":\"n_a_m_f_o:1016355-n_a_m_f_o:1016355=n_a_k_f_o:5197001484-n_a_g_n_o:8011045430957942-n_a_k_f_o:5197001470\",\n  \"ad_p_news\":\"n_a_m_f_o:1016356-n_a_m_f_o:1016356=n_a_k_f_o:5197001485-n_a_g_n_o:8011045430957942-n_a_k_f_o:5197001470\",\n  \"ad_p_dialog\":\"n_a_m_f_o:1016357=n_a_g_n_o:8011045430957942-n_a_k_f_o:5197001470\",\n  \"ad_p_auto_insert\":\"i_s_g_i_t:1001141490958951-i_s_g_i_t:1001141490958951\",\n  \"ad_p_auto_work\":\"n_a_m_f_o:1016358=n_a_k_f_o:5197001479-n_a_g_n_o:8011045430957942-n_a_k_f_o:5197001470\",\n  \"ad_p_auto_result\":\"n_a_m_f_o:1016359=n_a_k_f_o:5197001480-n_a_g_n_o:8011045430957942-n_a_k_f_o:5197001470\",\n  \"ad_p_feed_insert\":\"i_s_k_i_v:5197001468-i_s_k_i_v:5197001468=i_s_k_i_v:5197001473-i_s_g_i_t:1001141490958951\",\n  \"ad_p_result_insert\":\"i_s_k_i_v:5197001468-i_s_k_i_v:5197001468=i_s_k_i_v:5197001473-i_s_g_i_t:1001141490958951\",\n  \"ad_p_done_ad\":\"i_s_k_i_v:5197001468-i_s_k_i_v:5197001468-i_s_g_i_t:1001141490958951\",\n  \"ad_p_news_insert\":\"i_s_g_i_t:1001141490958951-i_s_g_i_t:1001141490958951\",\n\n  \"ad_p_i_u\":\"n_a_m_f_o:1016360=n_a_k_f_o:5197001471-n_a_g_n_o:8011045430957942-n_a_k_f_o:5197001470\",\n  \"ad_p_lock\":\"n_a_m_f_o:1016361-n_a_m_f_o:1016361-n_a_m_f_o:1016361-n_a_g_n_o:1041941420353984=n_a_g_n_o:8011045430957942-n_a_k_f_o:5197001470\",\n  \"ad_p_auto_booster\":\"i_s_g_i_t:7021849470062111=n_a_g_n_o:8011045430957942-n_a_k_f_o:5197001470\",\n  \"ad_p_unlock\":\"i_s_k_i_v:5197001481-i_s_g_i_v:8031744460461187=n_a_g_n_o:8011045430957942-n_a_k_f_o:5197001470\",\n  \"un_count\": \"50\",\n  \"un_t\": \"60000\",\n\n  \"ad_p_phone_over\":\"n_a_m_f_o:1016362-n_a_k_f_o:5197001477-n_a_g_n_o:8011045430957942-n_a_k_f_o:5197001470\",\n  \"ad_p_wifi_connect\":\"n_a_m_f_o:1016362-n_a_k_f_o:5197001477-n_a_g_n_o:8011045430957942-n_a_k_f_o:5197001470\",\n  \"ad_p_bu\":\"n_a_m_f_o:1016362-n_a_k_f_o:5197001477-n_a_g_n_o:8011045430957942-n_a_k_f_o:5197001470\",\n  \"ad_p_power_notify\":\"n_a_m_f_o:1016362-n_a_k_f_o:5197001477-n_a_g_n_o:8011045430957942-n_a_k_f_o:5197001470\",\n  \"ad_p_exit\":\"n_a_m_f_o:1016354=n_a_g_n_o:8011045430957942-n_a_k_f_o:5197001470\",\n  \"ad_p_idle\":\"i_s_c_i_t:=i_s_g_i_t:1001141490958951\",\n\n  \"ad_p_ev\":\"n_a_m_f_o:1016363-n_a_m_f_o:1016363=n_a_k_f_o:5197001470\",\n  \"ad_p_ev_gdt\":\"n_a_m_f_o:1016363-n_a_m_f_o:1016363=n_a_g_n_o:8011045430957942-n_a_k_f_o:5197001470\",\n  \"ad_p_ev_ks\":\"n_a_k_f_o:5197001467-n_a_k_f_o:5197001467=n_a_g_n_o:8011045430957942-n_a_k_f_o:5197001470\",\n\n  \"ad_p_notify_insert\":\"i_s_g_i_t:1001141490958951\",\n\n  \"ad_p_app_out\":\"i_s_k_i_v:5197001473-i_s_k_i_v:5197001473=i_s_k_i_v:5197001474-i_s_g_i_t:1001141490958951\",\n  \"a_o_i\":\"120000\",\n  \"a_o_c\":\"15\",\n\n  \"ad_p_outer_insert\":\"i_s_k_i_v:5197001473-i_s_k_i_v:5197001473=i_s_k_i_v:5197001474-i_s_k_i_v:5197001475-i_s_k_i_v:5197001476-i_s_g_i_t:1001141490958951\",\n  \"max_oi_count\":\"27\",\n\n  \"ad_p_outer_insert_g\":\"i_s_g_i_v:9031645410951945-i_s_g_i_v:9031645410951945=i_s_k_i_v:5197001474-i_s_k_i_v:5197001475-i_s_k_i_v:5197001476-i_s_g_i_t:1001141490958951\",\n  \"max_oi_g_count\":\"22\",\n\n  \"en_ev_oi\":\"1\",\n  \"en_ab_oi\":\"1\",\n\n  \"ad_p_n_s_1\":\"n_a_m_f_o:1016352\",\n  \"ad_p_n_s_2\":\"n_a_m_f_o:1016353\",\n\n  \"ad_draw_video\": \"\",\n  \"ad_full_video\": \"i_s_k_i_v:5197001468\",\n  \"ad_r_video\": \"r_w_g_i_v:1031543411318117\",\n  \"v_flow\": \"https://cpu.baidu.com/1085/d08603ee?scid=43408\",\n\n  \"ad_p_splash_insert\":\"s_a_g_i_s:5051842430355977-s_a_g_i_s:5051842430355977-s_a_g_i_s:5051842430355977-s_a_k_i_s:5197001478=s_a_g_i_s:5051842430355977\",\n  \"s_i_count\":\"15\",\n  \"s_i_t\":\"180000\",\n  \"s_i_e_d_l\": \"1\",\n\n  \"tt_ev_count\": \"30\",\n  \"ks_ev_count\": \"20\",\n  \"gdt_ev_count\": \"30\",\n\n  \"fun_auto_enable\":\"1\",\n  \"s_ad_dot\":\"1\"\n}";

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
