/*
��ʾ�������ļ���������д��
*/

import java.io.*;

class  FileWriterDemo2
{
	public static void main(String[] args) 
	{
		//����һ��true�����������������е��ļ������������ļ���ĩβ��д���ݡ�
		FileWriter fw = null;
		try
		{
			fw = new FileWriter("Demo.txt",true);
			fw.write("Hello World !");
		}
		catch (IOException e)
		{
			System.out.println(e.toString());
		}
		finally
		{
			try
			{
				fw.close();  //�����Ҳ���׳�IO�쳣
			}
			catch (IOException e)
			{
				System.out.println(e.toString());
			}
		}

		//����һ���ļ���ȡ�����󣬺�ָ�����Ƶ��ļ��������
		//Ҫ��֤���ļ����ڣ����򣬽�����FileNotFindException
		FileReader fr = new FileReader("Demo.txt");  //�����׳�IO�쳣

		//���ö�ȡ�������read������read()��һ�ζ�һ���ַ������һ��Զ����¶���
		//����ĩβ������-1
		while(true)
		{
			int ch = fr.read();
			if(ch == -1)
				break;
			System.out.println("ch="+(char)ch);
		}	
		fr.close();

		//�ڶ��ֶ�ȡ��ʽ��ͨ���ַ�������ж�ȡ
		FileReader fr1 = new FileReader("Demo.txt");  //�����׳�IO�쳣

		//����һ���ַ����飬���̴洢��ȡ�����ַ���
		//��read(char [])���ص��Ƕ�ȡ�����ַ�������
		char[] buf = new char[3];

		int num = fr1.read(buf);
		System.out.println("num="=num+"..."+new String(buf));

		fr1.close();
	}
}
