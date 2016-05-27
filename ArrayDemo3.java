/**
 * Created by wmy_one on 2016/5/27.
 * 这一节将会简单的介绍Java中，如何实现进制之间的转换。
 * 1）使用原始的除2取余法，实现十进制——>二进制
 * 思路：
 * 1、定义一个函数，使用原始的除2取余法实现十进制——>二进制；
 * 2、由于使用除2取余法，所以将会有一些数据，这里使用StringBuffer对象进行存储；
 * 3、先进行取余操作，获得最后一位数据，并使用StringBuffer对象的append()方法存储；
 * 4、将原十进制数进行除2操作，是为了获得下次进行取余运算的值；
 * 5、以此类推，直到除2后的结果为0为止，使用StringBuffer对象的reverse()方法
 * 将存储的数据反向输出，即可得到相应的二进制形式。
 * 2）使用和15进行与运算以及右移运算，实现十进制——>十六进制
 * 思路：
 * 1、定义一个函数，使用&15和>>>运算实现十进制——>十六进制转换；
 * 2、定义一个StringBuffer对象用于存储每次运算后的结果；
 * 3、由于不确定运算的次数，选择for循环结构，因为是int类型，共32位，每四位一组，
 * 所以，判断的条件为：for(int i=0;i<8;i++){}
 * 4、以此类推，直到运算结束；
 */
public class ArrayDemo3 {
    public static void main (String args[]){
        toBin(8);       //此方法仅仅可以用来计算正数的转换
        toBin_2(-6);     //此方法正数和负数均可
        toHex(60);
        toHex_2(-60);
        toOctal(60);   //十进制——>八进制
    }

    //定义一个功能：使用原始的除2取余法，实现十进制——>二进制；方法一
    public static void toBin(int num){
        StringBuffer stb = new StringBuffer(); //这是在声明一个对象，用于存储数据
        while(num>0){
            stb.append(num%2);    //使用该对象的append()方法添加数据
            num = num/2;
        }
        System.out.println(stb.reverse());  //使用该对象的reverse()方法反转数据
    }

    //定义一个功能：将二进制对应的数据存放在数组中，使用查表算法，实现十进制——>二进制；方法二
    public static void toBin_2(int num){
        /*
        char [] ch = {'0','1'};
        char [] arr = new char [32];
        int pos = arr.length;

        while(num != 0){
            int temp = num & 1;
            arr[--pos] = ch[temp];
            num = num >>> 1;
        }
        for (int i=pos; i<arr.length; i++)
            System.out.print(arr[i]);
        System.out.println();
        */
        transFun(num,1,1);
    }

    //定义一个功能：使用&15和>>>4运算，实现十进制——>十六进制；方法一
    public static void toHex(int num){
        StringBuffer stb = new StringBuffer();
        for (int i=0; i<8; i++){
            int temp = num & 15;
            if (temp > 9)
                stb.append((char)(temp-10+'A'));
            else
                stb.append(temp);
            num = num >>> 4;
        }
        System.out.println(stb.reverse());
    }

    //定义一个功能：将十六进制对应的数据存在数组中，使用查表算法，实现十进制——>十六进制；方法二
    public static void toHex_2(int num){
        /*
        char [] ch = {'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
        char [] arr = new char [8];
        int pos=arr.length;

        while(num != 0){
            int temp = num & 15;
            arr[--pos] = ch[temp];
            num = num >>> 4;
        }
        for (int i=pos; i<arr.length; i++)
            System.out.print(arr[i]);
        System.out.println();
        */
        transFun(num,15,4);
    }

    //定义一个功能：使用下面封装的模块，实现十进制——>八进制
    public static void toOctal(int num){
        transFun(num,7,3);
    }

    //定义一个功能：将上述两个方法二中相同的部分抽取出来，封装成一个模块，方便今后使用
    public static void transFun(int num, int base, int offset){
        if (num == 0){
            System.out.println(num);
            return;
        }
        char [] ch = {'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
        char [] arr = new char [32];
        int pos = arr.length;

        while (num != 0){
            int temp = num & base;
            arr[--pos] = ch[temp];
            num = num >>> offset;
        }
        for (int i=pos; i<arr.length; i++)
            System.out.print(arr[i]);
        System.out.println();
    }

}
