package cn.cg.hearthstone.card.magic;

import cn.cg.hearthstone.Game;
import cn.cg.hearthstone.enums.OccupationEnum;
import cn.cg.hearthstone.play.player.Player;
import lombok.Getter;
import lombok.Setter;

/**
 * @author: cg1
 * @date: 2021-04-18 21:35
 **/
@Getter
@Setter
public class CoinCard extends MagicCard {
    @Override
    public void init() {
        this.setCost(0);
        this.setOccupationEnum(OccupationEnum.NORMAL);
        setCode("CoinCard");
        setDesc("获得一个能量水晶");
        setName("魔法币");
    }

    @Override
    public void BattleCry(Game game, Player fromPlay) {
        //使用玩家获得一个临时魔法币
        fromPlay.setCurrentCost(fromPlay.getCurrentCost() + 1);
    }

}
