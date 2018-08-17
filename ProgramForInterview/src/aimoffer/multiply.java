package aimoffer;

import java.util.Arrays;

/**
 * 给定一个数组A[0,1,...,n-1],请构建一个数组B[0,1,...,n-1],
 * 其中B中的元素B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。
 * 不能使用除法。
 */
public class multiply {
    public static void main(String[] args) {
        int[] A = {1,2,3,4,5};
        System.out.println(Arrays.toString(multiply(A)));
    }
    public static int[] multiply(int[] A) {
        if (A == null || A.length == 0){
            return new int[]{};
        }
        int size = A.length;
        if (size == 1) {
            return new int[]{A[0]};
        }

        int[] forward = new int[size-1];
        int[] back = new int[size-1];

        for (int i = 0; i < (size - 1); i++) {
            if (i == 0) {
                forward[i] = A[i];
                back[size-2-i] = A[size-1-i];
            } else {
                forward[i] = forward[i-1] * A[i];
                back[size-2-i] = back[size-1-i] * A[size-1-i];
            }
        }

        int[] B = new int[size];
        for (int i = 0; i < size; i++) {
            if (i == 0) {
                B[i] = back[i];
            } else if (i == size-1){
                B[i] = forward[size-2];
            } else {
                B[i] = forward[i-1] * back[i];
            }
        }
        return B;
    }
}
