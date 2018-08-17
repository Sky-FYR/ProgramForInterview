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

public class BadSuspend {
    public static Object u = new Object();
    static ChangeObjectThread t1 = new ChangeObjectThread("t1");
    static ChangeObjectThread t2 = new ChangeObjectThread("t2");

    public static class ChangeObjectThread extends Thread{
        public ChangeObjectThread(String name) {
            super(name);
        }

        @Override
        public void run() {
            synchronized (u){
                System.out.println("in " + getName());
                Thread.currentThread().suspend();
                System.out.println(System.currentTimeMillis() + ": " + getName() + " resumed");
            }
        }
    }

    public static void main(String[] args) throws InterruptedException{
        t1.start();
        Thread.sleep(100);
        t2.start();
        Thread.sleep(100);
        t1.resume();
        Thread.sleep(1000);
        t2.resume();
    }
}
