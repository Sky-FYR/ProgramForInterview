package netease2017;

import java.util.Scanner;

public class NumReverse {

    public static int rev(int n) {
        int m = 0;
        while (n != 0) {
            m = m*10 + n%10;
            n /= 10;
        }
        return m;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();
        sc.close();

        System.out.println(rev(rev(x) + rev(y)));

        /*String xx = String.valueOf(x);
        String yy = String.valueOf(y);

        int i = 0;
        int j = 0;

        int next = 0;
        int tx = 0;
        int ty = 0;
        while (i<xx.length() || j<yy.length()) {
            if (i<xx.length()) {
                tx = xx.charAt(i)-'0';
            }
            if (j<yy.length()) {
                ty = yy.charAt(j)-'0';
            }
            int tmp =  tx + ty + next;
            if (tmp < 10) {
                System.out.print(tmp);
                next = 0;
            } else if (tmp > 10) {
                System.out.print(tmp%10);
                next = 1;
                if (i+1 >= xx.length() && j+1 >= yy.length()) {
                    System.out.print(next);
                }
            } else {
                if (next == 1) {
                    System.out.print(0);
                    if (i+1 >= xx.length() && j+1 >= yy.length()) {
                        System.out.print(next);
                    }
                }
                next = 1;
            }
            i++;
            j++;
            if (i == xx.length()) {
                tx = 0;
            }
            if (j == yy.length()) {
                ty = 0;
            }
        }*/
    }
}
