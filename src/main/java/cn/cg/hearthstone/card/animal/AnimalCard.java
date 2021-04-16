package cn.cg.hearthstone.card.animal;

import cn.cg.hearthstone.card.Card;
import cn.cg.hearthstone.enums.CardTypeEnum;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author: cg1
 * @date: 2021-04-16 15:47
 **/
@EqualsAndHashCode(callSuper = true)
@Data
public abstract class AnimalCard extends Card {


    public AnimalCard() {
        this.setCardTypeEnum(CardTypeEnum.ANIMAL);
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
