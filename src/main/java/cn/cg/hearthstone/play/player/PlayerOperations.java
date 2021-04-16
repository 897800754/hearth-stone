package cn.cg.hearthstone.play.player;

import cn.cg.hearthstone.card.Card;

/**
 * @author: cg1
 * @date: 2021-04-16 15:26
 **/
public interface PlayerOperations  {

    /**
     * 打出手牌
     *
     * @param card
     */
    void playHandCard(Card card);

    /**
     * 抽牌
     */
    void drawCards();

    /**
     * 初始化玩家
     */
    void initPlayer();

}
