/**
 * Created by wmy_one on 2016/6/15.
 * 这一节将会简单的介绍Java中的异常处理。
 * 1）异常的概念
 * 异常：就是程序在运行时出现的不正常现象；可以通过Java中的类进行描述。
 *
 * 严重的异常：Java通过Error类进行描述；对于Error类的异常，一般不编写针对性的代码对其进行处理。
 * 非严重的异常：Java通过Exception类进行描述；对于Exception类的异常，可以编写针对性的代码对其进行处理。
 *
 * 2）异常的处理
 * Java提供了特有的语句进行处理，格式：
 *                      try{
 *                              需要被检测的代码；
 *                      }
 *                      catch(异常类 变量){
 *                              处理异常的代码；（处理方式）
 *                      }
 *                      finally{
 *                               一定会执行的语句；
 *                       }
 *
 *3）对捕获到的异常对象进行常见的方法操作
 * 一些常见的方法： String getMessage()  获得异常信息； String toString() 异常名称：异常信息
 *                  printStackTrace()    异常名称：异常信息，异常出现的位置
 *
 * 在函数上声明异常：便于提高安全性，让调用者进行处理，如果不处理编译就失败。
 *
 * 4）多异常处理
 * 1、声明异常时，建议声明更为具体的异常，这样可以更具体的处理异常；
 * 2、对方声明几个异常， 就对应有几个catch块；如果多个catch块中的异常出现继承关系，父类异常catch块放在最下面。
 *
 * 建议子啊进行catch处理时，catch中一定定义具体的处理方式；
 * 不要简单的定义一句e.printStackTrace()，也不要简单的书写一条输出语句。
 *
 * 5）自定义异常
 * 因为在项目开发中，可能出现特有的问题，而这些问题并未被Java所描述，并封装成对象；
 * 因此，我们可以按照Java对问题封装的思想，将项目中出现的特有问题，进行自定义异常封装。
 *
 * 当在函数内部出现了throw抛出异常对象，此时，就必须给出对应的处理动作：
 * 1、在函数内部使用try、catch结构处理；
 * 2、在函数上声明异常，让调用者处理异常。
 * 通常情况下，函数内部出现的异常，函数上需要声明。
 *
 * 如何自定义异常信息呢？
 * 因为父类中已经把异常信息操作完了，因此，子类只要在构造函数中，将异常信息通过super传给父类；
 * 此时，子类就可以直接通过getMessage()方法获取自定义的异常信息。
 *
 * 注意：
 * 自定义异常必须继承Exception，原因：
 * 异常体系有一个特点，因为异常类和异常对象都被抛出，这个可抛性是Throwable独有的特点，
 * 只有这个体系中的类和对象才可以被throw和throws操作。
 *
 * throw和throws的区别：
 * 1、throw使用在函数内，throws使用在函数上；
 * 2、throw后面跟的是异常对象，throws后面跟的是异常类，可以跟多个，用逗号隔开。
 *
 * 6）RuntimeException异常
 * RuntimeException：运行时异常，是Exception中的一个特殊子类异常；
 * 特点：
 * 1、如果在函数内部使用throw抛出该异常，函数上可以不用声明，编译同样通过；
 * 2、如果在函数上使用throws声明该异常，调用者可以不用使用try、catch结构处理，编译同样通过。
 *
 * 对于RuntimeException异常，在函数内部使用throw抛出该异常后，之所以不用在函数上使用throws声明，是因为不需要调用者处理；
 * 当该异常发生时，由于在运行时，出现了无法运算的情况，所以，希望停止程序后，对代码进行修正，以便程序能继续运行。
 *
 * 自定义异常时，如果该异常的发生无法让程序在继续运算，就让该自定义异常继承RuntimeException。
 * 异常可以分为两类：
 * 1、编译时被检测的异常；也就是该异常被调用者处理后程序能继续运行；
 * 2、编译时不被检测的异常，也就是RuntimeException及其子类。
 *
 * 7）finally代码块
 * finally代码块中定义一些一定能够运行的代码；通常用于关闭资源。
 * 
 * 异常处理的几种格式：
 *  1、try{ 需要被检测的代码；}catch(异常类名 对象){ 处理异常的代码；（处理方式）}
 *  2、try{ 需要被检测的代码；}catch(异常类名 对象){ 处理异常的代码；（处理方式）}finally{ 一定会执行的语句；}
 *  3、try{ 需要被检测的代码；}finally{ 一定会执行的语句；}
 *  4、try{}catch(异常类名 对象){}catch(异常类名 对象){}……    //就是一个try语句和多个catch语句
 *
 * 注意：
 *      catch适用于处理异常的，如果没有catch就代表异常没有处理过；如果该异常是检测异常，那么就必须声明。
 *      
 */

/**
 * 定义一个类，用于描述一个简单的算术运算，方便进行异常分析。
 * @author wmy_one
 * @version V1.1
 */
class MathDemo
{
    int divide(int m, int n) throws Exception  //编写者在功能上通过throws关键字声明该功能可能出现的问题。
    {
        return m/n;
    }
}

/**
 * 定义一个MathDemo2类，用于测试对多异常进行处理。
 */
class MathDemo2
{
    int div(int m, int n)throws ArithmeticException,ArrayIndexOutOfBoundsException
    {
        int[] arr = new int[m];
        System.out.println("The element of array："+arr[4]);
        return m/n;
    }
}

/**
 * 定义一个NegativeException类，用于描述自定义异常。
 */
class NegativeException extends Exception   //getMessage()
{
    /*
    由于父类Throwable中已经提供了接收异常信息的构造函数，而Exception已经继承了父类，也已经定义了
    一个接收异常信息的构造函数，但是该构造函数仅仅传给父类，由父类的构造函数进行处理，并没有复写；
    因此，对于异常信息，子类可以调用父类的构造函数，也可以复写父类中对应的函数。这两种方法如下：
    */

    //自定义异常信息，方法一：
    /*
    private String msg;
    NegativeException(String msg)
    {
        this.msg = msg;
    }
    public String getMessage()
    {
        return msg;
    }
    */
    //自定义异常信息，方法二：
    NegativeException(String msg)
    {
        super(msg);
    }
}

/**
 * 定义一个MathDemo3类，用于测试自定义异常的处理。
 */
class MathDemo3
{
    int divide(int m, int n) throws NegativeException  //函数内部throw抛出的异常，需在函数上声明异常，让调用者处理异常。
    {
        if(n < 0)
            throw new NegativeException("出现除数是负数的异常 / by Negative Number");  //手动通过throw关键字抛出自定义异常对象
        return m/n;
    }
}


public class ObjectDemo11 {
    public static void main(String[] args)
    {
        MathDemo md = new MathDemo();
        try      //JVM将捕获的异常封装成异常对象，并传给程序调用者(主函数)；try检测到后将异常抛给catch
        {
            int x = md.divide(6,0);       //由于除数是0，此处，将出现ArithmeticException异常
            System.out.println("The output of x："+x);
        }
        // catch将捕捉到try检测到的异常，并使用Exception类型引用接收捕捉到的异常对象，然后执行相应处理代码
        catch(Exception e) //Exception e = new ArithmeticException();
        {
            System.out.println("发生异常！");
            System.out.println(e.getMessage());   //获取异常信息
            System.out.println(e.toString());    //异常名称：异常信息
            //e.printStackTrace();     //异常名称：异常信息，异常出现的位置。
            //其实jvm默认的异常处理机制，就是调用printStackTrace()方法，打印异常在堆内存中的跟踪信息。
        }

        //进行多异常处理
        MathDemo2 md2 = new MathDemo2();
        try
        {
            int y = md2.div(4,1);
            System.out.println("The output of y："+y);
        }
        catch(ArithmeticException e)   //捕捉ArithmeticException异常
        {
            System.out.println("发生除数是零的异常！");
            System.out.println(e.toString());
        }
        catch(ArrayIndexOutOfBoundsException e)  //捕捉ArrayIndexOutOfBoundsException异常
        {
            System.out.println("发生数组角标越界异常！");
            System.out.println(e.toString());
        }

        //自定义异常处理
        MathDemo3 md3 = new MathDemo3();
        try
        {
            int z = md3.divide(5,-1);
            System.out.println("The output of z："+z);
        }
        catch(NegativeException e)   //捕获NegativeException异常
        {
            System.out.println(e.toString());
            System.out.println("自定义异常信息！"+e.getMessage());
        }
        finally  //finally中存放的是一定能够执行的代码
        {
            System.out.println("The end of handling Exception !");
        }

        System.out.println("It is over !");
    }
}
