package dzh.com.JavaSE.com.Thread.basic.Deamon;

public class MyThread1 extends Thread{

    @Override
    public void run() {
        int i=10;
        while (i>0){
            System.out.println(getName()+"-"+i--);
        }
    }
}

//-------------------------------------
class MyThread2 extends Thread{
    @Override
    public void run() {
        int i=10;
        while (i>0){
            System.out.println(getName()+"-"+i--);
        }
    }

    /**
     * 守护线程，普通线程执行完，jvm就退出了，不管是否有守护线程
     */
    public static void main(String[] args) {
        MyThread1 m1=new MyThread1();
        MyThread2 m2=new MyThread2();
        m1.setName("m1");
        m2.setName("m2");

        m2.setDaemon(true);

        m1.start();
        m2.start();
    }
}
