package mutilthread;/*
 * ------------------------------------------------------------------
 * Copyright  2017 Hangzhou DtDream Technology Co.,Ltd. All rights reserved.
 * ------------------------------------------------------------------
 *   Product: ProgramForInterview
 *   Module Name: mutilthread
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
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ShellSortTaskMain {
    static int[] arr;
    static ExecutorService pool;
    public static class ShellSortTask implements Runnable{
        int i = 0;
        int h = 0;
        CountDownLatch latch;

        public ShellSortTask(int i, int h, CountDownLatch latch) {
            this.i = i;
            this.h = h;
            this.latch = latch;
        }

        @Override
        public void run() {
            if(arr[i] < arr[i-h]){
                int key = arr[i];
                int j = i - h;
                while (j>=0 && arr[j]>key){
                    arr[j+h] = arr[j];
                    j-=h;
                }
                arr[j+h] = key;
            }
//            System.out.println(Arrays.toString(arr));
            latch.countDown();
        }
    }

    public static void pShellSort(int[] arr) throws InterruptedException{
        int h = 1;
        CountDownLatch latch = null;
        while (h <= arr.length/3){
            h = h*3 + 1;
        }
        while (h>0){
            System.out.println("h="+h);
            if(h>=4){
                latch = new CountDownLatch(arr.length-h);
            }
            for (int i = h; i < arr.length; i++){
                if(h>=4){
                    pool.execute(new ShellSortTask(i, h, latch));
                }else {
                    if(arr[i] < arr[i-h]){
                        int key = arr[i];
                        int j = i - h;
                        while (j>=0 && arr[j]>key){
                            arr[j+h] = arr[j];
                            j-=h;
                        }
                        arr[j+h] = key;
                    }
//                    System.out.println(Arrays.toString(arr));
                }
            }
            latch.await();
            h = (h-1)/3;
        }
    }

    public static void main(String[] args) throws InterruptedException{
        arr = new int[]{5,52,6,3,4,8,9,1,8,7,11,46,52,11,85,99,100,16};
        pool = Executors.newCachedThreadPool();
        pShellSort(arr);
        pool.shutdown();
        System.out.println(Arrays.toString(arr));
    }
}
