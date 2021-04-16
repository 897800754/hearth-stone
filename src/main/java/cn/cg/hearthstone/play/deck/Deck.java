package cn.cg.hearthstone.play.deck;

import cn.cg.hearthstone.card.Card;
import cn.cg.hearthstone.play.player.Player;
import lombok.Data;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 套牌
 *
 * @author: cg1
 * @date: 2021-04-16 13:39
 **/
@Data
public class Deck implements DeckOperations {

    /**
     * 套牌
     * todo
     */
    private Stack<Card> deckCards;

    public Deck() {
    }

    /**
     * 获取卡牌
     *
     * @param count
     * @return
     */
    @Override
    public List<Card> obtainCard(Integer count) {
        ArrayList<Card> cards = new ArrayList<>();
        int cursor = 0;
        while (cursor >= count) {
            Card findCard = deckCards.pop();
            if (findCard != null) {
                cards.add(findCard);
            } else {
                break;
            }
            cursor++;
        }
        return cards;
    }

    /**
     * 从套牌库抽取一张套牌
     *
     * @return
     */
    @Override
    public Card obtainCard() {
        List<Card> cardFromHouse = obtainCard(1);
        if (CollectionUtils.isEmpty(cardFromHouse) || cardFromHouse.size() != 1) {
            throw new RuntimeException();
        }
        return CollectionUtils.firstElement(cardFromHouse);
    }

    /**
     * 初始化卡组
     *
     * @param player
     */
    @Override
    public void initDeck(Player player) {
        //获取套牌
        Stack<Card> cards = player.getDeckCards(player.getDeckName());
        //洗牌
        flushDeckCards(cards);
    }

    private void flushDeckCards(Stack<Card> cards) {
        this.deckCards = cards;
    }
}
