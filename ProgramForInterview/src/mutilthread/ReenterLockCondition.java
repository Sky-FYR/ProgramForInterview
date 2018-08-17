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

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ReenterLockCondition implements Runnable {
    public static ReentrantLock lock = new ReentrantLock();
    public static Condition condition1 = lock.newCondition();
    public static Condition condition2 = lock.newCondition();
    int lockCount;

    public ReenterLockCondition(int lockCount) {
        this.lockCount = lockCount;
    }

    @Override
    public void run() {
        if(lockCount == 1){
            try {
                lock.lock();
                System.out.println(Thread.currentThread().getId() + " wait for notify");
                condition1.await();
                System.out.println(Thread.currentThread().getId() + " awakened by condition1: " + System.currentTimeMillis());
                System.out.println(Thread.currentThread().getId() + " 占用2s");
                Thread.sleep(2000);
            }catch (InterruptedException e){
            }finally {
                lock.unlock();
            }
        }else {
            try {
                lock.lock();
                System.out.println(Thread.currentThread().getId() + " wait for notify");
                condition2.await();
                System.out.println(Thread.currentThread().getId() + " awakened by condition2: " + System.currentTimeMillis());
                System.out.println(Thread.currentThread().getId() + " 占用2s");
                Thread.sleep(2000);
            }catch (InterruptedException e){
            }finally {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException{
        ReenterLockCondition r1 = new ReenterLockCondition(1);
        ReenterLockCondition r2 = new ReenterLockCondition(2);
        new Thread(r1).start();
        new Thread(r2).start();

        Thread.sleep(2000);

        lock.lock();
        condition1.signal();
        condition2.signal();
        lock.unlock();
    }
}
