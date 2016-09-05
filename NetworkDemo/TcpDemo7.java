/*
�ͻ���ͨ������¼���û���������˶�����û�������У�顣

������û����ڣ��ڷ������ʾxxx���ѵ�¼��
���ڿͻ�����ʾxxx����ӭ����!

������û������ڣ��ڷ������ʾxxx�����Ե�½��
���ڿͻ�����ʾxxx�����û������ڡ�

����½���Ρ�
*/

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
class LoginClient
{
    public static void main(String[] args) throws Exception
    {
		Socket s = new Socket("192.168.1.253",10008);

		BufferedReader bufr = 
			new BufferedReader(new InputStreamReader(System.in));

		PrintWriter out = new PrintWriter(s.getOutputStream(),true);

		BufferedReader bufIn = 
			new BufferedReader(new InputStreamReader(s.getInputStread()));

		for(int i=0; i<3; i++)
		{
			String line = bufr.readLine();
			if(line == null)
				break;
			out.println(line);

			String info = bufIn.readLine();    
			System.out.println("info:"+info);
			if(info.contains("��ӭ")
			break;
		}
	
		bufr.close();
		s.close();
    }
}

/*
����ˣ�
*/

class UserThread implements Runnable
{
    private Socket s;
    UserThread(Socket s)
    {
		this.s = s;
    }

    Public void run()
    {
		String ip = s.getInetAddress().getHostAddress();
		System.out.println(ip+"......connected");
		try
		{
			for(int i=0; i<3; i++)
			{
				BufferedReader bufr = 
					new BufferedReader(new InputStreamReader(s.getInputStream()));

				String name = bufIn.readLine();
				if(name == null)
					break;

				BufferedReader bufr = new BufferedReader(new FileReader("user.txt"));
				PrintWriter out = new PrintWriter(s.getOutputStream());

				String line = null;

				boolean flag = false;
				while((line=bufr.readLine()) != null)
				{
					if(line.equals(name))
					{
						flag = true;
						break;
					}
				}

				if(flag)
				{
					System.out.println(name+",�ѵ�¼");
					out.println(name+",��ӭ����");
					break;
				}
				else
				{
					System.out.println(name+",���Ե�¼");
					out.println(name+",�û���������");
				}
			}
			s.close();
		}
		catch(Exception e)
		{
			throw new RuntimeException(ip+"У��ʧ��");
		}
    }
}

class LoginServer
{
    public static void main(String[] args) throws Exception
    {
		ServerSocket ss = new ServerSocket(10008);

		while(true)
		{
			Socket s = ss.accept();    
			new Thread(new UserThread).start();
		} 
    }
}