/**
 * Created by wmy_one on 2016/6/6.
 * 这一节中将会简单的介绍Java中的构造函数和this关键字。
 * 1）构造函数的特点
 * 函数名和类名相同；不用定义返回值类型，也不可以写return语句；多个构造函数是以重载的形式存在的。
 * 对象建立后就调用与之对应的构造函数；构造函数用于给对象进行初始化。
 *
 * 注意：
 * 当类中没有定义构造函数时，系统默认会给该类定义一个空参数的构造函数，此构造函数为：函数名(){}；方便对象的初始化，
 * 否侧无法建立对象，因为无法进行初始化；若类中自定义了构造函数后，此时，默认的构造函数就没有了。
 *
 * 2）一般方法和构造函数的区别
 *①、在写法和运行上均不同
 * 构造函数是在对象一建立就运行，给对象进行初始化；而一般方法是被对象调用时才执行，给对象添加对象具备的功能；
 *②、一个对象建立，构造函数值运行一次，而一般方法可以被对象多次调用。
 *
 * 3）什么时候定义构造函数
 * 当分析事物时，该事物具备一些特性或行为，此时，将这些内容定义在构造函数中，若构造函数在进行定义的时候，
 * 需要未知参数参与运算，此时，就定义参数。
 *
 * 4）构造代码块
 * 格式：{ 执行语句 }
 * 作用：给对象进行初始化
 * 对象一建立就执行，而且优先于构造函数执行；
 * 构造代码块中定义的是不同对象共性的初始化内容。
 *
 * 构造代码块和构造函数的区别：
 * 构造代码块是给所有对象进行统一初始化，而构造函数是给对应的对象初始化。
 *
 * 5）this关键字的特点
 * 从表面上来看，this是用于区分局部变量和成员变量名的；实质上，this代表它所在函数所属对象的引用；
 * 简单来说，就是哪个对象调用this所在的函数，this就代表哪个对象。
 *
 * 类中的成员之间相互调用，是通过对象来实现的，默认情况下，调用某个成员就是调用属于某个对象的成员；
 * 当变量名相同时，必须使用this关键字进行区分，否则将会作为局部变量进行操作。
 *
 * 6）this的应用
 * 当定义类中方法时，该方法内部要用到调用该方法的对象时，就用this来表示该对象，
 * 凡是本类方法内部使用了本类对象，就用this表示。
 *
 * 构造函数之间进行相互调用使用this关键字；并且this语句必须定义在构造函数的第一行，因为初始化要先执行。
 * 构造函数之间相互调用，使用this语句的格式为：this(形参);一般函数不能调用构造函数，this关键字只能用于构造函数中。
 */
class Person{
    private String name;
    private int age;

    //定义一个构造代码块，用于定义不同对象共性内容的初始化
    {
        cryFun();
    }

    //定义一个Person()构造函数，用于对相应的对象进行初始化
    Person(){
        System.out.println("A：Name："+name+", Age："+age);
        //cryFun();
    }

    //定义一个Person(String n)构造函数，用于对相应的对象进行初始化
    Person(String name){
        this.name = name;   //此处使用this关键字，适用于区分同名变量的含义
        System.out.println("B：Name："+this.name+", Age："+this.age);  //此处的this可以省略
        //cryFun();
    }

    //定义一个Person(String n, int a)构造函数，用于对相应的对象进行初始化
    Person(String name, int age){
        this.name = name;  //此处为了提高代码的复用性，可以使用this语句，格式为：this（name);
        this.age = age;   //此处的this.age表示该对象的age，就是将age赋值给该对象的age（堆内存中）
        System.out.println("C：Name："+name+", Age："+age);
        //cryFun();
    }

    //定义一个Person(int age)构造函数，用于给相应的对象进行初始化
    Person(int age){
        this.age = age;
    }

    /*需求：定义一个用于比较两个对象的年龄是否相同的方法
      思路：
      1、因为比较年龄是否相同，返回值为boolean类型，所以定义一个boolean类型的方法；
      2、因为要比较年龄，所以需要可以执行比较动作的语句，可以使用if语句；
      3、因为if语句中判断条件的返回值就是boolean类型，所以可以直接返回判断语句，为了简化代码而不用if语句；
      4、因为在该方法中要使用调用该方法的对象与传进的对象进行比较，所以要使用this关键字表示该对象。
    */
    public boolean compareFun(Person p){   //因为比较的是对象的age属性，所以形参使用Person p而不是int age
        return this.age == p.age;
    }

    //定义一个方法，用于增加对象的功能，可以多次调用
    public void cryFun(){
        System.out.println("Cry……");
    }
}
public class ObjectDemo2 {
    public static void main(String args[]){
        Person p1 = new Person(); //若类中没有Person()这个构造函数，此语句将报错，因为没有对应的构造函数对其进行初始化
        Person p2 = new Person("David");
        Person p3 = new Person("John",25);

        Person p4 = new Person(30);
        Person p5 = new Person(35);
        boolean b = p4.compareFun(p5);
        System.out.println("Compare two persons' age："+b);
    }
}
