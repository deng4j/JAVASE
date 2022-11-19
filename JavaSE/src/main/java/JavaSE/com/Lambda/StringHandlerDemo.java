package JavaSE.com.Lambda;

public class StringHandlerDemo {

    interface StringHandler {

        void printMessage(String msg);
    }

    public static void useStringHandler(StringHandler sh) {
        sh.printMessage("msg在此设置参数");
    }


    public static void main(String[] args) {
        //请分别使用匿名内部类 和 lambda表达式作为参数进行调用
        useStringHandler(new StringHandler() {
            @Override
            public void printMessage(String msg) {
                System.out.println("匿名内部类" + msg);
            }
        });

        StringHandler s = (msg) -> {
            System.out.println("lambda："+msg);
        };
        useStringHandler(s);
    }
}