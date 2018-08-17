package aimoffer;/*
 * ------------------------------------------------------------------
 * Copyright  2017 Hangzhou DtDream Technology Co.,Ltd. All rights reserved.
 * ------------------------------------------------------------------
 *   Product: ProgramForInterview
 *   Module Name: aimoffer
 *   Date Created: 2018/8/4
 *   Description:
 * ------------------------------------------------------------------
 * Modification History
 * DATE            Name           Description
 * ------------------------------------------------------------------
 * 2018/8/4      FYR
 * ------------------------------------------------------------------
 */

/**
 * 把只包含质因子2、3和5的数称作丑数（Ugly Number）。例如6、8都是丑数，但14不是，因为它包含质因子7。
 * 习惯上我们把1当做是第一个丑数。求按从小到大的顺序的第N个丑数。
 */
public class GetUglyNumber_Solution {

    public static void main(String[] args) {
        System.out.println(new GetUglyNumber_Solution().GetUglyNumber_Solution(10));
    }
    public int GetUglyNumber_Solution(int index) {
        if (index < 7) return index;
        int[] res = new int[index];
        res[0] = 1;
        int t1 = 0;
        int t2 = 0;
        int t3 = 0;
        for (int i = 1; i < index; i++) {
            res[i] = getMin(res[t1]*2,res[t2]*3,res[t3]*5);
            if(res[i] == res[t1]*2) t1++;
            if(res[i] == res[t2]*3) t2++;
            if(res[i] == res[t3]*5) t3++;
        }

        return res[index-1];
//        int count = 4;
//        int result;
//        for (int i = 6;; i++) {
//            if(isUgly(i)){
//                count++;
//            }
//            if(count == index){
//                result = i;
//                break;
//            }
//        }
//        return result;
    }

    public int getMin(int a, int b, int c){
        int d;
        return (d = a<b?a:b) < c ? d:c;
    }

    public boolean isUgly(int num){
        while (num%2 == 0){
            num /= 2;
        }
        while (num%3 == 0){
            num /= 3;
        }
        while (num%5 == 0){
            num /= 5;
        }
        if (num == 1) return true;
        return false;
    }
}
