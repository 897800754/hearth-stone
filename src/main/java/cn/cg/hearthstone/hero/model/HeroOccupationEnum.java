package cn.cg.hearthstone.hero.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 英雄职业
 *
 * @author: cg1
 * @date: 2021-04-16 12:56
 **/
@AllArgsConstructor
@Getter
public enum HeroOccupationEnum {
    /**
     * 法师
     */
    MASTER("master", "法师"),
    /**
     * 猎人
     */
    HUNTER("hunter", "猎人");


    private String code;
    private String cnName;

}
