package cn.cg.hearthstone.play.hand;

import cn.cg.hearthstone.card.Card;
import cn.cg.hearthstone.play.deck.Deck;
import cn.cg.hearthstone.play.player.Player;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * 手牌对象
 *
 * @author: cg1
 * @date: 2021-04-16 13:47
 **/
@Data
public class Hand implements HandOperations {

    /**
     * 手牌
     */
    private List<Card> handCard;

    public Hand() {
    }

    @Override
    public void addCard(List<Card> cards) {
        this.handCard.addAll(cards);
    }

    @Override
    public void initHand(Player player) {
        Deck deck = player.getDeck();
        List<Card> cards = deck.obtainCard(5);
        //抽五张牌加入手牌
        this.handCard = new ArrayList<>(cards);
    }


}
