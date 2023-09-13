package dzh.com.JavaSE.com.characteristic.Reflect.demo.genericsClass.demo5;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public abstract class TypeReference<T> {
    private final Type type;

    protected TypeReference() {
        Class<?> parameterizedTypeReferenceSubclass = findParameterizedTypeReferenceSubclass(this.getClass());
        Type type = parameterizedTypeReferenceSubclass.getGenericSuperclass();
        ParameterizedType parameterizedType = (ParameterizedType) type;
        this.type = parameterizedType.getActualTypeArguments()[0];
    }

    public Type getType() {
        return this.type;
    }

    public boolean equals(Object obj) {
        return this == obj || obj instanceof TypeReference && this.type.equals(((TypeReference) obj).type);
    }

    public int hashCode() {
        return this.type.hashCode();
    }

    public String toString() {
        return "TypeReference<" + this.type + ">";
    }

    private static Class<?> findParameterizedTypeReferenceSubclass(Class<?> child) {
        Class<?> parent = child.getSuperclass();
        if (Object.class == parent) {
            throw new IllegalStateException("Expected TypeReference superclass");
        } else {
            // 一直找，直到找出来
            return TypeReference.class == parent ? child : findParameterizedTypeReferenceSubclass(parent);
        }
    }

    public static void main(String[] args) {
        TypeReference<String> typeReference = new TypeReference<>(){};
        System.out.println(typeReference.getType());
    }
}