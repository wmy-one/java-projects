/*
��ӡ����
�����ṩ�˴�ӡ���������Խ������������͵�����ԭ����ӡ��
�ֽڴ�ӡ���� PrintStream
���캯�����Խ��յĲ������ͣ�
1��file����
2���ַ���·����
3���ֽ��������OutputStream

�ַ���ӡ����PrintWriter   //�Ƚϳ��ã�web�����г���ʹ��
���캯�����Խ��յĲ������ͣ�
1��file����
2���ַ���·����
3���ֽ��������OutputStream
4���ַ��������Writer

*/

import java.io.*;

class PrintStreamDemo
{
	public static void main(String[] args) 
	{
		BufferedReader bufr = new BufferedReader(new InputStreamReader(System.in));

		//PrintWriter out = new PrintWriter(System.out,true); //��ӡ�����
		PrintWriter out = new PrintWriter(new FileWriter("a.txt"),true); //д���ļ�

		String line = null;

		while((line=bufr.readLine()) != null)
		{
			if("over".equals(line))
				break;

			//out.write(line.toUpperCase());  //��д�����޻���
			out.println(line.toUpperCase());

			//out.flush();
		}

		out.close();
		bufr.close();
	}
}
