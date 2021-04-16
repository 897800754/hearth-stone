package cn.cg.hearthstone.play.deck;


import cn.cg.hearthstone.card.Card;
import cn.cg.hearthstone.play.player.Player;

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

    /**
     * 初始化套牌
     * @param player
     */
    void initDeck(Player player);
}
