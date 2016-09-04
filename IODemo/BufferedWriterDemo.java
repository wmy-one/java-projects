/*
1���ַ���д������������
�������ĳ�����Ϊ��������Ĳ���Ч�ʶ����ֵģ������ڴ���������֮ǰ������Ҫ����������

�û��������ṩ��һ����ƽ̨�Ļ��з���newLine();

2���ַ�����ȡ��������:
�û������ṩ��һ��һ�ζ�ȡһ�еķ�����readLine(); ������ı����ݵĻ�ȡ��
������nullʱ����ʾ�����ļ�ĩβ��

readLine������ԭ��
���۶�ȡһ�У����Ƕ�ȡ����ַ�����ʵ���ն�����Ӳ����һ��һ���Ķ�ȡ��
��������ʹ�õĻ���read����һ�ζ�ȡһ���ķ�����

ע�⣺
readLine�������ص�ʱ��ֻ���ػس���֮ǰ���������ݣ��������ػس�����

3��ͨ������������һ��.Java�ļ�
*/

import java.io.*;

class  BufferedDemo
{
	public static void main(String[] args) throw IOException
	{
		System.out.println("Hello World!");
		//����һ���ַ�д��������
		FileWriter fw = new FileWriter("buf.txt");

		//Ϊ������ַ�д������Ч�ʣ������˻��弼��
		//��ʱ��ֻ�轫��Ҫ�����Ч�ʵ���������Ϊ�����������������Ĺ��캯������
		BufferedWriter bufw = new BufferedWriter(fw);

		bufw.wite("abcd");
		bufw.newLine();  //��ʾ���뻻�з�

		//ע�⣺ֻҪ�õ�����������Ҫ�ǵ�ˢ��
		bufw.flush();
		
		//��ʵ�رջ������������ڹرջ������е�������
		bufw.close();


		//����һ����ȡ��������ļ������
		FileReader fr = new FileReader("buf.txt");

		//Ϊ�����Ч�ʣ����뻺�弼�������ַ���ȡ��������Ϊ�����������������Ĺ��캯��
		BufferedReader bufr = new BufferedReader(fr);
		
		String line = null;

		while((line = bufr.readLine() != null))
		{
			//String s1 = bufr.readLine();  //��ȡһ������
			System.out.println("line="+line);
		}

		bufr.close();

		//ͨ������������һ��.java�ļ�
		BufferedWriter bufw1 = null;
		BufferedReader bufr1 = null;

		try
		{
			bufr1 = new BufferedReader(new FileReader("text.java"));
			bufw1 = new BufferedWriter(new FileWriter("copyText.java"));

			String line = null;

			while((line = bufr1.readLine() != null))
			{
				bufw1.write(line);
				bufw1.newLine();  //���뻻�з�
				bufw1.flush();
			}
		}
		catch (IOException e)
		{
			throw new RuntimeException("��дʧ�ܣ�");
		}
		finally
		{
			if(bufr1 != null)
				try
				{
					bufr1.close();
				}
				catch (IOException e)
				{
					throw new RuntimeException("��ȡʧ�ܣ�");
				}

			if(bufw1 != null)
				try
				{
					bufw1.close();
				}
				catch (IOException e)
				{
					throw new RuntimeException("д��ʧ�ܣ�");
				}
		}
	}
}
