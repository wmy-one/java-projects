/**
 * Created by wmy_one on 2017/1/2.
 * 在这一节中，我将会记录自己在学习Java的基本数据类型中，
 * 遇到的一些特殊部分写下来，方便今后查阅。
 *
 * 1）从Java7开始，可以在int类型变量前加上"0b"前缀，表示二进制数；
 *    同时，也可以在数字中使用"_"作为间隔，便于阅读，例如：1_000表示1000；
 *    Java编译器将会自动去除这些"_"；
 *
 * 2）在JDK5.0中，可以使用十六进制表示浮点数值，例如：0.125表示为：0x1.0p-3；
 *    使用p表示指数，而不是e，尾数采用十六进制，指数采用十进制，指数的基数为2，不是10。
 *
 * 3）在浮点数值计算中，有三个特殊的浮点数值表示溢出和出错的情况：
 *     正无穷大、负无穷大、NaN（非数值）,这三个是float类型的常量；
 *     另外，常量：Double.POSITIVE_INFINITY、Double.NEGATIVE_INFINITY、Double.NaN，
 *     也可表示这三个值，但在实际应用中很少遇到；
 * 注意：
 *      不能使用"=="符号检测一个特定值是否等于Double.NaN，因为，所有"非数值"的值都不相同；
 *      但可以使用Double.isNaN(double a)来判断a是否是NaN，若是，返回true。
 *
 * 4）浮点数值不适用于禁止出现舍入计算的金融计算中，主要原因：浮点数值采用二进制系统表示，
 *    而在二进制系统中，无法精确表示分数1/10；
 * 注意：
 *      如果在数值计算中，要求不能有任何舍入误差，此时，可以使用BigDecimal类。
 *
 * 5）在Java中，对于运算符"/"，如果参与运算的两个操作数都是整数，称为整数除法，
 *    就是取整运算，直接舍弃余数；只要以一个不是整数，称为浮点除法，结果有小数。
 * 注意：
 *      ①、在Java中，使用64位存储一个double类型的数值；有些处理器使用80位浮点寄存器，需要截断结果；
 *      ②、由于可移植性要求，Java虚拟机规范规定，所有的中间计算都必须进行截断，增加截断操作消耗的时间；
 *      ③、针对最佳性能与理想结果之间的冲突，改进之处为：
 *          1）默认情况下，允许将中间计算结果采用扩展的精度，通常允许扩展指数，不允许扩展尾数，
 *              Intel芯片在截断尾数时，不损失性能。这种方式不会产生溢出；
 *          2）使用strictfp关键字修饰的方法或类（是类中的所有方法）必须使用严格的浮点计算，可能产生溢出；
 *
 * 6）Java没有字符串类型，而是使用String类，每一个使用双引号括起来的都是String类的一个实例；
 *    字符串是不可变的，不能修改字符串中的字符；通过拼接和提取操作看起来修改了原字符串，
 *    实际上是创建一个新字符串，将原来的字符串实例引用这个新的字符串，这样将降低运行效率。
 * 注意：
 *      ①、编译器共享字符串，仅仅在编译阶段完成，而不是在运行时完成；
 *      ②、字符串共享发生在复制字符串变量的时候，可以理解为有一个字符串共享池，存储这些字符；
 *      ③、当复制字符串时，先创建String对象，在查看共享池中是否有相应的字符，如果有，
 *          就直接将该对象指向对应的字符串，否则，在共享池中添加字符串。例如：String s = "abc"
 *      ④、实际上，只有字符串常量是共享的，连接和提取操作的结果不共享。
 *      另外，String s=""和s=null两者不相等，前者是一个String对象，表示长度为0的空串，后者是特殊值.
 *
 */
import java.util.*;

public class FirstDay
{
    public static void main(String[] args)
    {
        int a = 1_000;       //从Java7开始可以这样使用，表示1000
        int b = 0b1000;     //从Java7开始可以这样使用，表示8，可以直接写二进制数

        System.out.println("打印数据格式为：1_000= "+a+"; 0b1000= "+b);


        //float类型有三个特殊的常量：正无穷大、负无穷大、NaN（表示非数值）
        float c = 0F;
        float d = 0F;
        float e = c/d;     //float类型的两个值为0的数相除，结果为常量：NaN，表示一个非数值
        boolean f = Double.isNaN(e);

        //打印float类型的两个值为0的数相除的结果：
        System.out.println("float类型：0/0= "+e+"; 结果是否为NaN："+f);


        //浮点数采用二进制系统表示，由于二进制系统无法精确表示分数：1/10，将使用近似值表示
        double a1 = 2.0 - 1.1;    //结果为：0.8999999999999999
        System.out.println("double类型：2.0-1.1= "+a1);


        //运算符"/"的两个操作数的类型不用，运算结果不同，分别称为：整数除法和浮点除法
        int a2 = 15;
        int a3 = 2;
        int a4 = a2 / a3;     //结果为：7，而不是8,；整数除法不进行舍入

        float a5 = 15.0F / a3;   //结果为：7.5；浮点除法结果有小数

        System.out.println("整数除法：15/2= "+a4+"; 浮点除法：15.0/2= "+a5);


        //字符串的连接和提取操作
        String s1 = "Hello";
        String s2 = s1.substring(0,3);    //子串或提取操作，不包括3对应的字符
        String s3 = s2 + "p! John";       //字符串的拼接操作，结果中不会添加空格

        System.out.println("提取操作：s1.substring(0,3)= "+s2+"; 拼接操作：s2+'p! John'= "+s3);

        //字符串的比较操作
        String s4 = "abc";
        String s5 = "aBc";
        boolean ss = s4.equals(s5);   //比较两个字符串是否相等，区分大小写
        boolean sss = "abc".equalsIgnoreCase(s5);  //比较两个字符串是否相等，不区分大小写

        System.out.println("区分大小写：equals(s4)= "+ss+"; 不区分：equalsIgnoreCase(s5)= "+sss);


        //标准输入流输出流的使用
        Scanner in = new Scanner(System.in);

        //输入名字
        System.out.print("请输入你的名字：");
        String myName = in.nextLine();    //每次读取一行输入

        //输入年龄
        System.out.print("请输入你的年龄：");
        int age = in.nextInt();          //每次读取一个整数

        System.out.println("Hi! "+myName+", Next year, you are "+(age+1)+"!");

    }
}
