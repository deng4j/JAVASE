package dzh.com.JavaSE.com.characteristic.Reflect.demo.genericsClass.demo2;

/**
 * 这种方式是一种很有用的实践
 */
public class G <T>{
    private T data;

    public void setData(T data) {
        this.data = data;
    }

    public String getType(){
        return this.data.getClass().getTypeName();
    }

    public static void main(String[] args) {
        G<Integer> g = new G<>();
        g.setData(1); // 类型在这里确定
        System.out.println(g.getType());
    }
}
