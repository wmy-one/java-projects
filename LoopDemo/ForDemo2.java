/**
 * Created by wmy_one on 2016/5/24.
 * 这一节将会学习使用for循环打印9*9乘法表，break和continue的使用。
 * 1）打印正三角形的9*9乘法表
 * 步骤：
 * 1、使用循环语句，选择for和for嵌套语句；
 * 2、外循环控制行数，确定外循环的判断条件：for（int i=1;i<=9;i++）
 * 3、内循环控制每行的元素个数,确定内循环的判断条件：for（int j=1;j<=i;j++）;
 *
 * 2）break和continue语句的特点：
 * break：用于选择和循环结构，只能跳出当前循环结构；
 * continue：只能作用于循环结构；
 * 注意：
 * 1、continue语句是结束本次循环，继续下次循环；
 * 2、continue和break单独存在时，下面不能有任何语句，因为将执行不到这些语句；
 * 3、continue和break这两个语句都有作用范围，在作用范围外定义这两个语句，没有任何意义，将报错；
 * 3）标号
 * 标号：只能用于循环中， 就是给循环定义的一个名字，格式：
 * w：for(；；)
 *      q：for(；；)
 *           break w；      //表示跳出w循环，也就是说外循环
 *           continue w;   //表示跳出内循环，继续执行外循环
 * 这里的w和q就是标号，可以随意起名字，只要合法就行。
 */
public class ForDemo2 {
    public static void main (String args[]){
        //打印正三角形的9*9乘法表
        for(int i = 1; i <= 9; i++){
            for (int j = 1; j <= i; j++){
                System.out.print(j+"*"+i+"="+i*j+"\t");
            }
            System.out.println();
        }
        System.out.println("-----------------------");

        //break的使用
        for (int x = 0; x < 3; x++){
            for (int y = 1; y < 4; y++){
                System.out.print("x = "+x+"\t");
                break;     //仅仅跳出内循环
            }
        }
        System.out.println();
        System.out.println("-------------------");

        //标号的使用
        w:for (int x = 0; x < 3; x++){
            for (int y = 1; y < 4; y++){
                System.out.println("x = "+x);
                break w;
            }
        }
        System.out.println("-------------------");

        //continue的使用
        for (int x = 0; x <= 6; x++){
            //此if语句中的continue语句，将会结束本次循环，继续下次循环。
            if (x % 2 == 1)
                continue;
            System.out.print("x = "+x+"\t");
        }
        System.out.println();
        System.out.println("-------------------");

        w:for (int x = 0; x < 3; x++){
            for (int y = 1; y < 4; y++){
                System.out.print("x = "+x+"\t");
                continue w;    //此处的continue将会跳出内循环继续外循环
            }
        }
        System.out.println();
        System.out.println("-------------------");

        //打印一个由-组成的倒三角和由*组成的正三角的图形
        for (int i=0; i<5; i++){
            for (int j=i+1; j<5; j++){
                System.out.print("-");
            }
            for (int x=0; x<=i; x++){
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}
