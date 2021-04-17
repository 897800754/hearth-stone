package cn.cg.hearthstone.support;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * 游戏结束
 *
 * @author: cg1
 * @date: 2021-04-17 14:38
 **/
@Aspect
@Component
@Slf4j
public class RoomFinishAOP {

    @Around("@annotation(cn.cg.hearthstone.support.RoomFinish)")
    public Object finishAround(ProceedingJoinPoint point) throws Throwable {
        Object[] args = point.getArgs();
        try {
            return point.proceed(args);
        } catch (Throwable throwable) {
            //发送告警消息
//            MethodSignature signature = (MethodSignature) point.getSignature();
//            WarnMessage annotation = signature.getMethod().getAnnotation(WarnMessage.class);
            throw throwable;
        }
    }
}
