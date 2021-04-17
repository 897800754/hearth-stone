package cn.cg.hearthstone.hero;

import cn.cg.hearthstone.enums.OccupationEnum;
import cn.cg.hearthstone.play.player.Player;

/**
 * 猎人
 *
 * @author: cg1
 * @date: 2021-04-16 18:02
 **/
public class HunterHero extends Hero {

    /**
     * 初始化
     */
    public HunterHero() {
        super(OccupationEnum.HUNTER);
    }

    @Override
    public void initHero(Player player) {
        this.setSkillCost(2);
    }

    @Override
    public void skillCost(Player from) {
        from.setCurrentCost(from.getCurrentCost() - getSkillCost());
    }

    @Override
    public void skillEffect(Player from, Object to) {
        Player toPlayer = (Player) to;
        toPlayer.setCurrentBloodVolume(toPlayer.getCurrentBloodVolume() - 2);
    }


}
