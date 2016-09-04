/*
1����ʾMp3�ĸ��ƣ�ͨ���ֽ����Ļ�����

2���Զ����ֽ����Ļ�����
*/

import java.io.*;

//����һ��MyBufferedInputStream�࣬���������Զ����ֽ����Ļ���������
class MyBufferedInputStream
{
	private InputStream in;
	private byte[] buf = new byte[1024*4];
	private int pos=0, count=0;

	MyBufferedInputStream(InputStream in)
	{
		this.in = in;
	}

	//һ�ζ�ȡһ���ֽڣ��ӻ��������ֽ����飩�л�ȡ
	public int myRead() throws IOException
	{
		//ͨ��in�����ȡ�ֽ������ݣ����洢��buf��
		if(count == 0)  //��ѭ�������򻺳����д����ݣ�����ȡһ��
		{
			count = in.read(buf);

			if(count < 0)  //ȡ�껺�������ݣ�����-1
				return -1;

			byte b = buf[pos];
			count--;
			pos++;

			return b&255; //�����ȡ������1������-1�����ǽ�ԭ������������������ǰ�油0
		}
		else if(count > 0)  //��ѭ������ȡ������������
		{
			byte b = buf[pos];
			count--;
			pos++;

			return b&oxff;
		}

		return -1;
	}
	
	//�Զ���һ��myClose���������ڹر��ֽ�����Դ
	public void myClose() throws IOException
	{
		in.close();
	}
}


class  CopyMp3
{
	public static void main(String[] args) throws IOException
	{
		long start = System.currentTimeMillis();  //��ȡϵͳ��ǰ��ʱ��
		copy_1();
		long end = System.currentTimeMillis();

		System.out.println((end-start)+"����");
	}

	//ͨ���ֽ����Ļ�������ɸ���
	public static void copy_1() throws IOException //FileInputStream�����׳��쳣
	{
		BufferedInputStream bufis = new BufferedInputStream(new FileInputStream("D:\\0.mp3"));
		BufferedOutputStream bufos = new BufferedOutputStream(new FileOutputStream("D:\\1.mp3"));
		
		int by = 0;
		while((by=bufis.read()) != -1)  //���ֽڶ�ȡ����
		{
			bufos.write(by);  //���ֽ�д������
		}
		bufos.close();
		bufis.close();
	}
}
