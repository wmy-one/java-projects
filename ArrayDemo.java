/**
 * Created by wmy_one on 2016/5/26.
 * 这一节将会简单的介绍Java中的数组。
 * 1）数组的定义：
 * 同一种数据类型的集合，其实就是一个容器；自动给数组中的元素从0开始编号；
 * 2）数组的格式：
 * 元素类型 [] 数组名 = new 元素类型 [元素个数或数组长度]
 * 元素类型 [] 数组名 = new 元素类型 [] {1,2,3,4}；    简化形式：元素类型 [] 数组名 = {1,2,3,4};
 * 其中，new关键字用来在内存中产生一个容器实体；数组就是引用数据类型中的数组类型；
 *
 * 3）Java程序中的内存结构
 *1、Java程序在运行时，需要在内存中分配空间，未来提高运算效率，对空间划分不同的区域，
 * 每片区域都有特定的处理数据方式和内存管理方式，Java在启动时总共划分了5个空间，用于存放自己的数据；
 *2、这5个空间分别是：方法区、本地方法区、寄存器、栈内存和堆内存，其中，栈内存用于存储局部变量，
 * 当数据使用完后，所占用的空间自动释放；堆内存用于存储数组和对象，通过Java建立的实体都存在堆内存中；
 * 实体中的变量都有初始化值，当实体不在被使用时，将在不确定的时间内被垃圾回收器回收；
 *4）Java中的函数运行时，会在栈内存中开辟一块区间，在函数内部定义的变量，将在相应的函数区间内；
 *
 *5）数组在内存中的结构，例如：int[] x = new int[3]
 *①、int[] x 是局部变量，存放在站栈内存中，new产生的实体存放在堆内存中，堆内存中的每个实体都有一个存放位置，
 * 也就是内存中的地址值（都是二进制值）用来标识数据存放的位置；
 *②、例子中的=就是将数组内存中的起始地址值赋给x，而不是数组本身，此时，x指向或引用了数组；
 *③、如果不想让x指向了数组，使用语句x = null；即可；因为，一个实体在堆内存中没有任意一个引用使用它时，此时，该数组
 * 实体将会被Java虚拟机视为垃圾，不会立即清除，而是将在不确定的时间内启动垃圾回收机制，将该数组实体在堆内存中清除；
 *
 *6）内存结构分析的例子：
 * int[] y = x;                          |   int[] y = new int[3];   | int a = 8;
 * y[1]=3;    //此时，x[1]对应的值也是3；|   y[2] = 6;               | int b = a;
 * x = null;                            |    x = null;               | b = 3;      //此时，a的值还是8，b的值是3；
 * 上面的语句并不会产生垃圾；          | 此时，上面的语句将会产生垃圾|
 *7）数组中的属性：
 * 数组长度length属性，用于获得数组的长度，使用方式：数组名称.length；
 */
public class ArrayDemo {
    public static void main (String args[]){
        int [] x = new int [3];
        int [] y = x;
        y[1] = 3;
        x[1] = 6;
        System.out.println(x[1]+"\t"+y[1]);

        int [] z = {1,2,3,4,5,6};
        arrayFun(z);

        char [] ch = {'a','b','c'};
        System.out.println(ch);
        System.out.println("length："+ch.length+", "+ch);
        //输出结果为：[C@74a14482     ——>     [ —> 表示数组；   C —> 表示数组中的元素类型是char；
        // @74a14482   —>   表示在内存中的地址值，是个十六进制数，是由哈希算法算出的哈希值。
        // 这种结果表明直接打印数组实体的引用

        int [] arr = {3,1,4,1,5,9,2,6};
        int max = arrayMax(arr), max_2 = arrayMax_2(arr);
        arrayFun(arr);
        System.out.println("Max of array = "+max);
        System.out.println("Max_2 of array = "+max_2);
    }

    //定义功能：用于打印数组中的元素，并在一行显示
    public static void arrayFun(int [] arr){
        for (int i=0; i<arr.length; i++){
            if (i != arr.length -1)
                System.out.print(arr[i]+", ");
            else
                System.out.println(arr[i]);
        }
    }

    //定义功能：用于获取数组中的最大值，有两种方法
    public static int arrayMax(int [] arr){
        //此方法使用数组的第一个元素值作为初始化值
        int max = arr[0];
        for (int i=1; i<arr.length; i++){
            if (arr[i] > max)
                max = arr[i];
        }
        return max;
    }

    public static int arrayMax_2(int [] arr){
        //此方法使用数组的角标作为初始化值，
        int max = 0;
        for (int i=1; i<arr.length; i++){
            if (arr[i] > arr[max])
                max = i;
        }
        return arr[max];
    }
}
