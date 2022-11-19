package JavaSE.com.Javassist.basic;

import JavaSE.com.IO.classloader.ClassLoaderTest;
import javassist.*;

import java.io.IOException;

/**字节码操作，先下载并导入Javassist.jar包
 * Javassist是一个动态类库，可以用来检查、”动态”修改以及创建 Java类。其功能与jdk自带的反射功能类似，但比反射功能更强大。
 *
 * 重要的类
 * ClassPool：javassist的类池，使用ClassPool 类可以跟踪和控制所操作的类,它的工作方式与 JVM 类装载器非常相似，
 * CtClass： CtClass提供了检查类数据（如字段和方法）以及在类中添加新字段、方法和构造函数、以及改变类、父类和接口的方法。不过，Javassist 并未提供删除类中字段、方法或者构造函数的任何方法。
 * CtField：用来访问域
 * CtMethod ：用来访问方法
 * CtConstructor：用来访问构造器
 */
public class javassist1 {
    public static void main(String[] args) throws CannotCompileException, NotFoundException, IOException {
        ClassPool pool =ClassPool.getDefault();
        CtClass ctClass = pool.makeClass("JavassistEmp");
        //创建属性,先写源码，自动转字节码
        CtField empno = CtField.make("private int empno;", ctClass);
        CtField name = CtField.make("private String name;", ctClass);
        ctClass.addField(empno);
        ctClass.addField(name);

        //创建方法
        CtMethod getEmpno = CtMethod.make(" public int getEmpno() { return empno; }", ctClass);
        CtMethod setEmpno = CtMethod.make(" public void setEmpno(int empno) {\n" +
                "        this.empno = empno;\n" +
                "    }", ctClass);
        ctClass.addMethod(getEmpno);
        ctClass.addMethod(setEmpno);

        //添加构造器,有参构造
        CtConstructor ctConstructor = new CtConstructor(new CtClass[]{CtClass.intType, pool.get("java.lang.String")}, ctClass);
        ctConstructor.setBody("{\n" +
                "        this.empno = empno;\n" +
                "        this.name = name;\n" +
                "    }");
        ctClass.addConstructor(ctConstructor);
        //输出到一个工作空间
        ctClass.writeFile("D:\\ideasX\\JavaSE\\JavaSE\\src\\main\\resources\\javassist");
        System.out.println("生成成功");
    }
}

