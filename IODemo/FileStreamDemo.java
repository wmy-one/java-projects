/*
字节流：
InputStream OutputStream

1、需求：想要操作图片数据，这时就要用到字节流。

2、复制一个图片：
思路：
1、用字节读取流对象和图片关联；
2、用字节写入流对象创建一个图片文件；
3、通过循环读写，完成数据的存储；
4、关闭资源。
*/

import java.io.*;

class  FileStreamDemo
{
	public static void main(String[] args) throws IOException
	{
		writeFile();
		readFile_1();
		readFile_2();
		readFile_3();

		//复制一个图片
		FileOutputStream fos = null;
		FileInputStream fis = null;
		try
		{
			fos = new FileOutputStream("D:\\2.bmp");
			fis = new FileInputStream("D:\\1.bmp");

			byte[] buf = new byte[1024];
			int len=0;

			while((len=fis.read(buf)) != -1)
			{
				fos.write(buf,0,len);
			}
		}
		catch (IOException e)
		{
			throw new RuntimeException("读写图片失败！");
		}
		finally
		{
			try
			{
				if(fis != null)
					fis.close();
			}
			catch (IOException e)
			{
				throw new RuntimeException("读取关闭失败！");
			}

			try
			{
				if(fos != null)
					fos.close();
			}
			catch (IOException e)
			{
				throw new RuntimeException("写入关闭失败！");
			}
		}
		
	}

	//方法三：定义一个readFile函数，用于将文件中的数据读取到字节流中
	public static void readFile_3() throws IOException
	{
		FileInputStream fis = new FileInputStream("fos.txt");
		
		//int num = fis.available();  //返回该文件中字节的个数（包括换行符）
		byte[] buf = new byte[fis.available()];

		fis.read(buf);

		System.out.println(new String(buf));  //将数组转为字符串并打印出来

		fis.close();
	}
	
	//方法二：定义一个readFile函数，用于将文件中的数据读取到字节流中
	public static void readFile_2() throws IOException
	{
		FileInputStream fis = new FileInputStream("fos.txt");
		
		byte[] buf = new byte[1024];
		int len=0;

		while((len=fis.read(buf)) != -1)  //将读取的数据缓冲在数组中
		{
			System.out.println(new String(buf,0,len));
		}
		fis.close();
	}

	//方法一：定义一个readFile函数，用于将文件中的数据读取到字节流中
	public static void readFile_1() throws IOException
	{
		FileInputStream fis = new FileInputStream("fos.txt");

		int ch = 0;
		while((ch=fis.read()) != -1)  //一个一个的读取字节
		{
			System.out.println((char)ch);
		}
		fis.close();
	}

	//定义一个writeFile函数，用于向文件中写入字节流中的数据
	public static void writeFile() throws IOException
	{
		FileOutputStream fos = new FileOutputStream("fos.txt");

		fos.write("abcdef".getBytes());

		fos.close();
	}
}
