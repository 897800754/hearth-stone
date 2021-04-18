package cn.cg.hearthstone.card.animal;

import cn.cg.hearthstone.card.Card;
import cn.cg.hearthstone.card.CardBattleEffect;
import cn.cg.hearthstone.enums.CardTypeEnum;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

/**
 * @author: cg1
 * @date: 2021-04-16 15:47
 **/
@EqualsAndHashCode(callSuper = true)
@Getter
@Setter
public abstract class AnimalCard extends Card implements CardBattleEffect {


    public AnimalCard() {
        this.setCardTypeEnum(CardTypeEnum.ANIMAL);
        init();
    }

    /**
     * 攻击力
     */
    private Integer aggressivity;
    /**
     * 血量
     */
    private Integer bloodVolume;


}
