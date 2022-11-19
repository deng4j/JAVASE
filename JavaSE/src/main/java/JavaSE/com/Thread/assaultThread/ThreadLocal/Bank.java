package JavaSE.com.Thread.assaultThread.ThreadLocal;

/**
 * 当一个对象同时要执行不同操作时，可以使用ThreadLocal保存线程副本
 */
public class Bank {

    private  ThreadLocal<Integer> threadLocal=new ThreadLocal<>(){
        @Override
        protected Integer initialValue() {
            return 0;
        }
    };
    //取钱
    public int get(){
      return   threadLocal.get();
    }
    //存钱
    public void  set(int money){
        threadLocal.set(threadLocal.get()+money);
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
        }
    }


    public static void main(String[] args) {
        Bank bank=new Bank();
        Transfer transfer=new Transfer(bank);
        new Thread(transfer,"客户1").start();
        new Thread(transfer,"客户2").start();

    }
}
