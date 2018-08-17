package designPattern;

/**
 * Created by FYR on 2018/5/11.
 */
public class Singleton {

    private static Singleton singleton = new Singleton();

    private Singleton() {
        System.out.println("Singleton is created");
    }

    public static Singleton getInstance() {
        return singleton;
    }
}
