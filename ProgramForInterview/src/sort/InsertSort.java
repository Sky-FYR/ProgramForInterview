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

public class InsertSort {
    public static void insertSort(int[] arr){

        for(int i=1; i<arr.length; i++){
            int key = arr[i];
            int j=i;
//            for(; j>0; j--){
//                if(arr[j-1] > key){
//                    arr[j] = arr[j-1];
//                }else {
//                    break;
//                }
//            }
            while (j>0 && arr[j-1]>key){
                arr[j] = arr[j-1];
                j--;
            }
            arr[j] = key;

        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{5,52,6,3,4,8,9,1,8,7,11,46,52,11,85,99,100,16};
        insertSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
