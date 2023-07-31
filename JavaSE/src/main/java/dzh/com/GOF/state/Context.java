package dzh.com.GOF.state;

/**
 * 切换状态
 */
public class Context {
    private State state;

    public void setState(State state) {
        System.out.println("----修改状态----");
        this.state = state;
        this.state.handle();

    }
}
