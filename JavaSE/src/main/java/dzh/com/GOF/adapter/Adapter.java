package dzh.com.GOF.adapter;

/**
 * （USB和ps/2）适配器
 *
 */
public class Adapter  implements Target{
    private KeyBoard keyBoard;

    public Adapter(KeyBoard keyBoard) {
        this.keyBoard = keyBoard;
    }

    @Override
    public void handleReq() {
        keyBoard.request();
    }
}