package me.liuchu.test.comm.common;

public class TestRegion {

    private final static String[] PROVICE_CN = {"河北","山西","辽宁","吉林","黑龙江","江苏","浙江","安徽",
            "福建","江西","山东","河南","湖北","湖南","广东","海南","四川","贵州","云南","陕西",
            "甘肃","青海","台湾",
            "北京","天津","上海", "重庆",
            "广西","内蒙古","西藏","宁夏","新疆",
            "全国"};

    private final static String[] PROVICE_CODE = {"hebei","shan1xi","liaoning","jilin","heilongjiang","jiangsu","zhejiang","anhui",
            "fujian","jiangxi","shandong","henan","hubei","hunan","guangdong","hainan","sichuan","guizhou","yunnan","shanxi",
            "gansu","qinghai","taiwan",
            "beijing","tianjin","shanghai", "chongqin",
            "guangxi","neimenggu","xizang","ningxia","xinjiang",
            "quanguo"};

    public void genSql(){

        for (int i = 0; i < PROVICE_CN.length; i++) {

            String expression1 = "contact_area_analysis_"+PROVICE_CODE[i]+"_call_seconds int(11) DEFAULT -1 COMMENT '"+PROVICE_CN[i]+"地区通话总时长',";
            String expression2 = "contact_area_analysis_"+PROVICE_CODE[i]+"_call_cnt int(11) DEFAULT -1 COMMENT '"+PROVICE_CN[i]+"地区通话次数',";
            String expression3 = "contact_area_analysis_"+PROVICE_CODE[i]+"_msg_cnt int(11) DEFAULT -1 COMMENT '"+PROVICE_CN[i]+"地区短信条数',";
            System.out.println(expression1);
            System.out.println(expression2);
            System.out.println(expression3);
        }
    }

    public void genCode(){

        for (int i = 0; i < PROVICE_CN.length; i++) {

            String express1 = "case \""+PROVICE_CN[i]+"\":";
            String express2 = "feature.setContactAreaAnalysis"+upperFirstLetter(PROVICE_CODE[i])+"CallSeconds(contact.getTalkSeconds());";
            String express3 = "feature.setContactAreaAnalysis"+upperFirstLetter(PROVICE_CODE[i])+"CallCnt(contact.getTalkCnt());";
            String express4 = "feature.setContactAreaAnalysis"+upperFirstLetter(PROVICE_CODE[i])+"MsgCnt(contact.getMsgCnt());";
            String express5 = "break;";
            System.out.println(express1);
            System.out.println(express2);
            System.out.println(express3);
            System.out.println(express4);
            System.out.println(express5);
        }

    }

    private String upperFirstLetter(String str){
        return str.substring(0,1).toUpperCase().concat(str.substring(1).toLowerCase());
    }

    private Integer getDecimalByBinaryDigits(int[] binaryDigits){
        int result = 0;

        for (int i = 0; i < binaryDigits.length; i++) {
            result +=  binaryDigits[i] * Math.pow(2,i);
        }

        return result;
    }

    public static void main(String[] args) {
        //new TestRegion().gen();
        /*int a = new TestRegion().getDecimalByBinaryDigits(new int[]{1,0,0,1});
        System.out.println(a);*/
        new TestRegion().genCode();
    }
}
