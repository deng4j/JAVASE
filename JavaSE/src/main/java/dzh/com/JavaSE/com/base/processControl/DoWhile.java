package dzh.com.JavaSE.com.base.processControl;

public class DoWhile {
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
