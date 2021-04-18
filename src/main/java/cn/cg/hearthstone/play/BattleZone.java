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
import java.util.stream.Collectors;

/**
 * 战斗棋盘
 *
 * @author: cg1
 * @date: 2021-04-16 17:24
 **/
@Getter
@Setter
public class BattleZone {

    private Map<String, LinkedList<CardHolder<AnimalCard>>> battleZone;
    @JsonIgnore
    private Game game;


    public BattleZone(Game game) {
        this.game = game;
        this.battleZone = new HashMap<String, LinkedList<CardHolder<AnimalCard>>>();
        this.battleZone.put(game.getFirstPlayer().getPlayName(), new LinkedList<CardHolder<AnimalCard>>());
        this.battleZone.put(game.getLastPlayer().getPlayName(), new LinkedList<CardHolder<AnimalCard>>());
    }

    public void addCardHolder(String playName, CardHolder<AnimalCard> cardCardHolder) {
        List<CardHolder<AnimalCard>> cardHolders = battleZone.get(playName);
        cardHolders.add(cardCardHolder);
    }


    public void removeIfNeed() {
        Player firstPlayer = game.getFirstPlayer();
        List<CardHolder<AnimalCard>> firstCardHolders = battleZone.get(firstPlayer.getPlayName());
        Player lastPlayer = game.getLastPlayer();
        List<CardHolder<AnimalCard>> lastCardHolders = battleZone.get(lastPlayer.getPlayName());

        //触发亡语 ,todo 先下先触发
        List<CardHolder<AnimalCard>> firstCardHoldersNeedRemove = firstCardHolders
                .stream()
                .filter(x -> x.getLive() == 0 || x.getCurrentBloodVolume() <= 0)
                .peek(x -> x.dead(game, firstPlayer))
                .collect(Collectors.toList());
        List<CardHolder<AnimalCard>> lastCardHoldersNeedRemove = lastCardHolders
                .stream()
                .filter(x -> x.getLive() == 0 || x.getCurrentBloodVolume() <= 0)
                .peek(x -> x.dead(game, lastPlayer))
                .collect(Collectors.toList());

        //从战斗区删除
        firstCardHolders.removeAll(firstCardHoldersNeedRemove);
        lastCardHolders.removeAll(lastCardHoldersNeedRemove);
        //加入墓地
        for (CardHolder<AnimalCard> animalCardCardHolder : firstCardHoldersNeedRemove) {
            firstPlayer.getCemetery().addCard(animalCardCardHolder.getCard());
        }
        for (CardHolder<AnimalCard> animalCardCardHolder : lastCardHoldersNeedRemove) {
            lastPlayer.getCemetery().addCard(animalCardCardHolder.getCard());
        }
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

    /**
     * 获取当前玩家战斗区
     *
     * @return
     */
    public List<CardHolder<AnimalCard>> getCurrentPlayerBattleZone(Game game) {
        return this.battleZone.get(game.getCurrentPlay().getPlayName());
    }

    /**
     * 卡牌是否大于7
     *
     * @param game
     * @return
     */
    public boolean currentPlayerBattleZoneFull(Game game, Integer expect) {
        return getCurrentPlayerBattleZone(game).size() + expect >= 7;
    }


}
