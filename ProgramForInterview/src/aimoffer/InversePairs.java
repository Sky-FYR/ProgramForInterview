package aimoffer;

import java.util.Arrays;

/**
 * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。
 * 输入一个数组,求出这个数组中的逆序对的总数P。并将P对1000000007取模的结果输出。
 * 即输出P%1000000007
 */
public class InversePairs {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,0};
        System.out.println(InversePairs(arr));
    }
    public static int InversePairs(int [] array) {
        if (array == null || array.length == 0){
            return 0;
        }
        int[] copy = Arrays.copyOf(array, array.length);
        int count = InversePairCore(array, copy, 0, array.length-1);
        return count%1000000007;
//        Map<Integer,Integer> map = new TreeMap<>();
//
//        int size = array.length;
//        for (int i = 0; i < size; i++) {
//            map.put(array[i], i);
//        }
//
//        int j = 0;
//        int count = 0;
//        ArrayList<Integer> list = new ArrayList<>();
//        for (Map.Entry<Integer,Integer> entry : map.entrySet()){
//            if (j != 0){
//                for (int k = 0; k < j; k++){
//                    if (list.get(k) > entry.getValue()){
//                        count++;
//                    }
//                }
//            }
//            list.add(entry.getValue());
//            j++;
//        }
//        return count;
    }

    public static int InversePairCore(int[] array, int[] copy, int low, int high) {
        if (low == high) {
            return 0;
        }

        int mid = (low + high) / 2;

        int leftCount = InversePairCore(array, copy, low, mid);
        int rightCount = InversePairCore(array, copy, mid + 1, high);

        int count = 0;
        int i = mid;
        int j = high;
        int pos = high;
        while (i >= low && j > mid) {
            if (array[i] > array[j]) {
                count += (j - mid);
                if (count >= 1000000007) {//数值过大求余
                    count %= 1000000007;
                }
                copy[pos] = array[i];
                i--;
            } else {
                copy[pos] = array[j];
                j--;
            }
            pos--;
        }
        for (; i >= low; i--) {
            copy[pos] = array[i];
            pos--;
        }
        for (; j > mid; j--) {
            copy[pos] = array[j];
            pos--;
        }

        for (int k = low; k <= high; k++) {
            array[k] = copy[k];
        }

        return (count + leftCount + rightCount) % 1000000007;
    }
}
