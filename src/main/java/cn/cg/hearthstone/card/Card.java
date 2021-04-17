package cn.cg.hearthstone.card;

import cn.cg.hearthstone.enums.CardTypeEnum;
import cn.cg.hearthstone.enums.OccupationEnum;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

/**
 * 卡牌基类
 *
 * @author: cg1
 * @date: 2021-04-16 15:29
 **/
@Getter
@Setter
public abstract class Card implements CardOperations {

    private String id = UUID.randomUUID().toString();
    /**
     * 职业类型
     */
    private OccupationEnum occupationEnum;
    /**
     * 卡牌类型
     */
    private CardTypeEnum cardTypeEnum;
    /**
     * 费用
     */
    private Integer cost;
    /**
     * 名称
     */
    private String name;
    /**
     * 描述
     */
    private String desc;
    /**
     * 卡牌编号
     */
    private String code;

}
