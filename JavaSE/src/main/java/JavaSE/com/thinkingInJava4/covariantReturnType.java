package JavaSE.com.thinkingInJava4;

/**
 * 协变返回类型
 */
public class covariantReturnType {
    public static void main(String[] args) {
        Mill m=new Mill();
        Grain g = m.pocess();
        System.out.println(g);

        m=new wheatMill();
        //想使用自己特有的方法必须向下转型
        System.out.println(((wheatMill) m).process());
         g= m.pocess();
        System.out.println(g);
    }
}

class Grain{
    @Override
    public String toString(){
        return "Grain";
    }
}
class wheat extends Grain{
    @Override
    public String toString() {
        return "wheat";
    }
}
class  Mill{
    Grain pocess(){
        return  new Grain();
    }
}

class wheatMill extends Mill{
    wheat process(){
        return new wheat();
    }
}
