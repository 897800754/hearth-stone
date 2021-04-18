package cn.cg.hearthstone.play.player.deck;

import cn.cg.hearthstone.card.Card;
import cn.cg.hearthstone.card.animal.BabyFishmanCard;
import cn.cg.hearthstone.card.animal.LootHoarderCard;
import cn.cg.hearthstone.card.animal.MurlocTidehunterCard;

import java.util.HashMap;
import java.util.Stack;

/**
 * 卡组池,临时
 *
 * @author: cg1
 * @date: 2021-04-18 19:51
 **/
public class DeckPool {
    /**
     * 卡组池
     */
    private static HashMap<String, Stack<Card>> DECK_POOL;

    static {
        DECK_POOL = new HashMap<>();

        //放入30张鱼人宝宝
        Stack<Card> babyFishmanDeckCards = new Stack<>();
        for (int i = 0; i < 30; i++) {
            BabyFishmanCard babyFishmanCard = new BabyFishmanCard();
            babyFishmanDeckCards.add(babyFishmanCard);
        }
        DECK_POOL.put("鱼人宝宝卡组", babyFishmanDeckCards);
        //放入三十张鱼人猎潮者
        Stack<Card> murlocTidehunterDeckCards = new Stack<>();
        for (int i = 0; i < 30; i++) {
            MurlocTidehunterCard murlocTidehunterCard = new MurlocTidehunterCard();
            murlocTidehunterDeckCards.add(murlocTidehunterCard);
        }
        DECK_POOL.put("鱼人猎潮者卡组", murlocTidehunterDeckCards);
        //三十张战利品
        Stack<Card> lootHoarderCardDeckCards = new Stack<>();
        for (int i = 0; i < 30; i++) {
            LootHoarderCard lootHoarderCard = new LootHoarderCard();
            lootHoarderCardDeckCards.add(lootHoarderCard);
        }
        DECK_POOL.put("战利品卡组", lootHoarderCardDeckCards);
    }

    public static Stack<Card> getDeck(String name) {
        return DECK_POOL.get(name);
    }

}
