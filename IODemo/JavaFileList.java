/*
将一个指定目录下的Java文件的绝对路径，存储到一个文本文件中；
建立一个Java文件列表文件。

思路：
1、对指定的目录进行递归；
2、获取递归过程中Java文件的路径；
3、将这些路径存储到集合中；
4、将集合中的数据写入到一个文件中。
*/

import java.io.*;
import java.util.*;

class JavaFileList
{
    public static void main(String[] args) throws IOException
    {
	File dir = new File("d:\\javaTest");
	List<File> list = new ArrayList<File>();

	fileToList(dir,list);  //将指定目录下的所有内容列表存储在集合中
	printFun(list.size());
	
	File f = new File(dir,"javalist.txt");
	writeToFile(list,file.toString());   //将指定目录下的所有内容列表写入文件中
    }

    //定义一个printFun函数，用于打印接收的参数
    public static void printFun(Object obj)
    {
	System.out.println(obj);
    }

    //定义一个fileToList函数，使用集合list存储指定目录下的所有内容	
    public static void fileToList(File dir,List<File> list)
    {
	File[] files = dirlistFiles();
	
	for(File file : files)
	{
	    if(file.isDirectory())    //判断是否是目录
		fileToList(file,list);
	    else
	    {
		if(file.getName().endsWith(".java"))  //判断是否是以.java结尾的文件
		    list.add(file);
	    }
	}
    }

    public static void writeToFile(List<File> list,String javaListFile)
    {
	BufferedWriter bufw = null;
	try
	{
	    //创建写入流对象指向文件JavaListFile，并将写入流内容存储在缓冲区中，
	    bufw = new BufferedWriter(new FileWriter(javaListFile));
	    
	    for(File f : list)
	    {
		String path = f.getAbsolutePath();  //获取绝对路径
		bufw.write(path);  //写入流
		bufw.newLine();  //换行
		bufw.flush();  //将流缓冲区中的内容写入文件中
	    }
	}
	catch(IOException e)
	{
	    throw RuntimeException("写入文件失败！");
	}
	finally
	{
	    try
	    {
		if(bufw != null)
		    bufw.close();
	    }
	    catch(IOException ex)
	    {
		throw ex;
	    }
	}
    }
}