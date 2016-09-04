/*
将C盘中的一个文件复制到D盘；
原理：
其实就是讲C盘下的文件数据存储到D盘的一个文件中；
步骤:
1、在D盘创建一个文件，用于存储C盘文件中的数据；
2、定义读取流和C盘文件关联；
3、通过不断的读写完成数据存储；
4、关闭资源。
*/

import java.io.*;

class  CopyText
{
	public static void main(String[] args) 
	{
		//copyFun1(); //此处调用含有异常的函数，因此主函数应该抛出异常

		copyFun2();
	}

	//方法二：
	public static void copyFun2()
	{
		FileWriter fw = null;  //定义引用
		FileReader fr = null;
		
		try
		{
			fw = new FileWriter("copytest.txt");  //初始化引用
			fr = new FileReader("text.txt");

			char[] buf = new char[1024]; //在内存中定义一个数组，用于存储读取的字符

			int len = 0;
			while((len=fr.read(buf) != -1))
			{
				fw.write(buf,0,len);
			}
		}
		catch (IOException e)
		{
			throw RuntimeException("读写失败！");
		}
		finally
		{
			if(fr != null)
				try
				{
					fr.close();
				}
				catch (IOException e)
				{
				}
			if(fw != null)
				try
				{
					fw.close();
				}
				catch (IOException e)
				{
				}
		}
	}

	//方法一：从C盘读取一个字符，就往D盘写一个字符
	public static void copyFun_1() throw IOException
	{
		//创建目的地
		FileWiter fw = new FileWriter("copytest.txt");

		//与已有文件关联
		FileReader fr = new FileReader("test.txt");

		int ch = 0;
		while((ch = fr.read()) != -1)
		{
			fw.write(ch);  //将读取的字符写入流中
		}

		fw.close();
		fr.close();
	}
}
