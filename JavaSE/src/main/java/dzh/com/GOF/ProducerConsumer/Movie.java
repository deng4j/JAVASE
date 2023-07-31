package dzh.com.GOF.ProducerConsumer;

public class Movie {
    private  boolean flag=false;
    public static int count=10;
    private String video;

    public synchronized void make(String video){
        if (flag){
            //up等待
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }else {
            System.out.println("剪辑了"+video);
            flag=true;
            this.video=video;
            this.notifyAll();
        }

    }
    public synchronized void player(){
        if (flag){
            System.out.println("播放了"+"《"+video+"》");
            flag=false;
            count--;
            this.notifyAll();

        }else {
            //观众等待
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

}
