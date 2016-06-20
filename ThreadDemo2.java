/**
 * Created by wmy_one on 2016/6/20.
 * 1）多线程运行出现的安全问题
 * 问题的原因：当多条语句在操作同一个线程共享数据时，一个线程对多条语句只执行了其中的一部分，还没有执行完，
 *              另一个线程参与进来执行，导致共享数据出现错误。
 * 解决办法：对多条操作共享数据的语句，某一时间段，只能让一个线程将这些语句都执行完，在执行的过程中，
 *            其他线程不能参与执行。
 *
 * Java对于多线程的安全问题提供了专业的解决方式，就是同步代码块：synchronized(对象){需要同步的代码}
 * 也可以使用同步函数解决多线程的安全问题，就是将需要同步的代码放在使用synchronized修饰的函数中即可。
 *
 * 对象如同锁（标志位：0、1），持有锁的线程可以在同步代码块中执行；其他线程即使获得CPU的执行权，
 * 也进不去，因为没有获取锁。
 *
 * 同步函数使用的是哪个锁呢？
 * 函数需要被对象调用，那么函数对象都有一个所属对象引用，就是this；因此，同步函数使用的锁是this。
 * 如果同步函数被静态修饰后，使用的锁是不在是this，因为静态方法中不能定义this；静态进内存时，
 * 内存中没有本类对象，但是一定有该类对应的字节码文件对象，类名.class，该对象的类型是Class。
 *
 * 静态的同步方法使用的锁是该方法所在类的字节码文件对象，即，类名.class
 *
 * 同步的前提：   1、必须要有两个或两个以上的线程；       2、必须是多个线程使用同一个锁；
 *
 * 必须保证同步中只能有一个线程在执行即可。
 * 优点：解决了多线程的安全问题；
 * 弊端：多个线程都需要判断锁，较为消耗资源。
 *
 * 2）找安全问题
 * 1、明确哪些代码是多线程运行代码；
 * 2、明确共享数据；
 * 3、明确多线程运行代码中哪些语句在操作共享数据
 *
 * 3）死锁现象
 * 当同步中嵌套同步时，并且他们的锁不同(也就是对象不同)，这时，程序可能将会出现程序不在运行的现象，这就叫做死锁。
 * 死锁的程序：
 * class DeadClock implements Runnable  //定义一个DeadLock类，实现Runnable接口
 * {
 *     private boolean flag;
 *     DeadClock(boolean flag)
 *     {
 *         this.flag = flag;
 *     }
 *     public void run()
 *     {
 *         if(flag)
 *         {
 *             synchronized(MyLock.locka)   //需要MyLock.locka锁才能进去
 *             {
 *                 System.out.println("if locka");
 *                 synchronized(MyLock.lockb)    //需要MyLock.lockb锁才能进去
 *                 {
 *                     System.out.println("if lockb");
 *                 }
 *             }
 *         }
 *         else
 *         {
 *             synchronized(MyLock.locka)
 *             {
 *                 System.out.println("else locka");
 *                 synchronized(MyLock.lockb)
 *                 {
 *                     System.out.println("else lockb");
 *                 }
 *             }
 *         }
 *     }
 * }
 * class MyLock   //定义一个MyLock类，用于描述两个锁。
 * {
 *     Object locka = new Object();
 *     Object lockb = new Object();
 * }
 */

/*
Java中的单例设计模式：有饿汉式和懒汉式两种体现形式，在实际项目中常常使用饿汉式；
饿汉式：
class Single
{
    private static final Single s = new Single();
    private Single(){ }
    public static Single getInstance()
    {
        return s;
    }
}
懒汉式：                                 //采用同步函数的方式，比较低效                      //采用同步代码块的方式，稍微提高效率
class Single                             class Single                                        class Single {
{                                        {                                                      .......
    private static Single s = null;         private static Single s = null;                     public static Single getInstance(){
    private Single(){ }                     private Single(){ }                                     if(s == null){
    public static Single getInstance()      public static synchronized Single getInstance()             synchronized(Single.class){
    {                                       {                                                               if(s == null)
        if(s == null)                           if(s == null)                                                   s = new Single();
            s = new Single();                       s = new Single();                                   }
        return s;                                return s;                                          }
    }                                        }                                                      return s;
}                                          }                                                    }
懒汉式的特点在于实例的延迟加载，在多线程访问时，将可能存在多线程安全问题，可以通过加同步来解决，既可以使用同步函数，
也可以使用同步代码块；使用同步函数，将会增加判断锁的次数，比较低效；使用双层判断的同步代码块则可以稍微提高程序的效率。
但是，在使用同步时，因为被静态修饰，因此，所使用的锁是该类所属类的字节码文件对象，
 */

/**
 * 定义一个TicketThread类，用于实现Runnable接口，描述简单的多窗口卖票。
 * @author wmy_one
 * @version V1.1
 */
class TicketThread implements Runnable
{
    private int tick = 100;
    //Object obj = new Object();
    boolean flag = true;
    public void run()
    {
        //实现一个线程执行同步代码块中的代码，另一个线程执行同步函数中的代码
        if (flag) {
            while (true) {
                //同步代码块用于解决多线程的安全问题，将操作多线程共享的数据的多条语句放在同步代码块中
                synchronized (this) {
                    if (tick > 0) {
                        //sleep()方法将抛出一个中断异常，需要使用try、catch语句处理，因为run复写接口方法，接口方法不能抛
                        try {Thread.sleep(10); } catch (Exception e) { }
                        System.out.println(Thread.currentThread().getName() + "...Tick---" + tick--);
                    }
                }
                //show();  //解决多线程中的安全问题，既可以使用上面的同步代码块也可以使用同步函数（注释掉的部分）
            }
        }
        else
            while(true)
                show();
    }

    public synchronized void show()  //使用同步函数处理多线程中的安全问题
    {
        if(tick > 0)
        {
            //sleep()方法将抛出一个中断异常，需要使用try、catch语句处理
            try {Thread.sleep(10);} catch (Exception e){}
            System.out.println(Thread.currentThread().getName() + "...Tick---" + tick--);
        }
    }

}

/**
 * 定义一个Bank类，用于描述银行的金库，有两个客户每次存100，存三次。
 */
class Bank
{
    private int sum = 0;
    /*
    Object obj = new Object();
    public void addFun(int num)
    {
        synchronized (obj) //同步代码块，用于处理多线程的安全问题
        {
            sum += num;
            //此处sleep方法将抛出中断异常，可以将该异常抛出，仅仅为了方便使用try、catch语句处理
            try {Thread.sleep(10); } catch (Exception e) {}
            System.out.println("Sum = " + sum);
        }
    }
    */
    public synchronized void addFun(int num)  //同步函数使用synchronized修饰，和同步代码块具有同样的功能
    {
        sum += num;
        try{Thread.sleep(10);}catch(Exception e){}
        System.out.println(Thread.currentThread().getName()+"。。。Sum = "+sum);
    }
}

/**
 * 定义一个BankThread类，用于实现Runnable接口，并复写该接口中的run方法。
 */
class BankThread implements Runnable
{
    private Bank b = new Bank();
    public void run()
    {
        for(int i=0; i<3; i++) {
            b.addFun(100);
        }
    }
}

public class ThreadDemo2 {
    public static void main(String[] args)
    {
        TicketThread t = new TicketThread();  //仅仅创建一个TicketThread类的对象
        Thread T1 = new Thread(t);   //创建一个T1线程，并接受Runnable接口的子类对象
        Thread T2 = new Thread(t);

        T1.start();   //开启T1线程，并调用Runnable接口子类对象的run方法run方法
        try{Thread.sleep(10);}catch(Exception e){}  //为了将主线程冻结10ms，方便观察到两个线程执行不同代码块现象
        t.flag = false;
        T2.start();
        //Thread T3 = new Thread(t);
        //T3.start();

        BankThread bt = new BankThread(); //仅仅创建一个BankThread类的对象
        Thread TT1 = new Thread(bt);   //创建一个TT1线程，并接受Runnable接口的子类对象
        Thread TT2 = new Thread(bt);
        TT1.start();   //开启TT1线程，并调用Runnable接口子类对象的run方法
        TT2.start();
    }
}
