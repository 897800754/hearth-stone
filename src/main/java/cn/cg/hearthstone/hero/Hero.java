package cn.cg.hearthstone.hero;

import cn.cg.hearthstone.enums.OccupationEnum;
import cn.cg.hearthstone.play.player.Player;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

/**
 * 英雄基类
 *
 * @author: cg1
 * @date: 2021-04-16 12:54
 **/
@Getter
@Setter
@Slf4j
public abstract class Hero implements HeroOperations {
    /**
     * 初始化
     *
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

    /**
     * 技能费用
     *
     * @param player
     */
    private Integer skillCost;

    @Override
    public boolean userSkill(Player from, Object to) {
        boolean b = validateSkillCost(from);
        if (!b) {
            return false;
        }
        skillCost(from);
        skillEffect(from, to);
        return true;
    }

    /**
     * 技能减费用
     *
     * @param from
     */
    public abstract void skillCost(Player from);

    /**
     * 技能影响
     */
    public abstract void skillEffect(Player from, Object to);

    @Override
    public boolean validateSkillCost(Player from) {
        Integer currentCost = from.getCurrentCost();
        int cost = currentCost - skillCost;
        if (cost > 0) {
            return true;
        }
        log.error("进攻失败,攻击玩家名:{},原因:费用不足", from.getPlayName());
        return false;
    }
}
