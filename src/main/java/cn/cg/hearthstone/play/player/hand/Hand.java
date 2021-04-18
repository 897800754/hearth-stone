package cn.cg.hearthstone.play.player.hand;

import cn.cg.hearthstone.Game;
import cn.cg.hearthstone.card.Card;
import cn.cg.hearthstone.play.player.deck.Deck;
import cn.cg.hearthstone.play.player.Player;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

/**
 * 手牌对象
 *
 * @author: cg1
 * @date: 2021-04-16 13:47
 **/
@Getter
@Setter
public class Hand implements HandOperations {

    /**
     * 手牌
     */
    private List<Card> handCard;
    /**
     * 当前手牌数
     */
    private Integer currentHandCardCount;


    public Hand() {
    }

    @Override
    public void addCard(List<Card> cards) {
        this.handCard.addAll(cards);
        setCurrentHandCardCount();
    }

    @Override
    public void remove(List<Card> cards) {
        for (Card card : cards) {
            handCard.removeIf(next -> next.getId().equals(card.getId()));
        }
        setCurrentHandCardCount();
    }

    @Override
    public void initHand(Player player) {
        Deck deck = player.getDeck();
        List<Card> cards;

        Game game = player.getGame();
        Player currentPlay = game.getCurrentPlay();
        if (currentPlay.equals(player)) {
            //先手3张排
            cards = deck.obtainCard(3);
        } else {
            //后手4张牌+硬币
            cards = deck.obtainCard(4);
            //   cards.add();
        }
        //抽四张牌加入手牌
        this.handCard = new ArrayList<>(cards);
        setCurrentHandCardCount();
    }

    public Integer getCurrentHandCardCount() {
        return handCard.size();
    }

    public void setCurrentHandCardCount() {
        this.currentHandCardCount = handCard.size();
    }
}
