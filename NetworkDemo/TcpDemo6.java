
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
		if(args.length != 1)
		{
			System.out.println("��ѡ��һ��jpg��ʽ��ͼƬ");
			return;	
		}
	    
		//ͨ����dos�����У�ָ���ļ�·���ķ�ʽ���ļ������磺java PicClient d:\\1.jpg	
		File file = new File(args[0]);  

		if(!(file.exists()) && file.isFile()))
		{
			System.out.println("���ļ������⣬Ҫô�����ڣ�Ҫô�����ļ�!");
			return ;
		}

		if(file.getName().endsWith(".jpg"))
		{
			System.out.println("ͼƬ��ʽ����������ѡ��!");
			return ;
		}

		if(file.length() > 1024*5)
		{
			System.out.println("�ļ�����!");
			return ;
		}

		Socket s = new Socket("192.168.1.253",10007);
		FileInputStream fis = new FileInputStream(file);
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
����������һ�������ԣ���A�ͻ��������Ϻ󣬱�����˻�ȡ���������ִ�о������̣�
��ʱ��B�ͻ������ӣ�ֻҪ�ȴ�����Ϊ����˻�û�д�����A�ͻ��˵����󣬻�Ҫѭ������
ִ���´�accept������������ʱ��ȡ����B�ͻ��˶���

��ôδ�������ö��ͻ���ͬʱ�������ʷ���ˣ���ʱ���������þ��ǽ�ÿ���ͻ���
��װ��һ���������߳��У��������Ϳ���ͬʱ�������ͻ�������

��ζ����߳��أ�
ֻҪ��ȷ��ÿһ���ͻ���Ҫ�ڷ����ִ�еĴ��뼴�ɣ����ô���ֲ�뵽run������
*/

class PicThread implements Runnable
{
    private Socket s;
    PicThread(Socket s)
    {
		this.s = s;
    }

    public void run()
    {
		int count = 0;
		String ip = s.getInetAddress().getHostAddress();
		try
		{
			System.out.println(ip+"......connected");

			InputStream in = s.getInputStream();

			File file = new File(ip+"("+(count)+")"+".jpg");
			while(file.exists())
			{
				if(file.exists())
					file = new File(ip+"("+(count++)+")"+".jpg");
			}

			FileOutputStream fos = new FileOutputStream(file);

			byte[] buf = new byte[1024];
			int len =1;
			while((len=in.read(buf)) != -1)
			{
				fos.write(buf,0,len);
			}

			OutputStream out = s.getOutputStream();
			out.write("�ϴ��ɹ�".getBytes());

			fos.close();
			s.close();
		}
		catch(Exception e)
		{
			throw new RuntimeException(ip+"�ϴ�ʧ��!");
		}
    }
}

class PicServer
{
    public static void main(String[] args) throws Exception
    {
		ServerSocket ss = new ServerSocket(10007);

		while(true)
		{
			Socket s = ss.accept();
			new Thread(new PicThread(s)).start();
		}
	
		//ss.close();
    }
}