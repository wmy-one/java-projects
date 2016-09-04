/*
1��I/O֪ʶ
Java�����ݵĲ���ͨ�����ķ�ʽ��I/O�����������豸֮������ݴ��䣻
�ֽ����ĳ�����ࣺInpuStream��OutputStream
�ַ����ĳ�����ࣺReader��Writer

ע�⣺�����ĸ��������������������ƣ��������丸������Ϊ�������ĺ�׺��

2���ַ������ص㣺
������Ӳ���ϣ�����һ���ļ���д��һЩ�������ݡ�
�ҵ�һ��ר�����ڲ����ļ���Writer�������FileWriter��ǰ׺���Ǹ�������Ĺ��ܡ�

3��IO�쳣�Ĵ���ʽ
*/

import java.io.*;
class  FileWriterDemo
{
	public static void main(String[] args) throw IOException
	{
		FileWriter fw = null;  //ʹFileWriter���������������ļ�
		try
		{
			//����һ��FileWriter���󣬸ö���һ����ʼ���ͱ���Ҫ��ȷ���������ļ�
			//���ļ��ᱻ������ָ��Ŀ¼�£������Ŀ¼����ͬ���ļ����������ǵ���
			fw = new FileWriter("Demo.txt");

			//����write���������ַ���д�뵽����
			fw.write("abcdef");
			
			//ˢ���������еĻ�������ݣ���������ˢ�µ���Ӧ���ļ��С�
			//fw.flush();

			/*
			�ر�����Դ�������ڹر�֮ǰ����ˢ��һ���ڲ���������ݣ�������ˢ�µ�Ŀ�ĵ��У�
			��flush������flushˢ�º������Լ���ʹ�ã�closeˢ�º󣬻Ὣ���رա�
			*/
			//fw.close();
		}
		catch (IOException e)
		{
			System.out.println(e.toString());
		}
		finally
		{
			try
			{
				if(fw != null)
					fw.close();  //�����Ҳ�����׳�IOException�쳣
			}
			catch (IOException e)
			{
				System.out.println(e.toString());
			}		
		}
	}
}
