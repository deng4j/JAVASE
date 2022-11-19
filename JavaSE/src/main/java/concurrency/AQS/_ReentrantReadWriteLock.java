package concurrency.AQS;

import lombok.extern.slf4j.Slf4j;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

@Slf4j
/**
 * 读写锁，所有读锁操作完成后写锁操作才能进行，会发生线程饥饿问题。
 */
public class _ReentrantReadWriteLock {
    private final Map<String,Data> map=new TreeMap<>();

    private final ReentrantReadWriteLock lock=new ReentrantReadWriteLock();

    private final Lock readLock=lock.readLock();
    private final Lock writeLock=lock.writeLock();

    public Data get(String  key){
        readLock.lock();
        try {
            return map.get(key);
        } finally {
            readLock.unlock();
        }
    }

    public Set<String> getAllKeys(){
        readLock.lock();
        try {
            return map.keySet();
        } finally {
            readLock.unlock();
        }
    }

    public Data put(String key,Data value){
        writeLock.lock();
        try {
            return map.put(key,value);
        } finally {
            writeLock.unlock();
        }
    }

    public static void main(String[] args) {
        _ReentrantReadWriteLock lock=new _ReentrantReadWriteLock();
        Data data1=new Data(18);
        Data data2=new Data(13);
        Data data3=new Data(1);

        lock.put("d1",data1);
        lock.put("d2",data2);
        lock.put("d3",data3);

        Data d1 = lock.get("d1");
        System.out.println(d1);


    }

}

@lombok.Data
class Data implements Comparable<Data>{
    private int age;

    public Data(int age) {
        this.age = age;
    }

    public Data() {
    }

    @Override
    public int compareTo(Data o) {
        return this.age-o.age;
    }
}
