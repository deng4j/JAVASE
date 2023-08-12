package dzh.com.DesignPattern.DesignPattern.structuralPatterns.adapter.adapter1;

import dzh.com.DesignPattern.DesignPattern.structuralPatterns.adapter.adapter1.adaptee.Adaptee;
import dzh.com.DesignPattern.DesignPattern.structuralPatterns.adapter.adapter1.adaptee.KeyBoard;
import dzh.com.DesignPattern.DesignPattern.structuralPatterns.adapter.adapter1.adaptee.Mouse;
import dzh.com.DesignPattern.DesignPattern.structuralPatterns.adapter.adapter1.adapter.Adapter;
import dzh.com.DesignPattern.DesignPattern.structuralPatterns.adapter.adapter1.adapter.Target;

/**
 * 单向适配器模式，只有笔记本能调用鼠标键盘，鼠标键盘不能调用
 * 这个对象相当于只有USB接口的笔记本
 *
 * 对象适配器模式还有如下优点：
 *  1.一个对象适配器可以把多个不同的适配者适配到同一个目标；
 *  2.可以适配一个适配者的子类，由于适配器和适配者之间是关联关系，根据“里氏代换原 则”，适配者的子类也可通过该适配器进行适配。
 * 主要缺点:
 *  1.对于Java、C#等不支持多重类继承的语言，一次最多只能适配一个适配者类，不能同时适 配多个适配者；
 *  2.适配者类不能为最终类，如在Java中不能为final类，C#中不能为sealed类；
 *  3.在Java、C#等语言中，类适配器模式中的 目标抽象类 只能为接口，不能为类，其使用有一定的局限性。
 */
public class Computer {

    Target target;
    public void USB(Target target){
        this.target =target;
    }

    public void request(){
        this.target.handleReq();
    }

    public static void main(String[] args) {
        Computer computer=new Computer();

        Adaptee keyBoard=new KeyBoard();
        Adapter adapter=new Adapter(keyBoard); // 适配器插入键盘

        computer.USB(adapter); // 电脑插入适配器
        computer.request(); // 调用键盘

        Adaptee mouse = new Mouse();
        adapter.setAdaptee(mouse); // 适配器插入鼠标

        computer.request(); // 调用鼠标
    }

}
