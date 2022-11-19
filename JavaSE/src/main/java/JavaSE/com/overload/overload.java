package JavaSE.com.overload;

public class overload {
    public static void main(String[] args) {
        boolean e= eq(10.1,10);
        System.out.println(e);

    }
    public static boolean eq(Object a,Object b){
        if (a==b||a.equals(b)){
            return true;
        }else return false;
    }
}
