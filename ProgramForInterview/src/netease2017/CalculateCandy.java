package netease2017;

import java.util.Scanner;

public class CalculateCandy {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        int d = sc.nextInt();
        sc.close();

        if ((a+c)%2 == 0 && (b+d)%2 == 0 && (d-b)%2 == 0) {
            int A = (a+c)/2;
            int B = (b+d)/2;
            int C = (d-b)/2;
            if (A >= 0 && B >= 0 && C >= 0) {
                System.out.print(A+" "+B+" "+C);
                return;
            }
        }
        System.out.print("No");
    }
}
