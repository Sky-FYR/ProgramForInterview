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

public class LazySingleton {
    private static LazySingleton singleton = null;

    private LazySingleton(){
        System.out.println("LazySingleton is created");
    }

    public static LazySingleton getInstance(){
        if(singleton == null){
            singleton = new LazySingleton();
        }
        return singleton;
    }
}
