
import java.net.*;

class IPDemo
{
	public static void main(String[] args) throws Exception
	{
		//调用getLocalHost方法将会抛出UnknownHostException异常
		InetAddress i = InetAddress.getLocalHost();
		System.out.println(i.toString());
		System.out.println("address:"+i.getHostAddress());  //获取本机IP地址
		System.out.println("name:"+i.getHostName());   //获取本机主机名

		InetAddress ia = InetAddress.getByName("www.baidu.com");
		System.out.println("address:"+ia.getHostAddress());  //获取百度IP地址
		System.out.println("name:"+ia.getHostName());   //获取百度主机名，需要解析
	}
}
