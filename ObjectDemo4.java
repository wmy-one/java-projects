/**
 * Created by wmy_one on 2016/6/10.
 * 这一节将会简单的介绍Java中对象的初始化过程和单例设计模式。
 * 1） Person p = new Person("David",25);这条语句的执行过程：
 *
 * 1、因为new用到了Person.class文件，所以先找到该文件，并加载到内存中；
 * 2、如果有静态代码块，先执行类中的静态代码块，给Person类进行初始化；
 * 3、在堆内存中开辟空间，分配内存地址；
 * 4、在堆内存中建立对象的特有属性，并进行默认初始化；
 * 5、对属性进行显示初始化(就是定义属性时，已经进行的赋值)；
 * 6、如果有构造代码块，执行构造代码块，给对象进行初始化；
 * 7、如果有构造函数，执行对应的构造函数，给相应的对象进行初始化；
 * 8、将内存地址赋值给栈内存中的变量p。
 *
 * 2）设计模式：解决某一类问题最行之有效的方法。Java中有23中设计模式。
 * 单例设计模式：解决一个类在内存中只有一个对象。
 *
 * 思路：
 * 1、为了避免其他程序建立多个对象，先禁止其他程序建立该类对象；
 * 2、为了让其他程序能够访问到该类的对象，只好在该类中自定义一个对象；
 * 3、为了方便其他程序访问该类的对象，必须对外提供一些访问方式。
 *
 * 步骤：
 * 1、将构造函数使用private修饰，这样将不被外界所使用；
 * 2、在类中创建一个该类的对象；
 * 3、提供一个方法，可以获取该对象；
 *
 * 3）单例设计模式的两中体现方式：
 * 方式一：  称为：饿汉式    （开发常用）  简单、安全
 * 此方式，是初始化对象，Single类一进内存，就已经创建好了对象。
 * class Single{
 *     private Single(){}
 *     private static Single s = new Single();
 *     public static Single getInstance(){
 *         return s;
 *     }
 * }
 *
 * 方式二：  称为：懒汉式    存在漏洞，就是有创建对个对象的可能性
 * 此方式，是在方法调用时，才初始化对象，也叫作对象的延时加载；
 * Single类进内存后，对象还没有存在，只有调用了getInstance()方法时，才建立对象。
 * class Single{
 *     private Single(){}
 *     private static Single s = null;
 *     public static （synchronized） Single getInstance(){
 *         if (s == null)
 *              s = new Single();
 *         return s;
 *     }
 * }
 *
 * 当对个程序同时执行时，由于内存运行机制，可能将会出现创建对个对象的现象，可以使用synchronized关键字解决，
 * public static synchronized Single getInstance(){
 *         if (s == null)
 *              s = new Single();
 *         return s;
 * }
 *
 * 但这样将会使得程序的执行效率降低，也可以使用另一种解决方法：
 *  public static Single getInstance(){
 *     if (s == null){
 *         synchronized (Single.class){
 *             if (s == null)
 *                  s = new Single();
 *         }
 *     }
 *     return s;
 * }
 *
 * 总之，上来两种解决方式，能够解决漏洞问题，但是这样做将会增加代码的复杂性，所以开发中将会使用饿汉式。
 */

/**
 * 创建一个Person类，用于描述人的一些特征。
 * @author wmy_one
 * @version V1.1
 */
class Person{
    private String name;
    private int age;

    /**
     * 定义一个构造函数Person()，用于给对应的对象进行初始化。
     */
    Person(){
        System.out.println("Name："+name+", Age："+age);
    }

    /**
     * 定义一个构造代码块，用于给每个创建的对象进行初始化。
     */
    {
        System.out.println("Name："+name+",******,Age："+age);
    }

    /**
     * 定义一个构造函数Person(String name, int age)，用于给对应的对象进行初始化。
     * @param name  接收一个name参数，用于将对象的name属性初始化
     * @param age   接受一个age参数，用于将对象的age属性初始化
     */
    Person(String name, int age){
        this.name = name;
        this.age = age;
        System.out.println("Name："+name+",.....,Age："+age);
    }

    /**
     * 定义一个供外界设置name属性的方法，由于该属性被private修饰
     * @param name  接收一个外界传进来的name属性的值。
     */
    public void setName(String name){
        this.name = name;
    }

    /**
     * 定义一个speakFun()方法，用于说出自己的姓名和年龄。
     */
    public void speakFun(){
        System.out.println("Name："+name+",...***,Age："+age);
    }
}

/**
 * 创建一个Single类，用于保证该类在内存中只存在一个对象
 */
class Single{
    private int num;

    /**
     * 将构造函数私有化，使外界无法创建对象
     */
    private Single(){}

    /**
     * 定义一个setNum()方法，用于设置对象的num属性。
     * @param num  接收外界设置的num属性的值。
     */
    public void setNum(int num){
        this.num = num;
    }

    /**
     * 定义一个getNum()方法，用于获取对象的num属性值。
     * @return  向外界返回对象的num属性值。
     */
    public int getNum(){
        return num;
    }

    /**
     * 在Single类中，创建一个自定义的Single类的对象。
     */
    private static Single s = new Single();

    /**
     * 给外界提供一个获取Single类对象的方法。
     * @return  向外界返回一个Single类的对象
     */
    public static Single getInstance(){
        return s;
    }
}


public class ObjectDemo4 {
    public static void main(String[] args){
        Person p = new Person("David",25);
        p.setName("John");
        p.speakFun();

        Single s1 = Single.getInstance();  //在主函数中获取Single类的对象
        Single s2 = Single.getInstance();
        s1.setNum(26);  //设置对象s1的num属性
        System.out.println("The num of object s2："+s2.getNum());  //输出对象s2的num属性
    }
}
