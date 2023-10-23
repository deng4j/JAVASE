package dzh.com.JavaSE.com.Thread.JUC.Collections.DelayQueue;

import java.util.Random;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

public class DelayQueue1 {
    static class DelayedEle implements Delayed {
        // 延迟时间
        private final long delayTime;
        // 到期时间
        private final long expire;
        // 任务名称
        private String taskName;

        public DelayedEle(long delayTime, String taskName) {
            this.delayTime = delayTime;
            this.taskName = taskName;
            expire = System.currentTimeMillis() + delayTime;
        }

        /**
         * 剩余时间 = 到期时间 - 当前时间
         */
        @Override
        public long getDelay(TimeUnit unit) {
            return unit.convert(this.expire - System.currentTimeMillis(), TimeUnit.MILLISECONDS);
        }

        @Override
        public int compareTo(Delayed o) {
            return (int) (this.getDelay(TimeUnit.MILLISECONDS) - o.getDelay(TimeUnit.MILLISECONDS));
        }

        @Override
        public String toString() {
            return "DelayedEle{" +
                    "delayTime=" + delayTime +
                    ", expire=" + expire +
                    ", taskName='" + taskName + '\'' +
                    '}';
        }
    }


    public static void main(String[] args) throws InterruptedException {
        DelayQueue<DelayedEle> delayQueue = new DelayQueue<>();

        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            DelayedEle delayedEle = new DelayedEle(random.nextInt(500), "task" + i);
            delayQueue.offer(delayedEle);
        }

        DelayedEle d = null;
        while (true) {
            while ((d = delayQueue.take()) != null) {
                System.out.println(d);
            }
        }
    }
}
