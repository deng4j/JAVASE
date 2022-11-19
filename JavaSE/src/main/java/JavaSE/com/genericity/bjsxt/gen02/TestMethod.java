package JavaSE.com.genericity.bjsxt.gen02;

import java.io.Closeable;
import java.io.IOException;

/**
 * 泛型方法 <> 返回类型前面
 * 只能访问对象的信息，不能修改信息
 * @author Administrator
 *
 */
public class TestMethod {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		test("a"); //T -->String
	}
	//泛型方法
	public static <T> void test(T a){
		System.out.println(a);
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
