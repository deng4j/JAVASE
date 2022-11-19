package JavaSE.com.Javassist.basic;

import javassist.*;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

public class javassist2 {
    public static void main(String[] args) throws NotFoundException, IOException, CannotCompileException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        ClassPool pool=ClassPool.getDefault();
        CtClass ctClass = pool.get("com.Javassist.basic.Emp");



    }

    private static void insertMethod(ClassPool pool, CtClass ctClass) throws NotFoundException, CannotCompileException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        CtMethod work = ctClass.getDeclaredMethod("work", new CtClass[]{pool.get("java.lang.String")});
        //在方法体最前面插入
        work.insertBefore(" System.out.println($1+\"在工作\"+\"--前面\");");
        //指定行插入
        work.insertAt(17," System.out.println($1+\"在工作\"+\"--指定插入\");");
        //在方法体最后插入
        work.insertAfter("System.out.println($1+\"在工作\"+\"--最后这里\");");
        //通过反射生成新的方法
        reflection(ctClass,"work",new Class[]{String.class}, new Object[]{"小芳"});
    }

    private static void getNewProp(CtClass ctClass) throws CannotCompileException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        //创建方法$0,$1,$2代表方法的第几个参数
        CtMethod add = CtNewMethod.make("public int add(int a,int b){return a+b;}", ctClass);
        CtMethod devide = new CtMethod(CtClass.intType, "devide",
                new CtClass[]{CtClass.intType, CtClass.intType}, ctClass);
        devide.setModifiers(Modifier.PUBLIC);
        devide.setBody("{return $1-$2;}");
        ctClass.addMethod(devide);
        ctClass.addMethod(add);
        reflection(ctClass,"add",new Class[]{int.class,int.class},new Object[]{1,2});

    }
    //工具方法
    private static void reflection(CtClass ctClass, String mname, Class[] classes, Object[] objects) throws CannotCompileException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {

        //通过反射调用新生成的方法
        Class<?> aClass = ctClass.toClass();
        Object obj = aClass.newInstance();
        Method add1 = aClass.getDeclaredMethod(mname, classes);
        Object result=null;
        if (null!=objects){{
                result = add1.invoke(obj, objects);
        }}else{
            return;
        }
        System.out.println(result);
    }

    private static void getProp(CtClass ctClass) throws IOException, CannotCompileException, NotFoundException {
        //返回字节码数组
        //当CtClass 调用writeFile()、toClass()、toBytecode() 这些方法的时候会冻住ctClass
        byte[] bytes = ctClass.toBytecode();
        System.out.println("返回字节码数组:");
        System.out.println(Arrays.toString(bytes));
        System.out.println("获取类名："+ctClass.getName());
        System.out.println("获取父类："+ctClass.getSuperclass());
        System.out.println("获取接口："+ctClass.getInterfaces());
        //解冻
        ctClass.defrost();
    }
}
