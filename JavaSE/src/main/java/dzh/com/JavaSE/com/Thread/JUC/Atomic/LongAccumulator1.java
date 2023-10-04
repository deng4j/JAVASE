package dzh.com.JavaSE.com.Thread.JUC.Atomic;

import java.util.concurrent.atomic.LongAccumulator;
import java.util.concurrent.atomic.LongAdder;
import java.util.function.LongBinaryOperator;

public class LongAccumulator1 {
    /**
     * 调用LongAdder相当于使用下面方式调用LongAccumulator
     * @param args
     */
    public static void main(String[] args) {
        LongAdder adder = new LongAdder();

        LongAccumulator accumulator = new LongAccumulator(new LongBinaryOperator() {
            @Override
            public long applyAsLong(long left, long right) {
                return left + right;
            }
        }, 0);
    }
}
