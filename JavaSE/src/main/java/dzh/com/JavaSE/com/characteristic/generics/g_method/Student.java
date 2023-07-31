package dzh.com.JavaSE.com.characteristic.generics.g_method;

import java.util.Date;

/**
 * 泛型声明时字母不能使用 静态属性上
 */
public class Student<T1,T2> {
	private T1 javaScore;
	private T2 oracleScore;

	//泛型声明时不能使用 静态属性
	//private static T1 test;


	/**
	 * 这个泛型方法是静态的，使用了T作为返回值和方法参数类型，但是静态方法是属于类的，类直接调用的话，T类型无法指定具体类型，那么该方法就没有意义。所以直接报错。
	 */
//	public static T demo2(T t) { return t;}

	/**
	 * 这个也是静态方法，但是该静态方法是自定义一个泛型参数，并非使用类型参数。所以当传入一个具体类型时，该静态方法的<W>就是具体类型了。
	 */
	public static <T1> T1 getstatic(T1 t) {
		return t;
	}

	/**
	 * 虽然在方法中使用了泛型，但是这并不是一个泛型方法。
	 */
	public T1 getJavaScore() {
		return javaScore;
	}

	public void setJavaScore(T1 javaScore) {
		this.javaScore = javaScore;
	}


	public T2 getOracleScore() {
		return oracleScore;
	}

	public void setOracleScore(T2 oracleScore) {
		this.oracleScore = oracleScore;
	}


	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//使用时指定类型(引用类型)
		Student<String,Integer> stu = new Student<String,Integer> ();
		//1、安全：类型检查
		stu.setJavaScore("优秀");
//		stu.setOracleScore(1);
		//2、省心:类型转换，不能返回一个null给泛型
		int it =stu.getOracleScore(); //自动拆箱

		//
		Date date = Student.getstatic(new Date());
		System.out.println(date);
	}

}
