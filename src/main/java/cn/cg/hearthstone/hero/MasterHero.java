package cn.cg.hearthstone.hero;

import cn.cg.hearthstone.card.CardHolder;
import cn.cg.hearthstone.card.animal.AnimalCard;
import cn.cg.hearthstone.enums.OccupationEnum;
import cn.cg.hearthstone.play.BattleZone;
import cn.cg.hearthstone.play.player.Player;

/**
 * @author: cg1
 * @date: 2021-04-16 16:10
 **/
public class MasterHero extends Hero {

    /**
     * 初始化
     */
    public MasterHero() {
        super(OccupationEnum.MASTER);
    }

    @Override
    public void initHero(Player player) {
        this.setSkillCost(2);
    }

    @Override
    public void skillCost(Player from) {
        from.setCurrentCost(from.getCurrentCost() - getSkillCost());
    }

    @Override
    public void skillEffect(Player from, Object to) {
        if (to instanceof Player) {
            Player toPlayer = (Player) to;
            toPlayer.setCurrentBloodVolume(toPlayer.getCurrentBloodVolume() - 1);
        } else {
            //
            CardHolder<AnimalCard> toAnimalCard = (CardHolder<AnimalCard>) to;
            toAnimalCard.setCurrentBloodVolume(toAnimalCard.getCurrentBloodVolume() - 1);
            //是否需要进入墓地
            BattleZone battleZone = from.getGame().getBattleZone();
            battleZone.removeIfNeed();
        }
    }

}
