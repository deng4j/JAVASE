package dzh.com.JavaSE.com.characteristic.extend.extend1;

/**
 * 继承就是子类继承父类的特征和行为，使得子类对象（实例）具有父类的实例域和方法，或子类从父类继承方法，使得子类具有父类相同的行为。
 *
 * 继承的特性
 *  - 子类拥有父类非 private 的属性、方法。
 *  - 子类可以拥有自己的属性和方法，即子类可以对父类进行扩展和重写。调方法，如果子类重写了，就调用重写后的方法，否则调用父类的方法。
 *  - 子类可以用自己的方式实现父类的方法。
 *  - Java 的继承是单继承，但是可以多重继承，单继承就是一个子类只能继承一个父类；多重继承就是，例如 B 类继承 A 类，C 类继承 B 类
 *  - 提高了类之间的耦合性（继承的缺点，耦合度高就会造成代码之间的联系越紧密，代码独立性越差）。
 *
 * super关键字：我们可以通过super关键字来实现对父类成员的访问，用来引用当前对象的父类。
 * this关键字：指向自己的引用。
 *
 * Object 类是所有类的父类，也就是说 Java 的所有类都继承了 Object，子类可以使用 Object 的所有方法。
 *
 * 复合优先于继承。子类依赖父类的特定功能的实现细节。父类的实现有可能会随着发行版本的不同而有所变化，那么子类可能会遭到破坏。
 * 只有两个类真正存在"is-a"的关系的时候才能继承拓展。
 * 父类必须是为继承而设计，并提供文档说明，否则禁止继承。该文档必须精确说明覆盖每一个方法所带来的影响。
 * 为了继承而设计的类，你应该考虑暴露那些域，一方面你要尽可能少的暴露受保护的成员，一方面不能暴露太少类，否则无法用于继承。
 */
public class Manager extends Employee {
    private  int bonus;

    public Manager(String name, String id, int salary, int bonus) {
        super(name, id, salary); // 父类构造方法
        this.bonus = bonus;
    }

    @Override
    public void work() {
        System.out.println("项目经理"+getName()+"工资"+getSalary());
    }

    public void slackOff(){
        System.out.println("做项目好累，我要休息一下");
    }

    public static void main(String[] args) {
        Employee manager=new Manager("张三","001",20000,20000);
        manager.work();

        // 父类引用要想使用子类拓展功能，必须向下转型
        ((Manager) manager).slackOff();
    }
}
