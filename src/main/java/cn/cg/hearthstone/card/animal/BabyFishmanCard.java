package cn.cg.hearthstone.card.animal;

import cn.cg.hearthstone.Game;
import cn.cg.hearthstone.enums.OccupationEnum;
import lombok.*;

/**
 * 鱼人宝宝
 *
 * @author: cg1
 * @date: 2021-04-16 15:45
 **/
@EqualsAndHashCode(callSuper = true)
@Getter
@Setter
@ToString
public class BabyFishmanCard extends AnimalCard {


    public void init() {
        this.setCost(0);
        this.setOccupationEnum(OccupationEnum.NORMAL);
        setCode("BabyFishmanCard");
        setDesc("鱼人宝宝");
        setName("鱼人宝宝");
        setAggressivity(1);
        setBloodVolume(1);
    }


    @Override
    public void BattleCry(Game game) {

    }
}
