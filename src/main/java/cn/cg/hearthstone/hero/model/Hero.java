package cn.cg.hearthstone.hero.model;

import cn.cg.hearthstone.card.Card;
import cn.cg.hearthstone.hero.action.HeroOperations;
import lombok.Data;

import java.util.List;

/**
 * 英雄基类
 *
 * @author: cg1
 * @date: 2021-04-16 12:54
 **/
@Data
public abstract class Hero implements HeroOperations {
    /**
     * 职业
     *
     * @see HeroOccupationEnum
     */
    private HeroOccupationEnum occupationEnum;
    /**
     * 血量
     */
    private Integer bloodVolume = 30;

    private Deck deck = new Deck();

    /**
     * 当前费用
     */
    private Integer currentCost;

    /**
     * 手牌
     */
    private Hand hand = new Hand();
    /**
     * 手牌上限
     */
    private Integer handCardMaxLimit = 5;
    /**
     * 墓地
     */
    private List<Card> cemetery;

}
