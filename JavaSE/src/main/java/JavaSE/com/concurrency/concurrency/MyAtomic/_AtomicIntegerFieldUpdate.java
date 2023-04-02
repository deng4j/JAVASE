package JavaSE.com.concurrency.concurrency.MyAtomic;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/**
 * AtomicIntegerFieldUpdater：用于对一个对象的成员属性进行原子修改。
 * 成员属性：非static，volatile。
 */
@Slf4j
public class _AtomicIntegerFieldUpdate {
    private static AtomicIntegerFieldUpdater<_AtomicIntegerFieldUpdate> updater=
             AtomicIntegerFieldUpdater.newUpdater(_AtomicIntegerFieldUpdate.class,"count");
    @Getter
    public volatile int count=100;

    public static void main(String[] args) {
        _AtomicIntegerFieldUpdate aifu=new _AtomicIntegerFieldUpdate();
        if (updater.compareAndSet(aifu,100,200)){
            log.info("update success1:",aifu.getCount());
        }
        if (updater.compareAndSet(aifu,100,200)){
            log.info("update success2:",aifu.getCount());
        }else {
            log.info("update failed:",aifu.getCount());
        }
    }

}
