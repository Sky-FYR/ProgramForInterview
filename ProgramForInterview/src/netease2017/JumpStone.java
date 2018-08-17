package netease2017;

import java.util.Scanner;

public class JumpStone {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        sc.close();

        int[] steps = new int[m+1];

        for (int i = n+1; i <= m; i++) {
            steps[i] = Integer.MAX_VALUE;
        }
        steps[n] = 0;

        for (int i = n; i <= m; i++) {
            if (steps[i] == Integer.MAX_VALUE) {
                continue;
            }

            for (int j = 2; j*j <= i; j++) {
                if (i%j == 0) {
                    if (i+j <= m) {
                        steps[i+j] = steps[i]+1 < steps[i+j] ? steps[i]+1:steps[i+j];
                    }

                    if (i+(i/j) <= m) {
                        steps[i+(i/j)] = steps[i]+1 < steps[i+(i/j)] ? steps[i]+1:steps[i+(i/j)];
                    }
                }
            }
        }
        if (steps[m] == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(steps[m]);
        }
    }

    public static int getNext(int n, int m) {
        if (n == m) {
            return 0;
        } else if (n > m) {
            return -1;
        }
        int count = Integer.MAX_VALUE;
        int tmp = n-1;
        while (tmp > 1) {
            if (n%tmp == 0) {
                int re = getNext(n+tmp,m);
                if (re != -1) {
                    if (re < count) {
                        count = re;
                        break;
                    }
                }
            }
            tmp--;
        }
        if (count == Integer.MAX_VALUE) {
            return -1;
        }
        return ++count;
    }
}
