package JavaSE.com.GOF.bridge.question;

/**
 * 电脑销售接口
 *
 * 拓展性（有类别，品牌两个维度）：
 * 如果要新加一个类型，则要增加品牌下的类别。
 * 如果要增加一个新品牌电脑，则也要增加这种电脑的各种类。
 * 违反单一职责原则：
 * 一个类：联想笔记本，有两个引起这个类变化的原因。
 * 解决：使用桥接模式。
 *
 */
public interface Computer {
    void sale();
}

/**
 * 台式机大类
 */
class Desktop implements Computer{

    @Override
    public void sale() {
        System.out.println("销售台式机");
    }
}

/**
 * 笔记本大类
 */
class Laptop implements Computer{

    @Override
    public void sale() {
        System.out.println("销售笔记本电脑");
    }
}

/**
 * pad大类
 */
class Pad implements Computer{

    @Override
    public void sale() {
        System.out.println("销售iPad");
    }
}



