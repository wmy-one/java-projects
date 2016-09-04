/*
1、获取任意年二月份的天数
	思路：根据指定年设置一个时间就是：c.set(year,2,1);  //某一年的3月1日
	c.add(Calendar.DAY_OF_MONTH,-1);  //3月1日向前推一天，就是2月最后一天

2、获取昨天的现在这个时刻
	c.add(Calendar.DAY_OF_MONTH,-1);
*/
import java.util.*;

class CalendarDemo 
{
	public static void main(String[] args) 
	{
		Calendar c = Calendar.getInstance();

		//c.set(2018,2,25);
		c.add(Calendar.DAY_OF_MONTH,-1);

		printCalendar(c);
	}
	
	//定义一个用于打印的函数
	public static void printFun(Object obj)
	{
		System.out.println(obj);
	}

	//定义一个函数用于将设置的日期打印出来
	public static void printCalendar(Calendar c)
	{
		String [] mons = {"一月","二月","三月","四月",
						"五月","六月","七月","八月",
						"九月","十月","十一月","十二月"};

		String [] weeks = {"","星期日","星期一","星期二","星期三","星期四",
							"星期五","星期六"};

		Calendar c = Calendar.getInstance();

		int index = c.get(Calendar.MONTH);
		int index1 = c.get(Calendar.DAY_OF_MONTH);
		
		printFun(c.get(Calendar.YEAR)+"年");
		
		//printFun((c.get(Calendar.MONTH)+1)+"月");  //获取的月份是：0-11
		printFun(mons[index]);

		printFun(c.get(Calendar.DAY_OF_MONTH)+"日");

		//printFun(c.get(Calendar.DAY_OF_WEEK));
		printFun(weeks[index1]);
	}

	//定一个函数用于展示数学中的常见函数
	public static void showFun()
	{
		double d = Math.ceil(16.34);     //ceil返回大于指定值的最小整数
		double d1 = Math.floor(16.34);  //floor返回小于指定值的最大整数

		long L = Math.round(13.56);   //四舍五入
		double d2 = Math.pow(2,3);   //pow返回2的3次幂

		printFun("d="+d);
		printFun("d1="+d1);
		printFun("L="+L);
		printFun("d2="+d2);
		
		double dd = Math.random(); //随机产生一个0.0-1.0之间的数，不包括1.0
		printFun(dd);

		int dd1 = (int)(Math.random()*10+1);  //随机产生一个1-10之间的数
		printFun(dd1);

		//下面的方法需要导入java.util.Random
		Random r = new Random();
		int a = r.nextInt(10)+1;  //随机产生一个1-10之间的数
		printFun(a);
	}
}
