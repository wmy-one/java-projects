/**
 * Created by wmy_one on 2016/5/25.
 * 这一节将会简单的介绍Java中函数的一些特点、格式和overload。
 * 1）函数的格式：
 * 修饰符 返回值类型 函数名（参数类型1 形式参数1，参数类型2 形式参数2，……）{
 *     执行语句；
 *     return 结果；
 * }
 * 2）函数的特点：
 * 1、在函数内部可以调用函数，不能定义函数；
 * 2、返回值类型就是函数运行后，结果的数据类型；
 * 3、形式参数是一个变量，用来存储调用函数时，传递给函数的实际参数；
 * 4、在Java中将一些具有特定功能的代码封装成函数，用来提高代码的复用性；
 * 5、如果函数运算后，没有返回值，此时，将返回值类型用一个特定的void类型来标识，此时，该函数不能被输出语句输出。
 *
 * 3）函数的重载（overload）
 * 定义：在Java中允许在同一个类中定义一个以上同名函数，只要它们的参数个数或参数类型不同即可；
 * 特点：与返回值无关，只看参数列表；
 * 优点：方便阅读，优化程序设计。
 * 4）什么时候使用重载？
 * 当定义的功能相同，而参与运算的未知内容不同，此时，可以定义一个函数名称来表示其功能，方便阅读，
 * 而通过参数列表的不同来区分多个同名函数。
 *
 * 5）判断下列函数是否与给定的函数重载：
 * void add (int a, char b, double c){}
 * 1、
 * void add (int x, char y, double z){} //没有重载，因为和原函数参数个数和类型均相同
 * 2、
 * int add (int a, double b, char c){} //重载，因为参数类型不同，函数中的形式参数有顺序
 * 3、
 * boolean add (int c, char b){}  //重载，因为参数个数不同
 * 4、
 * void add (double c){}  //重载，因为参数个数不同
 * 5、
 * double add (int x, char y, double z){} //没有重载，因为参数列表相同，且不能和原函数放在同一个类中
 * 注意：重载和返回值类型无关
 */
public class FunctionDemo {
    public static void main (String args[]){
        int sum = addFun(3,6);
        System.out.println("Two numbers sum = "+sum);

        int max = maxFun(6,8);
        System.out.println("Two number max = "+max);

        multipleFun(3);
        System.out.println("--------------------");
        multipleFun();
    }

    //addFun函数用static修饰，是因为主函数是用static来修饰的，所以只能调用static修饰的函数
    public static int addFun(int x, int y){
        int sum = x + y;
        return sum;
    }

    //定义一个求两个整数中最大值的函数
    public static int maxFun(int a, int b){
        /*
        if (a > b)
            return a;
        else
            return b;
        */
        return (a>b)? a:b;
    }

    //定义一个打印9*9乘法表的函数
    public static void multipleFun(int x){
        for (int i=1; i<=x; i++){
            for (int j=1; j<=i; j++){
                System.out.print(j+"*"+i+"="+i*j+"\t");
            }
            System.out.println();
        }
    }

    //函数重载的应用
    public static void multipleFun(){
        multipleFun(9);
    }
}
