/**
 * Created by wmy_one on 2016/6/9.
 * 这一节将会创建一个对数据进行操作的工具类，方便其他程序进行调用
 *
 * 静态的应用：
 * 如果每个应用程序中都有共性的功能，可以将这些功能进行抽取，独立封装，方便复用；
 *
 * 虽然可以通过建立对象使用类中的这些工具方法，对数组进行操作，但是由于：
 * 1、对象是用来封装数据的，然而ArrayTool对象并没有封装特有数据；
 * 2、操作数组所使用的每个方法也没有用到ArrayTool对象中的特有数据；
 *
 * 此时，为了程序的严谨性，是不用建立对象的，可以将ArrayTool中的方法都用static修饰，直接通过类名调用；
 *
 * 将方法都static后，仍然可以被其他程序建立对象，进行使用，由于类对象的创建需要构造函数，
 * 此时，为了强制让类不能建立对象，可以将构造函数私有化来完成。
 */

//定义一个ArrayTool类，用于对数组进行操作，并独立创建，该类可以在其他程序中调用
class ArrayTool {
    private ArrayTool(){};  //为了增加类的严谨性，才将其构造函数私有化，仅仅能通过类名调用，而不能创建对象

   //创建一个方法，实现取出数组中最大值的功能，由于该方法没有用到类中特有的数据，因此，使用static修饰
    public static int getMax(int[] arr){
        int max = 0;
        for (int i=0; i<arr.length; i++){
            if (arr[i] > arr[max])
                max = i;
        }
        return arr[max];
    }

   //创建一个方法，实现取出数组中最小值的功能，由于该方法没有用到类中特有的数据，因此，使用static修饰
    public static int getMin(int[] arr){
        int min = 0;
        for (int i=0; i<arr.length; i++){
            if (arr[i] < arr[min])
                min = i;
        }
        return arr[min];
    }

    //创建一个方法，实现对数组进行排序的功能，由于该方法没有用到类中特有的数据，因此，使用static修饰
    public static void selectSort(int[] arr){
        for (int i=0; i<arr.length-1; i++){
            for (int j=i; j<arr.length; j++){
                if (arr[i] > arr[j])
                    swapFun(arr,i,j);
            }
        }
    }

    //创建一个方法，实现对数组使用冒泡法进行排序的功能，由于该方法没有用到类中特有的数据，因此，使用static修饰
    public static void bubleSort(int[] arr){
        for (int i=0; i<arr.length-1; i++){
            for (int j=0; j<arr.length-i-1; j++){
                if (arr[j] > arr[j+1])
                    swapFun(arr, j, j+1);
            }
        }
    }

    //创建一个方法，用于交换数组中两个元素的值，由于该方法仅仅提供给内部方法使用，而不提供给外部，所以使用private修饰
    private static void swapFun(int[] arr, int a, int b){
        int temp;
        temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    //创建一个方法，用于将将数组中的元素打印出来
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
