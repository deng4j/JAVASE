package dzh.com.JavaSE.com.base.Object;

/**
 *
 *
 * 在覆盖equals方法的时候，必须遵守通用约定：
 *  自反性(reflexive)。 对于任何非null的引用值x，x.equals(x)必须返回true。
 *  对称性(symmetric)。对于任何非null的引用值x和y，当且仅当y.equals(x)返回true时，x.equals(y)必须返回true.
 *  传递性(transitive)。 对于任何非null的引用值x、y和z,如果x.equals(y)返回true,并且y.equals(z)也返回true,那么x.equals(z)也必须返回true。
 *  一致性(consistent)。对于任何非null的引用值x和y，只要equals的比较操作在对象中所用的信息没有被修改，多次调用x.equals(y)就会一致地返回true,或者一致地返回false。
 *  非空性(Non-nullity)对于任何非nul1的引用值x，x.equals(nul)必 须返回false。
 *
 *  覆盖equals时总要覆盖hashCode，相等的对象必须具有相等的散列码，否则该类无法结合基于散列的集合一起正常运作。
 *  不要将equals中声明的Object对象替换为其他类型。
 */
public class Equals {

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
