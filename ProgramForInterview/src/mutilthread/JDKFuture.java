package mutilthread;/*
 * ------------------------------------------------------------------
 * Copyright  2017 Hangzhou DtDream Technology Co.,Ltd. All rights reserved.
 * ------------------------------------------------------------------
 *   Product: ProgramForInterview
 *   Module Name: mutilthread
 *   Date Created: 2018/7/31
 *   Description:
 * ------------------------------------------------------------------
 * Modification History
 * DATE            Name           Description
 * ------------------------------------------------------------------
 * 2018/7/31      FYR
 * ------------------------------------------------------------------
 */

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class JDKFuture{
    public static void main(String[] args) throws InterruptedException, ExecutionException{
        FutureTask<String> future = new FutureTask<String>(new RealData("a"));
        ExecutorService exec = Executors.newFixedThreadPool(1);
        exec.submit(future);
        System.out.println("请求完毕");
        try {
            Thread.sleep(2000);
        }catch (InterruptedException e){}
        System.out.println("数据没准备好，可能得等几秒：");
        long start = System.currentTimeMillis();
        System.out.println("数据 = " + future.get() + ": " + (System.currentTimeMillis() - start));
        try {
            System.out.println(future.get(1, TimeUnit.SECONDS));
        }catch (TimeoutException e){}
        exec.shutdown();
    }

    static class RealData implements Callable<String>{
        private String para;
        public RealData(String para){
            this.para = para;
        }

        @Override
        public String call() throws Exception {
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < 10; i++){
                sb.append(para);
                try {
                    Thread.sleep(500);//模拟数据准备时间
                }catch (InterruptedException e){}

            }
            return sb.toString();
        }
    }
}


