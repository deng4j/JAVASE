package dzh.com.DesignPattern.DesignPattern.behaviorPatterns.iterator;

import java.util.ArrayList;
import java.util.List;

/**
 * Aggregate（抽象聚合类）：它用于存储和管理元素对象，声明一个createIterator()方法用于 创建一个迭代器对象，充当抽象迭代器工厂角色。
 */
public class ConcreteMyAggregate<E> extends Aggregate<E>{
    private List<E> list=new ArrayList<>();

    public ConcreteMyAggregate(List<E> list) {
        this.list = list;
    }

    public ConcreteMyAggregate() {
    }

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public boolean add(int index, E e) {
        list.add(index,e);
        return true;
    }


    @Override
    public E get(int index) {
        return list.get(index);
    }

    @Override
    public E set(int index, E element) {
        return list.set(index,element);
    }

    @Override
    public E remove(int index) {
        return list.remove(index);
    }
}
