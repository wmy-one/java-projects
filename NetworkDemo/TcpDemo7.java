/*
客户端通过键盘录入用户名，服务端对这个用户名进行校验。

如果该用户存在，在服务端显示xxx，已登录；
并在客户端显示xxx，欢迎光临!

如果该用户不存在，在服务端显示xxx，尝试登陆；
并在客户端显示xxx，该用户不存在。

最多登陆三次。
*/

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
			if(info.contains("欢迎")
			break;
		}
	
		bufr.close();
		s.close();
    }
}

/*
服务端：
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
					System.out.println(name+",已登录");
					out.println(name+",欢迎光临");
					break;
				}
				else
				{
					System.out.println(name+",尝试登录");
					out.println(name+",用户名不存在");
				}
			}
			s.close();
		}
		catch(Exception e)
		{
			throw new RuntimeException(ip+"校验失败");
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