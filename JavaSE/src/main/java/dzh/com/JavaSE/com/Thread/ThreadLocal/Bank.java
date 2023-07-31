package dzh.com.JavaSE.com.Thread.ThreadLocal;

/**
 * ThreadLocal 叫做本地线程变量，意思是说，ThreadLocal 中填充的的是当前线程的变量，该变量对其他线程而言是封闭且隔离的，ThreadLocal 为变量在每个线程中创建了一个副本，这样每个线程都可以访问自己内部的副本变量。
 */
public class Bank {

    private  ThreadLocal<Integer> threadLocal=new ThreadLocal<>(){
        @Override
        protected Integer initialValue() {
            return 0;
        }
    };

    /**
     * 取钱
     */
    public int get(){
      return threadLocal.get();
    }

    /**
     * 存钱
     */
    public void  set(int money){
        threadLocal.set(threadLocal.get()+money);
    }

    /**
     * 退出系统
     */
    public void  exit(){
        threadLocal.remove();
    }

    //转账
    static class Transfer implements Runnable{

        private Bank bank;

        public Transfer(Bank bank) {
            this.bank = bank;
        }

        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                bank.set(10);
                System.out.println(Thread.currentThread().getName()+"账户余额"+
                bank.get());
            }
            bank.exit(); //防止内存泄漏
        }
    }


    public static void main(String[] args) {
        Bank bank=new Bank();
        Transfer transfer=new Transfer(bank);
        new Thread(transfer,"客户1").start();
        new Thread(transfer,"客户2").start();

    }
}
