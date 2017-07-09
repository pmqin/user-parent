package pmqin.com.test;

public class varargstest {

    /** http://blog.csdn.net/qq_37810594/article/details/72898148
     * 这里，总结下覆写必须满足的条件：

（1）重写方法不能缩小访问权限；

（2）参数列表必须与被重写方法相同（包括显示形式）；

（3）返回类型必须与被重写方法的相同或是其子类；

（4）重写方法不能抛出新的异常，或者超过了父类范围的异常，但是可以抛出更少、更有限的异常，或者不抛出异常。
     * @param args
     */
    public static void main(String[] args) {
        print("");
        // print("q32323", "we","sds","sd");
        print("q32323", "we", "sds", null);

        // print("hello", null);//别让null值和空值威胁到变长方法 因为两个方法都匹配，编译器不知道选哪个，于是报错了
        varargstest varargstest=new varargstest();
        Sub sub = varargstest.new Sub();
        // 向上转型
        Base base = sub;
        base.print("hello");
        
        // 不转型
       
        sub.print("hello");
        
        
    }

    public static void print(String aString, String... args) {

        int len = aString.length();
        int len2 = args.length;
        System.out.println((len2==0?0:args[0]) + "-----" + len2 + "fd-----------" + len);

        int i = 1;
        for (String temp : args) {

            System.out.println("第" + i + "个：" + temp);
            i++;
        }
    }

//    public static void print(String aString, Integer... args) {
//        int i = 1;
//        for (Integer temp : args) {
//
//            System.out.println("第222" + i + "个：" + temp);
//            i++;
//        }
//    }

    /***
     * 如果这个方法也是print，则编译器不知道该选哪个方法调用
     * 
     * @param args
     */
    public static void print2(String... args) {

        int len2 = args.length;
        System.out.println(args[0] + "-----" + len2 + "fd-----------");

        int i = 1;
        for (String temp : args) {

            System.out.println("第" + i + "个：" + temp);
            i++;
        }
    }

    // 基类
    class Base {
        void print(String... args) {
            System.out.println("Base......test");
        }
    }

    // 子类，覆写父类方法
    class Sub extends Base {
        @Override
        void print(String... args) {
            System.out.println("Sub......test");
        }
    }

}
