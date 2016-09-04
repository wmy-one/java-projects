/*
��ȡ����¼��:
System.out����Ӧ���Ǳ�׼���������̨��
System.in����Ӧ���Ǳ�׼���룬���̣�

����
1��ͨ������¼�����ݣ�
2����¼��һ�����ݺ󣬾ͽ������ݽ��д�ӡ��
3�����¼���������over����ֹͣ¼�롣
*/
import java.io.*;

class TransStreamDemo
{
	public static void main(String[] args) throws IOException
	{
		//����һ��ʵ�ּ���¼��һ�У����������ݴ�ӡ
		//����InputStream���ã�ָ���׼����������
		InputStream in = System.in;

		//����һ���ַ��������������ڴ洢¼����ַ�
		StringBuilder sb = new StringBuilder();
		
		while(true)
		{
			int ch = in.read();  //read���������׳�IO�쳣

			if(ch == '\r')
				continue;

			if(ch == '\n')
			{
				String s = sb.toString();
				if("over".equals == s)
					break;

				System.out.println(s.toUpperCase());
				sb.delete(0,sb.length());  //ÿ�δ�ӡ��һ�к���ջ�����
			}
			else
				sb.append((char)ch); //��¼����ַ���ӵ�������
		}

		//��������
		/*
		ͨ������ļ���¼��һ�����ݲ���ӡ���д��������ʵ���Ƕ�ȡһ�����ݵ�ԭ��
		Ҳ����readLine������

		�ܲ���ֱ��ʹ��readLine��������ɼ���¼��һ�����ݵĶ�ȡ�أ�
		readLine�������ַ���BufferedReader���еķ�����������¼���read������
		�ֽ���InputStream���еķ�����

		��ô�ܲ��ܽ��ֽ���ת���ַ�������ʹ���ַ�����������readLine������
		ͨ������java API�ĵ����֣�InputStreamRead�����ֽ���ͨ���ַ�����������
		���Խ��ֽ���תΪ�ַ�����������
		*/
		
		/*
		//��ȡ����¼�����
		InputStream in = System.in;

		//���ֽ�������ת���ַ�������ʹ��ת������InputStreamReader
		InputStreamReader isr = new InputStreamReader(in);

		//Ϊ�����Ч�ʣ����ַ���ʹ�û������������и�Ч������ʹ��BufferedReader
		BufferedReader bufr = new BufferedReader(isr);
		*/

		//��������������תΪ�������д���Ǽ���¼�������д��
		BufferedReader bufr = new BufferedReader(new InputStreamReader(System.in));
		

		/*
		//��ȡ��׼���������
		OutputStream out = System.out;

		//�����������ת���ַ�������ʹ��ת������OutputStreamWriter
		OutputStreamWriter osw = new OutputStreamWriter(out);

		//ʹ�û�������������ֽ����Ĳ���Ч�ʣ�ʹ��BufferedWriter
		BufferedWriter bufw = new BufferedWriter(osw);
		*/

		//��������������תΪ��
		BufferedWriter bufw = new BufferedWriter(new OutputStreamWriter(System.out));

		String line = null;

		while((line=bufr.readLine()) != null)
		{
			if("over".equals(line))
				break;

			//System.out.println(line.toUpperCase());

			//�������תΪ�ַ�������������������д������������䣺
			bufw.write(line.toUpperCase());  //д�뻺����
			bufw.newLine();  //����
			bufw.flush();   //���������е����ݴ�ӡ����
		}
		bufr.close();
	}
}
