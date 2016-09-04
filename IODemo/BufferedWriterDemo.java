/*
1）字符串写入流缓冲区：
缓冲区的出现是为了提高流的操作效率而出现的，所以在创建缓冲区之前，必须要先有流对象。

该缓冲区中提供了一个跨平台的换行符：newLine();

2）字符串读取流缓冲区:
该缓冲区提供了一个一次读取一行的方法：readLine(); 方便对文本数据的获取；
当返回null时，表示读到文件末尾。

readLine方法的原理：
无论读取一行，还是读取多个字符，其实最终都是在硬盘上一个一个的读取，
所以最终使用的还是read方法一次读取一个的方法。

注意：
readLine方法返回的时候，只返回回车符之前的数据内容，并不返回回车符。

3）通过缓冲区复制一个.Java文件
*/

import java.io.*;

class  BufferedDemo
{
	public static void main(String[] args) throw IOException
	{
		System.out.println("Hello World!");
		//创建一个字符写入流对象
		FileWriter fw = new FileWriter("buf.txt");

		//为了提高字符写入流的效率，加入了缓冲技术
		//此时，只需将需要被提高效率的流对象作为参数，传给缓冲区的构造函数即可
		BufferedWriter bufw = new BufferedWriter(fw);

		bufw.wite("abcd");
		bufw.newLine();  //表示加入换行符

		//注意：只要用到缓冲区，就要记得刷新
		bufw.flush();
		
		//其实关闭缓冲区，就是在关闭缓冲区中的流对象
		bufw.close();


		//创建一个读取流对象和文件相关联
		FileReader fr = new FileReader("buf.txt");

		//为了提高效率，加入缓冲技术，将字符读取流对象作为参数，传给缓冲对象的构造函数
		BufferedReader bufr = new BufferedReader(fr);
		
		String line = null;

		while((line = bufr.readLine() != null))
		{
			//String s1 = bufr.readLine();  //读取一行数据
			System.out.println("line="+line);
		}

		bufr.close();

		//通过缓冲区复制一个.java文件
		BufferedWriter bufw1 = null;
		BufferedReader bufr1 = null;

		try
		{
			bufr1 = new BufferedReader(new FileReader("text.java"));
			bufw1 = new BufferedWriter(new FileWriter("copyText.java"));

			String line = null;

			while((line = bufr1.readLine() != null))
			{
				bufw1.write(line);
				bufw1.newLine();  //加入换行符
				bufw1.flush();
			}
		}
		catch (IOException e)
		{
			throw new RuntimeException("读写失败！");
		}
		finally
		{
			if(bufr1 != null)
				try
				{
					bufr1.close();
				}
				catch (IOException e)
				{
					throw new RuntimeException("读取失败！");
				}

			if(bufw1 != null)
				try
				{
					bufw1.close();
				}
				catch (IOException e)
				{
					throw new RuntimeException("写入失败！");
				}
		}
	}
}
