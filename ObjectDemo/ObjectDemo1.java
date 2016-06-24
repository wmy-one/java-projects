/**
 * Created by wmy_one on 2016/6/5.
 *
 * 1）局部变量和成员变量的区别
 * ①、局部变量作用于函数内或者语句内；成员变量作用于整个类中。局部变量存在于栈内存中，成员变量存在于堆内存中，
 *     因为对象的存在，才存在内存中存在。
 * ②、成员变量都有初始化默认值，因为在堆内存中，需要参与运算，只有默认值后，才能参与运算，
 *     而局部变量在栈内存中， 没有默认值，只有赋值后，才能参与运算。
 *
 * 2）匿名对象的使用
 * ①、当对对象的方法只调用一次时，可以使用匿名对象，这样比较简化；当对对象进行多个成员调用时，必须给这个对象起个名字。
 * ②、匿名对象可以作为实际参数进行传递。
 *
 * 3）封装（Encapsulation）的概念
 * 将对象的属性和实现细节隐藏，仅仅对外提供公共访问的方式。
 * 优点：将变化隔离，便于使用；提高重用性和安全性。
 * 规则：将不需要对外提供的内容都封装起来；把属性都隐藏，提供公共的方法对其访问。
 *
 * 将类中的属性封装起来，可以使用的修饰符为：private，表示私有；是权限修饰符：用于修饰类中的成员（变量和方法）；
 * 属性私有化后，只能在本类中使用；即使在类外建立了对象，也不能直接访问；这时需要在类中提供对应的访问方式，
 * 类中的属性封装后，通常提供两种访问方式分别是：set和get；
 *
 * 之所以将类中的属性封装起来，对外提供访问方式，就是因为可以在访问方式中加入逻辑判断等语句，
 * 对访问的数据进行操作，提高代码的健壮性。
 *
 * 注意：private仅仅是封装的一种表现形式
 */

//创建一个Car类，用于练习匿名对象的使用
class Car{
    String color = "Yellow";
    int num = 4;

    void run (){
        System.out.println("Color："+color+", Num："+num);
    }
}

//创建一个person类，用于对封装概念的练习
class Person{
    String name = "David";
    private int age;        //将属性age封装起来

    //对外提供一个setAge访问方式，用于对属性age的操作；使用public修饰符，增加其访问权限
    public void setAge(int a){
        if (a > 0 && a < 130){
            age = a;   //此处的语句，仅仅对调用改方法的对象中的age属性赋值，而不是给类中的age赋值
            speak();
        }
        else
            System.out.println("Your input age is illegal !");
    }

    //对外提供一个getAge访问方式，用于获取属性age的值
    public int getAge(){
        return age;
    }

    //创建一个speak方法
    void speak(){
        System.out.println("Name："+name+", Age："+age);
    }
}

public class ObjectDemo1 {
    public static void main (String args[]){
        //仅仅调用一次对象的方法
        Car c0 = new Car();
        c0.run();

        //上面的语句可以简写为：
        new Car().run();     //使用匿名对象调用对象的方法

        //调用对象的多个成员
        Car c1 = new Car();
        c1.color = "red";
        c1.run();

        //此时，上面的语句不能使用匿名对象
        new Car().color = "blue";    //表示创建一个对象，该语句使用完之后，将自动成为垃圾而被回收
        new Car().run();             //输出结果仍然为Car类中定义的成员变量值

        //创建一个Car类型的变量进行传递
        Car c2 = new Car();
        showCar(c2);

        //上面的语句可以简写为：
        showCar(new Car());   //使用匿名对象作为实际参数进行传递

        //下面将会创建两个Person类变量，用于测试调用类中属性封装后的访问方式中的属性操作值的范围
        Person p1 = new Person();
        p1.setAge(30);  //此语句，仅仅改变该对象中的属性值，而不会改变类中对应的属性
        p1.speak();

        //上面的类变量设置完类中的属性后，不调用用setAge访问方式，测试此时的对象属性是否改变
        Person p2 = new Person();
        p2.speak();
        System.out.println(p2.getAge());
    }

    //需求：定义一个Car修配厂，将进去的汽车改为：轮胎数为6，颜色为黑色
    public static void showCar(Car c){
        c.num = 6;
        c.color = "Black";
        c.run();
    }
}
