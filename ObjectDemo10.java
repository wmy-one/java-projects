/**
 * Created by wmy_one on 2016/6/15.
 * 这一节将简单的介绍Java中的内部类。
 * 1）内部类的访问规则
 * 1、内部类可以直接访问内部类中的成员，包括私有；内部类之所以可以直接访问外部类中的成员，
 *     是因为内部类持有外部类的引用，格式为：外部类名.this
 * 2、外部类访问内部类中的成员，必须创建内部类对象。
 *
 * 2）内部类访问格式
 * 1、当内部类定义在外部类中的成员位置时，并且非私有时，可以在其他类中创建内部类对象，来访问内部类。
 *     格式：
 *           外部类名.内部类名 变量 = 外部类对象.内部类对象
 *     例如： Outer.Inner in = new Outer().new Inner();
 * 2、当内部类在外部类成员位置上时，可以被成员修饰符修饰。
 *    例如：private：将内部类封装在外部类中。
 *          static：内部类就具有static的特性。
 *
 *    当内部类被static修饰时，只能访问外部类中的static成员，出现访问限制；
 *
 *    在外部其它类（例如：主函数）中如何访问静态内部类中的非静态方法？
 *    格式：   new Outer.Innet.printFun();
 *
 *    在外部其它类（例如：主函数）中如何访问静态内部类中的静态方法？
 *    格式：    Outer.Innet.printFun();
 *
 * 注意：
 *      1、当内部类中定义了静态成员，此时，该内部类也必须是静态的；
 *      2、当外部类中的静态成员方法访问内部类时，此时，内部类也必须是静态的。
 *
 * 3）内部类定义在外部类中的局部
 * 1、不可以被成员修饰符修饰，因为这些修饰符只能修饰成员；
 * 2、可以直接访问外部类中的成员，因为还持有外部类中的引用
 * 3、不能访问它所在的局部中的变量，只能访问被final修饰的局部变量。
 *
 * 4）匿名内部类
 * 1、匿名内部类其实就是内部类的简写格式；
 * 2、定义匿名内部类的前提：内部类必须是继承一个类或者实现接口；
 * 3、匿名内部类的格式：new 父类名或接口(){定义子类内容};
 * 4、其实匿名内部类就是一个匿名子类对象；
 * 5、匿名内部类中的父类中定义的成员方法最好是不多于3个。
 */
/**
 * 定义一个匿名内部类的父类
 */
abstract class Fu
{
    abstract void show();
}
/**
 * 定义一个匿名内部类的接口
 */
interface Inter
{
    void method();
}


/**
 * 建立一个外部类和内部类，用于检验内部类和外部类中的成员访问特点。
 * @author wmy_one
 * @version V1.1
 */
class Outer
{
    private int num = 6;     //外部类中的私有成员变量
    /**
     * 定义一个外部类中的成员方法showFun1()，用于测试如何访问非静态内部类。
     */
    public void showFun1()
    {
        Inner in = new Inner();   //外部类创建内部类对象
        in.printFun();    //外部类访问内部类中的成员方法
    }

    /**
     * 定义一个外部类中的静态成员方法showFun2()，用于测试如何访问静态内部类。
     */
    public static void showFun2()
    {
        Inner2.show2();         //外部类中的静态成员方法，访问静态内部类中的静态成员方法
        new Inner2().show1();   //外部类中的静态成员方法，访问静态内部类中的非静态成员方法
    }

    /**
     * 定义一个外部类中的非静态成员方法showFun3()，用于测试如何访问定义在其中的内部类
     */
    void showFun3(final int a)   //此时，内部类只能方法被final修饰的局部变量
    {
        final int x = 3;
        class Inner     //定义一个内部类，此时，该内部类不能被static修饰，其中的成员也不能被修饰
        {
            void function()
            {
                System.out.println("Access local parameter in local Inner class !"+"...x："+x);
                System.out.println("Access local parameter in local Inner class !"+"...a："+a);
            }
        }
        new Inner().function();   //在外部类中的成员方法中，创建定义在局部中的内部类对象
    }
    /**
     * 定义一个外部类中的非静态方法showFun4()，用于测试如何调用匿名内部类
     */
    public void showFun4()
    {
        int n = 10;   //这是在匿名内部类的子类中定义成员变量
        Fu f = new Fu()
        {
            void show() {
                System.out.println("Print anonymous inner classes !"+"...num："+n);
            }
            void fun(){}
        };        //创建匿名内部类的父类引用指向子类对象，这是固定格式

        f.show();    //父类引用只能调用父类中的方法
        //f.fun();   //此写法编译失败，因为父类引用不能调用子类中的成员方法
    }
    /**
     * 定义一个外部类中的方法showFun5()，用于测试如何调用匿名内部类
     */
    public static Inter showFun5()
    {
        return new Inter()
        {
            public void method()
            {
                System.out.println("Access anonymous Inner interface!");
            }
        };    //创建匿名内部接口的子类对象
    }


    /**
     * 定义一个非静态的内部Inner类，英语测试如何访问外部类中的私有成员变量
     */
    class Inner
    {
        int num = 7;       //非静态内部类中的成员变量
        void printFun()   //非静态内部类中的非静态成员方法
        {
            int num = 8;    //内部类中成员方法中的变量
            System.out.println("The class of Inner："+Outer.this.num);   //内部类访问外部类中的成员变量
        }
    }


    /**
     * 定义一个静态的内部Inner2类，用于测试如何在其他类中访问静态内部类中静态和非静态成员。
     */
    static class Inner2
    {
        void show1()      //静态内部类中的非静态成员方法
        {
            System.out.println("Access the not static function in Inner2 ！");
        }
        static void show2()    //静态内部类中的静态成员方法
        {
            System.out.println("Access the static function in Inner2 ！");
        }
    }
}


public class ObjectDemo10 {
    public static void main(String[] args)
    {
        Outer ot = new Outer();   //创建外部类对象
        ot.showFun1();

        Outer.Inner in = new Outer().new Inner();   //直接访问非静态内部类的格式
        in.printFun();

        new Outer.Inner2().show1();   //访问静态内部类中的非静态成员
        Outer.Inner2.show2();         //访问静态内部类中的静态成员

        System.out.println("****Access static function in Outer class!***");
        Outer.showFun2();   //访问非静态外部类中的静态成员方法

        Outer out = new Outer();  //创建外部类对象，访问定义在外部类中的局部内部类
        /*
        外部类中的成员方法中接收的a被final修饰,但是上面的语句执行完后，
        将立即释放a，所以还能在对a赋值
        */
        out.showFun3(7);
        out.showFun3(8);

        new Outer().showFun4();   //创建外部类对象，调用匿名内部类

        /*
        Outer.showFun5()：表示Outer类中有一个静态方法showFun5()；
        .method()：表示showFun5()运算后的返回值是一个对象，并且是Inter类型的对象，
        因为只有是Inter类型的对象才能调用method()方法。
        */
        Outer.showFun5().method();
    }
}
