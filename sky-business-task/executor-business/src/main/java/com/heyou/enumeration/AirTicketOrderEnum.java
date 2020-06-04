package com.heyou.enumeration;

/**
 * @Description:
 * @Author: lhj
 * @Time: 2019/7/23 10:54
 * @Version: 1.0
 */
public interface AirTicketOrderEnum {

    enum AirOrderBizCategoryEnum {
        P_BIZ_AIR_TICKET_ORDER("P_BIZ_AIR_TICKET_ORDER", "机票订单");

        private String value;
        private String label;

        AirOrderBizCategoryEnum(String value, String label) {
            this.value = value;
            this.label = label;
        }

        public String getValue() {
            return value;
        }

        public String getLabel() {
            return label;
        }

        public static String findLabel(String value) {
            for (AirOrderBizCategoryEnum mps : values()) {
                if (mps.getValue().equals(value) ) {
                    return mps.getLabel();
                }
            }
            return null;
        }
    }

    enum AirOrderStateEnum {
        WAIT_PAY(0, "待支付"), WAIT_TICKET(2, "待出票"), BEING_TICKET(4, "正在出票"),ALREADY_TICKET(5,"已出票")
        ,CANCEL(6,"已取消"),RETURN_TICKET(7,"已退票");

        private Integer value;
        private String label;

        AirOrderStateEnum(Integer value, String label) {
            this.value = value;
            this.label = label;
        }

        public Integer getValue() {
            return value;
        }

        public String getLabel() {
            return label;
        }

        public static String findLabel(int value) {
            for (AirOrderStateEnum mps : values()) {
                if (mps.getValue() == value) {
                    return mps.getLabel();
                }
            }
            return null;
        }
    }

    enum AirPayCallBackMessageEnum {
        WAIT_DISPOSE(0, "待处理"), ALREADY_DISPOSE(2, "已处理");

        private Integer value;
        private String label;

        AirPayCallBackMessageEnum(Integer value, String label) {
            this.value = value;
            this.label = label;
        }

        public Integer getValue() {
            return value;
        }

        public String getLabel() {
            return label;
        }

        public static String findLabel(int value) {
            for (AirPayCallBackMessageEnum mps : values()) {
                if (mps.getValue() == value) {
                    return mps.getLabel();
                }
            }
            return null;
        }
    }

    enum AirPayTypeEnum {
        BALANCE(1, "余额支付"), ALIPAY(2, "支付宝自动支付");

        private Integer value;
        private String label;

        AirPayTypeEnum(Integer value, String label) {
            this.value = value;
            this.label = label;
        }

        public Integer getValue() {
            return value;
        }

        public String getLabel() {
            return label;
        }

        public static String findLabel(int value) {
            for (AirPayTypeEnum mps : values()) {
                if (mps.getValue() == value) {
                    return mps.getLabel();
                }
            }
            return null;
        }
    }

    enum InsuranceOrderStateEnum {

        WAIT_PAY(0, "待支付"), INSURE_SUCCESS(1, "投保完成"),INSURE_FAIL(2, "投保失败"),WAIT_INSURE(3, "待投保"),
        RETURN_INS_ING(4, "退保中"),RETURN_INS_SUCCESS(5,"已退保"),CANCEL(6,"已取消");

        private Integer value;
        private String label;

        InsuranceOrderStateEnum(Integer value, String label) {
            this.value = value;
            this.label = label;
        }

        public Integer getValue() {
            return value;
        }

        public String getLabel() {
            return label;
        }

        public static String findLabel(int value) {
            for (InsuranceOrderStateEnum mps : values()) {
                if (mps.getValue() == value) {
                    return mps.getLabel();
                }
            }
            return null;
        }
    }

}
