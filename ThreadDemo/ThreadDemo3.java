/**
 * Created by wmy_one on 2016/6/21.
 * 这一节将会简单的介绍Java中多线程间的通信。
 * 1）线程间的通信
 * 其实线程间的通信就是多个线程在操作同一资源，但是，它们操作的动作不同。
 * 2）等待唤醒机制
 * 就是使用wait()和notify()或者notifyAll()方法操作线程；其中等待线程存放在被内存中创建的线程池中，可以使用notify()唤醒，
 * 通常唤醒的是线程池中第一个处于等待状态的线程；当所有线程都处于等待状态时，可以使用notifyAll()方法唤醒。
 *
 * wait()、notify()、notifyAll()都使用在同步中，因为要对持有监视器（锁）的对象操作，并且只有同步中才有锁。
 * 这些方法都定义在Object类中，因为这些方法在操作同步中的线程时，都必须标识它们所操作线程持有的锁，只有同一个锁上的
 * 被等待的线程，可以被同一个锁上的notify唤醒，不可以对不同锁中的线程进行唤醒，也就是说，等待和唤醒必须是同一个锁。
 *
 * 锁可以是任意对象，所以可以被任意对象操作的方法定义在Object类中。
 *
 * 3）生产者-消费者模式
 * 下面程序中，输入和输出线程各自仅仅只有一个，这种情况将不会出现两个进程同时处于等待状态，
 * 因为，一个处于等待状态时，将会唤醒另一个线程；所以，可以使用if(flag)的形式判断，以及使用notify来唤醒。
 *
 * 但是，当有多个输入和多个输出线程时，由于线程在轮询占用CPU资源，这样将会出现，一个输入线程处于等待状态时，
 * 其他输入线程获得CPU执行权，输出线程并有获得执行权，此时，其他输入线程也将进入等待状态；多个输出线程也将会
 * 出现同样的现象；这样最终，所有进程可能都处于等待状态，程序挂起，不在执行。这时，可以将程序的判断语句改为：
 * 将if(true)换成while(true)，这样，每个处于等待状态的进程，在唤醒时，都会进行判断；将notify语句换为notifyAll语句。
 *
 * 4）生产者-消费者模式，新替换方案
 * 在JDK1.5中提供了多线程升级解决方案，将同步synchronized替换成显示Lock操作，将Object中中的wait、notify、notifyAll
 * 替换成了condition对象，该对象可以通过lock锁进行获取，这样可以只换醒处于休眠状态的对方线程，而本方线程由对方负责唤醒。
 *
 */

/**
 * 定义一个Resource类，用于描述被多线程操作的同一资源。
 */
class Resource
{
    String name;
    String sex;
    boolean flag = false;  //boolean类型的变量默认值是false
    /*
    优化后的代码：
    private String name;
    private String sex;
    private boolean flag = false;
    //由于这些资源将被多线程操作，可能存在安全问题，所以必须可以使用同步函数处理
    public synchronized void set(String name, String sex)  //对外提供操作私有化的成员变量
    {
        if(flag)
            try{this.wait();}catch(Exception e){}
        this.name = name;  //执行到该语句时，此时操作的线程可能没有了CPU执行权，其他线程也将操作该数据，将导致错误
        this.sex = sex;
        flag = true;
        this.notify();
     }
     */

    /*
    使用lock替换synchronized的新解决方案：
    private Lock lock = new ReentrantLock();     //创建一个锁对象
    private Condition condition_pro = lock.newCondition();   //创建一个生产者condition_pro对象
    private Condition condition_con = lock.newCondition();   //创建一个消费者condition_pro对象
    public void set(String name, String sex) throws InterruptedException
    {
        lock.lock();    //锁住
        try
        {
            while(flag)
                condition_pro.await();   //将生产者线程处于休眠状态
            this.name = name;
            this.sex = sex;
            flag = true;
            condition_con.signal();   ////将消费者线程唤醒
         }
         finally
         {
         lock.unlock();
         }
    }
     */

     /*
     优化后的代码：
     public synchronized void get()  //该方法也是被多线程操作的资源，也要使用同步函数处理
     {
         if(!flag)
            try{this.wait();}catch(Exception e){}
         System.out.println("Name：" + r.name + " ... Sex：" + r.sex);
         flag = false;
         this.notify();
      }
     */

    /*
    使用lock替换synchronized的新解决方案：
    public void get() throws InterruptedException
    {
        lock.lock();
        try
        {
            while(!flag)
                condition_con.await();
            System.out.println("Name：" + r.name + " ... Sex：" + r.sex);
            flag = false;
            condition_pro.signal();
        }
        finally
        {
            lock.unlock();
        }
    }
     */
}

/**
 * 定义一个InputThread类，实现Runnable接口，并复写其中的run方法，用于向同一资源中输入数据。
 */
class InputThread implements Runnable
{
    private Resource r;
    InputThread(Resource r)
    {
        this.r = r;
    }
    public void run()
    {
        int x = 0;
        while(true)
        {
            synchronized(r)   //由于是多线程在操作同一资源，为了避免安全问题，使用同步代码块解决
            {
                if(r.flag)  //当flag为true时，将该线程处于等待状态；为false时开始输入数据
                    //由于wait方法将会throw异常，并且run是复写Runnable接口的方法，只能使用try、catch语句处理
                    try{r.wait();}catch(Exception e){}
                if (x == 0) {
                    r.name = "David";
                    r.sex = "Male";
                } else {
                    r.name = "小米";
                    r.sex = "女";
                }
                x = (x + 1) % 2;
                r.flag = true;
                r.notify();  //唤醒被持有r锁的等待线程
            }
            /*
            优化后的代码：
            if(x == 0)
                r.set("David", "Male");
            else
                r.set("小米", "女");
            x = (x+1)%2;
             */
            /*
            使用lock替换synchronized的新解决方案：
            try
            {
                if(x == 0)
                r.set("David", "Male");
                else
                    r.set("小米", "女");
                x = (x+1)%2;
            }
            catch(InterruptedException e) { }
             */
        }
    }
}

/**
 * 定义一个OutputThread类，实现Runnable接口，并复写其中的run方法，用于从同一资源中输出数据。
 */
class OutputThread implements Runnable
{
    private Resource r;

    /**
     * 定义一个OutputThread类的构造函数，用于初始化该类对象，并接收R操作的资源对象。
     * @param r  接收一个Resource类的对象，也就是被OutputThread类对象操作的资源
     */
    OutputThread(Resource r)
    {
        this.r = r;
    }
    public void run()
    {
        while(true)
        {
            synchronized(r) {  //由于和InputThread类操作的是同一资源，也必须使用同步代码块处理
                if(!r.flag)
                    //因为wait是在同步中操作持有r锁的线程，必须标识它所操作线程持有的锁
                    try{r.wait();}catch(Exception e){}
                System.out.println("Name：" + r.name + " ... Sex：" + r.sex);
                r.flag = false;
                r.notify();
            }
            /*
            优化后的代码：
            r.get();
             */

            /*
            使用lock替换synchronized的新解决方案：
            try
            {
                r.get();
            }
            catch(InterruptedException e) { }
             */
        }
    }
}

public class ThreadDemo3 {
    public static void main(String[] args)
    {
        Resource r = new Resource();

        InputThread in = new InputThread(r);
        OutputThread out = new OutputThread(r);

        Thread T1 = new Thread(in);  //创建一个T1线程，并接收实现Runnable接口的子类对象
        Thread T2 = new Thread(out);
        T1.start();  //启动T1线程，并调用实现Runnable接口的子类中的run方法
        T2.start();

        /*
        上面6条语句可以使用匿名对象进行优化：
        new Thread(new InputThread(r)).start();
        new Thread(new OutputThread(r)).start();
         */
    }
}
