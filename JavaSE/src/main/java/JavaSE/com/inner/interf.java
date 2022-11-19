package JavaSE.com.inner;


interface inter{
    void show();
}

public class interf implements inter{

    @Override
    public void show() {
        System.out.println("外部类");
    }

    public static class interfImp implements inter{

        @Override
        public void show() {
            System.out.println("内部类");
        }
    }



    public static void main(String[] args) {
        inter i1=()->{
            System.out.println("我是i1");
        };
        i1.show();

        new inter() {
            @Override
            public void show() {
                System.out.println("匿名内部类");
            }
        }.show();

        //外部类直接使用
        interf interf = new interf();
        interf.show();
        //公开的内部类在静态方法中使用，必须也是静态内部类
        interfImp interfImp = new interfImp();
        interfImp.show();
    }
}
