package dzh.com.JavaSE.com.base.Object;

public class Trap_equals {
    public static void main(String[] args) {
        Boolean flag =null;
        // 当我们要做真假判断，避免这样做，很容易空指针异常
        try {
            if (flag==true){
                System.out.println("真");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        // 正确的做法是
        if (Boolean.TRUE.equals(flag)){
            System.out.println("真");
        }else {
            System.out.println("假");
        }
    }
}
