package cn.cg.hearthstone.card.magic;

import cn.cg.hearthstone.Game;
import cn.cg.hearthstone.card.Card;
import cn.cg.hearthstone.card.CardBattleEffect;
import cn.cg.hearthstone.enums.CardTypeEnum;
import cn.cg.hearthstone.play.player.Player;

/**
 * 法术卡牌
 *
 * @author: cg1
 * @date: 2021-04-18 21:36
 **/
public abstract class MagicCard extends Card implements CardBattleEffect {


    public MagicCard() {
        this.setCardTypeEnum(CardTypeEnum.MAGIC);
        init();
    }


    @Override
    public void deathLanguage(Game game, Player fromPlay) {
        throw new RuntimeException("法术卡牌没有战吼");
    }
}
