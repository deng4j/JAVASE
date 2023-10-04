package dzh.com.JavaSE.com.Thread.JUC.Atomic.AtomicInteger;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicInteger0 {
    public static void main(String[] args) {
        AtomicInteger ac1 = new AtomicInteger(10);
        System.out.println("原子值" + ac1);

        //getAndIncrement返回自增前的值
        int andIncrement = ac1.getAndIncrement();
        System.out.println("getAndIncrement" + andIncrement);
        System.out.println("原子值" + ac1.get());

        //incrementAndGet():返回自增后的值返回自增后的值
        int ia = ac1.incrementAndGet();
        System.out.println("incrementAndGet:" + ia);
        System.out.println("原子值:" + ac1.get());

        //addAndGet:以原子方式将输入的数值与实例中的值
        int i = ac1.addAndGet(20);
        System.out.println("返回自增后的值" + i);
        System.out.println("原子值" + ac1.get());

        //以原子方式设置为newValue的值，并返回旧值。
        int andAdd = ac1.getAndAdd(10);
        System.out.println("getAndAdd:" + andAdd);
        System.out.println("原子值:" + ac1);

    }
}
