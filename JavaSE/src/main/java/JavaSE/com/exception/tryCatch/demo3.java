package JavaSE.com.exception.tryCatch;

public class demo3 {

    public static void main(String[] args) {
        try {
            try {
                int i= 1/0;
            } catch (Exception e) {
                throw new Exception("分母为零");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
