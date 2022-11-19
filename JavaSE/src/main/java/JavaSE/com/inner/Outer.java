package JavaSE.com.inner;

interface Inter {
    void show();
}

public class Outer {
    public static Inter method() {
        return  new Inter() {
            @Override
            public void show() {
                System.out.println("hello world");
            }
        };

    }
}

class OuterDemo {
   public static void main(String[] args) {
       Outer.method().show();
   }
}