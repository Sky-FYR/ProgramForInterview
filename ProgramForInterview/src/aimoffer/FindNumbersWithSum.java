package aimoffer;

import java.util.ArrayList;

public class FindNumbersWithSum {
    public ArrayList<Integer> FindNumbersWithSum(int [] array, int sum) {
        ArrayList<Integer> list = new ArrayList<>();
//        int time = Integer.MAX_VALUE;
        int size = array.length-1;
        int low = 0;
        int high = size;
        int num1 = 0;
        int num2 = 0;
        while (low <= high) {
            if (array[low]>=sum) {
                break;
            }
            if (array[low]+array[high] == sum) {
//                if (array[low]*array[high] < time) {
//                    time = array[low]*array[high];
//                    num1 = array[low];
//                    num2 = array[high];
//                }
//                low++;
//                high--;
                num1 = array[low];
                num2 = array[high];
                break;
            } else if (array[low]+array[high] < sum) {
                low++;
//                high = size;
            } else if (array[low]+array[high] > sum) {
                high--;
            }
        }
        if (num1 != num2) {
            list.add(num1);
            list.add(num2);
        }
        return list;
    }
}
