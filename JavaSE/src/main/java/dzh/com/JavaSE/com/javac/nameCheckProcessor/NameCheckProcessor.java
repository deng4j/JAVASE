package dzh.com.JavaSE.com.javac.nameCheckProcessor;

import javax.annotation.processing.*;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;
import java.util.Set;

// 可以用"*"表示支持所有Annotations
@SupportedAnnotationTypes("*")
// 只支持JDK 21的Java代码
@SupportedSourceVersion(SourceVersion.RELEASE_21)
public class NameCheckProcessor extends AbstractProcessor {

    private NameChecker nameChecker;

    /**
     * 初始化名称检查插件
     * <p>
     * processingEnv：它是AbstractProcessor中的一个protected变量，在注解处理器初始化的时候（init()方法执行的时候）创建，
     * 继承了AbstractProcessor的注解处理器代码可以直接访问它。它代表了注解处理器框架提供的一个上下文环境，要创建新的代码、向编译器输出信息、获取其他工具类等都需要用到这个实例变量。
     */
    @Override
    public void init(ProcessingEnvironment processingEnv) {
        super.init(processingEnv);
        nameChecker = new NameChecker(processingEnv);
    }

    /**
     * Javac编译器在执行注解处理器代码时要调用的过程。
     * <p>
     * annotations：取到此注解处理器所要处理的注解集合
     * roundEnv：访问到当前这个轮次（Round）中的抽象语法树节点，每个语法树节点在这里都表示为一个Element
     * <p>
     * 每一个注解处理器在运行时都是单例的，如果不需要改变或添加抽象语法树中的内容，process()方法就可以返回一个值为false的布尔值，
     * 通知编译器这个轮次中的代码未发生变化，无须构造新的JavaCompiler实例。
     */
    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        // 把当前轮次中的每一个RootElement传递到一个名为NameChecker的检查器中执行名称检查逻辑
        if (!roundEnv.processingOver()) {
            for (Element element : roundEnv.getRootElements()) {
                nameChecker.checkNames(element);
            }
        }
        return false;
    }
}
