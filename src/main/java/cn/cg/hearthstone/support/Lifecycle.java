package cn.cg.hearthstone.support;

/**
 * 生命周期对象
 *
 * @author: cg1
 * @date: 2021-04-18 00:21
 **/
public interface Lifecycle {
    void start();

    void stop();

    boolean isRunning();
}
