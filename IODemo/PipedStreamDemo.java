
import java.io.*;

//定义一个Read类，用于实现读取数据操作
class Read implements Runnable
{
	private PipedInputStream in;

	Read(PipedInputStream in)
	{
		this.in = in;
	}

	public void run()
	{
		try
		{
			byte[] buf = new byte[1024];
			
			System.out.println("读取前.....没有数据，阻塞！");
			int len = in.read(buf);			
			System.out.println("读到数据.....阻塞结束！");

			String s = new String(buf,0,len);

			System.out.println(s);

			in.close();
		}
		catch (IOException e)
		{
			throw new RuntimeException("管道读取流失败!");
		}
	}
}

//定义一个Write类，用于实现写入数据操作
class Write implements Runnable
{
	private PipedOutputStream out;

	Write(PipedOutputStream out)
	{
		this.out = out;
	}

	public void run()
	{
		try
		{
			System.out.println("开始写入数据，等待6s后：");
			Thread.sleep(6000); //执行到此语句，线程进入睡眠状态6s，单位为：ms

			out.write("piped start write：".getBytes());
			out.close();
		}
		catch (Exception e)
		{
			throw new RuntimeException("管道输出流失败!");
		}
	}
}

class PipedStreamDemo 
{
	public static void main(String[] args) 
	{
		PipedInputStream in = new PipedInputStream();
		PipedOutputStream out = new PipedOutputStream();

		Read r = new Read(in);
		Write w = new Write(out);

		new Thread(r).start(); //启动线程
		new Thread(w).start();
	}
}
