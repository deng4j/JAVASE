package JavaSE.com.concurrency.concurrency.MyAtomic;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

@Slf4j
public class _AtomicReference {
    private static AtomicReference<Integer> count=new AtomicReference<>(0);

    public static void main(String[] args) {
        //如果是expectedValue，更新成newValue
        count.compareAndSet(0,2);
        count.compareAndSet(0,1);
        count.compareAndSet(1,3);
        count.compareAndSet(2,4);
        count.compareAndSet(3,5);

        log.info("count:{}",count.get());

        List<Integer> list=new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);


    }
}
