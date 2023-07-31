package dzh.com.JavaSE.com.characteristic.generics.Erase;

/**
 * 泛型接口:与继承同理
 * 重写方法随父类而定
 * 不能父类泛型，子类擦除
 *
 * 继承|实现声明 不指定类型
 * 使用时 不指定类型
 * 统一Object 对待
 *
 * 接口中 泛型字母只能使用在方法中，不能使用在全局常量中
 */
public interface Comparable<T> {
	void compare(T t);
}

/**
 * 声明子类指定具体类型
 */
class Comp implements Comparable<Integer>{

	@Override
	public void compare(Integer t) {
		// TODO Auto-generated method stub

	}

}

/**
 * 擦除
 */
class Comp1 implements Comparable{

	@Override
	public void compare(Object t) {
		// TODO Auto-generated method stub

	}

}

/**
 * 父类擦除，子类泛型
 */
class Comp2<T> implements Comparable{

	@Override
	public void compare(Object t) {
		// TODO Auto-generated method stub

	}

}

/**
 * 子类泛型>=父类泛型
 */
class Comp3<T> implements Comparable<T>{

	@Override
	public void compare(T t) {
		// TODO Auto-generated method stub

	}

}