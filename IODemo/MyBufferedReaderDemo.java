/*
ѧϰ��BufferedReader�������з���readLine��ԭ���
�����Զ���һ���࣬����һ�����ܺ�readLineһ�µķ�������ģ��һ��BufferedReader��
*/

import java.io.*;

//����һ��������ģ��readLine����
class MyBufferedReader
{
	private FileReader fr;

	MyBufferedReader(FileReader fr)
	{
		this.fr = fr;
	}

	//����һ�ζ�һ�����ݵķ���
	public String myReadLine() throw IOException //�˴����쳣�׳���Ϊ���õ����ߴ���
	{
		/*
		����һ����ʱ������ԭBufferedReader��װ�����ַ����飬�˴�����һ��StringBuilder
		��������Ϊ�����ջ��ǽ�����תΪ�ַ�����
		*/
		StringBuilder sb = new StringBuilder();

		int ch = 0;

		/*
		�˴���whileѭ�������ж��Ƿ�������з���Windows�еĻ��з��ǡ�\r\n����
		ֻ�е�����һ�Ρ�\r���͡�\n��ʱ����ʾ�����н�β����ʱ�����������е����������
		*/
		while((ch=r.read() != -1))
		{
			if(ch == '\r')
				continue;
			if(ch == '\n')
				return sb.toString();
			else
				sb.append((char)ch);
		}
		
		//�˴����ж�������ڴ������ļ����һ��û��ʹ�û��з������
		if(sb.length() != 0)
			return sb.toString();

		return null;
	}
	
	//�˴������myClose������FileReader�е�close�������ƣ����ڹر�����Դ
	public void myClose()
	{
		fr.chose();
	}
}


class  MyBufferedReaderDemo
{
	public static void main(String[] args) throw IOException
	{
		FileReader fr = new FileReader("buf.txt");

		MyBufferedReader mybuf = new MybufferedReader(fr);

		String line = null;

		while((line = mybuf.myReadLine() != null))
		{
			System.out.println("Line="+line);
		}

		mybuf.myClose();
	}
}
