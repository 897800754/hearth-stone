package cn.cg.hearthstone.play.player;

import cn.cg.hearthstone.Game;
import cn.cg.hearthstone.card.Card;

/**
 * @author: cg1
 * @date: 2021-04-16 15:26
 **/
public interface PlayerOperations {

    /**
     * 打出手牌
     *
     * @param card
     */
    void useHandCard(Card card);

    /**
     * 抽牌
     */
    void drawCards();

    /**
     * 初始化玩家
     */
    void initPlayer();

    /**
     * 卡牌攻击
     */
    void cardAttack(Object from, Object to);


    /**
     * 法术攻击
     */
    void cardAttack(Object from);

    /**
     * 向另一个玩家/生物攻击
     *
     * @param to
     */
    void attack(Object to);

    /**
     * 结束回合
     */
    void stopRound();

    /**
     * 开始回合
     */
    void beginRound();

    /**
     * 开始对局
     */
    void beginBattle(Game game);

    /**
     * 结束对局
     */
    void stopBattle(Game game);
}
