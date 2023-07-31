package dzh.com.JavaSE.com.characteristic.generics;

public class VarP {

    public <T> void printMsg( T... args){
        for(T t : args){
            System.out.println("泛型测试 t is " + t);
        }
    }
}
