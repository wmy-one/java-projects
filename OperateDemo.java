/**
 * Created by wmy_one on 2016/5/21.
 *
 * 这节将会使用Java，编写简单的算术运算和转移字符程序。
 *
 * 1）字符串数据和任何数据使用+操作符，都表示进行连接操作，结果都为字符串；
 * 2）%表示取模运算，也就是取余运算，其结果的正负仅仅和操作符%前面数字的正负有关；
 * 3）++和--表示自增和自减操作，a++和++a的区别是：前者先取a的值，在进行加1运算；后者操作相反；
 * 4）/和*表示除法和乘法操作符，两个int类型的数据相除，结果仍为int类型，就是直接将小数点后面的数字舍去；
 *
 * 转移字符：通过操作符\，来转变后面的字母或符号的含义；
 * \n：表示换行；
 * \t：制表符，相当于tab键；
 * \b：退格键，相当于backspace键；
 * \r：按下回车键，在Windows中，回车键是由两个字符来表示：\r\n；Linux系统中是由一个字符来表示：\n
 */
public class OperateDemo {
    public static void main (String args[]){
        int m = 4621,n;
        n = m/1000*1000;
        System.out.println(n);

        //模运算
        System.out.println(-1%5);
        System.out.println(1%-5);

        int a = 3,b;
        //自增和赋值运算；a++ ——>a+1
        b = a++;
        System.out.println("a="+a+",b="+b);

        //转移字符的使用
        System.out.println("\"Hello world\"");
        System.out.println(" hello \r\n java");
    }
}
