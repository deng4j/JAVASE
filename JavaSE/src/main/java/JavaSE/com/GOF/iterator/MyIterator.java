package JavaSE.com.GOF.iterator;

/**
 * 自定义迭代器接口
 */
public interface MyIterator {
    /**
     * 将游标指向第一个
     */
    void first();
    Object next();
    boolean hasNext();

    boolean isFist();
    boolean isLast();

    Object getCurrentObj();
}
