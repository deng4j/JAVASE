package JavaSE.com.Thread.basic;

import javax.swing.*;
import java.awt.*;


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
