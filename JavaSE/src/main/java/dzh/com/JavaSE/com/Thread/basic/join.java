package dzh.com.JavaSE.com.Thread.basic;

import javax.swing.*;
import java.awt.*;

/**
 * join()是 Thread 类中的一个方法，当我们需要让线程按照自己指定的顺序执行的时候，就可以利用这个方法。
 *
 * Thread.join()方法表示调用此方法的线程被阻塞，仅当该方法完成以后，才能继续运行。
 */
public class join extends JFrame {
    private  Thread A;
    private  Thread B;
    final  JProgressBar progressBar=new JProgressBar();
    final JProgressBar progressBar2=new JProgressBar();

    public join(){
        super();
        getContentPane().add(progressBar,BorderLayout.NORTH);
        getContentPane().add(progressBar2,BorderLayout.SOUTH);
        progressBar.setStringPainted(true);
        progressBar2.setStringPainted(true);

        A=new Thread(new Runnable() {
            int count=0;
            @Override
            public void run() {
                while (true){
                    progressBar.setValue(++count);
                    try {
                        Thread.sleep(200);//线程休眠两秒等待B线程结束
                        B.join();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        A.start();

        B=new Thread(new Runnable() {
            int count=0;
            @Override
            public void run() {
                while (true) {
                    progressBar2.setValue(++count);
                    try {
                        Thread.sleep(100);//线程休眠0.1秒
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    if (count == 100) {
                        break;
                    }
                }
            }
        });
        B.start();
    }
    public static void init(JFrame frame,int w,int h){
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(w,h);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        init(new join() ,400,200);
    }
}
