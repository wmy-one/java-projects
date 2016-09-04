/*
1、演示Mp3的复制，通过字节流的缓冲区

2、自定义字节流的缓冲区
*/

import java.io.*;

//定义一个MyBufferedInputStream类，用于描述自定义字节流的缓冲区功能
class MyBufferedInputStream
{
	private InputStream in;
	private byte[] buf = new byte[1024*4];
	private int pos=0, count=0;

	MyBufferedInputStream(InputStream in)
	{
		this.in = in;
	}

	//一次读取一个字节，从缓冲区（字节数组）中获取
	public int myRead() throws IOException
	{
		//通过in对象读取字节流数据，并存储在buf中
		if(count == 0)  //此循环用于向缓冲区中存数据，并读取一次
		{
			count = in.read(buf);

			if(count < 0)  //取完缓冲区数据，返回-1
				return -1;

			byte b = buf[pos];
			count--;
			pos++;

			return b&255; //避免读取连续的1，返回-1，而是将原数据类型提升后，在其前面补0
		}
		else if(count > 0)  //此循环用于取出缓冲区数据
		{
			byte b = buf[pos];
			count--;
			pos++;

			return b&oxff;
		}

		return -1;
	}
	
	//自定义一个myClose方法，用于关闭字节流资源
	public void myClose() throws IOException
	{
		in.close();
	}
}


class  CopyMp3
{
	public static void main(String[] args) throws IOException
	{
		long start = System.currentTimeMillis();  //获取系统当前的时间
		copy_1();
		long end = System.currentTimeMillis();

		System.out.println((end-start)+"毫秒");
	}

	//通过字节流的缓冲区完成复制
	public static void copy_1() throws IOException //FileInputStream将会抛出异常
	{
		BufferedInputStream bufis = new BufferedInputStream(new FileInputStream("D:\\0.mp3"));
		BufferedOutputStream bufos = new BufferedOutputStream(new FileOutputStream("D:\\1.mp3"));
		
		int by = 0;
		while((by=bufis.read()) != -1)  //逐字节读取数据
		{
			bufos.write(by);  //逐字节写入数据
		}
		bufos.close();
		bufis.close();
	}
}
