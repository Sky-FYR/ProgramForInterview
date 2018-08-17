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

import java.util.Arrays;
import java.util.Comparator;

/**
 * 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
 * 例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323。
 */
public class PrintMinNumber {

    public static void main(String[] args) {
        int[] numbers = {3,32,321,3};
        long start = System.currentTimeMillis();
        System.out.println(new PrintMinNumber().PrintMinNumber(numbers));
        System.out.println(System.currentTimeMillis()-start);
    }

    public String PrintMinNumber(int [] numbers) {
        int size = numbers.length;
        Integer[] ns = new Integer[size];
        for (int i = 0; i < size; i++) {
            ns[i] = numbers[i];
        }
        Arrays.parallelSort(ns, cmp);

        StringBuilder sb = new StringBuilder("");
        for (int i = 0; i < size; i++) {
            sb.append(ns[i]);
        }

        return sb.toString();
    }

    Comparator<Integer> cmp = new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            String s1 = Integer.toString(o1);
            String s2 = Integer.toString(o2);

            int size1 = s1.length();
            int size2 = s2.length();

            int i = 0;
            int j = 0;
            while (i<size1 || j<size2){
                if(s1.charAt(i) > s2.charAt(j)){
                    return 1;
                }else if(s1.charAt(i) < s2.charAt(j)){
                    return -1;
                }else {
                    i++;
                    j++;
                    if(i == size1 && j == size2) break;
                    if(i == size1) i--;
                    if(j == size2) j--;
                    continue;
                }
            }
            return 0;
        }
    };
}
