package dzh.com.JavaSE.com.characteristic.Reflect.demo.genericsClass.demo3;

import java.lang.reflect.*;
import java.util.List;

public class A {
    public List<? super Number> data1;
    public List<? extends Number> data2;

    public List<? super Number> getData1() {
        return data1;
    }

    public void setData1(List<? super Number> data) {
        this.data1 = data;
    }

    public List<? extends Number> getData2() {
        return data2;
    }

    public void setData2(List<? extends Number> data2) {
        this.data2 = data2;
    }

    public static void getFiled(){
        Field[] fields = A.class.getFields();
        for (Field field : fields) {
            System.out.println("------------"+field.getName()+"-----------");
            Type genericType = field.getGenericType();
            System.out.println(genericType.getTypeName());
            if(genericType instanceof ParameterizedType){
                ParameterizedType parameterizedType= (ParameterizedType)genericType;
                Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
                for (Type actualTypeArgument : actualTypeArguments) {
                    WildcardType wildcardType = (WildcardType) actualTypeArgument;

                    System.out.println("获取所有下界");
                    for (Type lowerBound : wildcardType.getLowerBounds()) {
                        System.out.println(lowerBound.getTypeName());
                    }

                    System.out.println("获取所有上界");
                    for (Type upperBound : wildcardType.getUpperBounds()) {
                        System.out.println(upperBound.getTypeName());
                    }
                }
            }
        }
    }

    private static void getMethod() {
        Method[] methods = A.class.getDeclaredMethods();
        for (Method method : methods) {
            System.out.println("-------------"+method.getName()+"---------------");
            //获取方法中的参数类型（包含泛型，区别于getParameterTypes）
            Type[] genericParameterTypes = method.getParameterTypes();
            for (Type genericParameterType : genericParameterTypes) {
                System.out.println(genericParameterType.getTypeName());
                if(genericParameterType instanceof ParameterizedType){
                    //因为这里只有setData有方法有入参，因此直接对应List<? super String>类型是ParameterizedType
                    ParameterizedType parameterizedType = (ParameterizedType) genericParameterType;
                    System.out.println(parameterizedType);
                    //获取List中的泛型参数
                    Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
                    for (Type actualTypeArgument : actualTypeArguments) {
                        System.out.println(actualTypeArgument);
                        //由于实际中是通配符?super String ,因此转成WildcardType
                        WildcardType wildcardType = (WildcardType) actualTypeArgument;
                        Type[] lowerBounds = wildcardType.getLowerBounds();
                        for (Type lowerBound : lowerBounds) {
                            System.out.println(lowerBound);
                        }
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws NoSuchFieldException {
        getFiled();
    }
}

