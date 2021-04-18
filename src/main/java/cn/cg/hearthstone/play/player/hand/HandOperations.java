package cn.cg.hearthstone.play.player.hand;

import cn.cg.hearthstone.card.Card;
import cn.cg.hearthstone.play.player.Player;

import java.util.List;

/**
 * 手牌对象行为
 *
 * @author: cg1
 * @date: 2021-04-16 13:47
 **/
public interface HandOperations {

    /**
     * 加入卡牌至手牌
     *
     * @param cards
     */
    void addCard(List<Card> cards);

    /**
     * 从手牌中删除
     */
    void remove(List<Card> cards);

    /**
     * 初始化手牌
     *
     * @param player
     */
    void initHand(Player player);

}
