/*
��ʾtcp���䣺(���ͻ��˺ͷ���˳���д����ͬһ���ı��У���Ϊ�˷���Աȡ�)

1��tcp�ֿͻ��˺ͷ���ˣ�
2���ͻ��˶�Ӧ�Ķ�����socket������˶�Ӧ�Ķ�����ServerSocket��
*/

/*
�ͻ��ˣ�
ͨ������socket���󣬷����ڸö�����ʱ���Ϳ���ȥ����ָ��������
��Ϊtcp���������ӵģ������ڽ���socket����ʱ����Ҫ�з���˴��ڣ�
�����ӳɹ����γ�ͨ·���ڸ�ͨ·�������ݵĴ��䡣

���󣺸�����˷�ˮ��һ���ı����ݡ�

���裺
1������socket���񣬲�ָ��Ҫ���ӵ������Ͷ˿ڣ�
2��ͨ��getOutputStream������ȡsocket���е��������
3���رտͻ��ˡ�
*/

import java.io.*;
import java.net.*;

class TcpClient
{
	public static void main(String[] args) throws Exception
	{
		//1�������ͻ��˵�socket����ָ��Ŀ�������Ͷ˿�
		Socket s = new Socket("192.168.1.253",5000);

		//2��Ϊ�˷������ݣ�Ӧ�û�ȡsocket���е������
		OutputStream out = s.getOutputStream();
		out.write("tcp: Hello world!".getBytes());

		//3���رտͻ���
		s.close();
	}
}

/*
���󣺶���˵�������ݲ���ӡ�ڿ���̨�ϡ�

����ˣ�
1��ͨ��ServerSocket()����������˵�socket���񣬲�����һ���˿ڣ�
2����ȡ���ӹ����Ŀͻ��˶���ͨ��ServerSocket��accept������
   û�����Ӿͻ�ȣ������������������ʽ�ģ�
3���ͻ���������������ݣ���ô�����Ҫʹ�ö�Ӧ�Ŀͻ��˶��󣬲���ȡ���ͻ��˶���Ķ�ȡ����
   ����ȡ�����������ݣ�����ӡ�ڿ���̨��
4���رշ���ˡ�����ѡ�ģ�ͨ����һֱ���ŵģ�
*/
class TcpServer 
{
	public static void main(String[] args) 
	{
		//1�����������socket���񣬲�����һ���˿�
		ServerSocket ss = new ServerSocket(5000);

		//2��ͨ��accept������ȡ���ӹ����Ŀͻ��˶���
		Socket s = ss.accept();

		String ip = s.getInetAddress().getHostAddress();
		System.out.println(ip+"......connected!");

		//3����ȡ�ͻ��˷��͹��������ݣ���ô�����Ҫʹ�ÿͻ��˵Ķ�ȡ������ȡ����
		InputStream in = s.getInputStream();

		byte[] buf = new byte[1024];
		int len = in.read(buf);

		System.out.println(new String(buf,0,len));

		//4���رտͻ���
		s.close();
		ss.close();
	}
}
