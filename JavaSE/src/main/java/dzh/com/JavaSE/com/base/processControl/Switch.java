package dzh.com.JavaSE.com.base.processControl;

/**
 * 表达式必须是一个 char 、byte、short、int、string 类型等数据
 */
public class Switch {
    public static void main(String[] args) {
        int a = 2;
        switch (a) {
            case 1:
                System.out.println(1);
                break;
            case 2: // 条件穿透
                System.out.println(2);
            case 3:
                System.out.println(3);
                break;
            default:
                System.out.println("default");
                break;
        }
    }
}
