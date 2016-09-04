/*
�ֽ�����
InputStream OutputStream

1��������Ҫ����ͼƬ���ݣ���ʱ��Ҫ�õ��ֽ�����

2������һ��ͼƬ��
˼·��
1�����ֽڶ�ȡ�������ͼƬ������
2�����ֽ�д�������󴴽�һ��ͼƬ�ļ���
3��ͨ��ѭ����д��������ݵĴ洢��
4���ر���Դ��
*/

import java.io.*;

class  FileStreamDemo
{
	public static void main(String[] args) throws IOException
	{
		writeFile();
		readFile_1();
		readFile_2();
		readFile_3();

		//����һ��ͼƬ
		FileOutputStream fos = null;
		FileInputStream fis = null;
		try
		{
			fos = new FileOutputStream("D:\\2.bmp");
			fis = new FileInputStream("D:\\1.bmp");

			byte[] buf = new byte[1024];
			int len=0;

			while((len=fis.read(buf)) != -1)
			{
				fos.write(buf,0,len);
			}
		}
		catch (IOException e)
		{
			throw new RuntimeException("��дͼƬʧ�ܣ�");
		}
		finally
		{
			try
			{
				if(fis != null)
					fis.close();
			}
			catch (IOException e)
			{
				throw new RuntimeException("��ȡ�ر�ʧ�ܣ�");
			}

			try
			{
				if(fos != null)
					fos.close();
			}
			catch (IOException e)
			{
				throw new RuntimeException("д��ر�ʧ�ܣ�");
			}
		}
		
	}

	//������������һ��readFile���������ڽ��ļ��е����ݶ�ȡ���ֽ�����
	public static void readFile_3() throws IOException
	{
		FileInputStream fis = new FileInputStream("fos.txt");
		
		//int num = fis.available();  //���ظ��ļ����ֽڵĸ������������з���
		byte[] buf = new byte[fis.available()];

		fis.read(buf);

		System.out.println(new String(buf));  //������תΪ�ַ�������ӡ����

		fis.close();
	}
	
	//������������һ��readFile���������ڽ��ļ��е����ݶ�ȡ���ֽ�����
	public static void readFile_2() throws IOException
	{
		FileInputStream fis = new FileInputStream("fos.txt");
		
		byte[] buf = new byte[1024];
		int len=0;

		while((len=fis.read(buf)) != -1)  //����ȡ�����ݻ�����������
		{
			System.out.println(new String(buf,0,len));
		}
		fis.close();
	}

	//����һ������һ��readFile���������ڽ��ļ��е����ݶ�ȡ���ֽ�����
	public static void readFile_1() throws IOException
	{
		FileInputStream fis = new FileInputStream("fos.txt");

		int ch = 0;
		while((ch=fis.read()) != -1)  //һ��һ���Ķ�ȡ�ֽ�
		{
			System.out.println((char)ch);
		}
		fis.close();
	}

	//����һ��writeFile�������������ļ���д���ֽ����е�����
	public static void writeFile() throws IOException
	{
		FileOutputStream fos = new FileOutputStream("fos.txt");

		fos.write("abcdef".getBytes());

		fos.close();
	}
}
