package cn.cg.hearthstone.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 游戏对局状态
 *
 * @author: cg1
 * @date: 2021-04-16 18:51
 **/
@AllArgsConstructor
@Getter
public enum RoomStatusEnum {
    BEGIN("begin", "开始"),

    ING("ing", "进行中"),

    END("end", "结束"),

    ;
    private String status;

    private String desc;
}
