package cn.cg.hearthstone.play;

import cn.cg.hearthstone.card.Card;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

/**
 * 墓地
 *
 * @author: cg1
 * @date: 2021-04-16 16:27
 **/
@Getter
@Setter
public class Cemetery {

    private List<Card> cardCemetery = new ArrayList<>();


    public void addCard(Card card) {
        cardCemetery.add(card);
    }

}
