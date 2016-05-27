/**
 * Created by wmy_one on 2016/5/27.
 * 这一节中将会简单的介绍Java中的二维数组。
 * 1）二维数组的格式：
 * int [][] arr = new int [3][2];
 * 此格式，表示定义了一个二维数组，有3个一维数组组成，每个一维数组有2个元素，每个元素的初始化值为：0；
 * int [][] = arr new int [3][];
 * 此格式，每个一维数组没有任何小数组指向，因为数组是引用数据类型，默认初始化值为：null；可以使用下面的格式初始化：
 * arr[0] = new int [2];    //表示重新在内存中产生了一个小数组，并将该小数组在内存中的地址值赋值给arr[0]；
 * arr[1] = new int [1];
 * arr[2] = new int [3];
 * 这时，每个一维数组的元素初始化值为：0；并且这是一个不规则的二维数组。
 *
 * 2）二维数组的内存结构
 * int [][] arr = new int [3][2];  //定义二维数组的过程中已经初始化，初始化值为：0.
 * System.out.println(arr);        结果为：[[I@74a14482  //[[表示二维数组，在内存中的地址值为：74a14482
 * System.out.println(arr[1]);     结果为：[I@1540e19d   //[表示一维数组，指向的一维小数组对应的地址值为：1540e19d
 *
 * int [][] = arr new int [3][];   //定义二维数组的过程中并没有初始化，默认初始化值为：null。
 * System.out.println(arr);        结果为：[[I@74a14482
 * System.out.println(arr[1]);     结果为：null     //null表示一维数组没有指向任何小数组，没有地址值，默认值为：null
 *
 * 3）注意：
 * 对于一个二维数组arr，arr[]的值为内存中的地址值，默认初始化值为：null；
 * arr[][]的值为元素对应的值，默认初始化值为：0.
 *
 * 4）一些一维数组和二维数组的非常见定义：
 * 一维数组的定义：int [] x; int x[];
 * 二维数组的定义：int [][] y; int y[][]; int [] y[];
 *
 * int [] x,y[];    //x是一维数组，y是二维数组；
 *
 * ①、x[0] = y;         //error
 * ②、y[0] = x;        //yes
 * ③、y[0][0] = x;     //error
 * ④、x[0][0] = y;     //error
 * ⑤、y[0][0] = x[0];  //yes
 * ⑥、x = y;           //error
 */
public class ArrayDemo4 {
    public static void main (String args[]){
        int [][] arr = new int [3][2];

        System.out.println(arr);
        System.out.println(arr[1]);
        System.out.println(arr[0][1]);

        System.out.println(arr.length);      //打印的是二维数组的长度
        System.out.println(arr[0].length);  //打印的是二维数组中第一个一维数组的长度

        int [][] a = new int [3][];

        System.out.println(a);
        System.out.println(a[1]);
        //System.out.println(a[0][1]);  //此写法将会编译不通过，因为定义的二维数组并没有初始化，故没有值

        int [][] b = new int [3][];
        b[0] = new int [2];   //对二维数组手动初始化
        b[1] = new int [1];
        b[2] = new int [3];

        System.out.println(b);
        System.out.println(b[1]);
        System.out.println(b[0][1]);

        int [][] c = {{1,2,3},{4,5,6},{7,8,9}};
        int sum = 0;

        for (int i=0; i<3; i++){
            for (int j=0; j<3; j++){
                sum += c[i][j];
            }
        }
        System.out.println("sum = "+sum);
    }
}
