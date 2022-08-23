package com.han.common.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 账号禁用等信息
 * 部分消息以token 形势保存，发送token 时带送
 */
@Getter
@AllArgsConstructor
public enum UserDisableEnum {

    /**
     * 账号禁用
     */
    ACCOUNT_DISABLES("account_disable", accountDisable()),

    /**
     * 单发消息禁言
     */
    MESSAGE_SINGLE_SEND_DISABLES("message_single_send_disable", messageDisable()),

    /**
     * 群组消息发送禁言
     */
    MESSAGE_GROUP_SEND_DISABLES("message_group_send_disable", messageDisable()),

    /**
     * 消息禁止发送
     */
    MESSAGE_ALL_SEND_DISABLES("message_all_send_disable", messageDisable());

    private final String disable;

    private final String type;

    /**
     * 账户禁用
     */
    static final String ACCOUNT_DISABLE = "account_disable";

    /**
     * 消息禁用
     */
    static final String MESSAGE_DISABLE = "message_disable";

    public static String accountDisable() {
        return ACCOUNT_DISABLE;
    }

    public static String messageDisable() {
        return ACCOUNT_DISABLE;
    }

    /**
     * 获取所有的 禁用枚举
     *
     * @return the UserDisableEnum[]
     */
    public static List<UserDisableEnum> allUserDisableEnum() {
        return Arrays.stream(UserDisableEnum.values())
                .collect(Collectors.toList());
    }

    /**
     * 根据类型查找所有的 UserDisableEnum
     *
     * @param type the type
     * @return List<UserDisableEnum>
     */
    public static List<UserDisableEnum> userDisableEnum(String type) {
        if (type == null) {
            return null;
        }
        return allUserDisableEnum().stream()
                .filter(p -> p.getType().equals(type))
                .collect(Collectors.toList());
    }

}
