package dzh.com.GOF.ProducerConsumer;

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
