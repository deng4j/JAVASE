package JavaSE.com.GOF.adapter;

/**
 * 适配器模式
 * InputStreamReader，OutputStreamWrite
 * 两个转化流使用了适配器模式
 *
 * 这个对象相当于只有USB接口的笔记本
 */
public class Computer {

    public void USB(Target target){
        target.handleReq();
    }

    public static void main(String[] args) {
        Computer client=new Computer();
        KeyBoard keyBoard=new KeyBoard();
        Target t=new Adapter(keyBoard);

        client.USB(t);
    }

}
