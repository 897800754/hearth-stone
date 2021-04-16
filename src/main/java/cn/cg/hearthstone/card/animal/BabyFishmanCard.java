package cn.cg.hearthstone.card.animal;

import cn.cg.hearthstone.enums.OccupationEnum;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * 鱼人宝宝
 *
 * @author: cg1
 * @date: 2021-04-16 15:45
 **/
@EqualsAndHashCode(callSuper = true)
@Data
@ToString
public class BabyFishmanCard extends AnimalCard {


    public BabyFishmanCard() {
        super();
        init();
    }


    @Override
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
    public void battleRoar() {

    }

}
