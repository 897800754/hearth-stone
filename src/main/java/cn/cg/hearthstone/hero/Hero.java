package cn.cg.hearthstone.hero;

import cn.cg.hearthstone.enums.OccupationEnum;
import cn.cg.hearthstone.play.player.Player;
import lombok.Data;

/**
 * 英雄基类
 *
 * @author: cg1
 * @date: 2021-04-16 12:54
 **/
@Data
public abstract class Hero implements HeroOperations {
    /**
     * 初始化
     * @param occupationEnum
     */
    public Hero(OccupationEnum occupationEnum) {
        this.occupationEnum = occupationEnum;
    }

    /**
     * 职业
     *
     * @see OccupationEnum
     */
    private OccupationEnum occupationEnum;


    @Override
    public void initHero(Player player) {

    }
}
