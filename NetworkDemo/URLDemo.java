
import jav.net.*;

class URLDemo 
{
	public static void main(String[] args) throws MalformedURLException
	{
		URL url = new URL("http://192.168.253:8080/myweb/demo.html?name=haha&age=30");
		
		//通过URL类的getProtocol()方法，获取此URL的协议名称
		System.out.println("getProtocol():"+url.getProtocol());

		//通过URL类的getHost()方法，获取此URL的主机名（如果适用）
		System.out.println("getHost():"+url.getHost());

		//通过URL类的getPort()方法，获取此URL的端口号
		System.out.println("getPort():"+url.getPort());

		//通过URL类的getPath()方法，获取此URL的路径部分
		System.out.println("getPath():"+url.getPath());

		//通过URL类的getFile()方法，获取此URL的文件名
		System.out.println("getFile():"+url.getFile());

		//通过URL类的getQuery()方法，获取此URL的查询部
		System.out.println("getQuery():"+url.getQuery());

		/*
		int port = getPort();
		if(port == -1)
			port = 80;  //如果没有写端口，则指定端口
		*/
	}
}
