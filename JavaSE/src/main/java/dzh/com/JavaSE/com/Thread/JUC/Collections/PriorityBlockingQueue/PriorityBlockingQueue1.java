package dzh.com.JavaSE.com.Thread.JUC.Collections.PriorityBlockingQueue;

import java.util.Random;
import java.util.concurrent.PriorityBlockingQueue;

public class PriorityBlockingQueue1 {

    static class Task implements Comparable<Task> {

        private int priority;
        private String taskName;

        @Override
        public int compareTo(Task o) {
            return this.priority >= o.priority ? 1 : -1;
        }

        @Override
        public String toString() {
            return "Task{" +
                    "priority=" + priority +
                    ", taskName='" + taskName + '\'' +
                    '}';
        }

        public int getPriority() {
            return priority;
        }

        public void setPriority(int priority) {
            this.priority = priority;
        }

        public String getTaskName() {
            return taskName;
        }

        public void setTaskName(String taskName) {
            this.taskName = taskName;
        }
    }

    public static void main(String[] args) {
        PriorityBlockingQueue<Task> taskPriorityBlockingQueue = new PriorityBlockingQueue<>();

        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            Task task = new Task();
            task.setPriority(random.nextInt(10));
            task.setTaskName("task"+i);
            taskPriorityBlockingQueue.put(task);
        }

        while (!taskPriorityBlockingQueue.isEmpty()){
            Task task = taskPriorityBlockingQueue.poll();
            System.out.println(task);
        }
    }

}
