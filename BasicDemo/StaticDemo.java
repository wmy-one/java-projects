/**
 * Created by wmy_one on 2016/6/9.
 * 1）静态代码块的格式：
 * static
 * {
 *     静态代码块中的执行语句
 * }
 *
 * 2）静态代码块的特点：
 * 随着类的加载而执行，只执行一次，优先于主函数执行；用于给类进行初始化。
 * 并且不需要依赖对象而执行，只有加载了该类，就执行静态代码块，无论是否创建了该类的对象。
 *
 * 3）注意：
 * 因为先加载类，所以，类中的静态代码块优先执行；若创建了对象，其次，执行构造代码块给对象进行初始化，
 * 只要有类的对象创建，就执行构造代码块，然后才执行对应构造函数中的语句。
 */

/**
 * 定义一个构造代码块的类，该类中并定义了一些静态代码块、构造代码块和构造函数
 * @author wmy_one
 * @version V1.1
 */
class StaticCode{
    /**
     * 定义一个构造函数，用于给对应的对象进行初始化
     */
    StaticCode(){
        System.out.println("b");
    }

    /**
     * 定义一个静态代码块，用于给类进行初始化
     */
    static{
        System.out.println("a");
    }

    /**
     * 定义一个构造代码块，用于给对象进行初始化
     */
    {
        System.out.println("c");
    }

    /**
     * 定义一个带参数的构造函数，用于给对应的对象进行初始化
     * @param x 接收使用new创建对象时，传进来的参数
     */
    StaticCode(int x){
        System.out.println("d");
    }

    /**
     * 定义一个静态方法，仅仅打印一些信息
     */
    public static void showFun(){
        System.out.println("end!");
    }
}

public class StaticDemo {

    /**
     * 定义一个静态代码块，用于给类进行初始化
     */
    static{
        System.out.println("b1");
    }

    public static void main(String[] args){
        new StaticCode();

        //下面的语句将不执行，因为类只加载一次，上面的语句已经加载了该类，若有构造函数，该语句仍然执行
        new StaticCode();
        System.out.println("Hello world!");

        new StaticCode(6);
        StaticCode.showFun();  //此语句是为了测试，没有创建对象，仍然可以执行静态代码块，前提是，将一些语句注释掉
    }

    /**
     * 定义一个静态代码块，用于给类进行初始化
     */
    static{
        System.out.println("c1");
    }
}
