package cn.cg.hearthstone;

import cn.cg.hearthstone.card.Card;
import cn.cg.hearthstone.card.CardHolder;
import cn.cg.hearthstone.card.animal.AnimalCard;
import cn.cg.hearthstone.hero.HunterHero;
import cn.cg.hearthstone.hero.MasterHero;
import cn.cg.hearthstone.play.BattleZone;
import cn.cg.hearthstone.play.hand.Hand;
import cn.cg.hearthstone.play.player.Player;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;

/**
 * @author: cg1
 * @date: 2021-04-16 18:05
 **/

public class SimpleTest {

    private static final ObjectMapper JSON = new ObjectMapper();


    public static void main(String[] args) throws JsonProcessingException {
        //加入两个玩家 ,卡组,手牌都是用默认
        Player firstPlayer = new Player("张三", new MasterHero(), "鱼人宝宝卡组");
        Player lastPlayer = new Player("李四", new HunterHero(), "鱼人宝宝卡组");
        //1.创建对局
        Game game = new Game(firstPlayer, lastPlayer);
        //开始游戏
        game.start();
        firstPlayer.beginRound();
        //获取玩家一的手牌
        Hand hand = firstPlayer.getHand();
        //打出一张手牌
        List<Card> handCard = hand.getHandCard();
        Card card = handCard.get(0);
        firstPlayer.playHandCard(card);
        //发起进攻,当然是失败的
        firstPlayer.attack(lastPlayer);
        //回合结束
        game.finishRound(firstPlayer);
        //后手开始
        //获取玩家一的手牌
        hand = lastPlayer.getHand();
        //打出一张手牌
        handCard = hand.getHandCard();
        card = handCard.get(0);
        lastPlayer.playHandCard(card);
        //回合结束
        game.finishRound(lastPlayer);
        //先手玩家发起进攻
        //获取战斗区域卡牌
        BattleZone battleZone = firstPlayer.getGame().getBattleZone();
        //攻击敌方鱼人宝宝,回合结束
        List<CardHolder<AnimalCard>> firstPlayBattleZone = battleZone.getFirstPlayBattleZone();
        List<CardHolder<AnimalCard>> lastPlayBattleZone = battleZone.getLastPlayBattleZone();
        CardHolder<AnimalCard> firstAnimalCardCardHolder = firstPlayBattleZone.get(0);
        CardHolder<AnimalCard> lastAnimalCardCardHolder = lastPlayBattleZone.get(0);
        firstPlayer.cardAttack(firstAnimalCardCardHolder, lastAnimalCardCardHolder);
        firstPlayer.cardAttack(firstAnimalCardCardHolder, lastAnimalCardCardHolder);
        game.finishRound(firstPlayer);
    }
}
