/*
1、I/O知识
Java对数据的操作通过流的方式，I/O流用来处理设备之间的数据传输；
字节流的抽象基类：InpuStream、OutputStream
字符流的抽象基类：Reader、Writer

注意：由这四个类派生出来的子类名称，都是以其父类名作为子类名的后缀。

2）字符流的特点：
需求：在硬盘上，创建一个文件并写入一些文字数据。
找到一个专门用于操作文件的Writer子类对象：FileWriter；前缀名是该流对象的功能。

3）IO异常的处理方式
*/

import java.io.*;
class  FileWriterDemo
{
	public static void main(String[] args) throw IOException
	{
		FileWriter fw = null;  //使FileWriter对象作用于整个文件
		try
		{
			//创建一个FileWriter对象，该对象一被初始化就必须要明确被操作的文件
			//该文件会被创建到指定目录下，如果该目录下有同名文件，将被覆盖掉。
			fw = new FileWriter("Demo.txt");

			//调用write方法，将字符串写入到流中
			fw.write("abcdef");
			
			//刷新流对象中的缓冲的数据，将该数据刷新到对应的文件中。
			//fw.flush();

			/*
			关闭流资源，但是在关闭之前，将刷新一次内部缓冲的数据，将数据刷新到目的地中；
			和flush的区别：flush刷新后，流可以继续使用，close刷新后，会将流关闭。
			*/
			//fw.close();
		}
		catch (IOException e)
		{
			System.out.println(e.toString());
		}
		finally
		{
			try
			{
				if(fw != null)
					fw.close();  //此语句也将会抛出IOException异常
			}
			catch (IOException e)
			{
				System.out.println(e.toString());
			}		
		}
	}
}
