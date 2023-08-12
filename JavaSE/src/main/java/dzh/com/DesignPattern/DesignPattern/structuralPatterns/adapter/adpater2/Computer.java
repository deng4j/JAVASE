package dzh.com.DesignPattern.DesignPattern.structuralPatterns.adapter.adpater2;

import dzh.com.DesignPattern.DesignPattern.structuralPatterns.adapter.adpater2.adaptee.Adaptee;
import dzh.com.DesignPattern.DesignPattern.structuralPatterns.adapter.adpater2.adaptee.KeyBoard;

public class Computer implements Target{
    @Override
    public void handleReq() {
        System.out.println("电脑");
    }

    public static void main(String[] args) {
        Adaptee keyBoard = new KeyBoard();
        Computer computer = new Computer();

        Adapter adapter = new Adapter(keyBoard,computer);
        adapter.handleReq(); // 电脑使用键盘
        adapter.request(); // 鼠标调用电脑

    }
}
