package cn.cg.hearthstone;

import cn.cg.hearthstone.hero.HunterHero;
import cn.cg.hearthstone.hero.MasterHero;
import cn.cg.hearthstone.play.player.Player;
import cn.cg.hearthstone.play.room.Room;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author: cg1
 * @date: 2021-04-16 18:05
 **/

public class InitTest {

    private static final ObjectMapper jsonUtils = new ObjectMapper();


    public static void main(String[] args) throws JsonProcessingException {
        //1.创建对局
        Room room = new Room();
        //加入两个玩家
        Player player1 = new Player("张三", room, new MasterHero(), "鱼人宝宝卡组");
        Player player = new Player("李四", room, new HunterHero(), "鱼人宝宝卡组");

        room.setFirstPlayer(player);
        room.setLastPlayer(player1);
        room.start();
        //展示手牌
        System.out.println(jsonUtils.writeValueAsString(player.getDeck()));


    }
}
