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
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。
 * 由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0。
 */
public class MoreThanHalfNum_Solution {

    public int MoreThanHalfNum_Solution(int [] array) {

        if(array.length == 0) return 0;
        int count = 0;
        int num = 0;
        for(int i=0;i<array.length;i++){
            if(count == 0){
                num = array[i];
                count++;
            }else if(num == array[i]){
                count++;
            }else {
                count--;
            }
        }
        count = 0;
        for(int i=0;i<array.length;i++){
            if(array[i] == num){
                count++;
            }
        }
        if(2*count > array.length) return num;
        return 0;
    }
}
