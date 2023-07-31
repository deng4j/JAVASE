package dzh.com.GOF.mediator;

public class Finacial implements Department {
    /**
     * 持有中介者的引用
     */
    private Mediator m;

    public Finacial(Mediator m) {
        this.m = m;
        m.register("finacial",this);
    }

    @Override
    public void selfAction() {
        System.out.println("财务部：汇款");
    }

    @Override
    public void outAction() {
        System.out.println("汇报财务报表");
    }
}
