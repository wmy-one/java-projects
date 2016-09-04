/*
���ڲ����ֽ������������

ByteArrayInputStream���ڹ����ʱ����Ҫ��������Դ����������Դ��һ���ֽ����飻

ByteArrayOutputStream���ڹ����ʱ�򣬲��ö�������Ŀ�ģ���Ϊ�ö������Ѿ���װ��
�ɱ䳤�ȵ��ֽ����飬���������Ŀ�ĵء�

��Ϊ�����������󶼲����������飬��û��ʹ��ϵͳ��Դ�����ԣ����ý���close�رա�

�����������ɽ���ʱ��

Դ�豸������ System.in��Ӳ�� FileStream���ڴ� ArrayStream
Ŀ���豸������̨ System.out��Ӳ�� FileStream���ڴ� ArrayStream

�����Ķ�д˼������������
*/

import java.io.*;

class ByteArrayStream 
{
	public static void main(String[] args) 
	{
		//����Դ
		ByteArrayInputStream bis = new ByteArrayInputStream("ABCDEF".getBytes());

		//����Ŀ��
		ByteArrayOutputStream bos = new ByteArrayInputStream();

		int by = 0;
		while((by=bis.read()) != -1)
		{
			bos.write(by);
		}

		System.out.println(bos.size());  //��ȡ��������С
		System.out.println(bos.toString());  //����ַ�����ӡ����

		//bos.writeTo(new FileOutputStream("a.txt"));  //д���ļ�
	}
}
