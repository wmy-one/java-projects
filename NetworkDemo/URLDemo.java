
import jav.net.*;

class URLDemo 
{
	public static void main(String[] args) throws MalformedURLException
	{
		URL url = new URL("http://192.168.253:8080/myweb/demo.html?name=haha&age=30");
		
		//ͨ��URL���getProtocol()��������ȡ��URL��Э������
		System.out.println("getProtocol():"+url.getProtocol());

		//ͨ��URL���getHost()��������ȡ��URL����������������ã�
		System.out.println("getHost():"+url.getHost());

		//ͨ��URL���getPort()��������ȡ��URL�Ķ˿ں�
		System.out.println("getPort():"+url.getPort());

		//ͨ��URL���getPath()��������ȡ��URL��·������
		System.out.println("getPath():"+url.getPath());

		//ͨ��URL���getFile()��������ȡ��URL���ļ���
		System.out.println("getFile():"+url.getFile());

		//ͨ��URL���getQuery()��������ȡ��URL�Ĳ�ѯ��
		System.out.println("getQuery():"+url.getQuery());

		/*
		int port = getPort();
		if(port == -1)
			port = 80;  //���û��д�˿ڣ���ָ���˿�
		*/
	}
}
