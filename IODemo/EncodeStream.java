/*
�����ı����
ASCII��������׼��Ϣ�����룻��һ���ֽڵ�7λ���Ա�ʾ��
ISO8859-1���������ŷ�������һ���ֽڵ�8λ���Ա�ʾ��
GB2312���й������ı����
GBK���й������ı�����������ں��˸�������������ַ��š�
Unicode�����ʱ�׼�룬�ں��˸������֡��������ֶ��������ֽ�����ʾ��javaʹ�õľ���unicode
UTF-8������������ֽ�����ʾһ���ַ���

���룺�ַ�������ֽ�����

���룺�ֽ��������ַ���

String-->byte[]��str.getBytes();

byte[]-->String��new String(byte[]);

*/

import java.io.*;

class EncodeStream 
{
	public static void main(String[] args) throws IOException
	{
		writeText();

		String s = "���";

		//��b1����gbk����
		byte[] b1 = s.getBytes("GBK");  //ָ�������ʽ�����׳��쳣		
		System.out.println(Arrays.toString(b1));

		//��b1����iso8859-1����
		String s1 = new String(b1,"iso8859-1");  //������תΪ�ַ��������ƶ������
		System.out.println("s1="+s1);

		//��s1����iso8859-1����
		byte[] b2 = s1.getBytes("iso8859-1");  //�ַ���������
		System.out.println(Array.toString(b2));

		//��b2����gbk����
		String s2 = new String(b2,"gbk");
		System.out.println("s2="+s2);
	}

	public static void writeText() throws IOException
	{
		//Ĭ�ϱ�����GBK���룬����ָ������UTF-8�����ʽ��ȡ
		InputStreamReader isr = 
			new InputStreamReader(new FileOutputStream("utf.txt"),"UTF-8");

		char[] buf = new char[10];
		int len = isr.read(buf); //����ʹ��UTF-8������ļ��ж�ȡ����
		
		String str = new String(buf,0,len);

		System.out.println(str);

		isr.close();
	}

	public static void writeText() throws IOException
	{
		//Ĭ�ϱ�����GBK���룬����ָ������UTF-8�����ʽд��
		OutputStreamWriter ows = 
			new OutputStreamWriter(new FileOutputStream("utf.txt"),"UTF-8");

		ows.write("���");  //������á�ʹ��UTF-8����д���ļ�

		ows.close();
	}
}
