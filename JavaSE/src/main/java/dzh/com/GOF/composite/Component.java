package dzh.com.GOF.composite;

/**
 * 组合模式：
 * 把部分和整体的关系用树形结构来表示，从而是客户端可以使用统一的方式处理部分
 * 对象和整体对象
 *
 * 抽象组件：定义了叶子和容器构件的共同点
 */
public interface Component {
    void operation();
}

/**
 * 叶子组件：无子节点
 */

interface Leaf extends Component{

}

/**
 * 容器组件：有容器特征，可以包含子节点
 */
interface Composite extends Component{
        void add(Component c);
        void remove(Component c);
        Component getChild(int index);
}

