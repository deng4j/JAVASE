package dzh.com.JavaSE.com.base.processControl;

/**
 *  for(初始化语句;判断条件语句;控制条件语句){
 * 	    循环体语句;
 *  }
 */
public class For {
    public static void main(String[] args) {
        m4();
    }

    private static void m4() {
        int i = 0;
        for (; i < 10; ) {
            i++;
            System.out.println(i);
        }
    }

    private static void m3() {
        for (int i = 0; i < 10; ) {
            i++;
            System.out.println(i);
        }
    }

    private static void m2() {
        for (int i = 10; i > 0; i--) {
            System.out.println(i);
        }
    }

    private static void m1() {
        for (int i = 0; i < 10; i++) {
            System.out.println(i);
        }
    }
}
