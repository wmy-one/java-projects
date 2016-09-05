/*
��дһ���������
�н������ݵĲ��֣��ͷ������ݵĲ��֣�����������Ҫͬʱ���У�
�Ǿ���Ҫ�õ�����̼߳�����һ���߳̿��ƽ��գ�һ���߳̿��Ʒ��͡�

��Ϊ�պͷ������ǲ�һ�µģ�����Ҫ��������run��������������������
��װ����ͬ�����С�
*/


import java.net.*;
import java.io.*;

//����һ��Send�࣬ʵ��Runnable�ӿڣ�����ʵ�ַ��Ͷ��߳�
class Send implements Runnable
{
    private DatagramSocket ds;
    public Send(DatagramSocket ds)
    {
		this.ds = ds;
    }
    public void run() 
    {
		try
		{
			BufferedReader bufr = new BufferedReader(new InputStreamReader(System.in));
	
			String line = null;
			while((line=bufr..readLine()) != null)
			{
				if("886".equals(line))
					break;
	
				byte[] buf = line.getBytes();
				DatagramPacket dp = 
					new DatagramPacket(buf,buf.length,InetAddress.getByName("192.168.255"),5000);

				ds.send(dp);
			}
		}
		catch(Exception e)
		{
			throw new RuntimeException("���Ͷ�ʧ��!");
		}
	}
}

//����һ��Receive�࣬ʵ��Runnable�ӿڣ�����ʵ�ֽ��ն��߳�
class Receive implements Runnable
{
    private DatagramSocket ds;
    public Receive(DatagramSocket ds)
    {
		this.ds = ds;
    }
    public void run() 
    {
		try
		{
			//�˴�ʹ��whileѭ������Ϊ���ܹ�ʵ�ֶ�ν��ܵĹ���
			while(true)  
			{
				byte[] buf = new byte[1024];
				DatagramPacket dp = new DatagramPacket(buf,buf.length);	
	    
				ds.receive(dp);
		
				String ip = dp.getAddress().getHostAddress();
				String data = new String(dp.getData(),0,dp.getLength());

				System.out.println(ip+"::"+data);
			}
	    }			
		catch(Exception e)
		{
			throw new RuntimeException("���ն�ʧ��!");
		}
    }
}


class ChatDemo
{
    public static void main(String[] args) throws Exception
    {
		DatagramSocket sendSocket = new DatagramSocket();
		DatagramSocket receSocket = new DatagramSocket(5000);

		new Thread(new Send(sendSocket)).start();  //�������Ͷ��߳�
		new Thread(new Receive(receSocket)).start();	
    }
}