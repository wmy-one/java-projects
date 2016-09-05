
import java.io.*;
import java.net.*;

/*
�ͻ��ˣ�
1������˵㣻
2����ȡ�ͻ������е�ͼƬ���ݣ�
3��ͨ��socket����������ݷ�������ˣ�
4����ȡ����˷�����Ϣ��
5���رտͻ�����Դ��
*/
class PicClient
{
    public static void main(String[] args) throws Exception
    {
		Socket s = new Socket("192.168.1.253",10007);
		FileInputStream fis = new FileInputStream("1.bmp");
		OutputStream out = s.getOutputStream();

		byte[] buf = new byte[1024];
		int len=0;

		while((len=fis.read(buf)) != -1)
		{
			out.write(buf,0,len);
		}
		//���߷����������д��,���������һ��-1
		s.shutdownOutput();

		InputStream in = s.getInputStream();
		byte[] bufIn = new byte[1024];
		int num = in.read(bufIn);
	
		System.out.pritnln(new String(bufIn,0,num));

		fis.close();
		s.close();
    }
}

/*
����ˣ�
*/
class PicServer
{
    public static void main(String[] args) throws Exception
    {
		ServerSocket ss = new ServerSocket(10007);
		Socket s = ss.accept();

		String ip = s.getInetAddress().getHostAddress();
		System.out.println(ip+"......connected");

		InputStream in = s.getInputStream();
		FileOutputStream fos = new FileOutputStream("server.bmp");

		byte[] buf = new byte[1024];
		int len =0;
		while((len=in.read(buf)) != -1)
		{
			fos.write(buf,0,len);
		}

		OutputStream out = s.getOutputStream();
		out.write("�ϴ��ɹ�".getBytes());

		fos.close();
		s.close();
		ss.close();  //����һ�η���ˣ�ʹ�ô����رշ����
    }
}