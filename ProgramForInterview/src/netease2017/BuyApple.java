package netease2017;

import java.util.Scanner;

public class BuyApple {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();

        System.out.println(buy(n));
    }

    public static int buy(int n) {
        if (n < 6 || n == 7) {
            return -1;
        }
        if (n == 6 || n == 8) {
            return 1;
        }

        int n1 = buy(n-6);
        int n2 = buy(n-8);
        if (n1 == -1 && n2 == -1) {
            return -1;
        } else {
            int tmp = n1 > n2 ? n2: n1;
            if (tmp == -1) {
                return n1 > n2 ? n1+1: n2+1;
            }
            return tmp+1;
        }
    }
}
