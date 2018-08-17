package mutilthread;/*
 * ------------------------------------------------------------------
 * Copyright  2017 Hangzhou DtDream Technology Co.,Ltd. All rights reserved.
 * ------------------------------------------------------------------
 *   Product: ProgramForInterview
 *   Module Name: mutilthread
 *   Date Created: 2018/7/29
 *   Description:
 * ------------------------------------------------------------------
 * Modification History
 * DATE            Name           Description
 * ------------------------------------------------------------------
 * 2018/7/29      FYR
 * ------------------------------------------------------------------
 */

import java.text.MessageFormat;
import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class ProConDemo {
    static class Producer implements Runnable {
        private volatile boolean isRunning = true;
        private BlockingQueue<PCData> queue;
        private static AtomicInteger count = new AtomicInteger();
        private static final int SLEEPTIME = 1000;

        public Producer(BlockingQueue<PCData> queue) {
            this.queue = queue;
        }

        @Override
        public void run() {
            PCData data;
            Random r = new Random();

            System.out.println("start producer id = "+Thread.currentThread().getId());

            try{
                int p = 0;
                while (isRunning){
                    Thread.sleep(r.nextInt(SLEEPTIME));
                    data = new PCData(count.incrementAndGet());
                    System.out.println(data+" is put in queue");
                    if(!queue.offer(data, 2, TimeUnit.SECONDS)){
                        System.out.println("failed to put data: "+data);
                    }else {
                        p++;
                    }
                }
                System.out.println("p"+Thread.currentThread().getId()+": 执行完毕，共生产"+p);
            }catch (InterruptedException e){
                e.printStackTrace();
                Thread.currentThread().interrupt();
            }
        }

        public void stop(){
            isRunning = false;
        }
    }

    static class Consumer implements Runnable{
        private BlockingQueue<PCData> queue;
        private static final int SLEEPTIME = 1000;

        public Consumer(BlockingQueue<PCData> queue) {
            this.queue = queue;
        }

        @Override
        public void run() {
            System.out.println("start consumer id = "+Thread.currentThread().getId());
            Random r = new Random();

            try{
                int c = 0;
                while (true){
                    PCData data = queue.poll(2, TimeUnit.SECONDS);
                    if(data != null){
                        int re = data.getData() * data.getData();
                        System.out.println(MessageFormat.format("{0}*{1}={2}", data.getData(), data.getData(), re));
                        c++;
                        Thread.sleep(r.nextInt(SLEEPTIME));
                    }else {
                        break;
                    }
                }
                System.out.println("c"+Thread.currentThread().getId()+": 执行完毕，共消费"+c);
            }catch (InterruptedException e){
                e.printStackTrace();
                Thread.currentThread().interrupt();
            }
        }
    }

    static final class PCData{
        private final int data;

        public PCData(int data) {
            this.data = data;
        }

        public PCData(String data) {
            this.data = Integer.valueOf(data);
        }

        public int getData() {
            return data;
        }

        @Override
        public String toString() {
            return "data=" + data;

        }

    }


    public static void main(String[] args) throws InterruptedException{
        BlockingQueue<PCData> queue = new LinkedBlockingQueue<PCData>(10);
        Producer p1 = new Producer(queue);
        Producer p2 = new Producer(queue);
        Producer p3 = new Producer(queue);
        Consumer c1 = new Consumer(queue);
        Consumer c2 = new Consumer(queue);
        Consumer c3 = new Consumer(queue);
        ExecutorService exec = Executors.newCachedThreadPool();
        exec.execute(p1);
        exec.execute(p2);
        exec.execute(p3);
        exec.execute(c1);
        exec.execute(c2);
        exec.execute(c3);
        Thread.sleep(5 * 1000);
        p1.stop();
        p2.stop();
        p3.stop();
        Thread.sleep(3000);
        exec.shutdown();
    }
}
