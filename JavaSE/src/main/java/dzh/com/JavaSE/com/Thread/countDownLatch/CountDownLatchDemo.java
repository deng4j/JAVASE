package dzh.com.JavaSE.com.Thread.countDownLatch;

import java.util.concurrent.CountDownLatch;

/**
 * 让某些线程等待其他线程执行完毕之后再执行
 */
public class CountDownLatchDemo {
    public static void main(String[] args) {
        //计数器的值为3
        CountDownLatch cdl=new CountDownLatch(3);

        Mother mother=new Mother(cdl);
        new Thread(mother,"妈妈").start();

        Child1 child1=new Child1(cdl);
        new Thread(child1,"大娃").start();

        Child2 child2=new Child2(cdl);
        new Thread(child2,"二娃").start();

        Child3 child3=new Child3(cdl);
        new Thread(child3,"三娃").start();

    }
}
