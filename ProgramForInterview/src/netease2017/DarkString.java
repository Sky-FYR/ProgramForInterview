package netease2017;

import java.util.Scanner;

public class DarkString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {
            int n = sc.nextInt();
            long[] dp = new long[n];
            dp[0] = 3;
            dp[1] = 9;
            for (int i = 2; i < n; i++) {
                dp[i] = 2*dp[i-1] + dp[i-2];
            }
            System.out.println(dp[n-1]);
        }
    }
}
