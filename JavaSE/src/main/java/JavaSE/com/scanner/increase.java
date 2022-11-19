package JavaSE.com.scanner;

public class increase {

    public static void main(String[] args) {
        int a=2;
        int b= (int)Math.floor(1+Math.random()*10);


        switch (b){
            case 1:
            case 2:
            case 3:
            case 4:
                System.out.println("我是卢本伟");
            break;
            case 5:
            case 6:
            case 7:
            case 8:
                System.out.println("我是韩金轮");
                break;
             default:
                 System.out.println("我是伞兵");
                 break;
        }
    }
}
