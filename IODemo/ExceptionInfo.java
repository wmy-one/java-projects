/*
java中有一个工具：log4j，有很多对象，方便建立java日志文件。
*/

import java.io.*;
import java.util.*;
import java.text.*;

class ExceptionInfo 
{
	public static void main(String[] args) throws IOException
	{
		//创建系统信息日志文件
		Properties prop = System.getProperties();
		//System.out.println(prop);   //直接将系统信息打印到控制台

		prop.list(new PrintStream("sysinfo.txt"));  //将系统信息输出到文件中

		//创建IO异常日志文件
		try
		{
			int[] arr = new int[2];
			System.out.println(arr[3]);
		}
		catch (Exception e)
		{
			//e.printStackTrace(new PrintStream("a.txt"));
			try
			{
				//格式化当前时间
				Date d = new Date();
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				String s = sdf.format(d);

				PrintStream ps = new PrintStream("exception.log")); //创建日志文件
				ps.println(s);
				System.setOut(ps);  //设置输出流
			}
			catch (IOException ex)
			{
				throw RuntimeException("日志文件创建失败！");
			}
			ps.close();
			e.printStackTrace(System.out);
		}

	}
}
