package dzh.com.JavaSE.com.Thread.Atomic;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 乐观锁： cas是从乐观的角度出发，假设每次获取数据别人都不会修改，所以不会上锁。只不过在修改共享数据的时候，会检查一下，别人有没有修改过这个数据。
 * ​	如果别人修改过，那么我再次获取现在最新的值。
 * ​	如果别人没有修改过，那么我现在直接修改共享数据的值.(乐观锁）。
 * 可能出现ABA问题
 * CAS算法:
 * 有3个操作数（内存值V， 旧的预期值A，要修改的值B）
 *
 * ​	当旧的预期值A == 内存值   此时修改成功，将V改为B
 *
 * ​	当旧的预期值A！=内存值   此时修改失败，不做任何操作
 *
 * ​	并重新获取现在的最新值（这个重新获取的动作就是自旋）
 */
public class AtomicInteger2 implements Runnable {
    AtomicInteger ices=new AtomicInteger(0);

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
                ices.incrementAndGet();
                System.out.println("送了"+ices+"个冰淇淋");
        }
    }

    public static void main(String[] args) {
        AtomicInteger2 ic=new AtomicInteger2();

        for (int i = 0; i < 10; i++) {
            new Thread(ic).start();
        }

    }
}
