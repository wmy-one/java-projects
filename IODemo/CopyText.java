/*
��C���е�һ���ļ����Ƶ�D�̣�
ԭ��
��ʵ���ǽ�C���µ��ļ����ݴ洢��D�̵�һ���ļ��У�
����:
1����D�̴���һ���ļ������ڴ洢C���ļ��е����ݣ�
2�������ȡ����C���ļ�������
3��ͨ�����ϵĶ�д������ݴ洢��
4���ر���Դ��
*/

import java.io.*;

class  CopyText
{
	public static void main(String[] args) 
	{
		//copyFun1(); //�˴����ú����쳣�ĺ��������������Ӧ���׳��쳣

		copyFun2();
	}

	//��������
	public static void copyFun2()
	{
		FileWriter fw = null;  //��������
		FileReader fr = null;
		
		try
		{
			fw = new FileWriter("copytest.txt");  //��ʼ������
			fr = new FileReader("text.txt");

			char[] buf = new char[1024]; //���ڴ��ж���һ�����飬���ڴ洢��ȡ���ַ�

			int len = 0;
			while((len=fr.read(buf) != -1))
			{
				fw.write(buf,0,len);
			}
		}
		catch (IOException e)
		{
			throw RuntimeException("��дʧ�ܣ�");
		}
		finally
		{
			if(fr != null)
				try
				{
					fr.close();
				}
				catch (IOException e)
				{
				}
			if(fw != null)
				try
				{
					fw.close();
				}
				catch (IOException e)
				{
				}
		}
	}

	//����һ����C�̶�ȡһ���ַ�������D��дһ���ַ�
	public static void copyFun_1() throw IOException
	{
		//����Ŀ�ĵ�
		FileWiter fw = new FileWriter("copytest.txt");

		//�������ļ�����
		FileReader fr = new FileReader("test.txt");

		int ch = 0;
		while((ch = fr.read()) != -1)
		{
			fw.write(ch);  //����ȡ���ַ�д������
		}

		fw.close();
		fr.close();
	}
}
