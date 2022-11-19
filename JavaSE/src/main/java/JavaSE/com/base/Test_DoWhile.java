package JavaSE.com.base;

public class Test_DoWhile {
    public static void main(String[] args) {
        int x= 0;
        int y=10;
        do{
            y--;
            ++x;
        }while(x<6);
        System.out.println(x+":"+y);
    }

}
