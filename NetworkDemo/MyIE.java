/*
演示客户端和服务端。

1、客户端：浏览器
   服务端：自定义

2、客户端：浏览器
   服务端：Tomcat服务器

3、客户端：自定义
   服务端：Tomcat服务器
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
