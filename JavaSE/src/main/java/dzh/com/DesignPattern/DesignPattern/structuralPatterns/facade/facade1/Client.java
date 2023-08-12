package dzh.com.DesignPattern.DesignPattern.structuralPatterns.facade.facade1;

import dzh.com.DesignPattern.DesignPattern.structuralPatterns.facade.facade1.facade.AbstractEncryptFacade;
import dzh.com.DesignPattern.DesignPattern.structuralPatterns.facade.facade1.facade.EncryptFacade;
import dzh.com.DesignPattern.DesignPattern.structuralPatterns.facade.facade1.facade.NewEncryptFacade;

/**
 * 外观模式的主要目的在于降低系统的复杂程度，在面向对象软件系统中，类与类之间的关系越多，不能表示系统设计得越好，反而表示系统中类之间的耦合度太大，
 * 这样的系统在维护 和修改时都缺乏灵活性，因为一个类的改动会导致多个类发生变化，而外观模式的引入在很大程度上降低了类与类之间的耦合关系。
 *
 * Facade（外观角色）：在客户端可以调用它的方法，在外观角色中可以知道相关的（一个 或者多个）子系统的功能和责任；
 * 在正常情况下，它将所有从客户端发来的请求委派到相应 的子系统去，传递给相应的子系统对象处理。
 *
 * SubSystem（子系统角色）：在软件系统中可以有一个或者多个子系统角色，每一个子系统 可以不是一个单独的类，而是一个类的集合，
 * 它实现子系统的功能；每一个子系统都可以被客户端直接调用，或者被外观角色调用，它处理由外观类传过来的请求；
 * 子系统并不知道外观的存在，对于子系统而言，外观角色仅仅是另外一个客户端而已。
 *
 * 模式优点：
 *  1.它对客户端屏蔽了子系统组件，减少了客户端所需处理的对象数目，并使得子系统使用起来更加容易。通过引入外观模式，客户端代码将变得很简单，与之关联的对象也很少。
 *  2.它实现了子系统与客户端之间的松耦合关系，这使得子系统的变化不会影响到调用它的客户端，只需要调整外观类即可。
 *  3. 一个子系统的修改对其他子系统没有任何影响，而且子系统内部变化也不会影响到外观对象。
 *
 * 模式缺点:
 *  1.不能很好地限制客户端直接使用子系统类，如果对客户端访问子系统类做太多的限制则减少了可变性和灵活性。
 *  2.如果设计不当，增加新的子系统可能需要修改外观类的源代码，违背了开闭原则。
 *
 * 模式适用场景:
 *  1.当要为访问一系列复杂的子系统提供一个简单入口时可以使用外观模式。
 *  2.客户端程序与多个子系统之间存在很大的依赖性。引入外观类可以将子系统与客户端解耦，从而提高子系统的独立性和可移植性。
 *  3.在层次化结构中，可以使用外观模式定义系统中每一层的入口，层与层之间不直接产生联 系，而通过外观类建立联系，降低层之间的耦合度。
 */

/**
 * 某软件公司欲开发一个可应用于多个软件的文件加密模块，该模块可以对文件中的数据进行加密并将加密之后的数据存储在一个新文件中，
 * 具体的流程包括三个部分，分别是读取源文 件、加密、保存加密之后的文件，其中，读取文件和保存文件使用流来实现，
 * 加密操作通过求模运算实现。
 */
public class Client {

    public static void main(String[] args) {
        AbstractEncryptFacade ef = new EncryptFacade();
        ef.fileEncrypt("src.txt", "des.txt");

        AbstractEncryptFacade ef1 = new NewEncryptFacade();
        ef1.fileEncrypt("src.txt", "des.txt");

    }
}
