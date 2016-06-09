/**
 * Created by wmy_one on 2016/6/8.
 * 1）static关键字
 * 用法：是一个修饰符，用于修饰成员（成员变量和成员函数）；
 * 当成员被static修饰时，就多了一种调用方式，除了可以被对象调用外，还可以直接被类名调用，格式为：类名.静态成员
 *
 * 特点：
 * ①、随着类的加载而加载；也就是说，当类加载到内存中，类中的静态成员就已经在内存中开辟好了空间；即，它的生命周期最长；
 * ②、优先于对象的存在；
 * ③、被所有对象所共享；
 * ④、可以直接被类名所调用。
 *
 * 2）实例变量和类变量的区别
 * 1、存放位置
 * 类变量随着类的加载而存在于方法区（或者共享区，或数据区）中；实例变量随着对象的建立而存在于堆内存中；
 * 2、生命周期
 * 类变量的生命周期最长，随着类的消失而消失；实例变量生命周期随着对象的消失而消失。
 *
 * 3）静态使用注意事项
 * 1、静态方法只能访问静态成员；非静态方法既可以访问静态也可以访问非静态；
 * 2、静态方法中不可以定义this、super关键字；因为静态优先于对象存在，所以静态方法中不可以出现this。
 * 3、主函数是静态的，主函数是一个特殊的函数，作为程序的入口，可以被jvm调用。
 *
 * 主要函数的定义：
 * public：代表着该函数访问权限是最大的；
 * static：代表主函数随着类的加载就已经存在了；
 * void：主函数没有具体的返回值，因为只是作为入口，被虚拟机调用，仅仅让其他程序能够运行；
 * main：不是关键字，仅仅是一个特殊的单词，可以被jvm识别；
 * String [] args：函数的参数，参数类型是一个数组，该数组中的元素是字符串，字符串类型的数组；
 *
 * 主函数是固定格式的：是jvm唯一识别的入口格式；jvm调用主函数时，传入的是new String[0]
 *
 * 4）静态的优缺点
 * 优点：对对象的共享数据进行单独空间的存储，节省空间，没有必要每个对象中都存储一份，可以直接被类名调用。
 * 缺点：生命周期过长，访问出现局限性。
 *
 * 5）什么时候使用静态
 * 静态变量：当对象中出现共享数据时，该数据被静态所修饰，存在于方法区；对象中的特有数据要定义成非静态，存在于堆内存中。
 * 静态方法：当方法内部没有访问到非静态数据（对象的特有数据），此时，该方法可以定义成静态的。
 *
 * 6）静态的应用
 * 如果每个应用程序中都有共性的功能，可以将这些功能进行抽取，独立封装，方便复用；
 * 虽然可以通过建立对象使用类中的这些工具方法，对数组进行操作，但是由于：
 * 1、对象是用来封装数据的，然而ArrayTool对象并没有封装特有数据；
 * 2、操作数组所使用的每个方法也没有用到ArrayTool对象中的特有数据；
 * 此时，为了程序的严谨性，是不用建立对象的，可以将ArrayTool中的方法都用static修饰，直接通过类名调用；
 * 将方法都static后，仍然可以被其他程序建立对象，进行使用，由于类对象的创建需要构造函数，
 * 此时，为了强制让类不能建立对象，可以将构造函数私有化来完成。
 */

//创建一个Person类，用于描述人的特征
class Person{
    String name;   //成员变量，也叫实例变量
    static String country = "CN";   // 静态成员变量，也叫类变量

    public void showFun(){
        System.out.println("Country："+country);
    }
}

//定义一个类，用于测试项主函数传递数组
class MainTest{
    public static void main (String[] args){
        for (int i=0; i<args.length; i++)
            System.out.println(args[i]);
    }
}

public class ObjectDemo3 {
    public static void main (String args[]){
        String[] arr = {"John","David","Tom"};
        MainTest.main(arr);

        System.out.println(Person.country);   //使用static关键字修饰后的成员，调用方式
        Person p = new Person();
        p.showFun();     //未被static修饰的成员，需要建立对象后，才能调用

        //调用外部定义好的ArrayTool工具类，用于对数组进行操作
        int[] arr1 = {3,1,4,1,5,9,2,6};

        /*
        ArrayTool类并不在该类中，调用时，jvm将在当前目录或指定目录(CLASSPATH路径)中查找ArrayTool类的执行文件，
        若有执行；否则，就查找对应的类文件，并编译。这些过程，都是由jvm完成的。
        */
        int max = ArrayTool.getMax(arr1);
        System.out.println("The max of array is："+ max);

        int min = ArrayTool.getMin(arr1);
        System.out.println("The min of array is："+ min);

        ArrayTool.printFun(arr1);     //排序前，打印数组中的元素
        ArrayTool.bubleSort(arr1);   //使用冒泡法对数组中的元素进行排序
        ArrayTool.printFun(arr1);   //排序后，打印数组中的元素

        /*
        如果ArrayTool类中的构造函数没有被static所修饰，可以创建类对象，来实现对数组的操作，具体如下：
        int[] arr2 = {3,1,4,1,5,9,2,6};

        ArrayTool tool = new ArrayTool();

        //此时，下面调用的ArrayTool中的方法也没有被static修饰，才能这样调用
        int max = tool.getMax(arr2);
        System.out.println("The max of array is："+ max);

        tool.printFun(arr1);     //排序前，打印数组中的元素
        tool.bubleSort(arr1);   //使用冒泡法对数组中的元素进行排序
        tool.printFun(arr1);   //排序后，打印数组中的元素
         */
    }
}
