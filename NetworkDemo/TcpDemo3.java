import java.io.*;
import java.net.*;

/*
需求：建立一个文本转换服务器；客户端给服务端发送文本，
      服务端接收到后会将文本转成大写，在返回给客户端。
      而且客户端可以不断的进行文本转换，当客户端输入over时，转换结束。

分析：
客户端：
既然是操作数据，那么就可以使用io技术，并按照io的操作规律来思考。
源：键盘录入。
目的：网络设备，网络输出流。
而且操作的是文本数据，可以选择字符流。

步骤:
1、建立socket服务，指定要连接的主机和端口；
2、获取键盘录入；
3、将数据发给服务端；
4、获取服务端返回的大写数据；
5、结束，关闭资源。

都是文本数据，可以使用字符流进行操作，同时提高效率，加入缓冲技术。
*/
class TransClient
{
	public static void main(String[] args) throws Exception
	{
		Socket s = new Socket("192.168.1.253",6000);

		//定义读取键盘数据的流对象
		BufferedReader bufr =
			new BufferedReader(new InputStreamReader(System.in));

		//定义目的，将数据写入到socket输出流，发给服务端
		/*
		BufferedWriter bufOut = 
			new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
		*/
		//可以使用下面的PrintWriter代替上面注释的语句
		PrintWriter out = new PrintWriter(s.getOutputStream(),true);

		//定义一个socket读取流，读取服务端返回的大写信息
		BufferedReader bufIn =
			new BufferedReader(new InputStreamReader(s.getInputStream()));

		String line = null;
		while((line=bufout.readLine()) != null)
		{
			if("over".equals(line))
				break;

			out.println(line);
			/*
			bufOut.write(line);  //将回车符之前的数据希尔缓冲区
			bufOut.newLine();  //加入换行符
			bufOut.flush();
			*/
			String str = bufIn.readLine();
			System.out.println("server:"+str);
		}

		bufr.close();
		s.close();  //执行后，在socket流中加入-1
	}
}

/*
服务端：
源：socket读取流；
目的：socket输出流；
都是文本，装饰。
*/
class TransServer
{
	public static void main(String[] args) throws Exception
	{
		ServerSocket ss = new ServerSocket(6000);

		Socket s = ss.accept();
		String ip = s.getInetAddress().getHostAddress();
		System.out.println(ip+"......connected!");

		//读取socket读取流中的数据
		BufferedReader bufIn =
			new BufferedReader(new InputStreamReader(s.getInputStream()));

		//目的，socket输出流，将大写数据写入到socket输出流，并发送给客户端
		/*
		BufferedWriter bufOut =
			new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
		*/
		//可以使用下面的PrintWriter代替上面注释的语句
		PrintWriter out = new PrintWriter(s.getOutputSteam(),true); 

		String line = null;
		while((line=bufIn.readLine()) != null)
		{
			System.out.println(line);  //true对应的println有效的刷新

			//如果目的使用PrintWriter创建，下面的语句可代替注释的三句
			out.println(line.toUpperCase()); 
			/*
			bufOut.write(line.toUpperCase());
			bufOut.newLine();
			bufOut.flush();
			*/
		}
		s.close();
		ss.close();
	}
}

/*
该例子出现的问题：
现象：客户端和服务端都在莫名的等待，为什么呢？
因为客户端和服务端都用阻塞式的方法，这些方法没有读到结束标记，
那么就一直等，而导致两端都在等待。
*/