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

import java.util.concurrent.locks.ReentrantLock;

public class IntLock implements Runnable {
    public static ReentrantLock lock1 = new ReentrantLock();
    public static ReentrantLock lock2 = new ReentrantLock();
    int lock;

    public IntLock(int lock){
        this.lock = lock;
    }

    @Override
    public void run(){
        try {
            if(lock == 1){
                lock1.lockInterruptibly();
                System.out.println(Thread.currentThread().getId()+"获得lock1");
                try {
                    Thread.sleep(500);
                }catch (InterruptedException e){}
                lock2.lockInterruptibly();
                System.out.println(Thread.currentThread().getId() + "获得lock2");
            }else {
                lock2.lockInterruptibly();
                System.out.println(Thread.currentThread().getId() + "获得lock2");
                try {
                    Thread.sleep(500);
                }catch (InterruptedException e){}
                lock1.lockInterruptibly();
                System.out.println(Thread.currentThread().getId() + "获得lock1");
            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }finally {
            if(lock1.isHeldByCurrentThread()){
                lock1.unlock();
                System.out.println(Thread.currentThread().getId() + "释放lock1");
            }
            if(lock2.isHeldByCurrentThread()){
                lock2.unlock();
                System.out.println(Thread.currentThread().getId() + "释放lock2");
            }
            System.out.println(Thread.currentThread().getId()+":线程退出");
        }
    }

    public static void main(String[] args) throws InterruptedException{
        IntLock r1 = new IntLock(1);
        IntLock r2 = new IntLock(2);
        Thread t1 = new Thread(r1);
        Thread t2 = new Thread(r2);
        t1.start();
        t2.start();
        Thread.sleep(1000);
        t1.interrupt();
    }
}
