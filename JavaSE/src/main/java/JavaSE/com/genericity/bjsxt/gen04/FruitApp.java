package JavaSE.com.genericity.bjsxt.gen04;
/**
 * 多态的两种形式
 * @author Administrator
 *
 */
public class FruitApp {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Fruit f =new Apple();
		test(new Apple());
	}
	//形参使用多态
	public static void test(Fruit f){

	}
	//返回类型使用多态
	public static Fruit  test2(){
		return new Apple();
	}

}

