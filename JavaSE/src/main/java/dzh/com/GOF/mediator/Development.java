package dzh.com.GOF.mediator;

/**
 * 研发部对象
 */
public class Development implements Department{
    /**
     * 持有中介者的引用
     */
    private Mediator m;

    public Development(Mediator m) {
        this.m = m;
        //相互可以找到
        m.register("development",this);
    }

    @Override
    public void selfAction() {
        System.out.println("研发部，开发项目");
    }

    @Override
    public void outAction() {
        System.out.println("汇报要求拨款");
    }
}
