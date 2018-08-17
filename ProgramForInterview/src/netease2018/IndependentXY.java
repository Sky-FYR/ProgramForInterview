package netease2018;

import java.util.Scanner;

public class IndependentXY {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();//每天支付x元
        int f = sc.nextInt();//f个水果
        int d = sc.nextInt();//有d元钱
        int p = sc.nextInt();//每个水果卖p元
        sc.close();

        if (f*x >= d) {
            System.out.println(d/x);
            return;
        }

        int left = d - f * x;
        int extra = left/(p+x);

        System.out.println(f+extra);
    }
}
