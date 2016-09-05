import java.io.*;
import java.net.*;

/*
���󣺽���һ���ı�ת�����������ͻ��˸�����˷����ı���
      ����˽��յ���Ὣ�ı�ת�ɴ�д���ڷ��ظ��ͻ��ˡ�
      ���ҿͻ��˿��Բ��ϵĽ����ı�ת�������ͻ�������overʱ��ת��������

������
�ͻ��ˣ�
��Ȼ�ǲ������ݣ���ô�Ϳ���ʹ��io������������io�Ĳ���������˼����
Դ������¼�롣
Ŀ�ģ������豸�������������
���Ҳ��������ı����ݣ�����ѡ���ַ�����

����:
1������socket����ָ��Ҫ���ӵ������Ͷ˿ڣ�
2����ȡ����¼�룻
3�������ݷ�������ˣ�
4����ȡ����˷��صĴ�д���ݣ�
5���������ر���Դ��

�����ı����ݣ�����ʹ���ַ������в�����ͬʱ���Ч�ʣ����뻺�弼����
*/
class TransClient
{
	public static void main(String[] args) throws Exception
	{
		Socket s = new Socket("192.168.1.253",6000);

		//�����ȡ�������ݵ�������
		BufferedReader bufr =
			new BufferedReader(new InputStreamReader(System.in));

		//����Ŀ�ģ�������д�뵽socket����������������
		/*
		BufferedWriter bufOut = 
			new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
		*/
		//����ʹ�������PrintWriter��������ע�͵����
		PrintWriter out = new PrintWriter(s.getOutputStream(),true);

		//����һ��socket��ȡ������ȡ����˷��صĴ�д��Ϣ
		BufferedReader bufIn =
			new BufferedReader(new InputStreamReader(s.getInputStream()));

		String line = null;
		while((line=bufout.readLine()) != null)
		{
			if("over".equals(line))
				break;

			out.println(line);
			/*
			bufOut.write(line);  //���س���֮ǰ������ϣ��������
			bufOut.newLine();  //���뻻�з�
			bufOut.flush();
			*/
			String str = bufIn.readLine();
			System.out.println("server:"+str);
		}

		bufr.close();
		s.close();  //ִ�к���socket���м���-1
	}
}

/*
����ˣ�
Դ��socket��ȡ����
Ŀ�ģ�socket�������
�����ı���װ�Ρ�
*/
class TransServer
{
	public static void main(String[] args) throws Exception
	{
		ServerSocket ss = new ServerSocket(6000);

		Socket s = ss.accept();
		String ip = s.getInetAddress().getHostAddress();
		System.out.println(ip+"......connected!");

		//��ȡsocket��ȡ���е�����
		BufferedReader bufIn =
			new BufferedReader(new InputStreamReader(s.getInputStream()));

		//Ŀ�ģ�socket�����������д����д�뵽socket������������͸��ͻ���
		/*
		BufferedWriter bufOut =
			new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
		*/
		//����ʹ�������PrintWriter��������ע�͵����
		PrintWriter out = new PrintWriter(s.getOutputSteam(),true); 

		String line = null;
		while((line=bufIn.readLine()) != null)
		{
			System.out.println(line);  //true��Ӧ��println��Ч��ˢ��

			//���Ŀ��ʹ��PrintWriter��������������ɴ���ע�͵�����
			out.println(line.toUpperCase()); 
			/*
			bufOut.write(line.toUpperCase());
			bufOut.newLine();
			bufOut.flush();
			*/
		}
		s.close();
		ss.close();
	}
}

/*
�����ӳ��ֵ����⣺
���󣺿ͻ��˺ͷ���˶���Ī���ĵȴ���Ϊʲô�أ�
��Ϊ�ͻ��˺ͷ���˶�������ʽ�ķ�������Щ����û�ж���������ǣ�
��ô��һֱ�ȣ����������˶��ڵȴ���
*/