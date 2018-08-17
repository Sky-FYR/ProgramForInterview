package netease2017;

import java.util.Scanner;

public class MaxOddDivisor {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextInt();
        sc.close();

        long sum = 0;
        for (long i=n; i>0; i=i/2) {
            long tmp = (i+1)/2;
            sum += tmp*tmp;
        }

        //复杂度太高
/*        int sum = 0;
        int[] f = new int[n+1];
        for (int i = 1; i < n+1; i++) {
            if (i%2 == 0) {
                f[i] = f[i/2];
            } else {
                f[i] = i;
            }
            sum += f[i];
        }*/

        System.out.println(sum);
    }
}
