
import java.io.*;

//����һ��Read�࣬����ʵ�ֶ�ȡ���ݲ���
class Read implements Runnable
{
	private PipedInputStream in;

	Read(PipedInputStream in)
	{
		this.in = in;
	}

	public void run()
	{
		try
		{
			byte[] buf = new byte[1024];
			
			System.out.println("��ȡǰ.....û�����ݣ�������");
			int len = in.read(buf);			
			System.out.println("��������.....����������");

			String s = new String(buf,0,len);

			System.out.println(s);

			in.close();
		}
		catch (IOException e)
		{
			throw new RuntimeException("�ܵ���ȡ��ʧ��!");
		}
	}
}

//����һ��Write�࣬����ʵ��д�����ݲ���
class Write implements Runnable
{
	private PipedOutputStream out;

	Write(PipedOutputStream out)
	{
		this.out = out;
	}

	public void run()
	{
		try
		{
			System.out.println("��ʼд�����ݣ��ȴ�6s��");
			Thread.sleep(6000); //ִ�е�����䣬�߳̽���˯��״̬6s����λΪ��ms

			out.write("piped start write��".getBytes());
			out.close();
		}
		catch (Exception e)
		{
			throw new RuntimeException("�ܵ������ʧ��!");
		}
	}
}

class PipedStreamDemo 
{
	public static void main(String[] args) 
	{
		PipedInputStream in = new PipedInputStream();
		PipedOutputStream out = new PipedOutputStream();

		Read r = new Read(in);
		Write w = new Write(out);

		new Thread(r).start(); //�����߳�
		new Thread(w).start();
	}
}
