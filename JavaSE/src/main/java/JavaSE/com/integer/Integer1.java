package JavaSE.com.integer;

public class Integer1 {
    public static void main(String[] args) {
        test3();
    }

    private static void test3() {
        Integer integer = Integer.valueOf("001");
        System.out.println(integer);
    }

    private static void test2() {
        String s="123 211 2135 2313 25";
        String[] s1=  s.split(" ");
        int[] numarr=new int[s1.length];
        for (int i = 0; i < s1.length; i++) {
            int newnum=Integer.parseInt(s1[i]);
            numarr[i]=newnum;
        }
        for (int i = 0; i < numarr.length; i++) {
            System.out.println(numarr[i]);
        }
    }

    private static void test1() {
        int x=4;
        System.out.println("hj"+(x>4?9.9:9));
        //输出9.0
    }
}
