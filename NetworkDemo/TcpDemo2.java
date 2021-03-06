import java.io.*;
import java.net.*;

/*
演示tcp传输的客户端和服务端的互访。

需求：客户端给服务端发送数据，服务端接收到后，给客户端反馈信息。
*/

/*
客户端：
1、建立socket服务，指定要连接的主机和端口；
2、获取socket流中的输出流，经数据写到该流中，通过网络发送给服务端；
3、获取socket流中的输入流，将服务端反馈的数据获取到，并打印；
4、关闭客户端资源。
*/
class TcpClient2
{
	public static void main(String[] args) 
	{
		Socket s = new Socket("192.168.1.253",6000);
		
		OutputStream out = s.getOutputStream();
		out.write("服务端，你好！"。getBytes());

		InputStream in = s.getInputStream();
		byte[] buf = new byte[1024];
		int len = in.read(buf);
		
		System.out.println(new String(buf,0,len));

		s.close();
	}
}


class TcpServer2
{
	public static void main(String[] args) throws Exception
	{
		ServerSocket ss = new ServerSocket(6000);

		Socket s = ss.accept();

		String ip = s.getInetAddress().getHostAddress();
		System.out.println(ip+"......connected!");
		InputStream in = s.getInputStream();

		byte[] buf = new byte[1024];
		int len = in.read(buf);

		System.out.println(new String(buf,0,len));

		OutputStream out = s.getOutputStream();
		out.write("客户端收到，你好!".getBytes());

		s.close();
		ss.close();
	}
}