/**
 * Created by wmy_one on 2016/6/9.
 * 这一节将会简单的介绍如何写Java的说明文档。
 *例如写下面的ArrayTool类文件的说明文档：
 * 1）我们编译完ArrayTool类后，生成ArrayTool.class文件，然后，将此文件发送给其他人，这时，其他人
 *    将该文件放置在classpath路径下（可在dos窗口中，使用命令设置：set classpath=.:d:\myhelp），就可以使用该工具类了，
 *    但是，他们并不知道该类中到底定义了多少方法，不清楚如何使用，因为，该类并没有说明文档。
 *
 * 2）Java的程序说明书通过文档注释来完成
 *
 * 3）写好说明文档后，制作方法：
 * 在dos窗口中，使用命令为：javadoc -d myhelp -author -version ArrayTool.java即可生成说明文档。
 *
 * 注意：要写成说明文档，该类必须被public修饰，才能生成说明文档，否则将报错。
 *
 * 4）一个类中默认会有一个空参数的构造函数，这个默认的构造函数的权限和所属类一致；
 * 如果类被public所修饰，那么默认的构造函数也被public修饰；否则，默认构造函数不带public修饰符。
 */


/**
 * 这是一个可以对数组进行操作的工具类，该类中提供了获取最值、排序等功能
 * @author wmy_one
 * @version V1.1
 */
class ArrayTool {   //要生成说明文档，必须将左边的类写成：public ArrayTool，并且文件名也是ArrayTool

    /**
     * 空参数构造函数。
     */
    private ArrayTool(){};

    /**
     * 获取一个整形数组中的最大值。
     * @param arr 接收一个int类型的数组。
     * @return 将会返回一个该数组中的最大值。
     */
    public static int getMax(int[] arr){
        int max = 0;
        for (int i=0; i<arr.length; i++){
            if (arr[i] > arr[max])
                max = i;
        }
        return arr[max];
    }

    /**
     * 获取一个整形数组中的最小值。
     * @param arr 接收一个int类型的数组。
     * @return  将会返回一个该数组中的最小值。
     */
    public static int getMin(int[] arr){
        int min = 0;
        for (int i=0; i<arr.length; i++){
            if (arr[i] < arr[min])
                min = i;
        }
        return arr[min];
    }

    /**
     * 将数组中的元素使用选择排序法，进行排序。
     * @param arr  接收一个int类型的数组。
     */
    public static void selectSort(int[] arr){
        for (int i=0; i<arr.length-1; i++){
            for (int j=i; j<arr.length; j++){
                if (arr[i] > arr[j])
                    swapFun(arr,i,j);
            }
        }
    }

    /**
     * 将数组中的元素使用冒泡排序法，进行排序。
     * @param arr  接收一个int类型的数组。
     */
    public static void bubleSort(int[] arr){
        for (int i=0; i<arr.length-1; i++){
            for (int j=0; j<arr.length-i-1; j++){
                if (arr[j] > arr[j+1])
                    swapFun(arr, j, j+1);
            }
        }
    }

    /**
     * 将数组中的元素进行位置置换。
     * @param arr  接收一个int类型的数组。
     * @param a  要置换的位置
     * @param b  要置换的位置
     */
    private static void swapFun(int[] arr, int a, int b){
        int temp;
        temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    /**
     * 用于打印数组中的元素，打印格式：[element1, element2, ……]
     * @param arr  接收一个int类型的数组。
     */
    public static void printFun(int[] arr){
        System.out.print("[");
        for (int i=0; i<arr.length; i++){
            if (i != arr.length-1)
                System.out.print(arr[i]+", ");
            else
                System.out.println(arr[i]+"]");
        }
    }

}
