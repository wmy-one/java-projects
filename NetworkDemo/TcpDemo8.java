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
		out.println("<font color='red' size='7'>客户端，你好!</font>"); //html代码

		s.close();
		ss.close();
    }
}
