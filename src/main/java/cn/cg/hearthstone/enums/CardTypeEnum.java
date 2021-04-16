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
public enum CardTypeEnum {
    /**
     * 生物
     */
    ANIMAL("animal", "动物"),
    /**
     * 法术
     */
    MAGIC("magic", "法术"),
    ;


    private String code;
    private String cnName;

}
