package JavaSE.com.exception.tryCatch;

public class TestCatch {
    public static void main(String[] args) {
        try {
            int i=1/0;
        } catch (Exception e) {
            System.out.println("异常");
            try {
                int i=1/0;
            } catch (Exception ex) {
                System.out.println("二次捕捉");
            }
        } finally {
            System.out.println("哈哈");
        }
    }
}
