package me.liuchu.test.comm.data;

import com.alibaba.fastjson.JSON;
import com.chuliu.demo.test.data.entity.ZzcJsonCombine;

public class TestZzc {

    public static void test(String flowStr, String creditStr){

        System.out.println(flowStr);
        System.out.println("------------------------------------------");
        System.out.println(creditStr);
        System.out.println("------------------------------------------");

        //JSON 转成 Object

        ZzcJsonCombine combine = new ZzcJsonCombine();

        ZzcJsonCombine.FlowFeature flowFeature = JSON.parseObject(flowStr,ZzcJsonCombine.FlowFeature.class);
        ZzcJsonCombine.CreditFeature creditFeature = JSON.parseObject(creditStr,ZzcJsonCombine.CreditFeature.class);

        combine.setCreditfeature(creditFeature);
        combine.setFlowFeature(flowFeature);

        String str1 = JSON.toJSONString(flowFeature);
        String str2 = JSON.toJSONString(creditFeature);

        System.out.println(str1);

        System.out.println("------------------------------------------");

        System.out.println(str2);

    }

    public static void main(String[] args) {
        String flowStr = "{\n" +
                "    \"intelliCredit\": {\n" +
                "        \"velocityCheck\": {\n" +
                "            \"pid\": {\n" +
                "                \"totalWindowSize\": 180,\n" +
                "                \"totalAppsNumber\": 4,\n" +
                "                \"crossTenantAppsNumber\": 3,\n" +
                "                \"mobiles\": \"M1,M2\",\n" +
                "                \"loanTypes\": \"p2p,cf_car,cf_digital\",\n" +
                "                \"tenantTypes\": \"P2P,ConsumerFinance\",\n" +
                "                \"subWindows\": [\n" +
                "                    {\n" +
                "                        \"subWindowSize\": 1,\n" +
                "                        \"totalAppsNumber\": 0,\n" +
                "                        \"crossTenantAppsNumber\": 0,\n" +
                "                        \"mobiles\": \"\",\n" +
                "                        \"loanTypes\": \"\"\n" +
                "                    }\n" +
                "                    ,\n" +
                "                    {\n" +
                "                        \"subWindowSize\": 3,\n" +
                "                        \"totalAppsNumber\": 1,\n" +
                "                        \"crossTenantAppsNumber\": 1,\n" +
                "                        \"mobiles\": \"M1\",\n" +
                "                        \"loanTypes\": \"cf_car\"\n" +
                "                    }\n" +
                "                    ,\n" +
                "                    {\n" +
                "                        \"subWindowSize\": 5,\n" +
                "                        \"totalAppsNumber\": 2,\n" +
                "                        \"crossTenantAppsNumber\": 1,\n" +
                "                        \"mobiles\": \"M1\",\n" +
                "                        \"loanTypes\": \"p2p,cf_car\"\n" +
                "                    }\n" +
                "                    ,\n" +
                "                    {\n" +
                "                        \"subWindowSize\": 10,\n" +
                "                        \"totalAppsNumber\": 3,\n" +
                "                        \"crossTenantAppsNumber\": 2,\n" +
                "                        \"mobiles\": \"M1,M2\",\n" +
                "                        \"loanTypes\": \"p2p,cf_car\"\n" +
                "                    }\n" +
                "                    ,\n" +
                "                    {\n" +
                "                        \"subWindowSize\": 30,\n" +
                "                        \"totalAppsNumber\": 3,\n" +
                "                        \"crossTenantAppsNumber\": 2,\n" +
                "                        \"mobiles\": \"M1,M2\",\n" +
                "                        \"loanTypes\": \"p2p,cf_car\"\n" +
                "                    }\n" +
                "                    ,\n" +
                "                    {\n" +
                "                        \"subWindowSize\": 60,\n" +
                "                        \"totalAppsNumber\": 3,\n" +
                "                        \"crossTenantAppsNumber\": 2,\n" +
                "                        \"mobiles\": \"M1,M2\",\n" +
                "                        \"loanTypes\": \"p2p,cf_car\"\n" +
                "                    }\n" +
                "                    ,\n" +
                "                    {\n" +
                "                        \"subWindowSize\": 90,\n" +
                "                        \"totalAppsNumber\": 4,\n" +
                "                        \"crossTenantAppsNumber\": 3,\n" +
                "                        \"mobiles\": \"M1,M2\",\n" +
                "                        \"loanTypes\": \"p2p,cf_car,cf_digital\"\n" +
                "                    }\n" +
                "                    ,\n" +
                "                    {\n" +
                "                        \"subWindowSize\": 180,\n" +
                "                        \"totalAppsNumber\": 4,\n" +
                "                        \"crossTenantAppsNumber\": 3,\n" +
                "                        \"mobiles\": \"M1,M2\",\n" +
                "                        \"loanTypes\": \"p2p,cf_car,cf_digital\"\n" +
                "                    }\n" +
                "                    \n" +
                "                ]\n" +
                "                \n" +
                "            }\n" +
                "            ,\n" +
                "            \"mobile\": {\n" +
                "                \"totalWindowSize\": 180,\n" +
                "                \"totalAppsNumber\": 1,\n" +
                "                \"crossTenantAppsNumber\": 0,\n" +
                "                \"pids\": \"P1\",\n" +
                "                \"loanTypes\": \"cf_car\",\n" +
                "                \"tenantTypes\": \"P2P,ConsumerFinance\",\n" +
                "                \"subWindows\": [\n" +
                "                    {\n" +
                "                        \"subWindowSize\": 1,\n" +
                "                        \"totalAppsNumber\": 0,\n" +
                "                        \"crossTenantAppsNumber\": 0,\n" +
                "                        \"pids\": \"\",\n" +
                "                        \"loanTypes\": \"\"\n" +
                "                    }\n" +
                "                    ,\n" +
                "                    {\n" +
                "                        \"subWindowSize\": 3,\n" +
                "                        \"totalAppsNumber\": 0,\n" +
                "                        \"crossTenantAppsNumber\": 0,\n" +
                "                        \"pids\": \"\",\n" +
                "                        \"loanTypes\": \"\"\n" +
                "                    }\n" +
                "                    ,\n" +
                "                    {\n" +
                "                        \"subWindowSize\": 5,\n" +
                "                        \"totalAppsNumber\": 0,\n" +
                "                        \"crossTenantAppsNumber\": 0,\n" +
                "                        \"pids\": \"\",\n" +
                "                        \"loanTypes\": \"\"\n" +
                "                    }\n" +
                "                    ,\n" +
                "                    {\n" +
                "                        \"subWindowSize\": 10,\n" +
                "                        \"totalAppsNumber\": 1,\n" +
                "                        \"crossTenantAppsNumber\": 0,\n" +
                "                        \"pids\": \"P1\",\n" +
                "                        \"loanTypes\": \"cf_car\"\n" +
                "                    }\n" +
                "                    ,\n" +
                "                    {\n" +
                "                        \"subWindowSize\": 30,\n" +
                "                        \"totalAppsNumber\": 1,\n" +
                "                        \"crossTenantAppsNumber\": 0,\n" +
                "                        \"pids\": \"P1\",\n" +
                "                        \"loanTypes\": \"cf_car\"\n" +
                "                    }\n" +
                "                    ,\n" +
                "                    {\n" +
                "                        \"subWindowSize\": 60,\n" +
                "                        \"totalAppsNumber\": 1,\n" +
                "                        \"crossTenantAppsNumber\": 0,\n" +
                "                        \"pids\": \"P1\",\n" +
                "                        \"loanTypes\": \"cf_car\"\n" +
                "                    }\n" +
                "                    ,\n" +
                "                    {\n" +
                "                        \"subWindowSize\": 90,\n" +
                "                        \"totalAppsNumber\": 1,\n" +
                "                        \"crossTenantAppsNumber\": 0,\n" +
                "                        \"pids\": \"P1\",\n" +
                "                        \"loanTypes\": \"cf_car\"\n" +
                "                    }\n" +
                "                    ,\n" +
                "                    {\n" +
                "                        \"subWindowSize\": 180,\n" +
                "                        \"totalAppsNumber\": 1,\n" +
                "                        \"crossTenantAppsNumber\": 0,\n" +
                "                        \"pids\": \"P1\",\n" +
                "                        \"loanTypes\": \"cf_car\"\n" +
                "                    }\n" +
                "                    \n" +
                "                ]\n" +
                "                \n" +
                "            }\n" +
                "            \n" +
                "        }\n" +
                "        \n" +
                "    }\n" +
                "    \n" +
                "}\n";

        String creditStr = "{\n" +
                "    \"loanInfo\": {\n" +
                "        \"pid\": {\n" +
                "            \"all\": {\n" +
                "                \"timeScopes\": {\n" +
                "                    \"D90\": {\n" +
                "                        \"queryCount\": 5,\n" +
                "                        \"loanCount\": 3,\n" +
                "                        \"loanTenantCount\": 2,\n" +
                "                        \"averageLoanGapDays\": 20,\n" +
                "                        \"averageTenantGapDays\": 25,\n" +
                "                        \"maxLoanAmount\": 3500,\n" +
                "                        \"maxLoanPeriodDays\": 14,\n" +
                "                        \"averageLoanAmount\": 2800,\n" +
                "                        \"maxOverdueDays\": 40,\n" +
                "                        \"overdueLoanCount\": 2,\n" +
                "                        \"overdueTenantCount\": 2,\n" +
                "                        \"overdueFor2TermTenantCount\": 2\n" +
                "                    },\n" +
                "                    \"D360\": {\n" +
                "                        \"queryCount\": 10,\n" +
                "                        \"loanCount\": 8,\n" +
                "                        \"loanTenantCount\": 5,\n" +
                "                        \"averageLoanGapDays\": 25,\n" +
                "                        \"averageTenantGapDays\": 25,\n" +
                "                        \"maxLoanAmount\": 6000,\n" +
                "                        \"maxLoanPeriodDays\": 30,\n" +
                "                        \"averageLoanAmount\": 2000,\n" +
                "                        \"maxOverdueDays\": 40,\n" +
                "                        \"overdueLoanCount\": 4,\n" +
                "                        \"overdueTenantCount\": 4,\n" +
                "                        \"overdueFor2TermTenantCount\": 3,\n" +
                "                        \"daysFromLastLoan\": 12,\n" +
                "                        \"monthsFromFirstLoan\": 8,\n" +
                "                        \"monthsFromLastOverdue\": 1,\n" +
                "                        \"monthsForNormalRepay\": 1,\n" +
                "                        \"remainingAmount\": 2400\n" +
                "                    }\n" +
                "                }\n" +
                "            }\n" +
                "        },\n" +
                "        \"mobile\": {\n" +
                "            \"all\": {\n" +
                "                \"timeScopes\": {\n" +
                "                    \"D90\": {\n" +
                "                        \"queryCount\": 5,\n" +
                "                        \"loanCount\": 3,\n" +
                "                        \"loanTenantCount\": 2,\n" +
                "                        \"averageLoanGapDays\": 20,\n" +
                "                        \"averageTenantGapDays\": 25,\n" +
                "                        \"maxLoanAmount\": 3500,\n" +
                "                        \"maxLoanPeriodDays\": 14,\n" +
                "                        \"averageLoanAmount\": 2800,\n" +
                "                        \"maxOverdueDays\": 40,\n" +
                "                        \"overdueLoanCount\": 2,\n" +
                "                        \"overdueTenantCount\": 2,\n" +
                "                        \"overdueFor2TermTenantCount\": 2\n" +
                "                    },\n" +
                "                    \"D360\": {\n" +
                "                        \"queryCount\": 10,\n" +
                "                        \"loanCount\": 8,\n" +
                "                        \"loanTenantCount\": 5,\n" +
                "                        \"averageLoanGapDays\": 25,\n" +
                "                        \"averageTenantGapDays\": 25,\n" +
                "                        \"maxLoanAmount\": 6000,\n" +
                "                        \"maxLoanPeriodDays\": 30,\n" +
                "                        \"averageLoanAmount\": 2000,\n" +
                "                        \"maxOverdueDays\": 40,\n" +
                "                        \"overdueLoanCount\": 4,\n" +
                "                        \"overdueTenantCount\": 4,\n" +
                "                        \"overdueFor2TermTenantCount\": 3,\n" +
                "                        \"daysFromLastLoan\": 12,\n" +
                "                        \"monthsFromFirstLoan\": 8,\n" +
                "                        \"monthsFromLastOverdue\": 1,\n" +
                "                        \"monthsForNormalRepay\": 1,\n" +
                "                        \"remainingAmount\": 2400\n" +
                "                    }\n" +
                "                }\n" +
                "            }\n" +
                "        },\n" +
                "        \"deviceId\": {\n" +
                "            \"all\": {\n" +
                "                \"timeScopes\": {\n" +
                "                    \"D90\": {\n" +
                "                        \"queryCount\": 5,\n" +
                "                        \"loanCount\": 3,\n" +
                "                        \"loanTenantCount\": 2\n" +
                "                    },\n" +
                "                    \"D360\": {\n" +
                "                        \"queryCount\": 5,\n" +
                "                        \"loanCount\": 4,\n" +
                "                        \"loanTenantCount\": 3\n" +
                "                    }\n" +
                "                }\n" +
                "            }\n" +
                "        },\n" +
                "        \"ipAddress\": {\n" +
                "            \"all\": {\n" +
                "                \"timeScopes\": {\n" +
                "                    \"D90\": {\n" +
                "                        \"queryCount\": 5,\n" +
                "                        \"loanCount\": 3,\n" +
                "                        \"loanTenantCount\": 2\n" +
                "                    },\n" +
                "                    \"D360\": {\n" +
                "                        \"queryCount\": 5,\n" +
                "                        \"loanCount\": 4,\n" +
                "                        \"loanTenantCount\": 3\n" +
                "                    }\n" +
                "                }\n" +
                "            }\n" +
                "        }\n" +
                "    },\n" +
                "    \"blacklist\": {\n" +
                "        \"pid\": {\n" +
                "            \"all\": {\n" +
                "                \"blackLevel\": \"DLQ90plus\",\n" +
                "                \"last6MTenantCount\": 2,\n" +
                "                \"last6MQueryCount\": 5,\n" +
                "                \"lastConfirmAtDays\": 16,\n" +
                "                \"lastConfirmStatus\": \"M3\",\n" +
                "                \"last12MMaxConfirmStatus\": \"M4\"\n" +
                "            }\n" +
                "        },\n" +
                "        \"mobile\": {\n" +
                "            \"all\": {\n" +
                "                \"blackLevel\": \"fraud\",\n" +
                "                \"last6MTenantCount\": 0,\n" +
                "                \"last6MQueryCount\": 0,\n" +
                "                \"lastConfirmAtDays\": 0,\n" +
                "                \"lastConfirmStatus\": \"\",\n" +
                "                \"last12MMaxConfirmStatus\": \"\"\n" +
                "            }\n" +
                "        },\n" +
                "        \"deviceId\": {\n" +
                "            \"all\": {\n" +
                "                \"blackLevel\": \"DLQ90plus\",\n" +
                "                \"last6MTenantCount\": 3,\n" +
                "                \"last6MQueryCount\": 6,\n" +
                "                \"lastConfirmAtDays\": 16,\n" +
                "                \"lastConfirmStatus\": \"M3\",\n" +
                "                \"last12MMaxConfirmStatus\": \"MN\"\n" +
                "            }\n" +
                "        },\n" +
                "        \"ipAddress\": {\n" +
                "            \"all\": {\n" +
                "                \"blackLevel\": \"DLQ90plus\",\n" +
                "                \"last6MTenantCount\": 2,\n" +
                "                \"last6MQueryCount\": 5,\n" +
                "                \"lastConfirmAtDays\": 16,\n" +
                "                \"lastConfirmStatus\": \"M3\",\n" +
                "                \"last12MMaxConfirmStatus\": \"M4\"\n" +
                "            }\n" +
                "        },\n" +
                "        \"gps\": {\n" +
                "            \"all\": {\n" +
                "                \"blackLevel\": \"fraud\",\n" +
                "                \"last6MTenantCount\": 0,\n" +
                "                \"last6MQueryCount\": 0,\n" +
                "                \"lastConfirmAtDays\": 0,\n" +
                "                \"lastConfirmStatus\": \"\",\n" +
                "                \"last12MMaxConfirmStatus\": \"\"\n" +
                "            }\n" +
                "        }\n" +
                "    }\n" +
                "}";

        test(flowStr,creditStr);
    }


}
