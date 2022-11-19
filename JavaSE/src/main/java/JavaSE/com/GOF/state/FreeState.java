package JavaSE.com.GOF.state;

public class FreeState implements State {
    @Override
    public void handle() {
        System.out.println("房间空闲");
    }
}

class BookedState implements State{

    @Override
    public void handle() {
        System.out.println("房间已预订");
    }
}

class CheckedInState implements State{

    @Override
    public void handle() {
        System.out.println("房间已入住");
    }
}

