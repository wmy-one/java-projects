/*
��ʾ�ͻ��˺ͷ���ˡ�

1���ͻ��ˣ������
   ����ˣ��Զ���

2���ͻ��ˣ������
   ����ˣ�Tomcat������

3���ͻ��ˣ��Զ���
   ����ˣ�Tomcat������
*/

import java.io.*;
import java.net.*;

class ServerDemo
{
    public static void main(String[] args) throws Exception
    {
		ServerSocket ss = new ServerSocket(11000);
		Socket s =ss.accept();

		String ip = s.getInetAddress().getHostAddress();
		System.out.println(ip+".....connected");

		InputStream in = s.getInputStream();
		byte[] buf = new byte[1024];
		int len = 0;

		System.out.println(new String(buf,0,len));

		PrintWriter out = new PrintWriter(s.getOutputStream(),true);
		out.println("<font color='red' size='7'>�ͻ��ˣ����!</font>"); //html����

		s.close();
		ss.close();
    }
}
