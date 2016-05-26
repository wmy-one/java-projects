/**
 * Created by wmy_one on 2016/5/26.
 * 这一节将会简单的介绍Java中的数组排序算法。
 * 1）选择排序算法
 * 步骤：
 * 1、定义一个函数，实现数组排序；
 * 2、将数组中的第一个元素和其他元素相比，将最小的元素和第一个元素交换位置；
 * 3、将第二个元素和之后的元素进行比较，将比它小的元素和该元素交换位置；
 * 4、以此类推，直到把整个数组中的元素都比较完。
 * 2）冒泡排序算法
 * 步骤：
 * 1、定义一个函数，实现数组排序；
 * 2、将数组中的第一个元素和第二个元素比较，若条件符合，交换他们的位置；
 * 3、将数组中的第二个元素和第三个元素比较，若条件符合，交换他们的位置；
 * 4、以此类推，直到把整个数组中的元素都比较完。
 *
 * 注意：冒泡排序仅仅将数组中的相邻元素进行比较；第一圈运行完后，最值放在了最后。
 * 3）使用Java中已经定义好的排序方式，格式如下：
 * import java.util.*;
 * Arrays.sort(arr);
 *
 * 注意：开发中，要对数组排序，常使用3）中的语句代码
 * 4）使用折中算法查找数组中的元素
 * 1、先将数组中的元素进行排序；
 * 2、将数组的中间元素与查找值进行比较；
 * 3、若查找值比数组中的中间元素大，则在数组中间元素的右半部分进行查找，否则，在左半部分查找
 * 4、以此类推，直到找到对应的值，并返回该元素对应的角标，若没找到，则返回-1。
 */

public class ArrayDemo2 {
    public static void main (String args[]){
        int [] arr = {3,1,4,1,5,9,2,6};
        //排序前，打印数组中的元素
        arrayPrint(arr);
        //选择排序
        //arraySelectSort(arr);
        //冒泡排序
        arrayBubbleSort(arr);
        //排序后，打印数组中的元素
        arrayPrint(arr);

        int [] a = {1,2,3,6,8,9};
        int index = halfSearch(a,8);
        System.out.println("index = "+index);

        int index_1 = indexFun(a,8);
        System.out.println("search index_1 = "+index_1);
        int index_2 = indexFun_2(a,8);
        System.out.println("insert place = "+index_2);
    }

    //定义一个功能：用于打印数组中的元素，并在同一行显示
    public static void arrayPrint(int [] arr){
        for (int i=0; i<arr.length; i++){
            if (i != arr.length -1)
                System.out.print(arr[i]+", ");
            else
                System.out.println(arr[i]);
        }
    }

    //定义一个功能：用于对数组中的元素进行排序，此处使用的是选择排序
    public static void arraySelectSort(int [] arr){
        for (int i=0; i<arr.length-1; i++){
            for (int j=i+1; j<arr.length; j++){
                /*
                int temp;
                if (arr[i] > arr[j]){

                    temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
                */
                swapFun(arr,i,j);
            }
        }
    }

    //定义一个功能：用于对数组中的元素进行排序，次数使用的是冒泡排序
    public static void arrayBubbleSort (int [] arr){
        for (int i=0; i<arr.length-1; i++){
            for (int j=0; j<arr.length-i-1; j++){   //-i：让每次比较的元素减少，-1：避免角标越界
                /*
                int temp;
                if (arr[j] > arr[j+1]){
                    temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
                */
                swapFun(arr,j,j+1);
            }
        }
    }

    //定义一个功能：用于对数组中的两个元素交换位置
    public static void swapFun(int [] arr, int a, int b){
        int temp;
        if (arr[a] > arr[b]) {
            temp = arr[a];
            arr[a] = arr[b];
            arr[b] = temp;
        }
    }

    //定义一个功能：用于查找数组中的元素对应的角标
    public static int indexFun(int [] arr, int key){  //此方法仅仅找到数组中第一个找到的元素对应的角标
        for (int i=0; i<arr.length; i++){
            if (arr[i] == key)
                return i;
        }
        return -1;
    }

    //定义一个功能：使用折中算法查找数组中的元素对应的角标
    public static int halfSearch(int [] arr, int key){
        int min, max, mid;
        min = 0;
        max = arr.length-1;
        mid = (min + max)/2;

        while(arr[mid] != key){
            if (key > arr[mid])
                min = mid + 1;
            else if (key < arr[mid])
                    max =mid - 1;
            if (min > max)
                return -1;
            mid = (min + max)/2;
        }
        return mid;
    }

    //定义一个功能：用于获取一个数值在有序的数组中插入的位置，并保证插入后，数组仍有序
    public static int indexFun_2(int [] arr, int key){
        int min=0, max=arr.length-1, mid;
        while(min <= max){
            mid = (min + max)/2;
            if (key > arr[mid])
                min = mid + 1;
            else if (key < arr[mid])
                max =mid - 1;
            else
                return mid;
        }
        return min;
    }

}
