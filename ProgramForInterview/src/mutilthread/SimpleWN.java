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

public class SimpleWN {
    final static Object object = new Object();
    public static class T1 extends Thread{
        public void run(){
            synchronized (object){
                System.out.println(System.currentTimeMillis()+":T1 start");
                try{
                    System.out.println(System.currentTimeMillis()+":T1 wait for object");
                    object.wait();
                    System.out.println(System.currentTimeMillis()+"T1 is awake");
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
            System.out.println(System.currentTimeMillis()+":T1 end");
        }
    }

    public static class T2 extends Thread{
        public void run(){
            synchronized (object){
                System.out.println(System.currentTimeMillis() + ":T2 start! notify one");
                object.notify();
                System.out.println(System.currentTimeMillis()+":T2 wait 5s");
                try {
                    Thread.sleep(5000);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
                System.out.println(System.currentTimeMillis()+":T2 end");
            }
        }
    }

    public static void main(String[] args) {
        new T1().start();
        new T2().start();
    }
}
