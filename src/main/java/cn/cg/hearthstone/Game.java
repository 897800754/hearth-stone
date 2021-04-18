package cn.cg.hearthstone;

import cn.cg.hearthstone.enums.RoomStatusEnum;
import cn.cg.hearthstone.play.BattleZone;
import cn.cg.hearthstone.play.player.Player;
import cn.cg.hearthstone.support.Lifecycle;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.Assert;

import java.util.UUID;

/**
 * 房间类
 *
 * @author: cg1
 * @date: 2021-04-16 13:06
 **/
@Getter
@Setter
@Slf4j
public class Game implements Lifecycle {
    private String id = UUID.randomUUID().toString();
    /**
     * 先手英雄
     */
    @JsonIgnore
    private Player firstPlayer;
    /**
     * 后手英雄
     */
    @JsonIgnore
    private Player lastPlayer;
    /**
     * 战斗区
     */
    private BattleZone battleZone;
    /**
     * 当前玩家
     */
    private Player currentPlay;
    /**
     * 回合数
     */
    private Integer rounds;

    /**
     * 对局状态
     *
     * @see RoomStatusEnum
     */
    private RoomStatusEnum roomStatus;

    public Game(Player firstPlayer, Player lastPlayer) {
        this.firstPlayer = firstPlayer;
        this.lastPlayer = lastPlayer;
        this.roomStatus = RoomStatusEnum.BEGIN;
    }

    /**
     * 对局开始
     */
    @Override
    public void start() {
        Assert.notNull(firstPlayer, "玩家异常");
        Assert.notNull(lastPlayer, "玩家异常");
        //  Assert.notNull(battleZone, "对局异常");
        battleZone = new BattleZone(this);
        this.firstPlayer.beginBattle(this);
        this.lastPlayer.beginBattle(this);
        this.roomStatus = RoomStatusEnum.ING;
        this.currentPlay = firstPlayer;
        rounds = 1;
    }

    @Override
    public void stop() {
        this.roomStatus = RoomStatusEnum.END;
        //todo
        log.info("游戏结束");
    }

    @Override
    public boolean isRunning() {
        return RoomStatusEnum.ING.getStatus().equals(roomStatus.getStatus());
    }

    /**
     * 玩家完成对决,交换玩家
     */
    public void finishRound() {
        log.debug("======================回合结束:玩家名{}================================", currentPlay.getPlayName());
        if (firstPlayer.equals(currentPlay)) {
            this.currentPlay = lastPlayer;
        } else {
            //后手玩家结束游戏,回合数+1
            this.currentPlay = firstPlayer;
            rounds++;
        }
        this.currentPlay.beginRound();
        log.debug("======================回合开始:玩家名{}================================", currentPlay.getPlayName());
    }

    /**
     * 获取先手玩家
     *
     * @return
     */
//    public Player getFirstPlay() {
//        return this.firstPlayer;
//    }

    /**
     * 获取后手玩家
     *
     * @return
     */
//    public Player getLastPlay() {
//        return this.lastPlayer;
//    }
}
