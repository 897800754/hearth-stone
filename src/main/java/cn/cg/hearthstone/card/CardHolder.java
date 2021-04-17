package cn.cg.hearthstone.card;

import cn.cg.hearthstone.card.animal.AnimalCard;
import cn.cg.hearthstone.enums.CardBattleStatusEnum;
import cn.cg.hearthstone.play.player.Player;
import lombok.Getter;
import lombok.Setter;

/**
 * @author: cg1
 * @date: 2021-04-16 17:26
 **/
@Getter
@Setter
public class CardHolder<T extends AnimalCard> {

    private T card;

    public CardHolder(T card) {
        this.card = card;
        this.live = 1;
        this.currentAggressivity = card.getAggressivity();
        this.currentBloodVolume = card.getBloodVolume();
        //战斗状态
        this.battleStatus = CardBattleStatusEnum.READY;
    }

    /**
     * 是否存活
     */
    private Integer live;
    /**
     * 当前攻击力
     */
    private Integer currentAggressivity;
    /**
     * 当前血量
     */
    private Integer currentBloodVolume;
    /**
     * 战斗状态
     */
    private CardBattleStatusEnum battleStatus;

    /**
     * 攻击card
     *
     * @param beAttackedHolder 被攻击card
     */
    public void attack(CardHolder<AnimalCard> beAttackedHolder) {
        //攻击完成,计算血量
        //攻击者血量
        this.setCurrentBloodVolume(beAttackedHolder.getCurrentAggressivity() - this.getCurrentBloodVolume());
        beAttackedHolder.setCurrentBloodVolume(this.getCurrentAggressivity() - beAttackedHolder.getCurrentBloodVolume());
        //攻击状态变更
        this.setBattleStatus(CardBattleStatusEnum.ATTACKED);
        //计算是否存活
        if (this.getCurrentBloodVolume() <= 0) {
            this.setLive(0);
        }
        if (beAttackedHolder.getCurrentBloodVolume() <= 0) {
            beAttackedHolder.setLive(0);
        }
    }

    /**
     * 攻击玩家
     * @param beAttackedPlay
     */
    public void attack(Player beAttackedPlay) {
      //todo
        //玩家血量减



    }




    public void flushBattleStatus() {
        this.battleStatus = CardBattleStatusEnum.ATTACHABLE;
    }
}
