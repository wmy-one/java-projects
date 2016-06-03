/**
 * Created by wmy_one on 2016/6/3.
 * 这一节将会简单的介绍Java中面向对象的基础知识。
 * 1）面向对象的特点
 * 面向过程强调的是功能行为；面向对象将功能封装成对象，强调具备了功能的对象；
 * 特点：面向对象是一种思想，就是将复杂问题简单化，从角色角度来说就是从执行者变成指挥者。
 * 特征：封装、继承、多态
 * 2）类和对象的关系
 * 类：就是对现有生活中事物的描述
 * 对象：就是这类事物，实实在在存在的个体
 * 映射到Java中：
 * 描述就是Java中用class定义的类；具体对象就是Java中在堆内存中用new创建的实体。
 *
 * 3）创建一个汽车类，思路：
 * ①、首先分析car类的属性和行为（统称为类中的成员）；其中，属性对应类中的变量，行为对应类中的方法（函数）；
 * ②、使用Java中的class关键字创建一个car类，并定义其属性和行为；
 * ③、在主函数中调用该类，语法为：类名 变量名 = new 类名();
 * ④、调用类中的属性和方法，可以对该类的对象进行操作，格式：对象(类类型的变量).类中的成员
 *
 *
 * 感想：在针对Java的面向对象开发中，今后，就是调用类、创建类、并维护类之间的关系的一个过程。
 */

class Car{

    //描述汽车的颜色
    String color = "yellow";

    //描述轮汽车的胎数
    int num = 4;

    //描述汽车的行为
    void runFun(){
        System.out.println("Color："+color+", Num："+num);
    }

}
public class ObjectDemo {
    public static void main (String args[]){

        //定义一个类类型变量，该变量指向该类在堆内存中的实体
        Car bmw = new Car();
        bmw.runFun();

        //多个对象指向同一个实体
        Car c = bmw;
        c.color = "red";
        bmw.runFun();
    }
}
