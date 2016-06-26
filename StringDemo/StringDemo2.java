/**
 * Created by wmy_one on 2016/6/26.
 * 1）需求：模拟一个trim方法，去除字符串两端的空格
 * 思路：
 * 1、判断字符串第一个位置是否是空格，如果是继续向下判断，直到不是空格为止；结尾处判断空格也是如此；
 * 2、当开始和结尾处都判断到不是空格时，就是要获取的字符串；
 * 3、要保证开始开始判断的位置小于等于结尾判断的位置，否则无意义。
 *
 * 2）需求：将一个字符串进行反转；将字符串中指定部分进行反转，"abcdef"变为："abcfed"
 * 思路：
 * 1、曾经学习过将数组的元素进行反转；
 * 2、将字符串变成数组，在进行反转；
 * 3、将反转后的数组变成字符串；
 * 4、只要将字符串中指定部分的开始和结束为止作为参数传递，进行反转即可。
 *
 * 3）需求：获取一个字符串在另一个字符串中出现的次数，"abcdefabcqwemn"
 * 思路：
 * 1、定义一个计数器；
 * 2、获取abc第一次出现的位置；
 * 3、从第一次出现位置后剩余的字符串中继续获取abc出现的位置；每获取一次更新一次计数器的值；
 * 4、当获取不到时，计数完成。
 *
 * 4）需求：获取两个字符串中最大相同子串
 * 思路：
 * 1、将短的字符串按照长度递减的方式获取到；
 * 2、将每次获取到的子串去长串中判断是否包含；如果包含，表示已经找到。
 *
 */
public class StringDemo2 {
    public static void main(String[] args)
    {
        String s1 = "  Hello world   ";
        printFun(s1);   //打印原来的字符串
        printFun(myTrim(s1));  //调用printFun函数，将经过myTrim函数处理过的字符串打印出来

        String s2 = "  abc def  ";
        printFun(s2);   //打印原来的字符串
        String s = stringReverse(s2,2,8);   //从字符串s2角标为2开始到角标为9的字符进行反转，不包括角标9对应的字符
        printFun(s);  //打印处理后的字符串

        String ss = stringReverse(s2);  //将字符串s2进行反转
        printFun(ss);

        String s3 = "abcdefabcqwemn";
        String s4 = "abc";
       int sss = getSubCount(s3,s4);   //统计s4在s3中出现的次数
        printFun(sss);

        String s5 = "asdfhelloqwer";
        String s6 = "mnhellozx";
        printFun(getMaxSubString(s5,s6));  //打印两个字符串中最大相同的子串
    }

    /**
     * 定义一个printFun函数，用于将传进来的数据打印出来
     * @param obj   接收一个Object类类型的变量，其他类型的变量将会进行类型提升
     */
    public static void printFun(Object obj)
    {
        System.out.println(obj);
    }

    //示例1：
    /**
     * 定义一个myTrim函数，用于模拟trim方法，去除字符串两端的空格
     * @param str  接收一个字符串，进行去除两端空格的处理
     * @return  返回处理后的字符串
     */
    public static String myTrim(String str)
    {
        int start = 0, end = str.length()-1;

        //此循环用于判断字符串是否是以空格开始
        while(start <= end && str.charAt(start) == ' ')
            start++;

        //此循环用于判断字符串是否是以空格结尾
        while(start <= end && str.charAt(end) == ' ')
            end--;

        return str.substring(start,end+1);
    }

    //示例2：
    /**
     * 定义一个stringReverse函数，用于反转字符串指定位置部分的字符
     * @param str    接受一个字符串str参数
     * @param start  接受一个start参数，表示反转的起始位置
     * @param end    接受一个end参数，表示反转的结束位置
     * @return     返回一个处理后的字符串
     */
    public static String stringReverse(String str, int start, int end)
    {
        //将字符串转为数组
        char[] arr = str.toCharArray();

        //将数组进行反转
        reverse(arr,start,end);

        //将数组转为字符串
        return new String(arr);
    }

    /**
     * 定义一个stringReverse函数，用于反转字符串
     * @param str   接受一个字符串类型的str参数
     * @return   返回一个处理后的字符串
     */
    public static String stringReverse(String str)
    {
        String s = stringReverse(str,0,str.length());
        return s;
    }

    /**
     * 定义一个reverse函数，将数组进行反转
     * @param arr  接受一个数组参数
     * @param x   接受一个int类型参数x，表示反转的起始位置
     * @param y   接受一个int类型参数y，表示反转的结束位置
     */
    private static void reverse(char[] arr, int x, int y)
    {
        for(int start=x,end=y-1; start<end; start++,end--)
        {
            swap(arr, start, end);
        }
    }

    /**
     * 定义一个swap函数，用于将换数组中两个元素的位置
     * @param arr  表示需要交换元素的数组
     * @param x   表示要交换的数组元素对应的角标x
     * @param y   表示要交换的数组元素对应的角标y
     */
    private static void swap(char[] arr, int x, int y)
    {
        char temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }

    //示例3：
    /**
     * 定义一个getSubCount函数，用于统计一个字符串在另一个字符串中出现的次数
     * @param str  接收一个String类型的str参数
     * @param subStr  接收一个String类型的substr参数
     * @return  返回统计的次数
     */
    public static int getSubCount(String str, String subStr)
    {
        int count = 0, index = 0;

        //此循环，每次获取subStr的索引值，就获取一次子串，并更新计数器
        while((index = str.indexOf(subStr)) != -1)
        {
            str = str.substring(index+subStr.length());
            count++;
        }
        /*
        方式二：   //此方式不用每次在内存中创建子串，浪费资源
        while((index = str.indexOf(subStr,index)) != -1)
        {
            index = index + subStr.length();
            count++;
        }
         */
        return count;
    }

    //示例4：
    /**
     * 定义一个getMaxSubString函数，用于获取两个字符串中最大相同的子串
     * @param s1   接收一个String类型的s1参数
     * @param s2   接收一个String类型的s2参数
     * @return  返回最大相同的子串
     */
    public static String getMaxSubString(String s1, String s2)
    {
        //用于判断s1和s2中最长的字符串
        String max = "", min = "";
        max = (s1.length() > s2.length())? s1:s2;
        min = (max == s1) ? s2:s1;

        //此循环，用于每次判断取最短字符串的子串去和另一个字符串比较，直到找到最大相同子串
        for(int i=0; i<min.length(); i++)
        {
            for(int x=0, y=min.length()-i; y!= min.length()+1; x++,y++)
            {
                String temp = min.substring(x,y);
                if(max.contains(temp))  //if(max.indexOf(temp) !=-1)
                    return temp;
            }
        }
        return "";
    }
}
