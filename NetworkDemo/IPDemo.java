
import java.net.*;

class IPDemo
{
	public static void main(String[] args) throws Exception
	{
		//����getLocalHost���������׳�UnknownHostException�쳣
		InetAddress i = InetAddress.getLocalHost();
		System.out.println(i.toString());
		System.out.println("address:"+i.getHostAddress());  //��ȡ����IP��ַ
		System.out.println("name:"+i.getHostName());   //��ȡ����������

		InetAddress ia = InetAddress.getByName("www.baidu.com");
		System.out.println("address:"+ia.getHostAddress());  //��ȡ�ٶ�IP��ַ
		System.out.println("name:"+ia.getHostName());   //��ȡ�ٶ�����������Ҫ����
	}
}
