/**
 * Created by wmy_one on 2016/6/24.
 * 这一节将会简单的介绍Java中如何停止线程，守护线程。
 * 1）如何停止线程
 * 由于stop方法已经过时，这时只有一种方法可以停止线程，就是使用run方法结束；开启多线程运行，运行代码通常都是循环结构，
 * 只要控制住循环，就可以让run方法结束，也就是让线程结束。
 *
 * 特殊情况：
 * 当线程处于冻结状态时，就不会读取结束循环的标记，此时，线程就不会结束。
 *
 * 当没有指定的方式让冻结状态的线程恢复到运行状态时，这时需要对冻结状态进行清除，强制让线程恢复到运行状态，
 * 这样就可以通过操作循环标记让线程结束。Thread类提供了该方法：interrupt()。
 *
 * 2）守护线程
 * Thread类中提供了一个setDaemon方法，将该线程标记为守护线程或者用户线程，当运行的线程都是守护线程时，JVM将退出，
 * 该方法必须在启动线程钱调用。此方法也可以结束线程执行run方法中的循环语句，这样也可以结束线程。
 *
 * 3）join方法的特点
 * 当A线程执行到B线程的join方法时（B.join()），此时，A将会等待，等B线程执行完后，A线程才会执行。
 * join可以用来临时加入线程执行。
 *
 * 4）Tread类中的一些方法
 * setPriority可以用于设置新陈的优先级（1-10），默认是5，代表抢夺CPU资源的频率；使用格式：线程.setPriority(int num),
 * 其中Java已经将一些优先级定义为常量，MAX_PRIORITY表示10、MIN_PRIORITY表示1、NORM_PRIORITY表示5.
 * yield方法用于释放线程的执行权，稍微减缓线程执行的频率，能达到线程均用CPU资源的效果，格式：Thread.yield()。
 *
 * 5）开发中线程的使用
 * 在实际开发中，如果一些代码能够独立运行相互无影响，这时为了提高程序的执行效率可以使用匿名内部类将这些独立运行的代码
 * 封装成一个线程，也可以单独创建一个线程类实现；这样这些独立运行的代码能同时执行，比较高效。
 * class ThreadTest
 * {
 *     public static void main(String[] args)
 *     {
 *         new Thread()    //通过匿名内部类将程序封装成一个线程
 *         {
 *             public void run()
 *             {
 *                 for(int i=0; i<100; i++)
 *                     System.out.println(Thread.currentThread().getName()+"..."+i);
 *             }
 *         }.start();
 *
 *         Runnable r = new Runnable()  //通过匿名内部类将程序封装成一个线程
 *         {
 *             public void run()
 *             {
 *                  for(int j=0; j<100; j++)
 *                      System.out.println(Thread.currentThread().getName()+"..."+j);
 *             }
 *         };
 *         new Thread(r).start();
 *
 *         for(int x=0; x<100; x++)
 *             System.out.println(Thread.currentThread().getName()+"..."+x);
 *     }
 * }
 */

/**
 * 定义一个StopThread类，实现Runnable接口，并复写run方法，用于描述线程运行的代码。
 * @author wmy_one
 * @version V1.1
 */
class StopThread implements Runnable
{
    private boolean flag = true;
    public synchronized void run()
    {
        while(flag)  //此处的while语句用于让线程循环执行
        {
            try
            {
                wait();
            }
            catch(InterruptedException e)  //捕捉try检测到的异常，并处理该异常
            {
                System.out.println(Thread.currentThread().getName()+"......Exception!");
                flag = false;  //冻结状态清除后，修改循环标记结束该线程
            }
            System.out.println(Thread.currentThread().getName()+"...run!");
            //若run方法不是synchronized同步方法，这时，可以通过将线程标记为守护线程，结束该线程的运行
        }
    }
    public void changeFlag()
    {
        flag = false;
    }
}

public class ThreadDemo4 {
    public static void main(String[] args)
    {
        StopThread s = new StopThread();
        Thread T1 = new Thread(s);    //创建T1线程，并接收Runnable接口的子类对象
        Thread T2 = new Thread(s);

        //T1.setDaemon(true);    //将该线程标记为守护进程，也就是后台运行
        //T2.setDaemon(true);
        T1.start();   //启动T1线程，并调用Runnable接口子类对象中的run方法
        T2.start();
        //T1.setPriority(Thread.NORM_PRIORITY);   //将T1线程的优先级设置为5

        int num = 0;
        while(true)   //此处的while循环用于让主进程循环执行代码
        {
            if (num++ == 30)
            {
                //s.changeFlag();  //如果没有使用同步，可以使用该方法结束线程
                T1.interrupt();
                T2.interrupt();   //调用Thread类中的interrupt方法，清除冻结状态
                break;
            }
            System.out.println(Thread.currentThread().getName()+"...run!");
        }
        System.out.println("Over !");
    }
}
