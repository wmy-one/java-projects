/*
打印流：
该流提供了打印方法，可以将各种数据类型的数据原样打印。
字节打印流： PrintStream
构造函数可以接收的参数类型：
1、file对象；
2、字符串路径；
3、字节输出流；OutputStream

字符打印流：PrintWriter   //比较常用，web开发中常常使用
构造函数可以接收的参数类型：
1、file对象；
2、字符串路径；
3、字节输出流；OutputStream
4、字符输出流：Writer

*/

import java.io.*;

class PrintStreamDemo
{
	public static void main(String[] args) 
	{
		BufferedReader bufr = new BufferedReader(new InputStreamReader(System.in));

		//PrintWriter out = new PrintWriter(System.out,true); //打印输出流
		PrintWriter out = new PrintWriter(new FileWriter("a.txt"),true); //写入文件

		String line = null;

		while((line=bufr.readLine()) != null)
		{
			if("over".equals(line))
				break;

			//out.write(line.toUpperCase());  //此写法，无换行
			out.println(line.toUpperCase());

			//out.flush();
		}

		out.close();
		bufr.close();
	}
}
