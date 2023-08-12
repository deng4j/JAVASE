package dzh.com.DesignPattern.DesignPattern.createPatterns.ProtoType.sheep;

import java.io.Serializable;
import java.util.Date;

/**
 * 原型模式：
 *  通过new产生一个对象非常繁琐，可以使用原型模式。
 *  java的克隆技术，一某个对象为原型，复制出新的对象。
 *  优点：效率高，避免构造过程
 *  new出来的对象采用默认值，克隆出的对象的属性完全和原型相同，
 *  并且不会影响原型对象，然后可以修改克隆对象的值。
 *
 *  Cloneable接口和Object的clone方法。
 *
 * 浅克隆：如果原型对象的成员变量是值类型，将复制一份给克隆对象；如果原型对象的成员变量是引用类型，则将引用对象的地址复制一份给克隆对象，也就是说原型对象和克隆 对象的成员变量指向相同的内存地址。
 * 深克隆：无论原型对象的成员变量是值类型还是引用类型，都将复制一份给克隆对象，深克隆将原型对象的所有引用对象也复制一份给克隆对象。
 *
 * 主要优点:
 *  1.当创建新的对象实例较为复杂时，使用原型模式可以简化对象的创建过程，通过复制一个 已有实例可以提高新实例的创建效率。
 *  2.扩展性较好，由于在原型模式中提供了抽象原型类，在客户端可以针对抽象原型类进行编程，而将具体原型类写在配置文件中，增加或减少产品类对原有系统都没有任何影响。
 *  3.原型模式提供了简化的创建结构，工厂方法模式常常需要有一个与产品类等级结构相同的工厂等级结构，而原型模式就不需要这样，原型模式中产品的复制是通过封装在原型类中的克隆方法实现的，无须专门的工厂类来创建产品。
 *  4.可以使用深克隆的方式保存对象的状态，使用原型模式将对象复制一份并将其状态保存起 来，以便在需要的时候使用（如恢复到某一历史状态），可辅助实现撤销操作。
 *
 * 主要缺点:
 *  1.需要为每一个类配备一个克隆方法，而且该克隆方法位于一个类的内部，当对已有的类进 行改造时，需要修改源代码，违背了“开闭原则”。
 *  2.在实现深克隆时需要编写较为复杂的代码，而且当对象之间存在多重的嵌套引用时，为了 实现深克隆，每一层对象对应的类都必须支持深克隆，实现起来可能会比较麻烦。
 *
 * 适用场景:
 *  1.创建新对象成本较大（如初始化需要占用较长的时间，占用太多的CPU资源或网络资 源），新的对象可以通过原型模式对已有对象进行复制来获得，如果是相似对象，则可以对 其成员变量稍作修改。
 *  2.如果系统要保存对象的状态，而对象的状态变化很小，或者对象本身占用内存较少时，可 以使用原型模式配合备忘录模式来实现。
 *  3。需要避免使用分层次的工厂类来创建分层次的对象，并且类的实例对象只有一个或很少的 几个组合状态，通过复制原型对象得到新实例可能比使用构造函数创建一个新实例更加方便。
 */

public class Sheep implements Cloneable,Serializable {
    private static final long serialVersionUID = 1L;
    private String name;
    private Date date;

    public Sheep() {
    }

    public Sheep(String name, Date date) {
        this.name = name;
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Sheep{" +
                "name='" + name + '\'' +
                ", date=" + date +
                '}';
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        //直接调用object对象的clone方法
        //此时两个母体和克隆对象引用了同一个属性对象（浅克隆）
        Object obj=super.clone();
        //添加下面代码，将date属性也进行复制（深克隆）
        Sheep s= (Sheep) obj;
        s.date= (Date) this.date.clone();

        return obj;
    }


}
