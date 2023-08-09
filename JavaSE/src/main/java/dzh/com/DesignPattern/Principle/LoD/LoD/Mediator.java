package dzh.com.DesignPattern.Principle.LoD.LoD;

/**
 * 通过引入一个专门用于控制界面控件交互的中间类(Mediator)来降低界面控 件之间的耦合度。引入中间类之后，界面控件之间不再发生直接引用，
 * 而是将请求先转发给中间类，再由中间类来完成对其他控件的调用。当需要增加或删除新的控件时，只需修改中 间类即可，无须修改新增控件或已有控件的源代码。
 */
public class Mediator {
    private List list;
    private Label label;
    private ComboBox comboBox;
    private TextBox textBox;
}
