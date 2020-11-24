package com.oz.config;

import com.oz.sdk.Sdk;
import com.oz.sdk.config.IAdConfigureCtg;

public class AdConfigureImpl extends IAdConfigureCtg {
    private static final int version = 0;
    private static final String testAdc = "";
    private static final String ppAdc = "";
    private static final String defaultAdc = "{\n  \"s_outer_ad_g\":\"0\",\n  \"s_inner_ad_g\":\"0\",\n  \"s_lock_ad_g\":\"0\",\n  \"s_unlock_ad_g\":\"0\",\n  \"s_Inter_ad_g\":\"0\",\n  \"s_auto_inter_ad_g\":\"0\",\n  \"s_auto_feed_ad_g\":\"0\",\n  \"s_news_ad_g\":\"0\",\n  \"s_ab_ad_guide\":\"0\",\n  \"s_po_ad_guide\":\"0\",\n  \"s_pn_ad_guide\":\"0\",\n  \"s_in_un_ad_guide\":\"0\",\n  \"s_result_ad_guide\":\"0\",\n  \"s_wifi_ad_guide\":\"0\",\n\n  \"a_i_tt\": \"5118686\",\n  \"a_i_ks\": \"519700086\",\n  \"a_i_gdt\": \"1111177750\",\n  \"a_i_ms\": \"102676\",\n\n  \"ad_p_splash\":\"s_a_m_i_s:1015457\",\n  \"ad_p_splash2\":\"s_a_g_i_s:2001342025164962=s_a_k_i_s:5197001157\",\n  \"ad_p_splash_inner\":\"s_a_c_i_s:887401243=s_a_g_i_s:2001342025164962\",\n\n  \"ad_p_home\":\"i_s_c_i_t_c:945600795-i_s_c_i_t_c:945600795-n_a_m_f_o:1015462=n_a_c_i_t:945600819-n_a_g_n_o:1001147055673205-n_a_k_f_o:5197001164\",\n  \"ad_p_home1\":\"n_a_m_f_o:1015462-i_s_c_i_t_c:945600795=n_a_c_i_t:945600819-n_a_g_n_o:1001147055673205-n_a_k_f_o:5197001164\",\n  \"ad_p_home2\":\"i_s_c_i_t_c:945600795-n_a_m_f_o:1015462=n_a_c_i_t:945600819-n_a_g_n_o:1001147055673205-n_a_k_f_o:5197001164\",\n  \"ad_p_home3\":\"n_a_m_f_o:1015462-i_s_c_i_t_c:945600795=n_a_c_i_t:945600819-n_a_g_n_o:1001147055673205-n_a_k_f_o:5197001164\",\n  \"ad_p_home4\":\"i_s_c_i_t_c:945600795-n_a_m_f_o:1015462=n_a_c_i_t:945600819-n_a_g_n_o:1001147055673205-n_a_k_f_o:5197001164\",\n  \"ad_p_home5\":\"n_a_m_f_o:1015462-i_s_c_i_t_c:945600795=n_a_c_i_t:945600819-n_a_g_n_o:1001147055673205-n_a_k_f_o:5197001164\",\n  \"ad_p_home6\":\"i_s_c_i_t_c:945600795-n_a_m_f_o:1015462=n_a_c_i_t:945600819-n_a_g_n_o:1001147055673205-n_a_k_f_o:5197001164\",\n\n  \"ad_p_s_m\":\"i_s_c_i_t_c:945600795-i_s_c_i_t_c:945600795-n_a_m_f_o:1015462-n_a_c_i_t:945600819-n_a_g_n_o:1001147055673205-n_a_k_f_o:5197001164\",\n  \"ad_p_result\":\"i_s_c_i_t_c:945600799-i_s_c_i_t_c:945600799=n_a_m_f_o:1015463-n_a_c_i_t:945600819-n_a_g_n_o:1001147055673205-n_a_k_f_o:5197001164\",\n  \"ad_p_news\":\"n_a_c_i_t:945600802-n_a_m_f_o:1015461-n_a_c_i_t:945600802-n_a_m_f_o:1015461=n_a_c_i_t:945600819-n_a_g_n_o:1001147055673205-n_a_k_f_o:5197001164\",\n  \"ad_p_dialog\":\"i_s_c_i_t_c:945600824-n_a_m_f_o:1015466=n_a_c_i_t:945600819-n_a_g_n_o:1001147055673205-n_a_k_f_o:5197001164\",\n  \"ad_p_auto_insert\":\"i_s_c_i_t:945600826-i_s_c_i_t:945600826=i_s_c_i_t:945600816-i_s_g_i_t:4011047075470262\",\n  \"ad_p_auto_work\":\"i_s_c_i_t_c:945600831-n_a_m_f_o:1015467=n_a_c_i_t:945600819-n_a_g_n_o:1001147055673205-n_a_k_f_o:5197001164\",\n  \"ad_p_auto_result\":\"i_s_c_i_t_c:945600833-n_a_m_f_o:1015468=n_a_c_i_t:945600819-n_a_g_n_o:1001147055673205-n_a_k_f_o:5197001164\",\n  \"ad_p_feed_insert\":\"i_s_c_i_v:945600812-i_s_c_i_v:945600812=i_s_k_i_v:5197001163-i_s_c_i_t:945600816-i_s_g_i_t:4011047075470262\",\n  \"ad_p_result_insert\":\"i_s_c_i_v:945600804-i_s_c_i_v:945600804=i_s_k_i_v:5197001161-i_s_c_i_t:945600816-i_s_g_i_t:4011047075470262\",\n  \"ad_p_done_ad\":\"i_s_c_i_v:945600804-i_s_k_i_v:5197001161-i_s_c_i_t:945600816-i_s_g_i_t:4011047075470262\",\n  \"ad_p_news_insert\":\"i_s_c_i_t:945600816-i_s_c_i_t:945600816=i_s_g_i_t:4011047075470262\",\n\n  \"ad_p_i_u\":\"i_s_c_i_t_c:945601497-i_s_c_i_t_c:945601497-n_a_m_f_o:1015465=n_a_c_i_t:945600819-n_a_g_n_o:1001147055673205-n_a_k_f_o:5197001164\",\n  \"ad_p_lock\":\"n_a_m_f_o:1015460-n_a_m_f_o:1015460-n_a_m_f_o:1015460-n_a_g_n_o:1051242095275322=n_a_g_n_o:1001147055673205-n_a_k_f_o:5197001164\",\n  \"ad_p_auto_booster\":\"i_s_c_i_t_c:945600816=n_a_g_n_o:1001147055673205-n_a_k_f_o:5197001164\",\n  \"ad_p_unlock\":\"i_s_k_i_v:5197001172-i_s_g_i_v:6071642005774407=n_a_c_i_t:945600819-n_a_g_n_o:1001147055673205-n_a_k_f_o:5197001164\",\n  \"un_count\": \"50\",\n  \"un_t\": \"60000\",\n\n  \"ad_p_phone_over\":\"n_a_m_f_o:1015469-n_a_k_f_o:5197001159-n_a_g_n_o:1001147055673205-n_a_k_f_o:5197001164\",\n  \"ad_p_wifi_connect\":\"n_a_m_f_o:1015469-n_a_k_f_o:5197001159-n_a_g_n_o:1001147055673205-n_a_k_f_o:5197001164\",\n  \"ad_p_bu\":\"n_a_m_f_o:1015469-n_a_k_f_o:5197001159-n_a_g_n_o:1001147055673205-n_a_k_f_o:5197001164\",\n  \"ad_p_power_notify\":\"n_a_m_f_o:1015469-n_a_k_f_o:5197001159-n_a_g_n_o:1001147055673205-n_a_k_f_o:5197001164\",\n  \"ad_p_exit\":\"n_a_m_f_o:1015462=n_a_g_n_o:1001147055673205-n_a_k_f_o:5197001164\",\n  \"ad_p_idle\":\"i_s_c_i_t:945600816-i_s_c_i_t:945600816=i_s_g_i_t:4011047075470262\",\n\n  \"ad_p_ev\":\"i_s_c_i_t_c:945601497-i_s_c_i_t_c:945601497=n_a_c_i_t:945600819-n_a_k_f_o:5197001164\",\n  \"ad_p_ev_gdt\":\"n_a_m_f_o:1015470-n_a_m_f_o:1015470=n_a_g_n_o:1001147055673205-n_a_k_f_o:5197001164\",\n  \"ad_p_ev_ks\":\"n_a_k_f_o:5197001160-n_a_k_f_o:5197001160=n_a_g_n_o:1001147055673205-n_a_k_f_o:5197001164\",\n\n  \"ad_p_notify_insert\":\"i_s_g_i_t:4011047075470262\",\n\n  \"ad_p_app_out\":\"i_s_c_i_v:945601228-i_s_c_i_v:945601228=i_s_k_i_v:5197001168-i_s_g_i_t:4011047075470262\",\n  \"a_o_i\":\"120000\",\n  \"a_o_c\":\"15\",\n\n  \"ad_p_outer_insert\":\"i_s_c_i_v:945601228-i_s_c_i_v:945601228=i_s_k_i_v:5197001168-i_s_k_i_v:5197001168-i_s_k_i_v:5197001168-i_s_g_i_t:4011047075470262\",\n  \"max_oi_count\":\"27\",\n\n  \"ad_p_outer_insert_g\":\"i_s_k_i_v:5197001167-i_s_k_i_v:5197001167=i_s_k_i_v:5197001168-i_s_k_i_v:5197001168-i_s_k_i_v:5197001168-i_s_g_i_t:4011047075470262\",\n  \"max_oi_g_count\":\"22\",\n\n  \"en_ev_oi\":\"1\",\n  \"en_ab_oi\":\"1\",\n\n  \"ad_p_n_s_1\":\"n_a_m_f_o:1015458\",\n  \"ad_p_n_s_2\":\"n_a_m_f_o:1015459\",\n\n  \"ad_draw_video\": \"945600828\",\n  \"ad_full_video\": \"i_s_c_i_v:945600812\",\n  \"ad_r_video\": \"945600808\",\n  \"v_flow\": \"https://cpu.baidu.com/1085/d08603ee?scid=43408\",\n\n  \"ad_p_splash_insert\":\"s_a_g_i_s:3051947075970315-s_a_g_i_s:3051947075970315-s_a_g_i_s:3051947075970315-s_a_k_i_s:5197001169=s_a_g_i_s:3051947075970315\",\n  \"s_i_count\":\"15\",\n  \"s_i_t\":\"180000\",\n  \"s_i_e_d_l\": \"1\",\n\n  \"tt_ev_count\": \"30\",\n  \"ks_ev_count\": \"20\",\n  \"gdt_ev_count\": \"30\",\n\n  \"fun_auto_enable\":\"1\",\n  \"s_ad_dot\":\"1\"\n}";

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
