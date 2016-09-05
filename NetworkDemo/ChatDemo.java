/*
编写一个聊天程序：
有接收数据的部分，和发送数据的部分，这两部分需要同时进行；
那就需要用到多个线程技术，一个线程控制接收，一个线程控制发送。

因为收和发动作是不一致的，所有要定义两个run方法，而且这两个方法
封装到不同的类中。
*/


import java.net.*;
import java.io.*;

//定义一个Send类，实现Runnable接口，用于实现发送端线程
class Send implements Runnable
{
    private DatagramSocket ds;
    public Send(DatagramSocket ds)
    {
		this.ds = ds;
    }
    public void run() 
    {
		try
		{
			BufferedReader bufr = new BufferedReader(new InputStreamReader(System.in));
	
			String line = null;
			while((line=bufr..readLine()) != null)
			{
				if("886".equals(line))
					break;
	
				byte[] buf = line.getBytes();
				DatagramPacket dp = 
					new DatagramPacket(buf,buf.length,InetAddress.getByName("192.168.255"),5000);

				ds.send(dp);
			}
		}
		catch(Exception e)
		{
			throw new RuntimeException("发送端失败!");
		}
	}
}

//定义一个Receive类，实现Runnable接口，用于实现接收端线程
class Receive implements Runnable
{
    private DatagramSocket ds;
    public Receive(DatagramSocket ds)
    {
		this.ds = ds;
    }
    public void run() 
    {
		try
		{
			//此处使用while循环，是为了能够实现多次接受的功能
			while(true)  
			{
				byte[] buf = new byte[1024];
				DatagramPacket dp = new DatagramPacket(buf,buf.length);	
	    
				ds.receive(dp);
		
				String ip = dp.getAddress().getHostAddress();
				String data = new String(dp.getData(),0,dp.getLength());

				System.out.println(ip+"::"+data);
			}
	    }			
		catch(Exception e)
		{
			throw new RuntimeException("接收端失败!");
		}
    }
}


class ChatDemo
{
    public static void main(String[] args) throws Exception
    {
		DatagramSocket sendSocket = new DatagramSocket();
		DatagramSocket receSocket = new DatagramSocket(5000);

		new Thread(new Send(sendSocket)).start();  //启动发送端线程
		new Thread(new Receive(receSocket)).start();	
    }
}