package dzh.com.JavaSE.com.Thread.ThreadLocal;

/**
 * ThreadLocal本地线程变量，内部维护一个map，以当前线程为key
 */
public class ThreadLocal1 {

    private  ThreadLocal<Integer> threadLocal=new ThreadLocal<>(){
        @Override
        protected Integer initialValue() {
            return 0;
        }
    };

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
        ThreadLocal1 threadLocal1=new ThreadLocal1();
        threadLocal1.set(789); // 主线程设置值

        System.out.println(threadLocal1.get()); //主线程get

        // 测试子线程是否能获取父线程的副本，答案是不能
        new Thread(new Runnable() {
            @Override
            public void run() {
                // 子线程get
                System.out.println(threadLocal1.get());
            }
        }).start();
    }
}
