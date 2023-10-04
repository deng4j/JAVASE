package dzh.com.JavaSE.com.characteristic.innerClass.inner2;

public class Outer2 {
    private Integer nnn = 10;

    class Inner2 {
        // 拿到的是一个副本
        private Integer aaa = nnn;

        public void reset() {
            aaa = 20;
            System.out.println("aaa:" + aaa);
            System.out.println("nnn:" + nnn);
            System.out.println("--------------------------");
            nnn = 5;
            System.out.println("nnn:" + nnn);
        }
    }

    public Inner2 getInner2() {
        return new Inner2();
    }
}
