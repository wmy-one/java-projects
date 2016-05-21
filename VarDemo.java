/**
 * Created by wmy_one on 2016/5/21.
 *
 * 这一节将会学习变量，并对变量进行操作。这些数据类型占用的内存大小为：
 * byte——>8  short——>16  int——>32  long——>64  默认为int类型
 * char——>2  float——>32  double——>64            默认为double类型
 * 若想表示单精度浮点数据，这需要在数值后面加上一个f，即可表示一个float类型的数据。
 *
 * 什么时候定义变量？
 * 当数据不确定的时候，需要对数据进行存储时，这时就需要定义一个变量来完成存储动作。
 *
 * 变量的声明过程：
 * 首先在内存中开辟一块内存空间，空间类型为变量类型，空间名称为变量名称，值为变量的值；
 *
 * 声明变量的格式：
 * 数据类型   变量名 = 初始化值
 */
public class VarDemo {
    public static void main (String args[]){
        //输出十进制数6对应的的二进制
        System.out.println(Integer.toBinaryString(6));

        int x = 6;
        System.out.println(x);

        byte b = 8;
        System.out.println(b);

        short c = 3000;
        System.out.println(c);

        long d = 1000000;
        System.out.println(d);

        char ch = 'a';
        System.out.println(ch);

        boolean bo = true;
        System.out.println(bo);

        float m = 3.14f;
        System.out.println(m);

        double n = 3.1415;
        System.out.println(n);
    }
}
