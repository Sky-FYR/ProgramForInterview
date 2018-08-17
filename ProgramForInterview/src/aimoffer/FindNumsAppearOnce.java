package aimoffer;

import java.util.HashMap;
import java.util.Map;

/**
 * 一个整型数组里除了两个数字之外，其他的数字都出现了偶数次。
 * 请写程序找出这两个只出现一次的数字。
 */
public class FindNumsAppearOnce {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,2,3,4};
        int[] num1 = new int[1];
        int[] num2 = new int[1];
        new FindNumsAppearOnce().FindNumsAppearOnce(arr,num1,num2);
        System.out.println(num1[0]);
        System.out.println(num2[0]);
    }
    public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        int size = array.length;
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < size; i++) {
            if (map.get(array[i]) == null) {
                map.put(array[i],i);
            }else {
                map.remove(array[i]);
            }
        }
        Integer[] num = new Integer[2];
        map.keySet().toArray(num);
        num1[0] = num[0];
        num2[0] = num[1];
    }
}
