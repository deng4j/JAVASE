package dzh.com.JavaSE.com.characteristic.innerClass.Hand;


/**
 * 接口中定义一个成员内部类
 */
public interface Hand {

    default RedCell getCell(){
        RedCell c = new RedCell();
        return c;
    }

    class RedCell{
        private String volume="123";
        private String shape="圆形";
    }
}

class People implements Hand{

}
