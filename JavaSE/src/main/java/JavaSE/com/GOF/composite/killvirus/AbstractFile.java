package JavaSE.com.GOF.composite.killvirus;

import java.util.ArrayList;
import java.util.List;

/**
 * 抽象组件
 */
public interface AbstractFile {
    void killVirus();
}

/**
 * 容器组件
 */

class Folder implements AbstractFile{
    private String name;
    //用于存放本容器构件下的子节点
    private List<AbstractFile> list=new ArrayList<>();

    public Folder(String name) {
        this.name = name;
    }

    public void add(AbstractFile file){
        list.add(file);
    }

    public AbstractFile getChild(int index){
        return list.get(index);
    }

    public void remove(AbstractFile file){
        list.remove(file);
    }

    @Override
    public void killVirus() {
        System.out.println("--文件夹："+name+"--查杀");
        //递归，查杀
        for (AbstractFile file : list) {
            file.killVirus();
        }

    }
}


//叶子组件
class ImageFile implements AbstractFile{
    private  String name;

    public ImageFile(String name) {
        this.name = name;
    }

    @Override
    public void killVirus() {
        System.out.println("--图像文件--"+name+"--查杀");
    }
}

class TxtFile implements AbstractFile{
    private  String name;

    public TxtFile(String name) {
        this.name = name;
    }

    @Override
    public void killVirus() {
        System.out.println("--文本文件--"+name+"--查杀");
    }
}
