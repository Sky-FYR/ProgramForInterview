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

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CyclicBarrierDemo {
    public static class Soldier implements Runnable{
        private final CyclicBarrier cyclic;
        private String soldierName;

        public Soldier(CyclicBarrier cyclic, String soldierName) {
            this.cyclic = cyclic;
            this.soldierName = soldierName;
        }

        @Override
        public void run() {
            try {
                cyclic.await();
                doWork();
                cyclic.await();
            }catch (InterruptedException e1){
            }catch (BrokenBarrierException e2){}
        }

        private void doWork(){
            try{
                System.out.println(soldierName + "正在执行任务");
                Thread.sleep(1000);
                System.out.println(soldierName + "完成任务");
            }catch (InterruptedException e){}
        }
    }

    public static class BarrierRun implements Runnable{
        private boolean flag;

        public BarrierRun(boolean flag) {
            this.flag = flag;
        }

        @Override
        public void run() {
            if(flag){
                System.out.println("士兵任务完成");
            }else {
                System.out.println("士兵集合完毕");
                flag = true;
            }
        }
    }

    public static void main(String[] args) throws InterruptedException{
        int N = 10;
        Soldier[] soldiers = new Soldier[N];
        CyclicBarrier cyclic = new CyclicBarrier(N, new BarrierRun(false));
        System.out.println("集合");
        ExecutorService executorService = Executors.newFixedThreadPool(N);
        for(int i = 0; i < 10; i++){
            System.out.println("士兵" + (i+1) + "报道");
            soldiers[i] = new Soldier(cyclic, "士兵" + (i+1));
            executorService.submit(soldiers[i]);
//            new Thread(soldiers[i]).start();
        }
        executorService.shutdown();
    }
}
