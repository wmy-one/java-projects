/**
 * Created by wmy_one on 2016/5/22.
 * 这一节将会简单的介绍一下Java中的switch语句，并分析if和switch的区别
 * 1）switch语句的格式：
 * switch（表达式）{
 *     case '取值1'：
 *         执行语句；
 *         break；
 *     case '取值2'：
 *          执行语句；
 *          break；
 *      ……
 *      default：
 *          执行语句；
 *          break； //此处的break可以省略，若default语句放在其他地方，此时的break不能省略
 * }
 * 2）switch语句的注意事项：
 * ①switch中的表达式，仅仅有四种类型，分别为：byte、short、int、char；
 * ②case和default语句没有顺序，先执行第一个case，没有匹配的case，执行default；
 * ③switch的结束有两种情况：遇到break语句和执行到switch语句结束这两种情况；
 * ④如果匹配的case或default没有break，此时，程序将继续向下执行并运行可以执行的语句，直到遇到break或switch结尾结束。
 *
 * 3）if和switch的区别：
 * ①如果判断的具体数值不多，并且也符合byte、short、int、char这四种类型，
 *     两者均可使用，建议使用switch，因为switch效率稍高；
 * ②其他情况：对区间判断，结果为boolean类型判断,使用if语句，因为，if语句的使用范围更广。
 *
 * 随着Java的JDK版本的升级，JDK对switch语句有所增强，
 * 例如：JDK5.0使switch中的表达式可以支持枚举类型，JDK7.0支持字符串类型。
 *
 */
public class SwitchDemo {
    public static void main (String args[]){
        int a = 3, b = 8;
        char ch = '+';
        switch (ch){
            case '+':
                System.out.println("a + b = " + (a + b));
                break;
            case '-':
                System.out.println("a - b = " + (a - b));
                break;
            case '*':
                System.out.println("a * b = " + (a * b));
                break;
            case '/':
                System.out.println("a / b = " + (a / b));
                break;
            default:
                System.out.println("False !");
                break;
        }
    }
}
