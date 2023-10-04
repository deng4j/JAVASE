package dzh.com.JavaSE.com.Thread.basic.wait_notify_notifyAll.producerConsumer;

public class App {
    public static void main(String[] args) {
        Movie m=new Movie();

        Make make=new Make(m);
        Player player=new Player(m);

        Thread mk=new Thread(make);
        Thread pl=new Thread(player);
        mk.start();
        pl.start();
    }
}
