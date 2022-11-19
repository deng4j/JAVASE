package JavaSE.com.interfaces;

class InterImpl implements Inter{
    public static void main(String[] args) {
        System.out.println(a);
        InterImpl t=new InterImpl();
        t.show2();
        t.show();
        Inter.show3();//只能通过接口名调用

    }

    @Override
    public void show() {
        show2();
    }
}