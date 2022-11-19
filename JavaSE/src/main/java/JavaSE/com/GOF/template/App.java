package JavaSE.com.GOF.template;

/**
 * 模板模式：
 */
class DrawMoney extends BankTemplate{

    @Override
    void transact() {
        System.out.println("我要取100w");
    }
}

public class App {
    public static void main(String[] args) {
        DrawMoney drawMoney=new DrawMoney();
        drawMoney.process();
    }
}


