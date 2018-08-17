package reflect;

import java.io.File;
import java.io.FileInputStream;
import java.lang.reflect.Method;
import java.util.Arrays;

public class MyClassLoader extends ClassLoader {

    private String classPath;

    public MyClassLoader(String classPath) {
        this.classPath = classPath;
    }

    private byte[] loadByte(String name) throws Exception {
        name = name.replaceAll("\\.", File.separator);
        FileInputStream fis = new FileInputStream(classPath + File.separator + name
                + ".class");
        int len = fis.available();
        byte[] data = new byte[len];
        fis.read(data);
        fis.close();
        return data;

    }

    @Override
    protected Class<?> loadClass(String name, boolean resolve) throws ClassNotFoundException {
        return super.loadClass(name, resolve);
    }

    protected Class<?> findClass(String name) throws ClassNotFoundException {
        try {
            byte[] data = loadByte(name);
            return defineClass(name, data, 0, data.length);
        } catch (Exception e) {
            e.printStackTrace();
            throw new ClassNotFoundException();
        }
    }

    public static void main(String[] args) throws Exception{
        MyClassLoader loader = new MyClassLoader("C:\\Users\\FYR\\Documents\\IntelliJIdeaProjects\\ProgramForInterview\\out\\production\\ProgramForInterview");
        Class<?> c1 = Class.forName("sort.BubbleSort", true, loader);
        Object obj = c1.newInstance();
        Method bubbleSort = c1.getDeclaredMethod("bubbleSort", int[].class);
        int[] arr = new int[]{5, 52, 6, 3, 4, 8, 9, 1, 8, 7, 11, 46, 52, 11, 85, 99, 100, 16};
        bubbleSort.invoke(obj, arr);
        System.out.println(Arrays.toString(arr));
    }
}
