/**
 * Created by wmy_one on 2016/6/25.
 * 1）字符串的特点
 * 字符串是一个对象，一旦初始化就不可以被改变；String类复写了Object类中的equals方法，用于判断字符串的内容是否相等。
 * String s1 = "abc";  和 String s2 = new String("abc"); 这两条语句的区别：
 * s1在内存中有一个对象，s2在内存中有两个对象（new将创建一个对象，接收的"abc"也是一个对象）；s1和s2都是类类型的变量。
 * 在内存中的方法区中，存储的是：方法、静态区、常量区，其中常量区用于存储常量和字符串。
 *
 * 2）常见的字符串操作方法
 * 1、获取
 *     1.1、获取字符串中字符的个数，也就是字符串的长度，int length()
 *     1.2、根据位置，获取该位置上的字符，char charAt(int index);
 *     1.3、根据字符，获取该字符在字符串中的位置，
 *          int indexOf(int ch); 返回的是ch在字符串中第一次出现的位置
 *          int indexOf(int ch, int fromIndex); 从fromIndex开始，获取ch在字符串中的位置
 *          int indexOf(String str); 返回的是str在字符串中第一次出现的位置
 *          int indexOf(String str, int fromIndex); 从fromIndex指定位置开始，获取str在字符串中的位置
 *          int lastIndexOf(int ch); 从字符串左边开始查找ch出现的位置
 * 2、判断
 *     2.1、字符串中是否包含一个子串，boolean contains(String str);
 *     2.2、字符串中是否有内容，boolean isEmpty(String str);  //此方法，从jdk1.6版本开始增加的
 *     2.3、字符串是否以指定内容开头，boolean startsWith(String str);
 *     2.4、字符串是否以指定内容结尾，boolean endsWith(String str);
 *     2.5、判断字符串内容是否相同，boolean equals(String str);
 *     2.6、判断字符串内容是否相同，并忽略大小写，boolean equalsIgnoreCase(String str);
 * 3、转换
 *     3.1、将字符数组转成字符串，
 *          构造函数：String(char[] data);
 *                    String(char[] data, int offset, int count);  //offset表示起始位，count表示转换的字符个数
 *          静态方法：static String copyValueOf(char[] data);
 *                    static String copyValueOf(char[] data, int offset, int count);
 *                    static String valueOf（char[] data);  //将基本数据类型转成字符串
 *     3.2、将字符串转成字符数组，
 *           char[] toCharArray();
 *     3.3、将字节数组转成字符串，
 *          String(byte[] data);
 *          String(byte[] data, int offset, int count);  //offset表示起始位，count表示转换的字符个数
 *     3.4、将字符串转成字节数组，
 *           byte[] getBytes();
 * 4、替换
 *     String replace(olderChar, newChar);  //如果要替换的字符不存在，则返回原来的字符串。
 *     String replace(olderString, newString);
 * 5、切割
 *     String[] split(分隔符);    //用于分隔字符串，返回值为字符串数组
 * 6、子串，获取字符串中的一部分
 *     String substring(begin);   //从指定位置开始到结尾，如果角标不存在，将发生角标越界异常
 *     String substring(begin,end);  //包含头，不包含尾；substring(0, str.length())表示整个字符串
 * 7、转换、去除空格
 *     7.1、将字符串转成大写或小写
 *          String toUpperCase();
 *          String toLowerCase();
 *     7.2、将字符串两端的多个空格去除
 *          String trim();   //仅仅去除字符串两端的空格，而不会将中间的空格去除
 *     7.3、对两个字符串进行自然顺序的比较
 *          int compareTo(string);
 *     //按字典顺序比较两个字符串，比较的是字符的ASCII值，返回值是正数、负数、和零；如果某个字符能得出结果，比较结束
 *
 * 注意：
 *      如果访问到字符串中不存在的角标时，将发生字符串角标越界异常；
 *      如果没有找到指定的字符或字符串，就返回-1；
 *      字符串和字节数组之间的转换，可以指定编码表。
 */
public class StringDemo1 {
    public static void main(String[] args)
    {
        String s1 = "abcdefamn";
        String s2 = "ArrayDemo.class";

        stringGet(s1); //调用stringGet函数
        stringIs(s2);  //调用stringIs函数

        stringTrans();    //调用stringTrans函数
        stringReplace();  //调用stringReplace函数
        stringSplit();    //调用stringSplit函数
        subString();     //调用subString函数

        stringMethod();  //定义stringMethod函数
    }

    /**
     * 定义一个printFun函数，仅仅用于打印接收的类类型变量
     * @param obj  接收的Object类类型变量，非类类型的变量将会提升类型
     */
    public static void printFun(Object obj)
    {
        System.out.println(obj);
    }

    /**
     * 定义一个stringGet函数，仅仅描述字符串的获取操作
     * @param str  接收的用于查找的字符串参数
     */
    public static void stringGet(String str)
    {
        //获取字符串的长度
        printFun(str.length());
        //获取字符串中索引值对应的字符
        printFun(str.charAt(3));
        //根据字符，获取该字符对应的索引值
        printFun(str.indexOf('f'));
        //根据子串，获取该子串对应的索引值
        printFun(str.indexOf("abc"));
        //从字符串的左边开始查找字符，并返回发字符对应的索引值
        printFun(str.lastIndexOf('a'));
    }

    /**
     * 定义一个stringIs函数，用于描述字符串的判断操作
     * @param str  接收的用于判断的字符串参数
     */
    public static void stringIs(String str)
    {
        //判断文件名是否以Array开头
        printFun(str.startsWith("Array"));
        //判断文件名是否以.class结尾，也就是是否是class文件
        printFun(str.endsWith(".class"));
        //判断文件名中是否包含子串Demo，仅仅能够说明文件名是否包含子串
        printFun(str.contains("Demo"));
    }
    /**
     * 定义一个stringTrans函数，用于描述字符串的转换操作
     */
    public static void stringTrans()
    {
        char[] arr = {'a','b','c','d'};
        String s = new String(arr);
        printFun(s);

        String s1 = "abcdef";
        char[] arr1 = s1.toCharArray();
        for(int i=0; i<arr1.length; i++)
        {
            printFun(arr1[i]);
        }
    }
    /**
     * 定义一个stringReplace函数，用于描述字符串的替换操作
     */
    public static void stringReplace()
    {
        String s = "abcdef";
        String s1 = s.replace('d','D');   //表示将字符d用D替换，如果替换的字符不存在，将返回原字符串
        printFun(s);
        printFun(s1);
    }
    /**
     * 定义一个stringSplit函数，用于描述字符串的分隔操作
     */
    public static void stringSplit()
    {
        String s = "David,John,Tom";
        String[] arr = s.split(",");   //将用逗号作为分隔符，分隔字符串s，返回值是字符串数组
        for(int i=0; i<arr.length; i++)
        {
            printFun(arr[i]);
        }
    }
    /**
     * 定义一个subString函数，用于描述获取字符串的子串操作
     */
    public static void subString()
    {
        String s = "abcdef";
        String s1 = s.substring(3,s.length());  //从指定位置开始取出字符串s中其余字符，作为其子串
        printFun(s1);
    }
    public static void stringMethod()
    {
        String s = "  Hello world  ";
        printFun(s.toLowerCase());  //将字符串s中的字符全部转为小写
        printFun(s.toUpperCase());  //将字符串s中的字符全部转为大写
        printFun(s.trim());      //去除字符串s两端的空格

        String s1 = "aAb";
        String s2 = "aac";
        printFun(s1.compareTo(s2));  //按字典顺序比较两个字符串的大小
        //从第一个字符开始比较他们的ASCII值，直到第一个不相等的字符，返回这两个字符对应ASCII码之差
    }
}
