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

class MyIE
{
    public static void main(String[] args) throws Exception
    {
		Socket s = new Socket("192.168.1.253",8080);

		PrintWriter out = new PrintWriter(s.getOutputStream(),true);
		out.println("GET /myweb/demo.html HTTP/1.1");
		out.println("Accept */*");
		out.println("Accept-Language: zh-cn");
		out.println("Host: 192.168.1.253:11000");
		out.println("Connection: Keep-Alive");

		out.println();
		out.println();

		BufferedReader bufr = new BufferedReader(new InputStreamReader(s.getInputStream()));
	
		String line = null;
		while((line=bufr.readLine()) != null)
		{
			System.out.println(line);
		}
		s.close();
    }
}
