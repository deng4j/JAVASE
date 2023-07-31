package dzh.com.JavaSE.com.characteristic.innerClass.Outer6;

/**
 * 匿名内部类与局部类对作用域内的变量拥有相同的的访问权限。
 *  1.匿名内部类可以访问外部内的所有成员；
 *  2.匿名内部类不能访问外部类未加final修饰的变量（注意：JDK1.8即使没有用final修饰也可以访问）；
 *  3.属性屏蔽，与内嵌类相同，匿名内部类定义的类型（如变量）会屏蔽其作用域范围内的其他同名类型（变量）：
 */
public class Outer6 {

    interface Dog{
        void run();
        void eat();
    }

    class Animal{
        private String name;

        public Animal(String name) {
            this.name = name;
        }

        public void show(){
            System.out.println("show："+this.name);
        }
    }


    public void show1(){
        int a = 10;
        // 匿名内部类
        Animal birth = new Animal("杜鹃鸟"){
            @Override
            public void show() {
                super.show();
            }
        };
        birth.show();
    }

    public void show2(){
        // 匿名内部类
        Dog dog = new Dog() {

            @Override
            public void run() {
                System.out.println("匿名内部类dog 跑");
            }

            @Override
            public void eat() {
                System.out.println("匿名内部类dog 吃");
            }
        };
        dog.run();
        dog.eat();
    }

}
