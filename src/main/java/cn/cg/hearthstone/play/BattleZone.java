package cn.cg.hearthstone.play;

import cn.cg.hearthstone.card.CardHolder;
import cn.cg.hearthstone.card.animal.AnimalCard;

import java.util.List;
import java.util.Map;

/**
 * 战斗区域
 *
 * @author: cg1
 * @date: 2021-04-16 17:24
 **/
public class BattleZone {

    private Map<String, List<CardHolder<AnimalCard>>> battleZone;

    public void addCardHolder(String playName, CardHolder<AnimalCard> cardCardHolder) {
        List<CardHolder<AnimalCard>> cardHolders = battleZone.get(playName);
        cardHolders.add(cardCardHolder);
    }
}
