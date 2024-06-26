package dzh.com.DesignPattern.DesignPattern.behaviorPatterns.ProducerConsumer;

public class Make implements Runnable{
    private Movie movie;

    public Make(Movie m) {
        this.movie=m;
    }

    @Override
    public void run() {
        while (true){
            if (Movie.count==0){
                break;
            }else {
                if (Movie.count%2==0){
                    movie.make("《瑞克与莫蒂》");
                }else {
                    movie.make("《武庚纪》");
                }
            }
        }
    }
}
