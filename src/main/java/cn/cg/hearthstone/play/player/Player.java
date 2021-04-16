package cn.cg.hearthstone.play.player;

import cn.cg.hearthstone.card.Card;
import cn.cg.hearthstone.card.CardHolder;
import cn.cg.hearthstone.card.animal.AnimalCard;
import cn.cg.hearthstone.card.animal.BabyFishmanCard;
import cn.cg.hearthstone.enums.CardTypeEnum;
import cn.cg.hearthstone.play.BattleZone;
import cn.cg.hearthstone.play.Cemetery;
import cn.cg.hearthstone.play.room.Room;
import cn.cg.hearthstone.play.deck.Deck;
import cn.cg.hearthstone.play.hand.Hand;
import cn.cg.hearthstone.hero.Hero;
import lombok.Data;

import java.util.Collections;
import java.util.Stack;

/**
 * 玩家类
 *
 * @author: cg1
 * @date: 2021-04-16 15:37
 **/
@Data
public class Player implements PlayerOperations {
    /**
     * 玩家名
     */
    private String playName;

    public Player(String playName, Room room, Hero hero, String deckName) {
        this.playName = playName;
        this.room = room;
        this.cemetery = new Cemetery();
        this.deck = new Deck();
        this.hand = new Hand();
        this.hero = hero;
        this.deckName = deckName = "鱼人宝宝";
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
    private Room room;
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
    private Deck deck;

    /**
     * 当前费用
     */
    private Integer currentCost = 1;
    /**
     * 手牌
     */
    private Hand hand;
    /**
     * 手牌上限
     */
    private Integer handCardMaxLimit = 5;
    /**
     * 墓地
     */
    private Cemetery cemetery;
    /**
     * 战斗区
     *
     * @param card
     */
    private BattleZone battleZone;

    @Override
    public void playHandCard(Card card) {
        //生物卡牌
        if (CardTypeEnum.ANIMAL.getCode().equals(card.getCardTypeEnum().getCode())) {
            //战吼回调
            card.battleRoar();
            //加入战斗区
            CardHolder<AnimalCard> animalCardCardHolder = new CardHolder<>((AnimalCard) card);
            battleZone.addCardHolder(this.playName, animalCardCardHolder);
        }
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


    /**
     * 鱼人宝宝卡组
     *
     * @param deckName
     * @return
     */
    public Stack<Card> getDeckCards(String deckName) {
        //放入30张鱼人宝宝
        Stack<Card> deckCards = new Stack<>();
        for (int i = 0; i < 30; i++) {
            BabyFishmanCard babyFishmanCard = new BabyFishmanCard();
            deckCards.add(babyFishmanCard);
        }
        return deckCards;
    }
}
