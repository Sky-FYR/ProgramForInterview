package designPattern;/*
 * ------------------------------------------------------------------
 * Copyright  2017 Hangzhou DtDream Technology Co.,Ltd. All rights reserved.
 * ------------------------------------------------------------------
 *   Product: ProgramForInterview
 *   Module Name: designPattern
 *   Date Created: 2018/7/29
 *   Description:
 * ------------------------------------------------------------------
 * Modification History
 * DATE            Name           Description
 * ------------------------------------------------------------------
 * 2018/7/29      FYR
 * ------------------------------------------------------------------
 */

public class StaticSingleton {
    private StaticSingleton(){
        System.out.println("StaticSingleton is created");
    }

    private static class SingletonHolder{
        private static StaticSingleton singleton = new StaticSingleton();
    }

    public static StaticSingleton getInstance(){
        return SingletonHolder.singleton;
    }
}
