package JavaSE.com.genericity.itheima;


interface inter<E> {
    void show(E e);
}

/**
 * 不能子类擦除，父类泛型
 * @param <E>
 */
public class gInterface<E> implements inter<E>{
    @Override
    public void show(E e) {

    }
}
