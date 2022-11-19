package JavaSE.com.Thread.basic.ithiema;

/**
 *拓展性差不能继承其他类
 */
public class MyThread extends Thread {
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
        MyThread m1=new MyThread();
        m1.setName("m1");
        MyThread m2=new MyThread();
        m2.setName("m2");
        m1.start();
        m2.start();

        //
        int i = MyThread.activeCount();
        System.out.println(i);
        ThreadGroup threadGroup = m1.getThreadGroup();
        System.out.println(threadGroup);

    }
}
