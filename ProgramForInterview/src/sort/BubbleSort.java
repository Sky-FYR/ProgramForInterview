package sort;/*
 * ------------------------------------------------------------------
 * Copyright  2017 Hangzhou DtDream Technology Co.,Ltd. All rights reserved.
 * ------------------------------------------------------------------
 *   Product: ProgramForInterview
 *   Module Name: sort
 *   Date Created: 2018/8/1
 *   Description:
 * ------------------------------------------------------------------
 * Modification History
 * DATE            Name           Description
 * ------------------------------------------------------------------
 * 2018/8/1      FYR
 * ------------------------------------------------------------------
 */

import java.util.Arrays;

public class BubbleSort {
    public static void bubbleSort(int[] arr){
        for(int i = 0; i < arr.length-1; i++){
            for(int j = arr.length-1; j > i; j--){
                if(arr[j-1]>arr[j]){
                    int temp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{5,52,6,3,4,8,9,1,8,7,11,46,52,11,85,99,100,16};
        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
