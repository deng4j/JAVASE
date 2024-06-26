package dzh.com.JavaSE.com.system;

public class Arraycopy {
    public static int[] insert(int[] arr, int a, int index) {
        int[] newarr = new int[arr.length + 1];
        if (index < arr.length - 1) {
            // 从arr的0位置开始，拷贝index个元素到newarr，从newarr的0为位置开始
            System.arraycopy(arr, 0, newarr, 0, index);
            newarr[index] = a;
            System.arraycopy(arr, index, newarr, index + 1, arr.length - index);
        }
        return newarr;

    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 9};
        int a = 2;
        int[] newarr = insert(arr, a, 0);
        for (int i = 0; i < newarr.length; i++) {
            System.out.println(newarr[i]);
        }

    }
}
