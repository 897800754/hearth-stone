package cn.cg.hearthstone.card;

import cn.cg.hearthstone.Game;
import cn.cg.hearthstone.play.player.Player;

/**
 * 卡牌战斗消息
 *
 * @author: cg1
 * @date: 2021-04-18 19:32
 **/
public interface CardBattleEffect {

    /**
     * 战吼
     */
    void BattleCry(Game game,Player fromPlay);

    /**
     * 亡语
     */
    void deathLanguage(Game game, Player fromPlay);


}
