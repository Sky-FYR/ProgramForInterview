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

public class SimpleFuture {
    public static void main(String[] args) {
        Client client = new Client();
        Data data = client.request("name");
        System.out.println("请求完毕");
        try {
            Thread.sleep(2000);
        }catch (InterruptedException e){}

        System.out.println("数据没准备好，可能得等几秒：");
        long start = System.currentTimeMillis();
        System.out.println(data.getResult() + ": " + (System.currentTimeMillis() - start));
    }

    interface Data{
        String getResult();
    }

    static class FutureData implements Data {
        protected RealData realData = null;
        protected boolean isReady = false;
        public synchronized void setRealData(RealData data){
            if (isReady){
                return;
            }
            this.realData = data;
            isReady = true;
            notifyAll();
        }

        @Override
        public synchronized String getResult() {
            while (!isReady){
                try {
                    wait();
                }catch (InterruptedException e){}
            }
            return realData.getResult();
        }
    }

    static class RealData implements Data {
        protected final String result;
        public RealData(String para){
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < 10; i++){
                sb.append(para);
                try {
                    Thread.sleep(500);
                }catch (InterruptedException e){}

            }
            result = sb.toString();
        }

        @Override
        public String getResult() {
            return result;
        }
    }

    static class Client {
        public Data request(final String queryStr){
            final FutureData futureData = new FutureData();
            new Thread() {
                @Override
                public void run() {
                    RealData realData = new RealData(queryStr);
                    futureData.setRealData(realData);
                }
            }.start();
            return futureData;
        }

    }
}