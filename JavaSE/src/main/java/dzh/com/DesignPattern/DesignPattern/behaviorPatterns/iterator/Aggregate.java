package dzh.com.DesignPattern.DesignPattern.behaviorPatterns.iterator;

public abstract class Aggregate<E> {

    public abstract int size();

    public boolean add(E e){
        add(size(), e);
        return true;
    }

    public abstract boolean add(int index, E e);

    public abstract E get(int index);

    public abstract E set(int index, E element);

    public abstract E remove(int index);

    public MyIterator<E> createIterator(){
        return new  ConcreteIterator();
    }

    /**
     *  ConcreteIterator（具体迭代器）：它实现了抽象迭代器接口，完成对聚合对象的遍历，同时 在具体迭代器中通过游标来记录在聚合对象中所处的当前位置，在具体实现时，游标通常是一个表示位置的非负整数。
     */
    private  class  ConcreteIterator implements MyIterator<E>{
        private int cursor;

        @Override
        public void first() {
            cursor=0;
        }

        public void cursorOutIndex(){
            if (cursor>=size()){
                throw new IndexOutOfBoundsException();
            }
        }

        @Override
        public E  next() {
            cursorOutIndex();
            return get(cursor++);
        }

        @Override
        public boolean hasNext() {
            if (cursor<size()){
                return true;
            }else {
                return false;
            }

        }

        @Override
        public boolean isFist() {
            return cursor == 0;
        }

        @Override
        public boolean isLast() {
            return cursor == size() - 1;
        }

        @Override
        public E getCurrentObj() {
            return get(cursor);
        }
    }
}
