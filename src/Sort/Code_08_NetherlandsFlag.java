package Sort;

/**
 * Created by zhaoxinliu on 2019/3/20
 */
public class Code_08_NetherlandsFlag {
    public  static int[] partition(int[] array, int left, int right, int num) {
        int less = left -1;
        int more = right + 1;
        int cur = left;
        while(cur < more){
            if(array[cur] < num){//只要num大于当前数字，就将当前数字与arr[++less]交换，cur++
                swap(array,++less,cur++);
            }else if(array[cur]  > num){//如果当前数字大于num,则当前数字与array[--more]交换，cur是不用++的。
                swap(array,--more,cur);
            }else{
                cur++;//如果相等的话，cur直接++
            }
        }
        return new int[]{++less,--more};
    }

    // for test
    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    // for test
    public static int[] generateArray() {
        int[] arr = new int[10];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 3);
        }
        return arr;
    }

    // for test
    public static void printArray(int[] arr) {
        if (arr == null) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] test = generateArray();

        printArray(test);
        int[] res = partition(test, 0, test.length - 1, 1);
        printArray(test);
        System.out.println(res[0]);
        System.out.println(res[1]);

    }


}
