package cn.cg.hearthstone.hero;

import cn.cg.hearthstone.play.player.Player;

/**
 * 英雄行为
 *
 * @author: cg1
 * @date: 2021-04-16 12:53
 **/
public interface HeroOperations {

    /**
     * 初始化
     * @param player
     */
    void initHero(Player player);


    /**
     * 技能
     */
    void userSkill();

}
