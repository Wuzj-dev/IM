package com.han.common.model.user.dto;

import com.han.common.model.enums.UserDisableEnum;
import org.springframework.util.CollectionUtils;
import java.util.List;

public class UserDisableDTO {

    private List<UserDisableEnum> userDisableList;

    public Boolean userDisableEnum(UserDisableEnum disableEnum){
       return userDisableEnum(userDisableList,disableEnum);
    }

    /**
     * 判断权限是否符合
     * @param disableEnum the disableEnum
     * @return the Boolean
     */
    public Boolean userDisableEnum(List<UserDisableEnum> userDisableList,UserDisableEnum disableEnum){
        if (CollectionUtils.isEmpty(userDisableList)
                || disableEnum == null){
            return Boolean.FALSE;
        }
        for (UserDisableEnum disable: userDisableList){
            if (disable.getDisable().equals(disableEnum.getDisable())){
                return Boolean.TRUE;
            }
        }
        return Boolean.FALSE;
    }

}
