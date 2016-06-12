/**
 * Created by wmy_one on 2016/6/11.
 * 这一节将会简单的介绍Java中抽象类的基础知识和模板方法。
 * 当对个类中出现相同功能时，但是功能主体不同；此时，可以进行向上抽取，
 * 只抽取功能定义，而不抽取功能主体，这就叫做抽象。
 *
 * 1）抽象类的特点
 * 1、抽象方法必须在抽象类中；
 * 2、抽象方法和抽象类必须被abstract关键字修饰；
 * 3、抽象类不可以使用new创建对象，因为调用抽象方法没有意义；
 * 4、抽象类中的抽象方法，若被调用，必须由子类复写所有的抽象方法后，建立子类对象对其调用；
 *    如果该子类覆盖了部分抽象方法，那么该子类还是一个抽象类。
 *
 * 注意：
 * 抽象类和一般类被太大的区别，抽象类仅仅多了个抽象方法，抽象类不可以实例化；
 * 抽象类中也可以不定义抽象方法，但不常见，这样做仅仅是不让该类创建对象。
 *
 * 2）模板方法的概念
 * 在定义功能时，功能的一部分是确定的，但是有一部分是不确定的，而确定的部分在使用不确定的部分；
 * 此时，就可以径不确定的部分暴露出去，由该类的子类来完成。
 * 模板方法设计模式能够提高代码的扩展性和复用性。
 *
 * 获取时间：
 * System.currentTimeMillis();是以毫秒为单位，计算当前的时间与1970年1月1日午时之差。
 */

/**
* 需求：
 * 开发一个系统，用于对员工进行建模，员工的属性有：姓名，工号，工资和工作内容；
 * 员工分为经理和工程师，其中，经理有另一个属性奖金。
 * 思路：
 * 1、将经理和工程师类中的共性内容进行抽取，并使用abstract类来描述，因为不用给该类创建对象；
 * 2、分别定义经理类和工程师类，用于描述他们的信息，并使用继承方法，继承abstract类中的基本信息；
 * 3、由于他们的工作内容不同，将员工的工作行为在抽象类中使用抽象方法，经理和工程师的类中分别复写该方法。
*/

/**
 * 定义一个Employee类，用于对员工进行建模，员工的属性有：姓名，工号，工资和工作内容。
 * @author wmy_one
 * @version V1.1
 */
abstract class Employee
{
    private String name;
    private int id;
    private double pay;

    /**
     * 定义一个构造函数，用于初始化员工信息
     * @param name 接收一个String类型的name属性值
     * @param id  接收一个int类型的id属性值
     * @param pay 接收一个double类型的pay属性值
     */
    Employee(String name, int id, double pay)
    {
        this.name = name;
        this.id = id;
        this.pay = pay;
    }

    /**
     * 定义一个抽象方法，用于抽取员工的工作行为定义，而不用抽取方法主体
     */
    abstract void workFun();
}

/**
 * 定义一个Manager类，用于描述经理的信息
 */
class Manager extends Employee
{
    private int bonus;

    /**
     * 定义一个构造函数，用于初始化经理信息
     * @param name   接收一个String类型的name属性值
     * @param id    接收一个int类型的id属性值
     * @param pay   接收一个double类型的pay属性值
     * @param bonus 接收一个int类型的bonus属性值
     */
    Manager(String name, int id, double pay, int bonus)
    {
        super(name, id, pay);
        this.bonus = bonus;
        System.out.println("The base information of Manager：");
        System.out.println("Name："+name+", ID："+id+", Pay："+pay+", Bonus："+bonus);
    }

    /**
     * 定义一个方法，用于描述经理的工作内容
     */
    void workFun()
    {
        System.out.println("Manager class!");
    }
}

/**
 * 定义一个Engineer类，用于描述工程师的信息
 */
class Engineer extends Employee
{
    /**
     * 定义一个构造函数，用于初始化工程师信息
     * @param name 接收一个String类型的name属性值
     * @param id   接收一个int类型的id属性值
     * @param pay  接收一个double类型的pay属性值
     */
    Engineer(String name, int id, double pay)
    {
        super(name, id, pay);
        System.out.println("The base information of Engineer：");
        System.out.println("Name："+name+", ID："+id+", Pay："+pay);
    }

    /**
     * 定义一个方法，用于描述工程师的工作内容
     */
    void workFun()
    {
        System.out.println("Engineer class!");
    }
}

/**
 * 定义一个GetTime类，用于获取一段程序的运行时间。
 * @author wmy_one
 * @version V1.1
 */
abstract class GetTime
{
    /**
     * 定义一个getTime方法，用于计算一段程序的运行时间，并打印出来，单位是ms。
     */
    public final void getTime()
    {
        long start = System.currentTimeMillis();
        runCode();
        long end = System.currentTimeMillis();

        System.out.println("The time of code running is："+(end-start)+"ms");
    }

    /**
     * 定义一个runCode方法，并且使用abstract修饰，因为，运行程序不确定，所以对该方法进行抽象
     */
    public abstract void runCode();
}

/**
 * 定义一个SubTime类，用于复写GetTime类中不确定的运行代码，从而增加代码的灵活性。
 */
class SubTime extends GetTime
{
    /**
     * 定义一个runCode方法，用于复写父类中的抽象方法，可以灵活地编写需要测试运行时间的运行程序。
     */
    public void runCode()
    {
        int sum =0;
        for (int i=0; i<5000; i++)
        {
            sum += i;
            if (i == 4999)
                System.out.println(sum);
        }
    }
}

public class ObjectDemo7
{
    public static void main(String[] args)
    {
        Manager m = new Manager("David",1001,12000.0,6000);  //创建Manager类对象
        m.workFun();
        System.out.println("-----------------------------");

        Engineer e = new Engineer("John",2001,8000.0);    //创建Engineer类对象
        e.workFun();

        //测试一段程序的运行时间
        SubTime t = new SubTime();
        t.getTime();
    }
}
