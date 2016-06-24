/**
 * Created by wmy_one on 2016/6/16.
 * 这一节将会继续简单的介绍Java中异常的处理。
 * 1）异常在子父类覆盖中的体现
 * 1、子类在覆盖父类时，如果父类的方法抛出异常，此时，子类的覆盖方法只能抛出父类的异常或者该异常的子类；
 * 2、如果父类中的方法抛出多个异常，此时，子类在覆盖该方法时，只能抛出父类异常的子集；
 * 3、如果父类或者接口的方法中没有异常抛出，此时，子类在覆盖方法时也不能抛出异常；
 *    如果子类的方法中发生了异常，就必须在该方法中使用try、catch语句进行处理，绝对不能将该异常抛出去。
 *
 * 2）异常的总结
 * 异常：是对程序运行时可能出现的问题的描述，并将问题封装成对象。
 * 异常体系：
 *          Throwable
 *              |--Error
 *              |--Exception
 *                     |--RuntimeException  //该异常类及其子类被throw抛出后，无需使用throws抛给调用者处理
 * 异常体系的特点：
 * 异常体系中的所有类以及建立的对象都具有可抛性；也就是可以使用throw和throws关键字处理(异常体系才有的特点)；
 *
 * 异常格式：try{ 被检测的程序；}catch{ 异常处理的语句；}finally{ 一定能够执行的语句；}
 * 其中，finally中的语句只有一种情况不会执行，当catch中的语句执行到System.exit(0)时，finally中的语句不会执行。
 *
 * 自定义异常：当自定义异常信息是，可以使用父类已经定义好的功能，就是将异常信息传递给父类的构造函数。
 * 自定义异常：按照Java中的面向对象思想，将程序中的出现的特有问题进行封装；
 * 优点：
 *     1、将问题进行封装；
 *     2、将正常流程代码和问题处理代码相分离，方便阅读。
 * 异常的处理原则：
 * 1、处理方式有两种：try或者throws；
 * 2、调用到抛出异常的功能时，抛出几个，就处理几个；一个try对应多个catch；
 * 3、多个catch，父类的catch放到最下面；
 * 4、catch内，需要定义针对性的处理方式，不要简单的定义printStackTrace，输出语句，也不要不写；
 *     当捕获到的异常，本功能处理不了时，可以继续在catch中抛出；
 *     try
 *     {
 *          throw new AException();
 *     }
 *     catch(AException e)
 *     {
 *          throw e;
 *     }
 *     如果该异常处理不了，但并不属于该功能出现的异常；可以将异常转换后，在抛出和该功能相关的异常。
 *     或者异常可以处理，当需要将异常产生的和本功能相关的问题提供出来，让调用者知道，并处理，
 *     也可以将捕获到的异常处理后，转化为新的异常。
 *     try
 *     {
 *         throw new AException()；
 *     }
 *     catch(AException e)
 *     {   //对AException进行处理
 *         throw new BException();
 *     }
 *
 * 异常的注意事项：
 * 在子父类覆盖时：1、子类抛出的异常必须是父类异常的子类或者子集；
 *                 2、如果父类或接口没有异常抛出时，子类覆盖出现异常时，只能try不能抛。
 *
 * 3）Java中的package关键字的使用
 * package的作用：1、用来对类文件进行分类管理；2、给类文件提供多层命名空间（此时，访问类时，类名前需要加上包名）。
 * 注意：package语句必须写在程序的第一行；类名的全称是：包名.类名；也是一种封装形式；此时，运行时，命令：java 包名.类名
 *   编译时，命令：javac -d 存放路径（本地用 .）Demo.java；表示将文件Demo.java编译生成的Demo.class文件放到指定的目录下；
 *    如果指定的目录不是当前目录，此时，需要设置classpath：set classpath=存放路径，告诉jvm去哪里找，这样运行才不会报错。
 *
 * 包与包之间的访问：
 * 例如：pack包中类Demo，packa包中的类DemoA，packb包中的类DemoB
 * 如果Demo类中要访问DemoA中的方法，此时需要将DemoA以及其中的成员都用public修饰，并且Demo类访问时，
 * 写成：packa.DemoA a = new packa.DemoA(); a.方法名(); 此时，才能访问DemoA中的成员。
 *
 * 若packb包中的类DemoB及其成员都被public修饰后，此时，DemoA可以继承DemoB类，DemoA中可以直接访问DemoB中的方法；
 * 继承的语句写法为：public class DemoA extends packb.DemoB；此时，Demo要访问DemoB，可以按照访问DemoA的方式；
 * DemoA已经继承了DemoB，而Demo并没有继承DemoB，此时，应该让Demo和DemoA访问DemoB中的类有区别，
 * 做法为：将DemoB中的方法使用protected关键字修饰，此时，Demo就不能直接访问DemoB中的成员了。
 *
 * 有了包之后，要访问其他包中的类，为了简化类名的书写，可以使用import关键字，“import pack.packa.packb.packc.DemoC;”，表示导入DemoC类；
 * import pack.packa.packb.packc.*  表示导入pack.packa.packb.packc中的所有类文件；建议不要使用通配符，
 * 需要使用包中的哪个类就导入哪个类；在实际开发中，使用的高级编译器，是不用自己写package和import这些语句的。
 *
 * 当导入不同的包中类出现同名时，此时，访问该类就必须加上包名加以区分；
 * 建议定义包名不要重复，可以使用url来定义，因为url是唯一的。例如：www.google.com  包名：com.google.Demo和com.google.Test
 *
 * 注意：一个包中的类以及成员要被其他包访问，必须将该包中的类以及成员使用public修饰；
 *       不同包中的子类还可以直接访问父类中被protected修饰的成员。
 */

/**
 * 定义一个Shape接口，用于抽取求任何图形的面积方法
 * @author wmy_one
 * @version V1.1
 */
interface Shape
{
    public abstract void getArea();
}

/**
 * 自定义一个IllegalValueException异常类，用于描述求圆面积时，发生的半径参数异常。
 */
class IllegalValueExeption extends RuntimeException
{
    IllegalValueExeption(String message)
    {
        super(message);
    }
}

/**
 * 定义一个Circle类，用于描述圆的面积
 */
class Circle implements Shape
{
    private int radius;
    private static final double PI = 3.14;

    /**
     * 定义一个Circle类的构造函数，用于初始化Circle类的对象。
     * @param radius  初始化Circle类对象时，接收传进来的半径值。
     */
    Circle(int radius)
    {
        if(radius < 0)
            throw new IllegalValueExeption("半径是负数 !");  //手动抛出异常，无需调用者处理
        this.radius = radius;
    }

    /**
     * 复写Shape接口中的getArea()方法，用于求解圆的面积。
     */
    public void getArea()
    {
        System.out.println("The area of circle is："+(radius*radius*PI));
    }
}
public class ObjectDemo12 {
    public static void main(String[] args)
    {
        //创建Circle类对象，并调用该类的getArea方法，求圆的面积
        Circle c = new Circle(3);
        c.getArea();
    }
}
