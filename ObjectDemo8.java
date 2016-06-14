/**
* Created by wmy_one on 2016/6/12.
 * 这一节中将会简单的介绍Java中的接口和多态。
 * 1）接口的基础知识
 * 接口：初期理解，可以认为是一个特殊的抽象类；当抽象类中的方法全都是抽象的，
 *       此时，该类可以通过接口的形式来表示。定义接口使用interface关键字。
 *
 * 2）接口定义时，格式特点：
 * 1、接口中的常见定义：常量、抽象方法；
 * 2、接口中的成员都有固定的修饰符。
 *      常量：public static final
*       方法：public abstract
*
 * 注意：接口中的成员都被public修饰；接口之间可以有多继承，类之间只能单继承，
 *       但可以继承一个类的同时，实现多个接口。
 *
 * 接口之间可以有继承关系；类和接口之间是实现关系。接口用于功能扩展，由子类来实现。
 *
 * 接口：是不可以创建对象的，因为接口中有抽象方法；需要被子类实现，
 * 子类对接口中的抽象方法全部覆盖后，子类才可以实例化，否则子类是一个抽象类。
 *
 * 3）多态的特点
 * 多态：可以理解为事物存在的多种体现形态。
 * 前提：必须是类与类之间有关系，要么继承，要么实现；另外还要存在覆盖。
 * 体现形式：父类的引用指向了自己子类的对象；或者说，父类的引用可以接收自己的子类对象。
 * 优点：提高了程序的扩展性，但是，只能使用父类中的引用访问父类中的成员。
 *
 * 4）在多态中成员函数的特点
 * 非静态成员函数的特点：
 * 在编译时期：参阅引用型变量所属的类中是否有调用的函数，如果有，编译通过，否则，编译失败；
 * 在运行时期：参阅对象所属的类中是否有调用的方法。
 * 例如：父类名 f = new 子类名();
 * 总之，成员函数在多态调用时，编译时看左边，运行时，看右边。
 *
 * 在多态中，静态成员函数的特点：
 * 例如：父类名 f = new 子类名();  //因为静态不需要依赖对象而存在，只要引用存在即可
 *无论编译还是运行，都参考左边（引用型变量所属的类）
 *
 * 例如：
 * 父类名 f = new 子类名();
 * System.out.println(f.num);   //将打印父类中的num
 * 在多态中，成员变量的特点：无论编译还是运行，都参考左边（引用型变量所属的类）
 */

/**
 * 定义一个Inter接口，用于实现接口
 * @author wmy_one
 * @verson V1.1
 */
interface Inter
{
    public static final int NUM = 6;
    public abstract void show();
}

/**
 * 定义一个Test类，用于实现Inter接口
 */
class Test implements Inter
{
    public void show()
    {
        System.out.println("Using Class to implements Interface !");
    }
}


/**
 * 定义一个Animal类，用于实现多态
 * @author wmy_one
 * @verson V1.1
 */
abstract class Animal
{
    abstract void eat();
    void sleep()
    {
        System.out.println("All animal have an action of sleep !");
    }
}

/**
 * 定义一个OperateTool类，是一个工具类，方便操作共性的行为
 */
class OperateTool
{
    public static void actionFun(Animal a)
    {
        a.eat();
        a.sleep();
    }
}

/**
 * 定义一个Cat类，用于描述Animal类型中，Cat的特征
 */
class Cat extends Animal
{
    public void eat()
    {
        System.out.println("Eat fish !");
    }
    public void catchMouse()
    {
        System.out.println("Cat catch mouse!");
    }
}

/**
 * 定义一个Dog类，用于描述Animal类型中，Dog的特征
 */
class Dog extends Animal
{
    public void eat()
    {
        System.out.println("Eat bone!");
    }
    public void watchHome()
    {
        System.out.println("Dog watch home!");
    }
}

/**
 * 定义一个Fu类，用于测试在多态中，成员函数和成员变量的特点
 */
class Fu
{
    int num = 3;
    void showFun1()
    {
        System.out.println("Fu class showFun1!");
    }
    void showFun2()
    {
        System.out.println("Fu class showFun2!");
    }
    static void showFun3()
    {
        System.out.println("Fu class showFun3!");
    }
}
class Zi extends Fu
{
    int num = 9;
    void showFun1()
    {
        System.out.println("Zi class showFun1!");
    }
    static void showFun3()
    {
        System.out.println("Zi class showFun3!");
    }
}

public class ObjectDemo8
{
    public static void main(String[] args)
    {
        //接口的使用
        Test t = new Test();
        t.show();
        System.out.println(t.NUM);
        System.out.println(Test.NUM);
        System.out.println(Inter.NUM);

        //多态的使用，多带自始至终都是子类的对象在变化
        System.out.println("方式一：");
        Animal a = new Cat();  //类型提升，向上转型
        eatFun(a);
        //强制将父类引用转为子类类型，向下转型，但不能讲父类对象转为子类类型。
        Cat c = (Cat) a;
        c.catchMouse();

        //使用方式二，可以将上面的三句转为下面的语句
        //eatFun(new Cat());

        //方式三，上面两种方式的优化形式
        System.out.println("方式三：");
        OperateTool ot = new OperateTool();
        ot.actionFun(new Cat());
        ot.actionFun(new Dog());

        //测试在多态中，成员函数和成员变量的特点
        Fu f = new Zi();
        f.showFun1();   //运行结果调用子类的方法，编译参考父类中的方法
        f.showFun2();   //调用父类的方法
        f.showFun3();   //运行结果调用父类的静态方法，因为静态不依赖对象，只要引用存在即可
        System.out.println(f.num);   //运行结果访问父类的成员变量
    }
    //方式一：
    public static void eatFun(Animal a)
    {
        a.eat();
    }
    /*
    //方式二：
    public static void eatFun(Animal a)
    {
        a.eat();
        if(a instanceof Cat)
        {
            Cat c = (Cat) a;
            c.catchMouse();
        }
        else if(a instanceof Dog)
        {
            Dog c = (Dog) a;
            c.watchHome();
        }
    }
    */
}

