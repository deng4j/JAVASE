package JavaSE.com.Thread.Pool.TestAtom;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 悲观锁：synchronized总是从最坏的角度出发，认为每次获取数据的时候，别人都有可能修改。
 */
public class sycn_ice implements Runnable {
    private  int ices=0;
    private Lock lock=new ReentrantLock();
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            //从共享数据拿到本地栈，修改后赋值给共享数据
            synchronized (lock){
                //ices++本身不是一个原子性的操作，用锁
                ices++;
                System.out.println("送了"+ices+"个冰淇淋");
            }
        }
    }

    public static void main(String[] args) {
        sycn_ice ic=new sycn_ice();

        for (int i = 0; i < 100; i++) {
            new Thread(ic).start();
        }

    }
}
