package cn.cg.hearthstone.hero.model;

import cn.cg.hearthstone.card.Card;

import java.util.List;

/**
 * @author: cg1
 * @date: 2021-04-16 13:46
 **/
public interface DeckOperations {

    /**
     * 获取卡牌
     *
     * @param count
     * @return
     */
    List<Card> obtainCard(Integer count);

    /**
     * 从套牌库抽取一张套牌
     *
     * @return
     */
    Card obtainCard();
}
