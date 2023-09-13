package dzh.com.DesignPattern.DesignPattern.createPatterns.Builder.builder4;

/**
 * 遇到多个构造参数时要考虑用构造器。
 *
 * 静态工厂和构造器都有个共同的局限性：他们都不能很好地拓展到大量的可选参数。
 * 一般的程序员会考虑重叠构造器（重载构造器方法），但是会很难写，而且阅读性差。
 * JavaBeans模式中使用setter方法来设置每一个必要的参数，创建实例很容易，阅读性也很强，但是有很严重的缺点。
 * 因为构造过程中被分到了几个调用中，在构造过程中JavaBean可能处于不一致状态的对象。
 * JavaBeans模式也阻止了把类做成不可变对象的可能。
 *
 * 优点：
 *  1.易于阅读
 *  2.可以对其参数进行约束条件。
 *  3.Builder可以有多个可变参数。
 *  4.可以利用当个builder构建多个对象。
 * 缺点：
 *  1.为了创建对象，必须先创建构建器，开销很大。
 *  2.Builder模式比重叠构造器模式更加冗长，只有在很多参数时才能使用，比如4个以上。
 *  3.不方便分步设置属性值
 */
public class NutritionFacts { // 营养成分表
    private int servingSize;
    private int servings;
    private int calories;
    private int fat;
    private int sodium;
    private int carbohydrate;

    @Override
    public String toString() {
        return "NutritionFacts{" +
                "servingSize=" + servingSize +
                ", servings=" + servings +
                ", calories=" + calories +
                ", fat=" + fat +
                ", sodium=" + sodium +
                ", carbohydrate=" + carbohydrate +
                '}';
    }

    public static class  Builder{
        // Required param
        private int servingSize;
        private int servings;
        // Optional param
        private int calories = 0;
        private int fat = 0;
        private int sodium = 0;
        private int carbohydrate = 0;

        public Builder(int servingSize, int servings) {
            this.servingSize = servingSize;
            this.servings = servings;
        }

        public Builder calories(int calories){
            this.calories = calories;
            return this;
        }
        public Builder fat(int fat){
            this.fat = fat;
            return this;
        }
        public Builder sodium(int sodium){
            this.sodium = sodium;
            return this;
        }
        public Builder carbohydrate(int carbohydrate){
            this.carbohydrate = carbohydrate;
            return this;
        }
        public NutritionFacts build(){
            return new NutritionFacts(this);
        }
    }

    private NutritionFacts(Builder builder){
        this.servingSize = builder.servingSize;
        this.servings = builder.servings;
        this.calories = builder.calories;
        this.fat= builder.fat;
        this.sodium = builder.sodium;
        this.carbohydrate = builder.carbohydrate;
    }

    public static void main(String[] args) {
        NutritionFacts nutritionFacts = new NutritionFacts.Builder(240, 8)
                .calories(100).fat(20).sodium(10).carbohydrate(29)
                .build();
        System.out.println(nutritionFacts);
    }
}
