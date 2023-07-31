package dzh.com.JavaSE.com.characteristic.Optional;

import java.util.Optional;


public class Optional2 {

    public static void main(String[] args) {
        m1();
    }

    private static void m1() {
        String foo = Optional.of("foo").orElseThrow();
        System.out.println(foo);

        long foo1 = Optional.of("foo").stream().count();
        System.out.println(foo1);

        Object fallback = Optional.ofNullable(null).or(() -> Optional.of("fallback")).get();
        System.out.println(fallback);
    }
}
