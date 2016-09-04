
import java.io.*;
import java.util.*;

class SequenceDemo 
{
	public static void main(String[] args) throws IOException
	{
		Vector<FileInputStream> v = new Vector<FileInputStream>();
		
		v.add(new FileInputStream("d:\\1.txt"));  //添加到集合中
		v.add(new FileInputStream("d:\\2.txt"));
		v.add(new FileInputStream("d:\\3.txt"));

		Enumeration<FileInputStream> en = v.elements();

		//将多个读取流合并成一个读取流 
		SequenceInputStream sis = new SequenceInputStream(en);

		FileOutputStream fos = new FileOutputStream("d:\\4.txt");

		byte[] buf = new byte[1024];
		int len=0;

		//此循环用于将读取流中的数据写入文件中
		while((len=sis.read(buf)) != -1) 
		{
			fos.write(buf,0,len);
		}
		
		fos.close();
		sis.close();  //关闭所有流
	}
}
