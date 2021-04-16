package cn.cg.hearthstone.play.hand;

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
     * @param card
     */
    void addCard(List<Card> card);

    /**
     * 初始化手牌
     * @param player
     */
    void initHand(Player player);

}
