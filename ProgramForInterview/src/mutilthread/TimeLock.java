package mutilthread;/*
 * ------------------------------------------------------------------
 * Copyright  2017 Hangzhou DtDream Technology Co.,Ltd. All rights reserved.
 * ------------------------------------------------------------------
 *   Product: ProgramForInterview
 *   Module Name: mutilthread
 *   Date Created: 2018/7/27
 *   Description:
 * ------------------------------------------------------------------
 * Modification History
 * DATE            Name           Description
 * ------------------------------------------------------------------
 * 2018/7/27      FYR
 * ------------------------------------------------------------------
 */

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class TimeLock implements Runnable{
    public static ReentrantLock lock = new ReentrantLock();

    @Override
    public void run() {
        try {
            if(lock.tryLock(5, TimeUnit.SECONDS)){
                System.out.println(Thread.currentThread().getId() + "获得lock，并占有锁6s");
                Thread.sleep(6000);
            }else {
                System.out.println(Thread.currentThread().getId()+"获取lock失败");
            }
        }catch (InterruptedException e){
        }finally {
            if(lock.isHeldByCurrentThread()){
                System.out.println(Thread.currentThread().getId() + "释放lock");
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) {
        TimeLock t1 = new TimeLock();
        new Thread(t1).start();
        new Thread(t1).start();
    }
}
