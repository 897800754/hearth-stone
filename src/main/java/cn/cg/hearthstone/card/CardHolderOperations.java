package cn.cg.hearthstone.card;

import cn.cg.hearthstone.Game;

/**
 * 战斗卡牌行为
 *
 * @author: cg1
 * @date: 2021-04-16 13:04
 **/
public interface CardHolderOperations {
    /**
     * 初始化
     */
    void init(Game game);


    /**
     * 打出
     */
    void show(Game game);

    /**
     * 死亡
     */
    void dead(Game game);
}
