package dzh.com.JavaSE.com.Thread.basic;

/**
 * 拓展性差不能继承其他类
 */
public class Thread1 extends Thread {
    private  int i=10;
    @Override
    public void run() {
        print();
    }

    private void print() {
        while (i>0){
            System.out.println(currentThread().getName()+"--"+i--);
        }
    }

    public static void main(String[] args) {
        Thread1 m1=new Thread1();
        m1.setName("m1");
        Thread1 m2=new Thread1();
        m2.setName("m2");
        m1.start();
        m2.start();

        int i = Thread1.activeCount();
        System.out.println(i);
        ThreadGroup threadGroup = m1.getThreadGroup();
        System.out.println(threadGroup);
    }
}
