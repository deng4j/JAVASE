package JavaSE.com.GOF.bridge.question;

/**
 * 神州品牌电脑
 */
public class ShenZhouDeskTop extends Desktop{
    @Override
    public void sale() {
        System.out.println("销售神州台式电脑");
    }
}

/**
 * 神州牌pad
 */
class ShenZhouPad extends Pad{
    @Override
    public void sale() {
        System.out.println("销售神州牌pad");
    }
}

/**
 * 神州牌笔记本
 */
class ShenZhouLapTop extends Desktop{
    @Override
    public void sale() {
        System.out.println("销售神州笔记本电脑");
    }
}