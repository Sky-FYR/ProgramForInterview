package aimoffer;

/**
 * 统计一个数字在排序数组中出现的次数。
 */
public class GetNumberOfK {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,5,6,6,6,7,8,9};
        System.out.println(GetNumberOfK(arr, 6));
    }

    public static int GetNumberOfK(int [] array , int k) {
        int count = 0;
        int low = 0;
        int high = array.length-1;

        while (low<=high){
            int mid = (low+high)/2;
            if (array[mid] < (k+0.5)) {
                low = mid+1;
            }else if (array[mid] > (k+0.5)) {
                high = mid-1;
            }
        }
        count = high;
        low = 0;
        high = array.length-1;
        while (low<=high){
            int mid = (low+high)/2;
            if (array[mid] < (k-0.5)) {
                low = mid+1;
            }else if (array[mid] > (k-0.5)) {
                high = mid-1;
            }
        }

        count = count - high;
        /*while (low<=high){
            int mid = (low+high)/2;
            if (array[mid] == k) {
                count++;
                int up = mid+1;
                int down = mid-1;
                while (up<array.length) {
                    if (array[up] == k) {
                        count++;
                        up++;
                    } else {
                        break;
                    }
                }
                while (down>=0) {
                    if (array[down] == k) {
                        count++;
                        down--;
                    } else {
                        break;
                    }
                }
                break;
            }else if (array[mid] < k) {
                low = mid+1;
            }else if (array[mid] > k) {
                high = mid-1;
            }
        }*/
        return count;
    }
}
