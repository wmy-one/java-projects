/*
java����һ�����ߣ�log4j���кܶ���󣬷��㽨��java��־�ļ���
*/

import java.io.*;
import java.util.*;
import java.text.*;

class ExceptionInfo 
{
	public static void main(String[] args) throws IOException
	{
		//����ϵͳ��Ϣ��־�ļ�
		Properties prop = System.getProperties();
		//System.out.println(prop);   //ֱ�ӽ�ϵͳ��Ϣ��ӡ������̨

		prop.list(new PrintStream("sysinfo.txt"));  //��ϵͳ��Ϣ������ļ���

		//����IO�쳣��־�ļ�
		try
		{
			int[] arr = new int[2];
			System.out.println(arr[3]);
		}
		catch (Exception e)
		{
			//e.printStackTrace(new PrintStream("a.txt"));
			try
			{
				//��ʽ����ǰʱ��
				Date d = new Date();
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				String s = sdf.format(d);

				PrintStream ps = new PrintStream("exception.log")); //������־�ļ�
				ps.println(s);
				System.setOut(ps);  //���������
			}
			catch (IOException ex)
			{
				throw RuntimeException("��־�ļ�����ʧ�ܣ�");
			}
			ps.close();
			e.printStackTrace(System.out);
		}

	}
}
