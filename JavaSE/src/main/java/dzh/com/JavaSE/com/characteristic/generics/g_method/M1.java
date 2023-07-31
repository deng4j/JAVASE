package dzh.com.JavaSE.com.characteristic.generics.g_method;

import java.io.Closeable;
import java.io.IOException;

/**
 * 只能访问对象的信息，不能修改信息
 * public 与 返回值中间<T>非常重要，可以理解为声明此方法为泛型方法。
 * 只有声明了<T>的方法才是泛型方法，泛型类中的使用了泛型的成员方法并不是泛型方法。
 * <T>表明该方法将使用泛型类型T，此时才可以在方法中使用泛型类型T。
 * 泛型的数量也可以为任意多个：public <T,K> K showKeyName(Generic<T> container{...}
 */
public class M1<T1,T2> {
	public static void main(String[] args) {
		String a = test("a");
		System.out.println(a);
	}

	/**
	 * 泛型方法
	 */
	public static <T> T test(T a){
		System.out.println(a instanceof String);
		return a;
	}
	// extends <=
	public static <T extends Closeable> void test(T... a){
		for(T temp:a){
			try {
				if(null!=temp){
					temp.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
