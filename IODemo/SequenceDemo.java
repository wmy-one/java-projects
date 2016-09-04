
import java.io.*;
import java.util.*;

class SequenceDemo 
{
	public static void main(String[] args) throws IOException
	{
		Vector<FileInputStream> v = new Vector<FileInputStream>();
		
		v.add(new FileInputStream("d:\\1.txt"));  //��ӵ�������
		v.add(new FileInputStream("d:\\2.txt"));
		v.add(new FileInputStream("d:\\3.txt"));

		Enumeration<FileInputStream> en = v.elements();

		//�������ȡ���ϲ���һ����ȡ�� 
		SequenceInputStream sis = new SequenceInputStream(en);

		FileOutputStream fos = new FileOutputStream("d:\\4.txt");

		byte[] buf = new byte[1024];
		int len=0;

		//��ѭ�����ڽ���ȡ���е�����д���ļ���
		while((len=sis.read(buf)) != -1) 
		{
			fos.write(buf,0,len);
		}
		
		fos.close();
		sis.close();  //�ر�������
	}
}
