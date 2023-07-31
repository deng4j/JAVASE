package dzh.com.JavaSE.com.Thread.Collections.ConcurrentHashMap;

import java.util.concurrent.ConcurrentHashMap;

/**
 * 在1.7之前：
 * 默认创建一个长度16，加载因子0.75的大数组。一旦创建，无法扩容。
 * 根据hash值存入大数组的索引，如果该索引处为null，则索引记录
 * 该地址值，然后在该地址下创建一个初始长度为2的小数组。元素进行
 * 二次哈希，存入小数组中。小数组相当于一个小hashmap
 *
 * 如果二次hash值一样，且equal不同，则会前插。
 * 如果二次hash值不一样，且equal一样，则会覆盖。
 *
 * concurrenthashmap每个线程操作会把大数组下的小数组锁住，使用悲观锁
 * concurrenthashmap最多允许16个线程同时操作
 *
 * 在1.8之后：
 *  1如果使用空参构造创建ConcurrentHashMap对象，则什么事情都不做。
 *  在第一次添加元素的时候创建哈希表。
 * ​	2，计算当前元素应存入的索引。
 * ​	3，如果该索引位置为null，则利用cas算法，将本结点添加到数组中。
 * ​	4，如果该索引位置不为null，则利用volatile关键字获得当前位置最新的结点地址，尾插，变成链表。
 * ​	5，当链表的长度大于等于8时，自动转换成红黑树6，以链表或者红黑树头结点为锁对象，配合悲观锁保证多线程操作集合时数据的安全性
 */
public class ConcurrentHashMap1 {
    public static void main(String[] args) throws InterruptedException {
        ConcurrentHashMap<String, String> hm = new ConcurrentHashMap<>(100);

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 25; i++) {
                hm.put(i + "", i + "");
            }
        });


        Thread t2 = new Thread(() -> {
            for (int i = 25; i < 51; i++) {
                hm.put(i + "", i + "");
            }
        });

        t1.start();
        t2.start();

        System.out.println("----------------------------");
        //为了t1和t2能把数据全部添加完毕
        Thread.sleep(1000);

        //0-0 1-1 ..... 50- 50

        for (int i = 0; i < 51; i++) {
            System.out.println(hm.get(i + ""));
        }//0 1 2 3 .... 50
    }
}
