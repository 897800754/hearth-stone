package cn.cg.hearthstone.card.animal;

import cn.cg.hearthstone.Game;
import cn.cg.hearthstone.enums.OccupationEnum;
import cn.cg.hearthstone.play.player.Player;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

/**
 * 战利品贮藏者
 *
 * @author: cg1
 * @date: 2021-04-16 15:45
 **/
@EqualsAndHashCode(callSuper = true)
@Getter
@Setter
@ToString
@Slf4j
public class LootHoarderCard extends AnimalCard {


    public void init() {
        this.setCost(2);
        this.setOccupationEnum(OccupationEnum.NORMAL);
        setCode("LootHoarderCard");
        setDesc("亡语:抽一张牌");
        setName("战利品贮藏者");
        setAggressivity(2);
        setBloodVolume(1);
    }

    @Override
    public void deathLanguage(Game game, Player fromPlay) {
        //玩家抽一张卡牌
        fromPlay.drawCards();
    }


}
