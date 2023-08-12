package dzh.com.DesignPattern.DesignPattern.behaviorPatterns.visitor;

import dzh.com.DesignPattern.DesignPattern.behaviorPatterns.visitor.Department.Department;
import dzh.com.DesignPattern.DesignPattern.behaviorPatterns.visitor.Department.FADepartment;
import dzh.com.DesignPattern.DesignPattern.behaviorPatterns.visitor.Employee.Employee;
import dzh.com.DesignPattern.DesignPattern.behaviorPatterns.visitor.Employee.FulltimeEmployee;
import dzh.com.DesignPattern.DesignPattern.behaviorPatterns.visitor.Employee.ParttimeEmployee;

/**
 * 访问者模式(Visitor Pattern):提供一个作用于某对象结构中的各元素的操作表示，它使我们可以 在不改变各元素的类的前提下定义作用于这些元素的新操作。访问者模式是一种对象行为型模式。
 *
 * 由于访问者模式的使用条件较为苛刻，本身结构也较为复杂，因此在实际应用中使用频率不是特别高。
 *
 * 主要优点:
 *  1.增加新的访问操作很方便。使用访问者模式，增加新的访问操作就意味着增加一个新的具 体访问者类，实现简单，无须修改源代码，符合“开闭原则”。
 *  2.将有关元素对象的访问行为集中到一个访问者对象中，而不是分散在一个个的元素类中。 类的职责更加清晰，有利于对象结构中元素对象的复用，相同的对象结构可以供多个不同的 访问者访问。
 *  3.让用户能够在不修改现有元素类层次结构的情况下，定义作用于该层次结构的操作。
 *
 * 主要缺点:
 *  1.增加新的元素类很困难。在访问者模式中，每增加一个新的元素类都意味着要在抽象访问 者角色中增加一个新的抽象操作，并在每一个具体访问者类中增加相应的具体操作，这违背了“开闭原则”的要求。
 *  2.破坏封装。访问者模式要求访问者对象访问并调用每一个元素对象的操作，这意味着元素对象有时候必须暴露一些自己的内部操作和内部状态，否则无法供访问者访问。
 *
 * 适用场景:
 *  1.一个对象结构包含多个类型的对象，希望对这些对象实施一些依赖其具体类型的操作。在 访问者中针对每一种具体的类型都提供了一个访问操作，不同类型的对象可以有不同的访问 操作。
 *  2.需要对一个对象结构中的对象进行很多不同的并且不相关的操作，而需要避免让这些操 作“污染”这些对象的类，也不希望在增加新操作时修改这些类。访问者模式使得我们可以将相 关的访问操作集中起来定义在访问者类中，对象结构可以被多个不同的访问者类所使用，将 对象本身与对象的访问操作分离。
 *  3.对象结构中对象对应的类很少改变，但经常需要在此对象结构上定义新的操作。
 */
public class Client {
    public static void main(String[] args) {
        EmployeeList list = new EmployeeList();
        Employee fte1, fte2, fte3, pte1, pte2;
        fte1 = new FulltimeEmployee("张无忌", 3200.00, 45);
        fte2 = new FulltimeEmployee("杨过", 2000.00, 40);
        fte3 = new FulltimeEmployee("段誉", 2400.00, 38);
        pte1 = new ParttimeEmployee("洪七公", 80.00, 20);
        pte2 = new ParttimeEmployee("郭靖", 60.00, 18);
        list.addEmployee(fte1);
        list.addEmployee(fte2);
        list.addEmployee(fte3);
        list.addEmployee(pte1);
        list.addEmployee(pte2);

        Department dep = new FADepartment();
        list.accept(dep);
    }
}
