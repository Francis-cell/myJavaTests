package com.zmr.LearningFiles.BooksReading.EffectiveJavaDemos.Enums;

/**
 * <p> 针对 chUwConclusionForAutoSipMain 方法设计的枚举，用来确切形成到总公司的原因 </p>
 * <p> 该方法一共有如下几种到总公司的场景 </p>
 * <p> 1、非委托经办类业务，注销保单、批改人数、团单人员信息批改、变更关系人--到省。 </p>
 * <p> 2、判断是不是非委托，如果是非委托必须到总； </p>
 * <p> 3、是否存在关系人类型为团体，而且证件类型或证件号为空的情况,是的话，到总公司批改审批岗； </p>
 * <p> 4、批改人数 人数超 10% 或者 保费超1000万 管控； </p>
 * <p> 5、产品校验  只有批退业务反洗钱管控配置表的产品才需要校验反洗钱； </p>
 * <p> 6、如果为见费出单业务则需要提交到总公司批改审批岗； </p>
 * <p> 7、修改份额保费的业务需要提交到总公司批改审批岗； </p>
 * <p> 其中 3、5、7 为到处长的场景 </p>
 */
public enum SipHeadToHeadReason {
    /** 1、非委托经办类业务，注销保单、批改人数、团单人员信息批改、变更关系人--到省； */
    NOT_DELEGATED,
    /** 2、判断是不是非委托，如果是非委托必须到总； */
    OTHER_NOT_DELEGATED,
    /** 3、是否存在关系人类型为团体，而且证件类型或证件号为空的情况,是的话，到总公司批改审批岗； */
    GROUP_AFFILIATES(ReasonType.TO_SECTION_CHIEF),
    /** 4、批改人数 人数超 10% 或者 保费超1000万 管控； */
    W14_CONDITIONS,
    /** 5、产品校验  只有批退业务反洗钱管控配置表的产品才需要校验反洗钱； */
    ANTI_MONEY_LAUNDERING(ReasonType.TO_SECTION_CHIEF),
    /** 6、如果为见费出单业务则需要提交到总公司批改审批岗； */
    SEE_THE_FEE_BILLING,
    /** 7、修改份额保费的业务需要提交到总公司批改审批岗； */
    MODIFY_SHARE_PREMIUMS(ReasonType.TO_SECTION_CHIEF);


    private final ReasonType reasonType;

    SipHeadToHeadReason(ReasonType reasonType) {
        this.reasonType = reasonType;
    }

    SipHeadToHeadReason() {
        this(ReasonType.NOT_TO_SECTION_CHIEF);
    }

    /**
     * <p> 获取是否到处长 </p>
     * @return
     */
    String getToChiefOrNot() {
        return reasonType.reasonTypeInner();
    }

    // The strategy enum type
    private enum ReasonType {
        /** 不需要到处长的情况 */
        NOT_TO_SECTION_CHIEF {
            @Override
            String reasonTypeInner() {
                return "NOT_TO_SECTION_CHIEF";
            }
        },
        /** 需要到处长的情况 */
        TO_SECTION_CHIEF {
            @Override
            String reasonTypeInner() {
                return "TO_SECTION_CHIEF";
            }
        };

        abstract String reasonTypeInner();

        String getToChiefOrNot() {
            return reasonTypeInner();
        }
    }
}
