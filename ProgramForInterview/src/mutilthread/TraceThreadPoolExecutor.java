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

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Future;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class TraceThreadPoolExecutor extends ThreadPoolExecutor {

    public TraceThreadPoolExecutor(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);
    }

    @Override
    public void execute(Runnable command) {
        super.execute(wrap(command, clientTrace(), Thread.currentThread().getName()));
    }

    @Override
    public Future<?> submit(Runnable task) {
        return super.submit(wrap(task, clientTrace(), Thread.currentThread().getName()));
    }

    private Exception clientTrace() {
        return new Exception("Client stack trace");
    }

    private Runnable wrap(final Runnable task, final Exception clientStack, String clientThreadName) {
        return new Runnable() {
            @Override
            public void run(){
                try {
                    task.run();
                }catch (Exception e){
                    clientStack.printStackTrace();
                    e.printStackTrace();
                }
            }
        };
    }
    static class DivTask implements Runnable{
        int a;
        int b;

        public DivTask(int a, int b) {
            this.a = a;
            this.b = b;
        }

        @Override
        public void run() {
            double re = a/b;
            System.out.println(re);
        }
    }

    public static void main(String[] args) throws InterruptedException{
        ThreadPoolExecutor poolExecutor = new TraceThreadPoolExecutor(0, Integer.MAX_VALUE,
                0L, TimeUnit.SECONDS, new SynchronousQueue<Runnable>());
        for(int i = 0; i < 5; i++){
            poolExecutor.submit(new DivTask(100, i));
            Thread.sleep(10);
        }
    }
}
