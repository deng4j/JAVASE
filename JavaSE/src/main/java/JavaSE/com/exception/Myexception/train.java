package JavaSE.com.exception.Myexception;

/**
 * try...catch要捕获了正确的异常，try...catch才有意义，否则默认交给虚拟机处理
 * 出现多个异常写多个catch，用于区分异常处理结果
 * 多个异常有子父类关系，父类写下面，否则子类异常不会出现
 */
public class train {
    static  int vag(int a,int b) throws Myexception{
        if (a<0||b<0){
            throw  new Myexception("数字不能小于0");
        }
        if (a>100||b>100){
            throw  new Myexception("数字不能大于100");
        }
        return  (a+b)/2;
    }

    public static void main(String[] args) {
        try {
            int a=vag(400,-10);
            System.out.println(a);
        } catch (Myexception myexception) {
            myexception.printStackTrace();
        }
    }
}
