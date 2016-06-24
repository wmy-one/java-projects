/**
 * Created by wmy_one on 2016/6/19.
 * 这一节将会简单的介绍Java中的多线程知识。
 * 1）线程的基本概念
 * 进程：是一个正在执行的程序，每一个进程都有一个执行顺序，该顺序是一个执行了路径，或者叫控制单元；
 * 线程：就是进程中的一个独立的控制单元，线程控制着进程的执行；一个进程中至少有一个线程。
 *
 * Java VM启动的时候会有一个进程叫java.exe，该进程至少有一个线程负责Java程序的执行，
 * 并且这个线程运行的代码存在于main方法中，我们将该线程称为主线程。
 *
 * 扩展：其实更细节说明jvm，jvm启动不止一个线程，还有一个负责垃圾回收机制的线程。
 * 段线程的意义：多线程的出现，让程序中的某些代码能够产生同时运行的效果，也可以提高效率。
 *
 * 2）创建线程
 * Java的API文档中已经提供了对线程这类事物得描述，就是Thread类；
 * 创建线程的第一种方式：继承Thread类；
 * 步骤：
 * 1、定义类继承Thread类；2、复写Thread类中的run方法；目的：将自定义的代码存储在run方法中，让线程运行；
 * 3、调用线程的start方法，该方法的作用：①、启动线程；②、调用run方法。
 *
 * 创建线程的第二种方式：实现Runnable接口
 * 步骤：
 * 1、定义类实现Runnable接口；2、覆盖Runnable接口中的run方法，将线程要运行的代码存放在该run方法中；
 * 3、通过Thread类建立线程对象；4、将Runnable接口的子类对象作为实际参数传给Thread类的构造函数；
 *    因为，自定义的run方法所属的对象是Runnable接口的子类对象，所以要让线程去指定对象的run方法，
 *    就必须明确该run方法所属的对象；
 * 5、调用Thread类的start方法开启线程，并调用Runnable接口子类的run方法。
 *
 * 实现方式和继承方式的区别：
 * 实现方式好处：避免了单继承的局限性；继承方式不能再继承其他类；在定义线程时，建议使用实现方式。
 * 继承Thread：线程代码存放在Thread子类的run方法中；实现Runnable：线程代码存放在接口子类的run方法中。
 *
 * 同样的多线程程序，每次运行的结果不同，原因是：多个线程都在获取CPU的执行权，CPU执行到谁，就运行谁；但是，在某个时刻，
 * 只能有一个程序在执行（多核除外），CPU在这些线程之间快速的切换，已达到看上去是同时运行的效果。可以形象的将多线程的
 * 运行形容为在互相抢夺CPU的执行权，这是多线程的一个特点：随机性，谁抢到执行谁，执行多长时间，由CPU决定。
 *
 * 为什么复写run方法？
 * Thread类用于描述线程，该类就定义一个功能，用于存储线程运行的代码，该存储功能就是run方法；
 * 也就是说Thread类中的run方法，用于存储线程要运行的代码。
 *
 * 3）线程的状态
 * 阻塞：是临时状态，表示该线程具有运行资格，却无执行权限；冻结：由sleep(time)或wait()触发，表示该线程放弃执行资格；
 * 冻结状态结束后，并不会立即进入运行状态，而是进入阻塞状态，此时，该线程具有了运行资格，由CPU决定何时执行；
 * 消亡：由stop()或run()运行结束触发，表示线程的结束。
 *
 * 线程都有自己默认的名称，Thread-编号，该编号从0开始，通过getName()方法获的。
 * static Thread currentThread()：获取当前线程对象；getName()：获取线程名称；设置线程名称：setName()方法或构造函数。
 */

/**
 * 定义一个DemoThread类，用于继承Thread类，并复写Thread类中的run方法。
 * @author wmy_one
 * @version V1.1
 */
class DemoThread extends Thread
{
    DemoThread(String name)
    {
        super(name);
    }
    /**
     * 复写Thread类中的run方法
     */
   public void run()   //该方法中的代码由创建的线程负责执行
    {
        for(int i=0; i<50; i++)
            //此处的Thread.currentThread()表示当前线程对象，可以使用this替换。
            System.out.println(Thread.currentThread().getName()+"..."+"Starting run......"+i);
    }
}

/**
 * 定义一个TicketThread类，用于描述使用所线程思想，实现简单的多窗口卖票功能。方式一：
 * @author wmy_one
 * @version V1.1
 */
class TicketThread1 extends Thread
{
    private static int tick = 100;   //由于static修饰的成员周期比较长，通常不使用static
    public void run()
    {
        while(true)
        {
            if(tick > 0)
                System.out.println(Thread.currentThread().getName()+"...Tick："+tick--);
        }
    }
}

/**
 * 定义一个TicketThread类，用于描述使用所线程思想，实现简单的多窗口卖票功能。方式二：
 */
class TicketThread2 implements Runnable //extends Thread
{
    private static int tick = 100;   //由于static修饰的成员周期比较长，通常不使用static
    public void run()
    {
        while(true)
        {
            if(tick > 0)
                System.out.println(Thread.currentThread().getName()+"...Tick："+tick--);
        }
    }
}

public class ThreadDemo {
    public static void main(String[] args)   //main中的代码由主线程负责执行
    {
        DemoThread dt = new DemoThread("Thread-one");  //创建一个线程
        dt.start();   //开启线程并执行该线程的run方法
        //dt.run();   //仅仅是对象调用方法，而线程创建了并没有运行

        for(int j=0; j<50; j++)  //由主线程负责执行
            System.out.println("Hello World......"+j);

        //多窗口同时卖票的多线程，方式一：
        TicketThread1 t1 = new TicketThread1();   //创建t1线程
        TicketThread1 t2 = new TicketThread1();  //创建t2线程
        t1.start();   //开启t1线程
        t2.start();  //开启t2线程

        //方式二：
        TicketThread2 TT = new TicketThread2();  //仅仅表示创建TicketThread类的TT对象，并不是线程

        //将接口子类对象作为参数传给Thread类的构造函数，用于指定对象的run方法
        Thread T1 = new Thread(TT);  //创建一个T1线程
        Thread T2 = new Thread(TT);  //创建一个T2线程
        T1.start();
        T2.start();
    }
}
