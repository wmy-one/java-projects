/*
删除一个带内容的目录：
删除原理：
在window中，删除目录从里面往外面删除的。

既然是从里往外删除，就需要用到递归。
*/

import java.io.*;

class RemoveDir
{
    public static void main(String[] args)
    {
	File dir = new File("d:\\testdir");  //指定目录
	removeDir(dir);
    }

    //定义一个removeDir函数，用于删除指定目录下的所有内容	
    public static void removeDir(File dir)
    {
	File[] Files = dir.listFiles();

	//此循环用于删除指定目录及其子目录下的所有文件
	for(int x=0; x<files.length; x++)
	{
	    //此if语句用于避免隐藏文件
	    if(!files[x].isHidden() && files[x].isDirectory())
		removeDir(files[x]);
	    else
		printFun(files[x].toString()+":-file-:"+files[x].delete());
	}
	
	printFun(dir+"::dir::"+dir.delete());  //删除目录
    }

    //定义一个printFun函数，用于打印接收的参数
    public static void printFun(Object obj)
    {
	System.out.println(obj);
    }
}