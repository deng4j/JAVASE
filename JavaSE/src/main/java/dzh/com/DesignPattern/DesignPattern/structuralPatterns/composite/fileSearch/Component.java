package dzh.com.DesignPattern.DesignPattern.structuralPatterns.composite.fileSearch;

/**
 * 抽象组件：定义了叶子和容器构件的共同点
 */
public interface Component {
    void operation();
}

/**
 * Leaf（叶子构件）：它在组合结构中表示叶子节点对象，叶子节点没有子节点，它实现了在抽象构件中定义的行为。
 * 对于那些访问及管理子构件的方法，可以通过异常等方式进行处理。
 */

interface Leaf extends Component {

}

/**
 * Composite（容器构件）：它在组合结构中表示容器节点对象，容器节点包含子节点，其子 节点可以是叶子节点，
 * 也可以是容器节点，它提供一个集合用于存储子节点，实现了在抽象 构件中定义的行为，包括那些访问及管理子构件的方法，
 * 在其业务方法中可以递归调用其子节点的业务方法。
 */
interface Composite extends Component {
    void add(Component c);

    void remove(Component c);

    Component getChild(int index);
}

