package netease2017;

import java.util.Scanner;

public class Palindrome {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        int i = 0;
        while (i<n) {
            nums[i] = sc.nextInt();
            i++;
        }
        sc.close();
        int count = 0;
        int j = i-1;
        i = 0;
        while (i < j) {
            if (nums[i] == nums[j]) {
                i++;
                j--;
                continue;
            } else if (nums[i] < nums[j]) {
                    nums[i+1] += nums[i];
                    i++;
                    count++;
            } else {
                    nums[j-1] += nums[j];
                    j--;
                    count++;
            }
        }

        System.out.println(count);
    }
}
