/**
 * Created by wmy_one on 2016/6/27.
 * 1）StringBuffer介绍
 * StringBuffer是字符串缓冲区，是一个容器；可以对字符串进行存储、删除、获取、修改。
 * 特点：
 * 1、长度是可变化的；
 * 2、可以直接操作多个数据类型；
 * 3、最终通过toString方法变成字符串。
 *
 * ①存储、
 * append()：表示将指定数组添加到原理数据的结尾，返回值仍是StringBuffer对象；
 * StringBuffer insert(index,数组)：可以在index位置插入数组；
 * ②、删除
 * StringBuffer delete(start,end)：删除缓冲区中的数据，包含start，不包含end；
 * StringBuffer deleteCharAt(index)：删除指定位置的字符；
 * ③、获取
 * char charAt(int index)：表示获取指定位置处的数据
 * int indexOf(String str)：表示获取字符串str对应的位置
 * int lastIndexOf(String str)：表示获取字符串str从左边对应的位置
 * String substring(int start, int end)：表示获取从指定位置开始和结束处的字符串
 * ④、修改
 * StringBuffer replace(start,end, string)：表示从start开始到end结尾处的内容用字符串string替换
 * void setChartAt(index,char ch)：表示将指定位置处的数据替换为ch
 * ⑤、void getChars(int srcBegin, int srcEnd, char[] dst, int dstBegin)：表示将缓冲区中指定数据存到字符数组中
 *
 * 2）StringBuilder介绍
 * JDK1.5版本之后出现了StringBuilder类，StringBuilder是线程不同步；StringBuffer是线程同步。
 * 将StringBuilder的实例用于多个线程是不安全的，如果需要这样的同步，建议使用StringBuffer；
 * 因此，单线程使用StringBuilder，多线程使用StringBuffer。
 *
 * 在今后的开发中，建议使用StringBuilder，它的用法和StringBuffer类似，只需将StringBuffer换成StringBuilder即可。
 * JDK版本升级的三要素：1、提高效率；2、简化书写；3、提高安全性。
 *
 * 3）基本数据类型对象包装类：  对应的格式为：基本数据类型 ——>  对应的对象包装类
 * byte ——>  Byte      int ——>  Integer       short ——>  Short       long ——>  Long
 * float ——>  Float    double ——>  Double     char ——>  Character    boolean ——>  Boolean
 * 基本数据类型对象包装类常见作用，就是用于基本数据类型和字符串类型之间做转换；
 * 1、基本数据类型转成字符串：
 *      基本数据类型+"" ； 专业做法是：基本数据类型.toString(基本数据类型值)；例如：Integer.toString(34)； //变成"34"
 * 2、字符串转成基本数据类型：
 *    ①、xxx n = Xxx.parse.Xxx(String);  例如：int a = Integer.parse.Int("123"); 表示将"123"转成123并赋值给int类型的a
 *    ②、对象调用方式：Integer i = new Integer("123");  int a = i.intValue();  也可以将"123"转成123
 *  注意：方法①是静态的，方法②是非静态的，必须通过创建对象实现调用。
 * 3、十进制转成其他进制：
 *      Integer.toBinaryString(十进制数)；将十进制转成二进制；  Integer.toOctalString(十进制);  将十进制转成八进制
 *      Integer.toHexString(十进制);  将十进制转成十六进制
 * 4、其它进制转成十进制：
 *      int a = Integer.parseInt(String,radix); 表示将字符串形成的其它进制转成十进制，其中radix表示对应的进制
 *      例如：int a = Integer.parse("3c",16); 表示将字符串形成的16进制转成10进制。
 *
 * 4）JDK1.5版本新特性
 * 如果已经定义的Integer变量指向对象的数值在byte范围内，对于新特性，此时在新建一个Integer变量，且指向对象的数值相同，
 * 此时，将不会开辟新的内存空间，因为，两者指向同一个Integer对象。
 * 另外，Integer类型的变量将会多一个值为nul，此时不能使用：x.intValue()方法，健壮性降低。
 */
public class StringDemo3 {
    public static void main(String[] args)
    {
        StringBuffer s = new StringBuffer();

        s.append("abc").append(123);  //向字符串缓冲区对象s添加内容
        s.insert(2,"A");   //向StringBuffer对象的指定位置插入内容
        printFun(s.toString());

        s.delete(2,5);   //删除StringBuffer对象中从索引值是2的位置开始到5结束的内容，不包括5对应的数据
        printFun(s.toString());

        s.deleteCharAt(2);   //删除StringBuffer对象中索引值为2对应的数据
        printFun(s.toString());

        s.replace(1,3,"789");   //将指定位置的数据替换为789
        printFun(s.toString());

        char[] ch = new char[6];
        s.getChars(1,3,ch,2);  //将缓冲区中指定数据存到字符数组中
        for(int i=0; i<ch.length; i++)
            printFun("--- "+ch[i]+" ...");

        //基本数据类型转成字符串
        printFun(Integer.toString(123));    //将整数123转成字符串形式
        printFun(Boolean.toString(true));  //将布尔类型的true转成字符串形式

        //字符串转成基本数据类型
        printFun("..."+Integer.parseInt("123"));   //将字符串形式的123转成int类型
        printFun("..."+Boolean.parseBoolean("true"));  //将字符串形式的true转成boolean类型

        //进制之间的转换
        printFun(Integer.toBinaryString(6));  //将十进制的6转成二进制
        printFun(Integer.toOctalString(3));   //将十进制的3转成八进制
        printFun(Integer.toHexString(60));    //将十进制的60转成十六进制

        printFun("..."+Integer.parseInt("110",2));  //将字符串形式的二进制110转成十进制
        printFun("..."+Integer.parseInt("3c",16));  //将字符串形式的十六进制3c转成十进制

        //Integer x = new Integer(4);  //可以写成下面的语句
        Integer x = 4;  //自动装箱，就是将4封装成Integer对象 //new Integer(4)
        x = x/* x.intValue()*/ + 2;  //x+2：先将x拆装变成int类型的数与2进行加运算，在将结果装箱赋值给x

        Integer m = 128;
        Integer n = 128;
        printFun("m==n："+(m==n));  //结果为false，因为是两个对象

        Integer i = 127;
        Integer j = 127;
        printFun("i==j："+(i==j)); //结果为true，两者指向了同一个Integer对象
    }

    /**
     * 定义一个printFun函数，用于将接收的字符串打印出来
     * @param str  接收一个String类型的变量str
     */
    public static void printFun(String str)
    {
        System.out.println(str);
    }
}
