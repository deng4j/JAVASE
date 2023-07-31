package dzh.com.JavaSE.com.characteristic.Abstract;


public abstract class Fruit {
    public String name;

    public Fruit(String name) {
        this.name = name;
    }

    abstract void photosynthesis();

    public void grow() {
        throw new RuntimeException("不能直接操作");
     }
}

abstract class HotFruit extends Fruit {
    public String temporary;

    public HotFruit(String name,String temporary) {
        super(name);
        this.temporary = temporary;
    }
}


class Pineapple extends HotFruit {
    public Pineapple(String name, String temporary) {
        super(name, temporary);
    }

    @Override
    void photosynthesis() {
        System.out.println(this.name+"--"+this.temporary+"--光合作用");
    }

    public static void main(String[] args) {
        Pineapple pineapple = new Pineapple("菠萝","40摄氏度");
        pineapple.photosynthesis();
    }
}
