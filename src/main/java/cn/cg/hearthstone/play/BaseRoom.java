package cn.cg.hearthstone.play;

import cn.cg.hearthstone.hero.model.Hero;
import lombok.Data;

/**
 * 房间基类
 *
 * @author: cg1
 * @date: 2021-04-16 13:06
 **/
@Data
public abstract class BaseRoom {
    /**
     * 先手英雄
     */
    private Hero firstHero;
    /**
     * 后手英雄
     */
    private Hero lastHero;

}
