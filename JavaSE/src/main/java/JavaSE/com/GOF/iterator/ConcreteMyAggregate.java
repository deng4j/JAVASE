package JavaSE.com.GOF.iterator;

import java.util.ArrayList;
import java.util.List;

/**
 * 自定义的聚合类
 */
public class ConcreteMyAggregate {
    private List<Object> list=new ArrayList<>();

    public ConcreteMyAggregate(List<Object> list) {
        this.list = list;
    }

    public ConcreteMyAggregate() {
    }

    public void addObject(Object obj){
        this.list.add(obj);
    }

    public void removeObject(Object obj){
       this.list.remove(obj);
    }

    public List<Object> getList(List<Object> list){
        return list;
    }

    public void setList(List<Object> list) {
        this.list = list;
    }

    public MyIterator createIterator(){
        return new  ConcreteIterator();
    }

    /**
     * 使用内部类可以直接使用外部类的属性
     */
    private  class  ConcreteIterator implements MyIterator{
        private int cursor;

        @Override
        public void first() {
            cursor=0;
        }

        public void cursorOutIndex(){
            if (cursor>=list.size()){
                throw new IndexOutOfBoundsException();
            }
        }

        @Override
        public Object  next() {
            cursorOutIndex();
            return list.get(cursor++);
        }

        @Override
        public boolean hasNext() {
            if (cursor<list.size()){
                return true;
            }else {
                return false;
            }

        }

        @Override
        public boolean isFist() {
            return cursor==0?true:false;
        }

        @Override
        public boolean isLast() {
            return cursor==list.size()-1?true:false;
        }

        @Override
        public Object getCurrentObj() {
            return list.get(cursor);
        }
    }
}
