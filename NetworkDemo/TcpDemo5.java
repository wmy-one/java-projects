
import java.io.*;
import java.net.*;

/*
客户端：
1、服务端点；
2、读取客户端已有的图片数据；
3、通过socket输出流将数据发给服务端；
4、读取服务端反馈信息；
5、关闭客户端资源。
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
		//告诉服务端数据已写完,传给服务端一个-1
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
服务端：
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
		out.write("上传成功".getBytes());

		fos.close();
		s.close();
		ss.close();  //运行一次服务端，使用此语句关闭服务端
    }
}