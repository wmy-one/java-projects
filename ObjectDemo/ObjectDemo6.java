/**
 * Created by wmy_one on 2016/6/11.
 * 这一节将会简单的介绍Java中的final关键字。
 * 1）final的特点
 * final：最终；作为一个修饰符。
 *
 * 1、可以修饰类、函数、变量；
 * 2、被final修饰的类，不能被继承；这样可以避免被子类复写功能；
 * 3、被final修饰的方法，不可以被复写；
 * 4、被final修饰的变量是一个常量，只能赋值一次；既可以修饰成员变量，也可以修饰局部变量；
 * 5、内部类定义在类中的局部位置上时，只能访问该局部被final修饰的局部变量。
 *
 * 2）示例说明
 * 在描述事物时，一些数据的出现值是固定的，为了增强阅读性，给这些值起个名字，方便阅读；
 * 然而这些值不需要改变，所以要加上final修饰，作为常量；
 *
 * 常量的书写规范：所有字母大写，如果由多个单词组成时，每个单词之间通过下划线连接。
 */

/**
 * 定义一个MathMethods类，实现基础数学常用方法(加和减)的功能
 * @author wmy_one
 * @version V1.1
 */
class MathMethods
{
    /**
     * 定义一个int类型的addFun方法，用于计算数学中的两数之和。为了不被复写，使用final修饰
     * @param a 接收第一个int类型的加数
     * @param b 接收第二个int类型的加数
     * @return  返回int类型的两数之和
     */
    final int addFun(int a, int b)
    {
        int sum = a + b;
        return sum;
    }

    /**
     * 定义一个int类型的subtractFun方法，用于计算数学中的两数之差。为了不被复写，使用final修饰
     * @param a 接收第一个int类型的减数
     * @param b 接收第二个int类型的减数
     * @return  返回int类型的两数之差
     */
    final int subtractFun(int a, int b)
    {
        int difference = a - b;
        return difference;
    }
}

/**
 * 定义一个MathDemo类，并且继承MathMethods类，用于拓展父类的功能。
 */
class MathDemo extends MathMethods
{
    /**
     * 定义一个int类型的multiplyFun方法，用于计算数学中两数之积。为了不被复写，使用final修饰
     * @param a 接收第一个int类型的乘数
     * @param b 接收第二个int类型的乘数
     * @return  返回int类型的两数之积
     */
    final int multiplyFun(int a, int b)
    {
        int product = a * b;
        return product;
    }

    /**
     * 定义一个int类型的divideFun方法，用于计算数学中两数之商。为了不被复写，使用final修饰
     * @param a 接收第一个int类型的除数
     * @param b 接收第二个int类型的除数
     * @return  返回int类型的两数之商
     */
    final int divideFun(int a, int b)
    {
        int quotient = a / b;
        return quotient;
    }
}
public class ObjectDemo6
{
    public static void main(String[] args)
    {
        MathDemo m = new MathDemo();
        int sum = m.addFun(3,5);
        System.out.println("The sum of two numbers is："+sum);

        int difference = m.subtractFun(6,12);
        System.out.println("The difference of two numbers is："+difference);

        int product = m.multiplyFun(2,3);
        System.out.println("The product of two numbers is："+product);

        int quotient = m.divideFun(9,2);
        System.out.println("The quotient of two numbers is："+quotient);

        final double PI = 3.14;
        System.out.println("The area of circle is："+circleFun(3,PI));

    }

    /**
     * 定义一个double类型的circleFun方法，用于计算数学中的圆的面积。
     * @param r 接收一个int类型的半径r值
     * @param p 接收一个double类型的π值
     * @return  返回一个double类型的area值，即，圆的面积
     */
    public static double circleFun(int r, double p)
    {
        double area = p * r * r;
        return area;
    }

}
