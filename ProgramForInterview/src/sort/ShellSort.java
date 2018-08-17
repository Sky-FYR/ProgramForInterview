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

public class ShellSort {
    public static void shellSort(int[] arr){
        int h = 1;
        while (h <= arr.length/3){
            h = h*3 + 1;
        }
        while (h > 0){
            for (int i=h; i<arr.length; i++){
                if(arr[i] < arr[i-h]){
                    int key = arr[i];
                    int j = i;
                    while (j>=h && arr[j-h]>key){
                        arr[j] = arr[j-h];
                        j-=h;
                        System.out.println(j);
                    }
                    arr[j] = key;
                }
            }
            h = (h-1)/3;
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{5,52,6,3,4,8,9,1,8,7,11,46,52,11,85,99,100,16};
        shellSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
