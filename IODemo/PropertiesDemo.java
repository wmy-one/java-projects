/*
properties是hashtable的子类；也就是说它具备map集合的特点，
而且它里面存储的键值对都是字符串；是集合中和IO技术结合的集合容器。

该对象的特点：
可以用于键值对形式的配置文件。
在加载数据时，需要数据有固定格式：键=值
*/

import java.io.*;
import java.util.*;

class PropertiesDemo
{
	public static void main(String[] args) throws IOException
	{
		setAndGet();
		method();
		loadDemo();
	}

	//演示：如何将流中的数据存储到集合中
	public static void loadDemo() throws IOException
	{
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream("info.txt");
		
		//将流中的数据加载进集合
		prop.load(fis);
		
		prop.setProperty("David","25");  //将键为David的值改为25，仅仅改变内存中的内容

		FileOutputStream fos = new FileOutputStream("info.txt");
		prop.store(fos,"zhushi"); //将propterty设置信息保存到文件中，并添加注释信息

		System.out.print(prop);  //打印集合中的数据
		prop.list(System.out);  //将输出流列出来

		fos.close();
		fis.close();
	}	

	//想要将info.txt中键值数据存到集合中进行操作；思路：
	/*
	1、用一个流和info.txt文件关联；
	2、读取一行数据，将该行数据用“=”进行切割；
	3、等号左边作为键，右边作为值，存入的properties集合中即可。
	*/
	public static void method() throws IOException
	{
		BufferedReader bufr = new BufferedReader(new FileReader("info.txt"));
		
		String line=null;

		Properties prop = new Properties();

		while((line=bufr.readLine()) != null)
		{
			String[] arr = line.split("=");
			//System.out.println(arr[0]+"..."+arr[1]);
			prop.setProperty(arr[0],arr[1]);
		}

		bufr.close();
		System.out.println(prop);
	}

	//设置和获取元素
	public static void setAndGet()
	{
		Properties prop = new Properties();

		prop.setProperty("Jhon","25");  //通过setProperty设置姓名和年龄信息
		prop.setProperty("Tom","30");
	
		//System.out.println(prop);
		String value = prop.getProperty("Jhon"); //通过getProperty获取键为john的值
		System.out.println(value);

		set<String> names = prop.stringPropertyName(); //返回键集合——set集合内容为String
		for(String s : names)
		{
			System.out.println(s+":"+prop.getProperty(s));
		}
	}

	/*
	用于记录应用程序运行次数，如果使用次数已到，此时给出注册提示。

	很容易想到的是计数器，可是计数器定义在程序中，随着程序的运行而在内存中存在，
	并进了自增；可是随着该应用程序的退出，该计数器也在内存中消失。

	下一次在启动改程序，又重新开始从0计数，这不是我们想要的。

	程序即使结束，该计数器的值也存在，下次程序启动会先加载该计数器的值，
	并加1后重新存储起来。所以，要建立一个配置文件，用于记录该软件的使用次数。

	该配置文件使用键值对的形式，这样便于阅读数据，并操作数据。

	键值对数据是map集合，数据是以文件形式存储，使用io技术，那么map+io -->properties。

	配置文件可以实现应用程序数据的共享。
	*/
	public static void method_1() throws IOException
	{
		Properties prop = new Properties();

		File f = new File("cpunt.properties"); //java中配置文件后缀是：xml和properties
		if(!f.exists())
			f.createNewFile();  //创建文件

		FileInputStream fis = new FileInputStream(f);

		prop.load(fis);  //将流中的数据加载进集合
		
		int count = 0;
		String value = prop.getProperty("time"); //获取键为time对应的值

		if(value != null)
		{
			count = Integer.perseInt(value);  //将String转为int
			if(count >=5)
			{
				System.out.println("您好！使用次数已到，请注册！");
			    return;
			}
		}

		count++;

		prop.setProperty("time",count+""); //修改键和值

		FileOutputStream fos = new FileOutputStream(f);

		prop.store(fos,"");  //将prop信息保存到文件中

		fos.close();
		fis.close();
	}
}
