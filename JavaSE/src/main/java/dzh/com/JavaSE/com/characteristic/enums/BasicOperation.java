package dzh.com.JavaSE.com.characteristic.enums;

interface Operation{
    int apply(int a,int b);
}

/**
 * 使用接口对枚举进行拓展
 */
public enum BasicOperation implements Operation{
    PLUS(){
        @Override
        public int apply(int a, int b) {
            return a+b;
        }
    },
    MINUS(){
        @Override
        public int apply(int a, int b) {
            return a-b;
        }
    };
}
