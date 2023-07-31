package dzh.com.GOF.bridge.question;

/**
 * 联想品牌电脑
 */
public class LenovoDeskTop extends Desktop{
    @Override
    public void sale() {
        System.out.println("销售联想台式电脑");
    }
}

/**
 * 联想牌pad
 */
class LenovoPad extends Pad{
    @Override
    public void sale() {
        System.out.println("销售联想牌pad");
    }
}

/**
 * 联想牌笔记本
 */
class LenovoLapTop extends Desktop{
    @Override
    public void sale() {
        System.out.println("销售联想笔记本电脑");
    }
}