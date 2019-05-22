package me.liuchu.test.comm.data.entity;

import lombok.Data;

import java.util.List;

@Data
public class ZzcJsonCombine {

    //ZZC流量监控接口返回的JSON第三级JSONObject（root ->"intelliCredit" -> "velocityCheck"）对应的对象,
    private FlowFeature flowFeature;

    //ZZC神月平台接口返回的JSON对应的对象
    private CreditFeature creditfeature;

    @Data
    public static class FlowFeature{

        private IntelliCredit intelliCredit;

        @Data
        private static class IntelliCredit{

            private VelocityCheck velocityCheck;

            @Data
            private static class VelocityCheck{

                private PidOrMobileDetail pid;
                private PidOrMobileDetail mobile;

                @Data
                private static class PidOrMobileDetail{
                    private Integer totalWindowSize;
                    private Integer totalAppsNumber;
                    private Integer crossTenantAppsNumber;
                    private String mobiles;
                    private String loanTypes;
                    private String tenantTypes;

                    private List<SubWindow> subWindows;

                    @Data
                    private class SubWindow{
                        private Integer subWindowSize;
                        private Integer totalAppsNumber;
                        private Integer crossTenantAppsNumber;
                        private String mobiles;
                        private String loanTypes;
                    }
                }
            }
        }

    }

    @Data
    public static class CreditFeature{
        private LoanInfo loanInfo;
        private BlackList blackList;

        @Data
        private static class LoanInfo{

            private PidOrMobileDetail pid;
            private PidOrMobileDetail mobile;

            private DeviceIdOrIpAddressDetail deviceId;
            private DeviceIdOrIpAddressDetail ipAddress;

            @Data
            private static class PidOrMobileDetail{

                private All all;

                @Data
                private static class All{

                    private TimeScopes timeScopes;

                    @Data
                    private static class TimeScopes{
                        private Day90 D90;
                        private Day360 D360;

                        @Data
                        private static class Day90 extends DayBase{

                        }

                        @Data
                        private static class Day360 extends DayBase{
                            private Integer daysFromLastLoan;
                            private Integer monthsFromFirstLoan;
                            private Integer monthsFromLastOverdue;
                            private Integer monthsForNormalRepay;
                            private Integer remainingAmount;
                        }

                        @Data
                        private static class DayBase{
                            private Integer queryCount;
                            private Integer loanCount;
                            private Integer loanTenantCount;
                            private Integer averageLoanGapDays;
                            private Integer averageTenantGapDays;
                            private Integer maxLoanAmount;
                            private Integer maxLoanPeriodDays;
                            private Integer averageLoanAmount;
                            private Integer maxOverdueDays;
                            private Integer overdueLoanCount;
                            private Integer overdueTenantCount;
                            private Integer overdueFor2TermTenantCount;
                        }
                    }
                }


            }

            @Data
            private static class DeviceIdOrIpAddressDetail{
                private All all;

                @Data
                private static class All{
                    private TimeScopes timeScopes;

                    @Data
                    private static class TimeScopes{
                        private Day90 D90;
                        private Day360 D360;

                        @Data
                        private static class Day90 extends DayBase{

                        }

                        @Data
                        private static class Day360 extends DayBase{

                        }

                        @Data
                        private static class DayBase{
                            private Integer queryCount;
                            private Integer loanCount;
                            private Integer loanTenantCount;
                        }
                    }
                }
            }

        }

        @Data
        private static class BlackList{
            private CommonDetail pid;
            private CommonDetail mobile;
            private CommonDetail deviceId;
            private CommonDetail ipAddress;
            private CommonDetail gps;

            @Data
            private static class CommonDetail{
                private All all;

                @Data
                private static class All{

                    private String blackLevel;
                    private Integer last6MTenantCount;
                    private Integer last6MQueryCount;
                    private Integer lastConfirmAtDays;
                    private String lastConfirmStatus;
                    private String last12MMaxConfirmStatus;
                }
            }
        }


    }

}
