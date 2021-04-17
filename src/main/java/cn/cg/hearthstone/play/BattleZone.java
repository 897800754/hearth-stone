package cn.cg.hearthstone.play;

import cn.cg.hearthstone.Game;
import cn.cg.hearthstone.card.CardHolder;
import cn.cg.hearthstone.card.animal.AnimalCard;
import cn.cg.hearthstone.play.player.Player;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * 战斗棋盘
 *
 * @author: cg1
 * @date: 2021-04-16 17:24
 **/
@Getter
@Setter
public class BattleZone {

    private Map<String, List<CardHolder<AnimalCard>>> battleZone;
    @JsonIgnore
    private Game game;


    public BattleZone(Game game) {
        this.game = game;
        this.battleZone = new HashMap<String, List<CardHolder<AnimalCard>>>();
        this.battleZone.put(game.getFirstPlayer().getPlayName(), new LinkedList<CardHolder<AnimalCard>>());
        this.battleZone.put(game.getLastPlayer().getPlayName(), new LinkedList<CardHolder<AnimalCard>>());
    }

    public void addCardHolder(String playName, CardHolder<AnimalCard> cardCardHolder) {
        List<CardHolder<AnimalCard>> cardHolders = battleZone.get(playName);
        cardHolders.add(cardCardHolder);
    }


    public void removeIfNeed() {
        List<CardHolder<AnimalCard>> firstCardHolders = battleZone.get(game.getFirstPlayer().getPlayName());
        List<CardHolder<AnimalCard>> lastCardHolders = battleZone.get(game.getLastPlayer().getPlayName());
        firstCardHolders.removeIf(x -> x.getLive() == 0 || x.getCurrentBloodVolume() <= 0);
        lastCardHolders.removeIf(x -> x.getLive() == 0 || x.getCurrentBloodVolume() <= 0);
        //送入墓地,todo


    }

    public void flushCardsBattleStatus(Player player) {
        List<CardHolder<AnimalCard>> cardHolders = battleZone.get(player.getPlayName());
        for (CardHolder<AnimalCard> cardHolder : cardHolders) {
            cardHolder.flushBattleStatus();
        }
    }

    /**
     * 获取先手玩家战斗区
     *
     * @return
     */
    public List<CardHolder<AnimalCard>> getFirstPlayBattleZone() {
        return this.battleZone.get(game.getFirstPlayer().getPlayName());
    }

    /**
     * 获取后手玩家战斗区
     *
     * @return
     */
    public List<CardHolder<AnimalCard>> getLastPlayBattleZone() {
        return this.battleZone.get(game.getLastPlayer().getPlayName());
    }

}
