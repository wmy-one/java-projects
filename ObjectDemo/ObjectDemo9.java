/**
 * Created by wmy_one on 2016/6/14.
 * 这一节将会简单的介绍Java中多态的应用。
 * 1）需求：
 * 创建一块主板，集成PCI接口，用于适配不同类型的网卡等等；
 * 将PCI封装成接口，各个网卡实现这个接口，并复写里面的功能，然后，在主板中定义函数接收PCI类型的引用。
 *
 * 2）Object类的使用
 * Object类是Java中每个类的父类，其中已经定义了一些多有对象的基础功能。
 * 例如：equals()和toString()这两个公用的功能。
 */
//应用一：主板需求
interface PCI
{
    public void openFun();
    public void closeFun();
}
class MainBord
{
    public void runFun()
    {
        System.out.println("Start MainBord !");
    }
    public void userPCI(PCI p)  //相当于PCI p = new netCard();
    {
        if (p != null)
        {
           p.openFun();
           p.closeFun();
        }
    }
}
class netCard implements PCI
{
    public void openFun()
    {
        System.out.println("Start netCard !");
    }
    public void closeFun()
    {
        System.out.println("Close NetCard !");
    }
}

//应用二：Object类的使用
class Person
{
    private int num;
    Person(int num)
    {
        this.num = num;
    }
    public boolean equals(Object ob)  //复写父类的equals()方法,Object ob = new Person();
    {
        if (!(ob instanceof Person))
            return false;
        Person p = (Person) ob;
        return this.num == p.num;
    }
}


public class ObjectDemo9 {
    public static void main(String[] args)
    {
        MainBord mb = new MainBord();
        mb.runFun();
        mb.userPCI(new netCard());

        Person p1 = new Person(6);
        Person p2 = new Person(8);
        System.out.println(p1.equals(p2));

        Class c = p1.getClass();  //Class类用来描述生成的.class文件
        System.out.println(c.getName());
        System.out.println(Integer.toHexString(p1.hashCode()));   //p1对象的地址对应的哈希值
        System.out.println(c.getName()+"@"+Integer.toHexString(p1.hashCode()));

        // 输出结果为：Person@74a14482，表示Person类型，地址为：74a14482，是哈希值。
        System.out.println(p1.toString());
    }
}
