package dzh.com.JavaSE.com.Memory;

/**
 * 对象可以在被GC时自我拯救。
 * 这种自救的机会只有一次，因为一个对象的finalize()方法最多只会被系统自动调用一次
 */
public class FinalizeEscapeGC {
    public static FinalizeEscapeGC SAVE_HOOK = null;

    public void isAlive() {
        System.out.println("yes, i am still alive");
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("finalize method executed!");
        // 因为Finalizer方法优先级很低，暂停0.5秒，以等待它
        Thread.sleep(10);
        FinalizeEscapeGC.SAVE_HOOK = this;
    }

    public static void main(String[] args) throws Throwable {
        while (true) {
            SAVE_HOOK = new FinalizeEscapeGC();
            //对象第一次成功拯救自己
            SAVE_HOOK = null;
            System.gc();
            if (SAVE_HOOK != null) {
                SAVE_HOOK.isAlive();
            } else {
                System.out.println("no, i am dead");
            }
        }
    }
}