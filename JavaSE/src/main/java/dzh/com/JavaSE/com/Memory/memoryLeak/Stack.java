package dzh.com.JavaSE.com.Memory.memoryLeak;

import java.util.Arrays;
import java.util.EmptyStackException;

/**
 * 这段程序中有一个严重的内存泄漏问题。
 * 如果栈先增长，然后收缩，那么从栈中弹出来的对象将不会被当作垃圾回收，即使栈的程序不再引用这些对象。
 * 这是因为栈内部维护着对这些对象的过期引用。所谓的过期引用是指永远也不会再被解除的引用。
 * 下面案例中，凡是在elements数组的"活动部分"之外的任何引用都是过期的。"活动部分"是指elements中下标小于size的那些元素。
 * 为了解决这个内存泄漏问题，我们每次pop都要将栈中该索引位设为null。
 *
 * 内存泄漏的另一个常见的来源是缓存。一旦你把对象引用放到缓存中，它就很容易被遗忘。
 * 可以用WealHashMap代表缓存，当缓存中的项过期后，他们就会被自动删除。所有缓存项的生命周期都是由该键的外部引用决定的，而不是值。
 *
 * 内存泄漏第三个创建来源是监听器和其他回调。
 * 如果你实现了一个API，客户端在这个API中注册了回调，却没有显式地取消注册，那么除非你采取某些动作，否则它们就会积聚。
 * 确保回调立即被当作垃圾回收的最佳方法就是只保存它们的弱引用。例如WeakHashMap的键。
 */
public class Stack {
    private Object[] elements;
    private int size=0;
    private static final int DEFAULT_INITIAL_CAPACITY = 16;

    public Stack() {
        elements = new Object[DEFAULT_INITIAL_CAPACITY];
    }

    public void push(Object e){
        ensureCapacity();
        elements[size++]=e;
    }

    public Object pop(){
        if (size==0) throw new EmptyStackException();
        Object element = elements[--size];
        elements[size] = null; // 清空过期引用，防止内存泄漏
        return element;
    }

    private void ensureCapacity() {
        if (elements.length==size){
            elements = Arrays.copyOf(elements,2*size+1);
        }
    }
}
