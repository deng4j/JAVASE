package dzh.com.DesignPattern.DesignPattern.behaviorPatterns.mediator.mediator1.department;

import dzh.com.DesignPattern.DesignPattern.behaviorPatterns.mediator.mediator1.mediator.Mediator;

/**
 * 市场部
 */
public class Market implements Department {
    /**
     * 持有中介者的引用
     */
    private Mediator m;

    public Market(Mediator m) {
        this.m = m;
        m.register("Market",this);
    }

    @Override
    public void selfAction() {
        System.out.println("市场部：接项目");
    }

    @Override
    public void outAction() {
        System.out.println("市场部汇报经理：项目需要100w");
        m.commend("finacial");
    }
}
