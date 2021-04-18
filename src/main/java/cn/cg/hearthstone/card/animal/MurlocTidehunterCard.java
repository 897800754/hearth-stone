package cn.cg.hearthstone.card.animal;

import cn.cg.hearthstone.Game;
import cn.cg.hearthstone.card.CardHolder;
import cn.cg.hearthstone.enums.OccupationEnum;
import cn.cg.hearthstone.play.BattleZone;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

/**
 * 鱼人猎潮者
 *
 * @author: cg1
 * @date: 2021-04-16 15:45
 **/
@EqualsAndHashCode(callSuper = true)
@Getter
@Setter
@ToString
@Slf4j
public class MurlocTidehunterCard extends AnimalCard {


    public void init() {
        this.setCost(1);
        this.setOccupationEnum(OccupationEnum.NORMAL);
        setCode("MurlocTidehunterCard");
        setDesc("战吼:召唤一个1/1的约人斥侯");
        setName("鱼人猎潮者");
        setAggressivity(2);
        setBloodVolume(1);
    }


    @Override
    public void BattleCry(Game game) {
        BattleZone battleZone = game.getBattleZone();
        //todo 召唤两个
        if (battleZone.currentPlayerBattleZoneFull(game, 1)) {
            log.error("卡槽已满");
            return;
        }
        //召唤一个小怪
        SmallMurlocTidehunterCard smallMurlocTidehunterCard = new SmallMurlocTidehunterCard();
        //加入到游戏对局中
        CardHolder<AnimalCard> animalCardCardHolder = new CardHolder(smallMurlocTidehunterCard);
        battleZone.addCardHolder(game.getCurrentPlay().getPlayName(), animalCardCardHolder);
    }


    public class SmallMurlocTidehunterCard extends AnimalCard {

        @Override
        public void init() {
            this.setCost(1);
            this.setOccupationEnum(OccupationEnum.NORMAL);
            setCode("SmallMurlocTidehunterCard");
            setDesc("");
            setName("鱼人猎潮者儿子");
            setAggressivity(1);
            setBloodVolume(1);
        }

        @Override
        public void BattleCry(Game game) {

        }
    }
}
