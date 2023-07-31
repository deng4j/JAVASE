package dzh.com.JavaSE.com.characteristic.innerClass.Outer2;

public class Outer2 {
    private Integer nnn = 10;

    public class Inner2{
        private Integer aaa = nnn;

        public void show(){
            System.out.println("Inner2 show");
        }
    }

    public Inner2 getInner2(){
        return new Inner2();
    }
}
