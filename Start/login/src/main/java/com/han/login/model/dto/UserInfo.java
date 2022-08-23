package com.han.login.model.dto;

import com.han.common.enums.OperateEnum;
import com.han.common.model.user.OperaPermissions;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

/**
 * @ClassNAME UserInfo
 * @Description
 * @Author wuj
 * @Date 2022/7/10 10:12
 */
public class UserInfo {

    /**
     * 用户唯一标识符
     */
    private String userId;

    private boolean isDisable;

    /**
     * 当前在线登陆登陆
     */
    private Map<OnlineDevice, AppInfo> appInfoMap;

    /**
     * 操作权限
     */
     private Map<OperateEnum, List<OperaPermissions>> operate;



    @Getter
    @AllArgsConstructor
    public class AppInfo{

        /**
         * 设备
         */
        private OnlineDevice onlineDevice;

        /**
         * 登陆时间
         */
        private LocalDateTime onLineStartTime;

    }

    /**
     * 登陆在线设备
     */
    @Getter
    @AllArgsConstructor
    enum OnlineDevice{
        /** 手机*/
        PHONE("PHONE", "手机"),
        /** 平板系统*/
        PAD("PAD","平板"),
        PC("PC","电脑设备"),
        OTHER("OTHER","其它");

        /**
         * 设备类型
         */
        private String deviceType;

        /**
         * 设备描述
         */
        private String deviceDesc;
    }

    @AllArgsConstructor
    @Getter
    enum OSType{

        IOS("IOS", "IOS"),
        ANDROID("ANDROID", "ANDROID"),
        MAC("MAC","MAC"),
        WINDOWS("WINDOWS","WINDOWS");

        /**
         * 系统类型
         */
        private String osType;

        /**
         * 描述
         */
        private String osDesc;

    }



    class OerateAuthority{




    }







}
