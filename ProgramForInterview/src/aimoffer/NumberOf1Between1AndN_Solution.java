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
 * 求出1~13的整数中1出现的次数,并算出100~1300的整数中1出现的次数？
 * 为此他特别数了一下1~13中包含1的数字有1、10、11、12、13因此共出现6次,但是对于后面问题他就没辙了。
 * ACMer希望你们帮帮他,并把问题更加普遍化,可以很快的求出任意非负整数区间中1出现的次数（从1 到 n 中1出现的次数）。
 */
public class NumberOf1Between1AndN_Solution {

    public static void main(String[] args) {
        int count = new NumberOf1Between1AndN_Solution().NumberOf1Between1AndN_Solution(14);
        System.out.println(count);
    }

    public int NumberOf1Between1AndN_Solution(int n) {
        if(n<=0){
            return 0;
        }
        int len = getLenOfNum(n);
        if(len == 1){
            return 1;
        }
        int tmp = powerBaseOf10(len-1);
        int first = n/tmp;
        int firstNum = first==1 ? n%tmp+1 : tmp;
        int otherNum = first * (len-1) * (tmp/10);
        return firstNum + otherNum + NumberOf1Between1AndN_Solution(n%tmp);

    }

    //求10的n次方
    public int powerBaseOf10(int base){
        return (int) Math.pow(10,base);
    }

    //获取数字的位数
    public int getLenOfNum(int num){
        int len = 0;
        while(num != 0){
            len++;
            num /= 10;
        }
        return len;
    }
}
