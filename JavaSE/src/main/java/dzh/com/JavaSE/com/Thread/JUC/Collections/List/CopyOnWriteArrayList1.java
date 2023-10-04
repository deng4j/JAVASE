package dzh.com.JavaSE.com.Thread.JUC.Collections.List;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public class CopyOnWriteArrayList1 {
    /**
     * 迭代器弱一致性问题
     */
    public static void main(String[] args) throws InterruptedException {
        CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<>();
        list.add("aaa");
        list.add("bbb");
        list.add("ccc");
        list.add("ddd");
        list.add("eee");

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                list.set(2, "222");
                list.remove(3);
            }
        });
        thread.start();

        Iterator<String> it = list.iterator();

        thread.join();

        while (it.hasNext()){
            System.out.println(it.next());
        }
    }
}
