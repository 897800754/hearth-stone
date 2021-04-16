package cn.cg.hearthstone.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 职业
 *
 * @author: cg1
 * @date: 2021-04-16 12:56
 **/
@AllArgsConstructor
@Getter
public enum OccupationEnum {
    /**
     * 法师
     */
    MASTER("master", "法师"),
    /**
     * 猎人
     */
    HUNTER("hunter", "猎人"),
    /**
     * 普通
     */
    NORMAL("normal", "通用"),
    ;


    private String code;
    private String cnName;

}
