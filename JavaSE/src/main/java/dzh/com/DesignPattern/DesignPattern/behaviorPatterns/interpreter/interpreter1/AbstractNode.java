package dzh.com.DesignPattern.DesignPattern.behaviorPatterns.interpreter.interpreter1;

/**
 * AbstractExpression（抽象表达式）：在抽象表达式中声明了抽象的解释操作，它是所有终结符表达式和非终结符表达式的公共父类。
 */
public abstract class AbstractNode {
    public abstract String interpret();
}
