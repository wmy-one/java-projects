/*
File类：
1、用来将文件或文件夹封装成对象；
2、方便对文件和文件夹的属性信息进行操作；
3、File对象可以作为参数传递给流的构造函数。

File类常见方法：
1、创建
	boolean createNewFile();  在指定位置创建文件，如果文件已经存在，不创建，返回false;
			和输出流不一样，输出流对象创建文件时，若存在，则覆盖。

2、删除
	boolean delete();删除失败，返回false
	void deleteOnExit(); 在程序退出时，删除指定文件

3、判断
	boolean exists();  文件是否存在；  isFile();   isDirectory();  
	isHidden();   isAbsolute(); 

4、获取信息
	getName();
	getPath():
	getParent():

	getAbsolutePath():
	long getLastModified():
	long length():
*/

class  FileDemo
{
	public static void main(String[] args) 
	{
		consMethod();
		method_1();
	}

	public static void method_3()
	{
		File f1 = new File("D:\\test.java");
		File f2 = new File("D:\\hahah.java");
		
		//此方法将会修改文件名，如果这两个文件不再同一目录，
		//则删除f1，在另一个指定磁盘创建文件
		printFun("rename:"+f1.renameTo(f2));
	}

	public static void method_2()
	{
		File f = new File("file.txt");

		printFun("path:"+f.getPath());
		printFun("abspath:"+f.getAbsolutePath());

		//返回绝对路径中的父目录；如果获取的是相对路径，返回null;
		//如果相对路径中有上一层目录，那么该目录就是返回结果
		printFun("parent:"+f.getParent());  
			
	}

	//文件常见方法的使用
	public static void method_1()
	{
		File f = new File("file.txt");
		printFun("create:"+f.createNewFile());  //创建文件
		printFun("delete:"+f.delete());   //删除文件
	}

	//创建File对象
	public static void consMethod()
	{
		//将a.txt封装成file对象，可以将已有的或未存在的文件或文件夹封装成对象
		File f1 = new File("a.txt");

		//将文件夹和目录作为参数，并封装成File对象
		File f2 = new File("D:\\test","b.txt");
		
		//现将文件夹封装成file对象，在作为参数传给file
		File d = new File("D:\\test");
		File f3 = new File(d,"c.txt");

		printFun("f1:"+f1);
		printFun("f2:"+f2);
		printFun("f3:"+f3);
		
		//下面两条语句功能相同；使用separator属性，可以实现目录分割符跨平台
		//File f4 = new File("D:\\test\\d.txt");
		File f4 = new File("D:"+File.separator+"test"+File.separator+"d.txt");
	}

	public static void printFun(Object obj)
	{
		System.out.println(obj);
	}
}
