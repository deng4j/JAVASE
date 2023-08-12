package dzh.com.DesignPattern.DesignPattern.behaviorPatterns.iterator;

/**
 *  Iterator（抽象迭代器）：它定义了访问和遍历元素的接口，声明了用于遍历数据元素的方法。
 */
public interface MyIterator<E> {
    /**
     * 将游标指向第一个
     */
    void first();
    E next();
    boolean hasNext();

    boolean isFist();
    boolean isLast();

    E getCurrentObj();
}
