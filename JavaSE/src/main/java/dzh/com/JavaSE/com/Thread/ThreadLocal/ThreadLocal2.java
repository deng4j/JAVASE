package dzh.com.JavaSE.com.Thread.ThreadLocal;

/**
 * 创建子线程时，会将父线程的InheritableThreadLocal拷贝一份给子线程
 */
public class ThreadLocal2 {

    // 可继承的ThreadLocal
    private  ThreadLocal<Integer> threadLocal=new InheritableThreadLocal<>();

    public int get(){
      return threadLocal.get();
    }

    public void  set(int val){
        threadLocal.set(val);
    }


    public void  remove(){
        threadLocal.remove();
    }

    public static void main(String[] args) {
        ThreadLocal2 threadLocal1=new ThreadLocal2();
        threadLocal1.set(789); // 主线程设置值

        System.out.println(threadLocal1.get()); //主线程get

        // 测试子线程是否能获取父线程的副本，答案能
        new Thread(new Runnable() {
            @Override
            public void run() {
                // 子线程get
                System.out.println(threadLocal1.get());
            }
        }).start();
    }
}
