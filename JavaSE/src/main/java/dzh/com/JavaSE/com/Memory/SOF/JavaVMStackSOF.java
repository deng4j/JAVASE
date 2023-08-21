package dzh.com.JavaSE.com.Memory.SOF;

/**
 * -Xss208k
 * 设置栈内存208k
 *
 * 测试栈深度
 */
public class JavaVMStackSOF {

    private int stackLength = 0;

    public void stackLeak(){
        stackLength++;
        stackLeak();
    }

    public static void main(String[] args) {
        JavaVMStackSOF javaVMStackSOF = new JavaVMStackSOF();
        try {
            javaVMStackSOF.stackLeak();
        } catch (Throwable e) {
            System.out.println("stack length:"+javaVMStackSOF.stackLength);
            e.printStackTrace();
        }
    }
}
