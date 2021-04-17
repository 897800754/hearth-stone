package cn.cg.hearthstone.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author: cg1
 * @date: 2021-04-16 18:51
 **/
@AllArgsConstructor
@Getter
public enum CardBattleStatusEnum {
    READY("read", "准备阶段"),

    ATTACHABLE("attachable", "可攻击"),

    ATTACKED("attacked", "已攻击"),

    ;
    private String status;

    private String desc;
}
