package cn.cg.hearthstone.play.player;

import cn.cg.hearthstone.Game;
import cn.cg.hearthstone.card.Card;
import cn.cg.hearthstone.card.CardHolder;
import cn.cg.hearthstone.card.animal.AnimalCard;
import cn.cg.hearthstone.enums.CardBattleStatusEnum;
import cn.cg.hearthstone.enums.CardTypeEnum;
import cn.cg.hearthstone.hero.Hero;
import cn.cg.hearthstone.play.BattleZone;
import cn.cg.hearthstone.play.Cemetery;
import cn.cg.hearthstone.play.player.deck.Deck;
import cn.cg.hearthstone.play.player.deck.DeckPool;
import cn.cg.hearthstone.play.player.hand.Hand;
import cn.cg.hearthstone.support.JsonUtil;
import cn.cg.hearthstone.support.PrintLogInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.util.Collections;
import java.util.Stack;

/**
 * 玩家类
 *
 * @author: cg1
 * @date: 2021-04-16 15:37
 **/
@Getter
@Setter
@Slf4j
public class Player implements PlayerOperations, PrintLogInfo {
    /**
     * 玩家名
     */
    private String playName;

    public Player(String playName, Hero hero, String deckName) {
        this.playName = playName;
        this.cemetery = new Cemetery();
        this.deck = new Deck();
        this.hand = new Hand();
        this.hero = hero;
        this.deckName = deckName;
        initPlayer();
    }

    //todo
    private String deckName;
    /**
     * 英雄
     */
    private Hero hero;
    /**
     * room
     */
    @JsonIgnore
    private Game game;
    /**
     * 血量
     */
    private Integer bloodVolume = 30;
    /**
     * 当前血量
     */
    private Integer currentBloodVolume = 30;
    /**
     * 套牌对象
     */
    //todo 暂时忽略
    @JsonIgnore
    private Deck deck;
    /**
     * 当前费用
     */
    private Integer currentCost = 0;

    public Integer getCurrentBloodVolume() {
        return currentBloodVolume;
    }

    public void setCurrentBloodVolume(Integer currentBloodVolume) {
        this.currentBloodVolume = currentBloodVolume;
        if (currentBloodVolume <= 0) {
            game.stop();
        }
    }

    /**
     * 总费用
     */
    private Integer totalCost = 0;
    /**
     * 手牌
     */
    private Hand hand;
    /**
     * 手牌上限
     */
    //todo 暂未处理
    private Integer handCardMaxLimit = 10;
    /**
     * 墓地
     */
    private Cemetery cemetery;
    /**
     * 技能状态
     */
    private CardBattleStatusEnum cardBattleStatusEnum;


    @Override
    public void playHandCard(Card card) {
        //check是否可以打出
        //todo 当前只判断费用
        int cost = currentCost - card.getCost();
        if (cost < 0) {
            //费用不够
            log.warn("费用不够");
            return;
        } else {
            currentCost = cost;
        }
        //生物卡牌
        if (CardTypeEnum.ANIMAL.getCode().equals(card.getCardTypeEnum().getCode())) {
            AnimalCard animalCard = (AnimalCard) card;
            //加入战斗区
            CardHolder<AnimalCard> animalCardCardHolder = new CardHolder<>(animalCard);
            game.getBattleZone().addCardHolder(this.playName, animalCardCardHolder);
            animalCardCardHolder.show(game);
        } else {
            //todo 法术
            //加入到墓地

        }
        //从手牌中删除
        hand.remove(Collections.singletonList(card));
    }

    @Override
    public void drawCards() {
        //从套牌获取卡牌
        Card card = getDeck().obtainCard();
        //加入套牌到手中
        getHand().addCard(Collections.singletonList(card));
    }

    @Override
    public void initPlayer() {
        //初始化英雄
        this.hero.initHero(this);
        //初始化套牌
        this.deck.initDeck(this);
        //初始化手牌
        this.hand.initHand(this);
    }

    @Override
    public void cardAttack(CardHolder<AnimalCard> from, Object to) {
        if (!CardBattleStatusEnum.ATTACHABLE.getStatus().equals(from.getBattleStatus().getStatus())) {
            log.warn("不可攻击");
            return;
        }
        //攻击完成 CardHolder<AnimalCard> to
        if (to instanceof CardHolder) {
            //攻击生物
            from.attack((CardHolder) to);
        } else {
            from.attack((Player) to);
        }
        //判断是否要从棋牌中删除
        game.getBattleZone().removeIfNeed();
    }

    @Override
    public void attack(Object to) {
        this.hero.userSkill(this, to);
    }

    @Override
    public void stopRound() {
        game.finishRound();
    }

    @Override
    public void beginRound() {
        //费用+1
        this.totalCost++;
        //当前费用回满
        this.currentCost = this.totalCost;
        //抽卡
        drawCards();
        //己方怪物状态重置
        flushZoneCardsBattleStatus();
        //打印状态信息
        //   printInfo();
    }

    @Override
    public void beginBattle(Game game) {
        this.game = game;
    }

    @Override
    public void stopBattle(Game game) {

    }


    private void flushZoneCardsBattleStatus() {
        BattleZone battleZone = this.getGame().getBattleZone();
        battleZone.flushCardsBattleStatus(this);
    }


    /**
     * 鱼人宝宝卡组
     *
     * @param deckName
     * @return
     */
    public Stack<Card> getDeckCards(String deckName) {
        return DeckPool.getDeck(deckName);

    }

    @Override
    public void printInfo() {
        //打印玩家卡牌信息
        boolean debugEnabled = log.isDebugEnabled();
        //debug模式 打印详细日志
        if (debugEnabled) {
            log.debug("基本信息:\r\n{}", JsonUtil.toJsonString(this));
            log.debug("牌局情况:\r\n{}", JsonUtil.toJsonString(this.getGame()));

        }
    }
}
