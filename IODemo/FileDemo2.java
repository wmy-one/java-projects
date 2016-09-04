
import java.io.*;

class FileDemo2 
{
	public static void main(String[] args) 
	{
		listRootsDemo();
		listDemo();

		File dir = new File("d:\\");
		File[] files = dir.listFiles(); //列出当前目录下的文件

		for(File f : files)
		{
			System.out.println(f.getName()+"::"+f.length());
		}
	}

	//定义一个listDemo_2函数，用于实现过滤指定目录下的文件	
    public static void listDemo_2()
    {
		File dir = new File("d:\\java\\day");  //指定目录
	
		//String[] arr = dir.list();  //将指定目录下所有文件名存到数组中

		//此时，list依据accept方法的返回值，来判断需要过滤掉的文件
		String[] arr = dir.list(new FilenameFilter()
		{
			public boolean accept(File dir, String name)
			{
				//此处的dir表示指定目录，name表示目录下的文件名
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

		//调用list方法的file对象必须是封装了一个目录，此目录还必须存在
		String[] names = f.list(); //打印指定目录下所有的文件名和文件夹名（包括隐藏文件）

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
