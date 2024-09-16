package dzh.com.JavaSE.com.characteristic.generics.flaw;

// java泛型的缺陷
public class TypeErasureGenerics<E> {
    public void doSomething(Object item) {
//        if (item instanceof E) {   // 不合法，无法对泛型进行实例判断
//
//        }
//        E newItem = new E();       // 不合法，无法使用泛型创建对象
//        E[] itemArray = new E[10]; // 不合法，无法使用泛型创建数组
    }
}
