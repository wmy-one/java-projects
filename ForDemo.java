/**
 * Created by wmy_one on 2016/5/23.
 * 这一节将会简单的介绍Java中的for循环以及一些注意事项：
 * 1）for循环的格式：
 * for（初始化表达式；循环条件表达式；循环后的操作表达式）
 * {
 *     循环体（也就是执行语句）；
 * }
 * 2）最简单的无限循环表达式
 * for（；；）{}   //在for循环中，默认的循环条件表达式为true
 * while（true）{}
 * 3）注意事项
 * 如果将控制循环的变量定义在for语句中，该变量只在for循环内有效，for语句执行完成后，该变量将会从内存中释放。
 *
 * 4）问题1：统计1-100之间7的倍数出现的次数
 * 思路：
 * 1、先对1-100进行遍历，通过循环的形式；
 * 2、在循环的过程中，定义条件，只对7的倍数进行操作；
 * 3、因为7的倍数不确定，只要条件符合，就通过一个变量记住这个变化的次数。
 *
 * 步骤：
 * 1、定义循环语句，使用for循环；
 * 2、在循环中定义判断，只要是7的倍数即可，使用if语句，条件：7的倍数 %7==0；
 * 3、定义一个变量，该变量随着7的倍数出现而递增。
 *
 * 5）问题2：打印一个下面的图像
 *                  ******
 *                  *****
 *                  ****
 *                  ***
 *                  **
 *                  *
 *步骤：
 * 1、定义嵌套循环语句，选择for和for嵌套；
 * 2、分析图形可知：外循环控制图形的行数，内循环控制图形的每一行中元素的个数；
 * 3、定义一个变量，随着外循环而变，并将该变量作用到内循环中的条件表达式或初始表达式；
 * 4、也可以直接使用外循环中控制循环的变量，来作用到内循环中的初始表达式，实现同样的效果。
 *
 * 6）打印图形总结：
 * 如果想打印上图中的倒三角形状的图形，可以改变内循环中的初始化值，让初始化值随着外循环而变；
 * 如果想打印上图中的正三角形状的图形，可以改变内循环中的条件判断值，让条件判断值随着外循环而变。
 */
public class ForDemo {
    public static void main (String args[]) {
        //for循环的不同表现形式如下所示
        for (int x = 1; x < 3; x++) {
            System.out.println("x=" + x);
        }

        int y = 1;
        for (System.out.println('a'); y < 3; System.out.println('d'), y++) {
            System.out.println('c');
            //y++;
        }

        int z = 0;
        for (; z < 3; ) {
            System.out.println("z=" + z);
            z++;
        }

        //写一个循环，统计1-100之间是7的倍数的次数
        int count = 0;
        for (int i = 1; i <= 100; i++) {
            if (i % 7 == 0) {
                count++;
                System.out.println("count = " + count + ", i = " + i);
            }
        }
        System.out.println("1-100之间7的倍数出现的次数为：" + count);

        //实现问题2中的图形
        System.out.println("---------方法一：-------");
        int n1 = 6;
        for (int i1 = 0; i1 < 6; i1++) {          //外循环控制行数，内循环控制每行的元素个数。
            for (int j1 = 0; j1 < n1; j1++) {
                System.out.print('*');
            }
            System.out.println();
            n1--;
        }

        System.out.println("---------方法二：-------");
        int n2 = 0;
        for (int i2 = 0; i2 < 6; i2++) {
            for (int j2 = n2; j2 < 6; j2++) {
                System.out.print('*');
            }
            System.out.println();
            n2++;
        }

        System.out.println("---------方法三：-------");
        for(int i3 = 0; i3 < 6; i3++) {
            for (int j3 = i3; j3 < 6; j3++) {
                System.out.print('*');
            }
            System.out.println();
        }

        System.out.println("---------正三角形-------");
        for(int m = 0; m < 6; m++) {
            for (int n = 0; n <= m; n++) {
                System.out.print('*');
            }
            System.out.println();
        }
    }
}
