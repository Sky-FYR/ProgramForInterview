import java.io.BufferedReader;
import java.io.UnsupportedEncodingException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.*;
import java.util.function.Consumer;

/**
 * Created by FYR on 2018/5/3.
 */
public class Main {
    private static String str = "FYR";
    private static int i;

    public String type = "tai di";
    private int age = 3;

    public static void main(String[] args){
        new Main();
//        System.out.println(new Main().NumberOf1Between1AndN_Solution(1300));
//        class Test implements Runnable{
//            @Override
//            public void run() {
//                System.out.println(Thread.currentThread().getName());
//            }
//        }
//        Thread t = new Thread(new Test(),"runnable");
//        t.start();
//        System.out.println(Thread.activeCount());

//        Map<Integer, Integer> map = new ConcurrentSkipListMap<Integer, Integer>();
//        map.put(1, 1);
//        for(int i = 0; i < 10; i++){
//            map.put(i, i);
//        }
//        System.out.println(map.get(8));

//        Main inc = new Main();
//        int i = 0;
//        System.out.println(inc.fermin(i));
//        System.exit(0);
//        int[] arr = {1,5,6,7,4,2,3,1,3,5,9,8,10};
//        Arrays.stream(arr).forEach(System.out::print);
//        Arrays.stream(arr).map(x -> x = x + 1).forEach(System.out::print);
//        System.out.println();
//        Arrays.stream(arr).map(x -> (x % 2 == 0 ? x : x + 1)).forEach(System.out::print);
//        System.out.println();
//        Arrays.stream(arr).forEach(System.out::print);

//        class R implements hello{}
//        new R().fermin1(1);
//        hello.fermin(1);

//        Comparator<T> cmp = Comparator.comparing(T::getI).thenComparing(T::getJ);
//
//        List<T> list = new ArrayList<>();
//        list.add(new T(1, "sss"));
//        list.add(new T(1, "zzz"));
//        list.add(new T(3, "aaa"));
//        list.add(new T(0, "ggg"));

//        Collections.sort(list, cmp);

//        list.stream().map(T::getI).forEach(System.out::print);
//        list.stream().map(t -> t).forEach(System.out::print);
//        list.stream().mapToInt(t -> t.i).forEach(System.out::print);
//        System.out.println();
//        list.stream().map(T::toString).forEach(System.out::print);
//        System.out.println();
//        list.forEach(t -> System.out.print(t));
//        list.forEach(System.out::print);
//        list.stream().forEach(T::toString);
////        list.stream().forEach(T::printJ);
//        System.out.println();
        //并行化，可以多线程计算，但不保证执行结果与串行结果顺序相同
//        list.stream().map(T::getI).parallel().forEach(System.out::print);
//        list.parallelStream().mapToInt(t -> t.i).forEach(System.out::print);

//        T[] ts = new T[list.size()];
//        list.toArray(ts);
        //可以保证顺序相同
//        Arrays.parallelSort(ts, cmp);
//        System.out.println(Arrays.toString(ts));
//        Arrays.parallelSort(arr);
//        System.out.println(Arrays.toString(arr));
//        list.stream().forEach(new Consumer<T>() {
//            @Override
//            public void accept(T t) {
//                t.i++;
//            }
//        });
        //Stream的排序，并返回一个新流
//        Stream stream = list.stream().sorted(cmp);
//        //Stream的forEach
//        stream.forEach(new Consumer() {
//            @Override
//            public void accept(Object o) {
//                System.out.println(o);
//            }
//        });
//        //注意：一个流只能被使用一次，使用完了就没了
//        stream.forEach((final Object o) -> {
//            System.out.println(o);
//        });
//        stream.forEach(o -> {
//            System.out.println(o);
//        });
//        stream.forEach(o -> System.out.println(o));
//        stream.forEach(System.out::print);

//        //迭代器的forEach
//        list.forEach(new Consumer<T>() {
//            @Override
//            public void accept(T t) {
//                System.out.println(t.getI());
//            }
//
//            @Override
//            public Consumer<T> andThen(Consumer<? super T> after) {
////                return new Consumer<T>() {
////                    @Override
////                    public void accept(T t) {
////                        this.accept(t);
////                        after.accept(t);
////                    }
////                };
//                return t -> { accept(t);after.accept(t);};
//            }
//        }.andThen(t -> System.out.println(t.getJ())));

//        long a = 0xF000000000000000L;
//        long b = 0x7FFFFFFFFFFFFFFFL;
//
//        System.out.println(a-b);

//        int[] aa = new int[10];
//        System.out.println(aa[1]);
//        String str = "1|2|3";
//        System.out.println(str.split("\\|").length);
//        int i=5;
//        int s=(i++ + ++i + i-- + --i);
//        System.out.println(s);

//        System.out.println(Main.i);
//        int a = '2';
//        System.out.println(a);

//        byte a = -128;
//        System.out.println(Byte.toString((byte)(a-1)));
//        char b = '\u0000';
//        System.out.println('a');
//        System.out.println((1<<16)-1);

//        final T t = new T(1,"2");
//        t.j = "3";
//        System.out.println(t.getJ());

    }

    static class Y extends T {
        public Y(int i, String j) {
            super(i, j);
        }
    }

    static class T{
        private int i;
        String j;

        public T(int i, String j) {
            this.i = i;
            this.j = j;
        }

        private int getI() {
            return i;
        }

        public String getJ() {
            return j;
        }

        private void printJ(){
            System.out.println(j);
        }

        public static void printJ(T j){
            System.out.println(j);
        }

        @Override
        public String toString() {
            return "T{" +
                    "i=" + i +
                    ", j='" + j + '\'' +
                    '}';
        }
    }

    public interface hello{
        static final int i = 0;
        static int fermin(int i){
            try{
                i++;
                return i;
            }finally {
                i++;
                System.out.println(i);
            }
        }
        default int fermin1(int i){
            try{
                i++;
                return i;
            }finally {
                i++;
                System.out.println(i);
            }
        }
    }
    @FunctionalInterface
    public interface IntHandler {
        void handle();
        //void handle(int i);
        boolean equals(Object obj);
    }
    int fermin(int i){
        try{
            i++;
            return i;
        }finally {
            i++;
            System.out.println(i);
        }
    }

/*    public String countAndSay(int n) {
        StringBuffer sb = new StringBuffer("1");
        for(int i=1;i<n;i++){
            for(int j=0;j<sb.length();j++){

            }
        }
    }*/
    public static int searchInsert(int[] nums, int target) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        for(int i=0;i<nums.length;i++){
            if(target <= nums[i]){
                return i;
            }
        }
        return nums.length;
    }

    public static int strStr(String haystack, String needle) {
        int len = needle.length();
        if(needle == null || len == 0){
            return 0;
        }
        for(int i=0;i<haystack.length()-len;i++){
            if(haystack.charAt(i) == needle.charAt(0) && haystack.substring(i,i+len).equals(needle)){
                return i;
            }
        }
        return -1;
    }

    public static int removeElement(int[] nums, int val) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        int curr = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == val){
                if(i == 0){
                    curr = i;
                }else{
                    continue;
                }
            }else {
                int temp = nums[curr];
                nums[curr] = nums[i];
                nums[i] = temp;
                curr++;
            }
        }
        return curr;

    }
    public static int removeDuplicates(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        int pre = nums[0];
        int size = 1;
        for(int i = 1; i < nums.length; i++){
            int num = nums[i];
            if(pre == num)
                continue;
            nums[size++] = num;
            pre = num;
        }
        return size;
        /*int len = nums.length;
        if(len == 0) return len;
        Arrays.sort(nums);
        int curr = nums[0];
        int curr_index = 0;
        for(int i=1;i<len;i++){
            if(nums[i] != curr){
                curr_index++;
                int temp = nums[curr_index];
                nums[curr_index] = nums[i];
                nums[i] = temp;
                curr = nums[curr_index];
            }
        }
        curr_index++;
        return curr_index;*/
    }
}
