/*
1）System：类中的属性和方法都是静态的，不能被实例化。
out：标准输出，默认是控制台；
in：标准输入，默认是键盘；

描述系统的一些信息：获取系统属性信息：Properties getProperties();

2）Runtime对象
该类并没有提供构造函数，说明不可以new对象，直接想到该类中的方法都是静态的；
但是查阅API发现该类中还有非静态方法，说明该类肯定会提供方法获取本类对象，
而且该方法是静态的，返回值类型是本类类型；

由这个特点可以看出该类使用了单例设计模式来完成；
该方法是static Runtime getRuntime();
*/

import java.util.*;  //System和Date类需要导入此包
import java.text.*;  //Date类需要带入此包

class SystemDemo 
{
	public static void main(String[] args) 
	{
		Properties prop = System.getProperties();
		
		/*
		因为Properties是Hashtable的子类，也是Map集合的一个子类对象
		此时，可以通过map的方法取出该集合中的元素；
		该集合中存储的都是字符串，没有反省定义。
		*/
		
		//获取所有属性信息
		for(Object obj : prop.keySet())
		{
			String value = (String)prop.get(obj);
			System.out.println(obj+"::"+value);
		}

		//如何在系统中自定义一些特有信息
		System.setProperty("mykey","myvalue");

		//获取指定属性信息
		String value = System.getProperty("os.name");	
		System.out.println("value="+value);

		//如何在jvm启动时，动态加载一些属性信息
		String v = System.getProperty("wmy");
		System.out.println("v="+v);  //可以在dos中使用-D<name>=<value> 获取


		Runtime r = Runtime.getRuntime();
		//r.exec("C:\\winmine.exe");
		Process p = r.exec("C:\\winmine.exe");

		Thread.sleep(4000);  //等待4s
		p.destroy();  //杀掉进程


		Date d = new Date();
		System.out.println(d);  //打印的时间格式不明确，希望有些格式

		//将模式封装到SimpleDateformat对象中
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 E hh:mm:ss");

		//调用format方法让模式格式化指定date对象
		String time = sdf.format(d);

		System.out.println("time= "+time);

	}
}
