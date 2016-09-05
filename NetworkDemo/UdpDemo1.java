/*
UDP特点：（桌面共享、聊天、视频会议等）
1、将数据及源和目的封装成数据包中，不需要建立连接；
2、每个数据包的大小限制在64k内;
3、不需要建立建立，速度快，是不可靠协议。

TCP特点：
1、建立连接，形成传输数据的通道；
2、在连接中进行大数据量传输；
3、通过三次握手完成连接，是可靠协议；
4、必须建立连接，效率会稍低。
*/

import java.net.*;

/*
需求：通过udp传输方式，讲一段文字数据发送出去。

定义一个UDP发送端：
思路：
1、建立udpsocket服务；
2、提供数据，将数据封装到数据中；
3、通过socket服务的发送功能，将数据包发送出去；
4、关闭资源。
*/
class UDPSendDemo 
{
	public static void main(String[] args) throws Exception
	{
		//1、创建udp服务，通过DatagramSocket对象
		DatagramSocket ds = new DatagramSocket();

		//2、确定数据，并封装成数据包,DatagramPacket(byte[] buf,int length, InetAddress address, int port)
		byte[] buf = "udp ge hello".getBytes();
		DatagramPacket dp = new DatagramPacket(buf,buf.length,InetAddress.getByName("192.168.1.1"),5000);

		//3、通过socket服务，将已有的数据包发送出去，通过send方法
		ds.send(dp);

		//4、关闭资源
		ds.close();
	}
}

//此处的发送端和接收端程序，可以单独写成一个文件，单独运行，此处为了方便对比写在一块。
/*
需求：定义一个应用程序，用于接收并处理udp协议传输的数据。

定义udp接收端：
思路：
1、定义udpsocket服务；通常会监听一个端口，其实就是给这个接收网络应用程序
   定义数字标识，方便明确哪些数据过来，该应用程序可以出来。
2、定义一个数据包，因为要存储接收到的字节数据，因为数据包对象中
   有更多功能，可以提取字节数据中的不同数据信息；
3、通过socket服务的receive方法将接收到的数据存入已定义好的数据包中；
4、通过数据包对象的特有功能，将这些不同的数据取出，打印在控制台上；
5、关闭资源。
*/

class UdpReceiveDemo
{
    public static void mian(String[] args) throws Exception
    {
		//1、创建udp socket，建立端点；
		DatagramSocket ds = new DatagramSocket(5000);
	
		//2、定义数据包，用于存储接收到的数据；
		byte[] buf = new byte[1024];
		DatagramPacket dp = new DatagramPacket(buf,buf.length);

		//3、通过socket服务的receive方法将接收到的数据存入数据包中；
		ds.receive(dp);  //阻塞式方法

		//4、通过数据包的方法获取其中的数据；
		String ip = dp.getAddress().getHostAddress();
		String data = new String(dp.getData(),0,dp.getLength);
		int port = dp.getPort();

		System.out.println(ip+"::"+data+"::"+port);

		//5、关闭资源
		ds.close();
    }
}