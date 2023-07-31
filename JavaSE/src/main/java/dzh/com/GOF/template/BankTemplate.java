package dzh.com.GOF.template;

public abstract class BankTemplate {
    public void takeNumber(){
        System.out.println("排队取号");
    }

    /**
     * 钩子方法
     */
    abstract void transact();

    public void evaluate(){
        System.out.println("反馈评分");
    }

    public final void process(){
        this.takeNumber();
        this.transact();
        this.evaluate();

    }
}
