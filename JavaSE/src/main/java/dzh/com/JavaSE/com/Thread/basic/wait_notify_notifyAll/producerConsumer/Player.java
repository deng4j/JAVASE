package dzh.com.JavaSE.com.Thread.basic.wait_notify_notifyAll.producerConsumer;

public class Player implements Runnable{
    private Movie movie;

    public Player(Movie m) {
        this.movie=m;
    }

    @Override
    public void run() {
        while (true){
            if (Movie.count==0){
                break;
            }else {
               movie.player();
            }
        }
    }
}
