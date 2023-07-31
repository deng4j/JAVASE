package dzh.com.GOF.ProtoType.sheep;

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
        //添加下面代码，将属性也进行复制（深克隆）
        Sheep s= (Sheep) obj;
        s.date= (Date) this.date.clone();

        return obj;
    }


}
