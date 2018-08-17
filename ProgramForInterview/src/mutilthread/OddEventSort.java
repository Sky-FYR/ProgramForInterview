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

public class OddEventSort {
    static int exchFlag = 1;
    static int[] arr;
    static ExecutorService pool;

    static synchronized void setExchFlag(int v){
        exchFlag = v;
    }
    static synchronized int getExchFlag(){
        return exchFlag;
    }
    public static class OddEventSortTask implements Runnable{
        int i;
        CountDownLatch latch;

        public OddEventSortTask(int i, CountDownLatch latch) {
            this.i = i;
            this.latch = latch;
        }

        @Override
        public void run() {
            if(arr[i] > arr[i+1]){
                int temp = arr[i];
                arr[i] = arr[i+1];
                arr[i+1] = temp;
                setExchFlag(1);
            }
            latch.countDown();
        }
    }

    public static void pOddEventSort(int[] arr) throws InterruptedException{
        int start = 0;
        while (getExchFlag() == 1 || start == 1){
            setExchFlag(0);
            CountDownLatch latch = new CountDownLatch(arr.length/2-(arr.length%2==0?start:0));
            for(int i = start; i < arr.length-1; i+=2){
                pool.submit(new OddEventSortTask(i,latch));
            }
            latch.await();
            if(start == 0){
                start = 1;
            }else {
                start = 0;
            }
        }
    }

    public static void main(String[] args) throws InterruptedException{
        arr = new int[]{5,52,6,3,4,8,9,1,8,7,11,46,52,11,85,99,100,16};
        pool = Executors.newCachedThreadPool();
        long begin = System.nanoTime();
        pOddEventSort(arr);
        System.out.println(Arrays.toString(arr) + "  " + (System.nanoTime()-begin));
        pool.shutdown();
    }
}
