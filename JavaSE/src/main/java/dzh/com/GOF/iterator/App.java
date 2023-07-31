package dzh.com.GOF.iterator;

/**
 * 迭代器模式
 */
public class App {
    public static void main(String[] args) {
        ConcreteMyAggregate cma=new ConcreteMyAggregate();
        cma.addObject("aa");
        cma.addObject("bb");
        cma.addObject("ccc");

        MyIterator iterator = cma.createIterator();
        while (iterator.hasNext()){
            Object next = iterator.next();
            System.out.println(next);
        }

    }
}
