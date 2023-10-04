package dzh.com.JavaSE.com.base.processControl;

/**
 * for(初始化语句;判断条件语句;控制条件语句){
 * 循环体语句;
 * }
 */
public class For {
    public static void main(String[] args) {
        m7();
    }

    /**
     * goto语句在超过3层循环会变得很好用
     */
    private static void m7() {
        loop:
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 3; k++) {
                    if (i == 1 && j == 1 && k == 1) {
                        System.out.println("-------------");
                        continue loop;
                    }
                    System.out.println(i + ":" + j + ":" + k);
                }
            }
        }
    }

    private static void m6() {
        for (int i = 0; i < 10; i++) {
            if (i == 5) continue; // 跳过本次循环
            System.out.println(i);
        }
    }

    private static void m5() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (j == 5) {
                    System.out.println("j:" + j);
                    // 停止该层循环
                    break;
                }
            }
            System.out.println("i:" + i);
        }
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
