package dzh.com.DesignPattern.DesignPattern.state;

/**
 * 状态模式:
 * 可以切换不同状态，对应不同行为。
 */
public class App {
    public static void main(String[] args) {
        Context ctx=new Context();

        ctx.setState(new  FreeState());
        ctx.setState(new BookedState());
    }
}
