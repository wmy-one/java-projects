
import java.io.*;

class FileDemo2 
{
	public static void main(String[] args) 
	{
		listRootsDemo();
		listDemo();

		File dir = new File("d:\\");
		File[] files = dir.listFiles(); //�г���ǰĿ¼�µ��ļ�

		for(File f : files)
		{
			System.out.println(f.getName()+"::"+f.length());
		}
	}

	//����һ��listDemo_2����������ʵ�ֹ���ָ��Ŀ¼�µ��ļ�	
    public static void listDemo_2()
    {
		File dir = new File("d:\\java\\day");  //ָ��Ŀ¼
	
		//String[] arr = dir.list();  //��ָ��Ŀ¼�������ļ����浽������

		//��ʱ��list����accept�����ķ���ֵ�����ж���Ҫ���˵����ļ�
		String[] arr = dir.list(new FilenameFilter()
		{
			public boolean accept(File dir, String name)
			{
				//�˴���dir��ʾָ��Ŀ¼��name��ʾĿ¼�µ��ļ���
				/*
				if(name.endsWith(".bmp"))
					return true;
				else
					return false;
				*/		
				return name.endsWith(".bmp");
			}
		});
	
		System.outprintln("len:"+arr.length);  
		for(String name : arr)
		{
			System.outprintln(name);
		}
    }

	public static void listDemo()
	{
		File f = new File("D:\\");

		//����list������file��������Ƿ�װ��һ��Ŀ¼����Ŀ¼���������
		String[] names = f.list(); //��ӡָ��Ŀ¼�����е��ļ������ļ����������������ļ���

		for(String name : names)
		{
			System.out.println(name);
		}
	}

	public static void listRootsDemo()
	{
		File[] files = File.listRoots();  

		for(File f:files)
		{
			System.out.println(f);
		}
	}
}
