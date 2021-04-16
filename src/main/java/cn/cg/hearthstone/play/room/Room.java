package cn.cg.hearthstone.play.room;

import cn.cg.hearthstone.play.BattleZone;
import cn.cg.hearthstone.play.player.Player;
import lombok.Data;
import org.springframework.util.Assert;

/**
 * 房间基类
 *
 * @author: cg1
 * @date: 2021-04-16 13:06
 **/
@Data
public class Room {
    /**
     * 先手英雄
     */
    private Player firstPlayer;
    /**
     * 后手英雄
     */
    private Player lastPlayer;
    /**
     * 战斗区
     */
    private BattleZone battleZone;

    public Room() {
        init();
    }

    /**
     * 初始化
     */
    private void init() {
        battleZone = new BattleZone();
    }

    /**
     * 对局开始
     */
    public void start() {

        Assert.notNull(firstPlayer, "玩家异常");
        Assert.notNull(lastPlayer, "玩家异常");
    }

    /**
     * 下个回合
     */
    public void nextRound() {

    }
}
