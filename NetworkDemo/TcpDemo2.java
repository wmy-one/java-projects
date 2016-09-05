import java.io.*;
import java.net.*;

/*
��ʾtcp����Ŀͻ��˺ͷ���˵Ļ��á�

���󣺿ͻ��˸�����˷������ݣ�����˽��յ��󣬸��ͻ��˷�����Ϣ��
*/

/*
�ͻ��ˣ�
1������socket����ָ��Ҫ���ӵ������Ͷ˿ڣ�
2����ȡsocket���е��������������д�������У�ͨ�����緢�͸�����ˣ�
3����ȡsocket���е���������������˷��������ݻ�ȡ��������ӡ��
4���رտͻ�����Դ��
*/
class TcpClient2
{
	public static void main(String[] args) 
	{
		Socket s = new Socket("192.168.1.253",6000);
		
		OutputStream out = s.getOutputStream();
		out.write("����ˣ���ã�"��getBytes());

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
		out.write("�ͻ����յ������!".getBytes());

		s.close();
		ss.close();
	}
}