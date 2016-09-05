/*
UDP�ص㣺�����湲�����졢��Ƶ����ȣ�
1�������ݼ�Դ��Ŀ�ķ�װ�����ݰ��У�����Ҫ�������ӣ�
2��ÿ�����ݰ��Ĵ�С������64k��;
3������Ҫ�����������ٶȿ죬�ǲ��ɿ�Э�顣

TCP�ص㣺
1���������ӣ��γɴ������ݵ�ͨ����
2���������н��д����������䣻
3��ͨ����������������ӣ��ǿɿ�Э�飻
4�����뽨�����ӣ�Ч�ʻ��Ե͡�
*/

import java.net.*;

/*
����ͨ��udp���䷽ʽ����һ���������ݷ��ͳ�ȥ��

����һ��UDP���Ͷˣ�
˼·��
1������udpsocket����
2���ṩ���ݣ������ݷ�װ�������У�
3��ͨ��socket����ķ��͹��ܣ������ݰ����ͳ�ȥ��
4���ر���Դ��
*/
class UDPSendDemo 
{
	public static void main(String[] args) throws Exception
	{
		//1������udp����ͨ��DatagramSocket����
		DatagramSocket ds = new DatagramSocket();

		//2��ȷ�����ݣ�����װ�����ݰ�,DatagramPacket(byte[] buf,int length, InetAddress address, int port)
		byte[] buf = "udp ge hello".getBytes();
		DatagramPacket dp = new DatagramPacket(buf,buf.length,InetAddress.getByName("192.168.1.1"),5000);

		//3��ͨ��socket���񣬽����е����ݰ����ͳ�ȥ��ͨ��send����
		ds.send(dp);

		//4���ر���Դ
		ds.close();
	}
}

//�˴��ķ��Ͷ˺ͽ��ն˳��򣬿��Ե���д��һ���ļ����������У��˴�Ϊ�˷���Ա�д��һ�顣
/*
���󣺶���һ��Ӧ�ó������ڽ��ղ�����udpЭ�鴫������ݡ�

����udp���նˣ�
˼·��
1������udpsocket����ͨ�������һ���˿ڣ���ʵ���Ǹ������������Ӧ�ó���
   �������ֱ�ʶ��������ȷ��Щ���ݹ�������Ӧ�ó�����Գ�����
2������һ�����ݰ�����ΪҪ�洢���յ����ֽ����ݣ���Ϊ���ݰ�������
   �и��๦�ܣ�������ȡ�ֽ������еĲ�ͬ������Ϣ��
3��ͨ��socket�����receive���������յ������ݴ����Ѷ���õ����ݰ��У�
4��ͨ�����ݰ���������й��ܣ�����Щ��ͬ������ȡ������ӡ�ڿ���̨�ϣ�
5���ر���Դ��
*/

class UdpReceiveDemo
{
    public static void mian(String[] args) throws Exception
    {
		//1������udp socket�������˵㣻
		DatagramSocket ds = new DatagramSocket(5000);
	
		//2���������ݰ������ڴ洢���յ������ݣ�
		byte[] buf = new byte[1024];
		DatagramPacket dp = new DatagramPacket(buf,buf.length);

		//3��ͨ��socket�����receive���������յ������ݴ������ݰ��У�
		ds.receive(dp);  //����ʽ����

		//4��ͨ�����ݰ��ķ�����ȡ���е����ݣ�
		String ip = dp.getAddress().getHostAddress();
		String data = new String(dp.getData(),0,dp.getLength);
		int port = dp.getPort();

		System.out.println(ip+"::"+data+"::"+port);

		//5���ر���Դ
		ds.close();
    }
}