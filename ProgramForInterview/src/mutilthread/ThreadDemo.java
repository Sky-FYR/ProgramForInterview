package mutilthread;/*
 * ------------------------------------------------------------------
 * Copyright  2017 Hangzhou DtDream Technology Co.,Ltd. All rights reserved.
 * ------------------------------------------------------------------
 *   Product: ProgramForInterview
 *   Module Name: mutilthread
 *   Date Created: 2018/7/28
 *   Description:
 * ------------------------------------------------------------------
 * Modification History
 * DATE            Name           Description
 * ------------------------------------------------------------------
 * 2018/7/28      FYR
 * ------------------------------------------------------------------
 */

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadDemo {
    public static class MyTask implements Runnable{
        @Override
        public void run() {
            System.out.println(System.currentTimeMillis() + ":Thread ID:"
                    + Thread.currentThread().getId());
            try {
                Thread.sleep(1000);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }

        public static void main(String[] args) throws InterruptedException{
            MyTask task = new MyTask();
            ExecutorService exec = Executors.newFixedThreadPool(5);
            for(int i = 0; i < 10; i++){
                exec.execute(task);
            }
            Thread.sleep(2000);
            exec.shutdown();
        }
    }
}
