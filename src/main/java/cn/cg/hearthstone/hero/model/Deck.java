package cn.cg.hearthstone.hero.model;

import cn.cg.hearthstone.card.Card;
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
    private Stack<Card> deckCards = new Stack<Card>();


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
            Card card = deckCards.pop();
            if (card != null) {
                cards.add(card);
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

}
