package dzh.com.DesignPattern.DesignPattern.createPatterns.SingleTon;

/**
 * 类加载的时候不会立即加载静态内部类，只有当调用时才会加载，
 * 加载类是线程安全的
 * 兼备了并发高效调用和延迟加载的优势
 *
 */
public class InnerClassTon {
    private InnerClassTon(){
        //防止被反射破解
        if (InnerClassTon.getInstance()!=null){
            throw new RuntimeException("对象已被创建");
        }
    }

    private static class Instance{
      private static final InnerClassTon innerClassTon=new InnerClassTon();
    }

    public static InnerClassTon getInstance(){
        return Instance.innerClassTon;
    }
}
