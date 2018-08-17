package netease2017;

import java.util.Scanner;

public class GoodPoint {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        sc.close();
        int count = 0;
        int n= (int)Math.pow(m,0.5);
        while (n > 0) {
            int tmp = m - (n)*(n);
            int tmp2 = (int)Math.pow(tmp,0.5);
            if (tmp2*tmp2 == tmp) {
                count++;
            }
            n--;
        }
        count *= 4;
        System.out.println(count);
    }
}
