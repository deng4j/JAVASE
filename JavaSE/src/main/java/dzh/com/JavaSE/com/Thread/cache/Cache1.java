package dzh.com.JavaSE.com.Thread.cache;

/**
 * 缓存行优化
 */
public class Cache1 {
    static final int LINE_NUM = 1024 ;
    static final int COLUM_NUM = 1024 ;

    /**
     * CPU当访问一个元素时，如果缓存没有命中，会将主内存中，该元素连同后面的若干元素的一个缓存行大小内存，复制到Cache中。
     * 而缓存是有容量控制的，缓存满了后会根据淘汰算法替换缓存行。
     *
     * 很明显，方式1比方式2要快很多。
     * 方式1中每次操作的元素，内存地址是连续的，每次访问都可以在缓存中命中，就不需要去主内存中找。
     * 方式2中每次操作的元素是跳跃的，所以会经常从主内存复制缓存行，而很多缓存行的变量还没被读取，就又被替换了。
     * @param args
     */
    public static void main(String[] args) {
        long[][] arr = new long[LINE_NUM][COLUM_NUM];

        long start = System.currentTimeMillis();
        for (int i = 0; i < LINE_NUM; i++) {
            for (int j = 0; j < COLUM_NUM; j++) {
                arr[i][j] = i*2+j;
            }
        }
        long end = System.currentTimeMillis();
        System.out.println("方式1 cache time:"+(end-start));

        long start2 = System.currentTimeMillis();
        for (int i = 0; i < LINE_NUM; i++) {
            for (int j = 0; j < COLUM_NUM; j++) {
                arr[j][i] = i*2+j;
            }
        }
        long end2 = System.currentTimeMillis();
        System.out.println("方式2 cache time:"+(end2-start2));
    }
}
