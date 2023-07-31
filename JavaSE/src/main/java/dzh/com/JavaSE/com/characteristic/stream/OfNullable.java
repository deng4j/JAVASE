package dzh.com.JavaSE.com.characteristic.stream;

import java.util.stream.Stream;

public class OfNullable {

    public static void main(String[] args) {
        m1();
    }

    /**
     * 单个元素构造流:
     * of方法中，如果单个参数为null的话那新生成的流中就会包含一个null的元素，
     * 如果这种情况下我们不想在流中包含一个null元素，我就想一个元素都没有，整个流是empty的。
     * 那要怎么办，这个时候就可以用到ofNullable这个方法了。
     */
    private static void m1() {
        String str = null;
        Stream<String> stream = Stream.of(str);
        System.out.print("of: ");
        stream.forEach(System.out::println);

        Stream<String> stream2 = Stream.ofNullable(str);
        System.out.println("ofNullable: ");
        stream2.forEach(System.out::println);
    }
}
