package dzh.com.DesignPattern.DesignPattern.behaviorPatterns.interpreter.interpreter1.nonterminalExpression;

import dzh.com.DesignPattern.DesignPattern.behaviorPatterns.interpreter.interpreter1.AbstractNode;

/**
 * And解释：非终结符表达式
 */
public class AndNode extends AbstractNode {
    private AbstractNode left; //And的左表达式
    private AbstractNode right; //And的右表达式

    public AndNode(AbstractNode left, AbstractNode right) {
        this.left = left;
        this.right = right;
    }

    //And表达式解释操作
    @Override
    public String interpret() {
        return left.interpret() + " 再 " + right.interpret();
    }
}
