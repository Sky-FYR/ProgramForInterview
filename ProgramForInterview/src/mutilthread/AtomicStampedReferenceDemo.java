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

import java.util.concurrent.atomic.AtomicStampedReference;

public class AtomicStampedReferenceDemo {
    static AtomicStampedReference<Integer> money = new AtomicStampedReference<Integer>(19,0);

    public static void main(String[] args) {
        for (int i = 0; i < 3; i++){
            final int timeStamp = money.getStamp();
            new Thread(){
                @Override
                public void run() {
                    int i = 0;
                    while (true && i<3){
                        Integer m = money.getReference();
                        if (m < 20) {
                            if(money.compareAndSet(m , m+20, timeStamp, timeStamp+1)){
                                System.out.println("余额小于20元，充值成功，余额："+ money.getReference());
                                break;
                            }else {
                                System.out.println("充值失败，尝试重新充值");
                            }
                        }else {
                            System.out.println("余额大于20元，无需充值");
                            break;
                        }
                        i++;
                    }
                    System.out.println("=============================");
                }
            }.start();
        }

        new Thread(){
            @Override
            public void run() {
                for(int i = 0; i < 10; i++){
                    while (true){
                        int timeStamp = money.getStamp();
                        Integer m = money.getReference();
                        if(m > 10){
                            if(money.compareAndSet(m, m-10, timeStamp, timeStamp+1)){
                                System.out.println("消费成功，余额："+money.getReference());
                                break;
                            }
                        }else {
                            System.out.println("余额不足");
                            break;
                        }
                    }
                }
            }
        }.start();
    }
}
