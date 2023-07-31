package dzh.com.JavaSE.com.characteristic.exception.tryCatchFinally;

public class TCF1 {
    public static void main(String[] args) {
        try {
            int a = 1/0;
        } finally {
            System.out.println("exe");
        }
    }
}
