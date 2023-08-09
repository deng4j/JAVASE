package dzh.com.DesignPattern.DesignPattern.bridge.Usebridge;

/**
 * 电脑大类
 */
public class Computer {
    protected Brand brand;

    public Computer(Brand brand) {
        this.brand = brand;
    }

    public Computer() {
    }

    public void sale(){
        brand.sale();
    }
}

/**
 * 电脑类别类
 */
class DeskTop extends Computer{

    public DeskTop(Brand brand) {
        super(brand);
    }

    public DeskTop() {
    }

    @Override
    public void sale() {
        super.sale();
        System.out.println("销售台式");
    }
}

/**
 * 笔记本类别
 */
class LapTop extends Computer{
    public LapTop(Brand brand) {
        super(brand);
    }

    @Override
    public void sale() {
        super.sale();
        System.out.println("销售笔记本");
    }
}


