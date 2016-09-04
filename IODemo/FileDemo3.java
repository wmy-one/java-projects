/*
列出指定目录下文件或者文件夹，包括子目录中的内容，
也就是列出指定目录下所有内容。

因为目录中还有目录，只要使用同一个列出目录功能的函数完成即可；
在列出过程中出现的还是目录的话，还可以再次调用本功能，
也就是函数本身调用自身，这种表现形式，或者编程手法，称为递归。

递归要注意：
1、限定条件；
2、要注意递归的次数，尽量避免内存溢出。
*/

import java.io.*;

class FileDemo3
{
    public static void main(String[] args)
    {
	File dir = new File("d:\\java");

	showDir(dir);       //列出目录下所有内容
	showDir_2(dir,0);  //列出目录下所有内容——带层次

	toBin(6);  //打印6的二进制表现形式
    }

    //定义一个toBin函数，用于将接收的数转为二进制
    public static void toBin(int num)
    {
	if(num > 0)
	{
	    toBin(num/2);  //利用递归循环调用toBin函数，进行除2模2运算
	    System.out.println(num%2);
	}
    }

    //定义一个showDir函数，用于实现打印指定目录下及其子目录下的所有文件	
    public static void showDir(File dir)
    {
	File[] files = dir.listFiles();
	for(int x=0; x<files.length; x++)
	{
	    System.out.println(dir);
	    if(files[x].isDirectory())  //判断是否是目录，如果是，则继续遍历
		showDir(files[x]);
	    else
	        System.out.println(files[x]);
	}
    }

    //
    public static String getLevel(int level)
    {
	StringBuilder sd = new StringBuilder();
	sb.append("|--");

	for(int x=0; x<level; x++)
	{
	    //sb.append("|--");
	    sb.insert(0,"| ");
	}
	return sb.toString();
    }

    //列出指定目录下及其子目录下的所有文件，有一定的层级	
    public static void showDir_2(File dir,int level)
    {
	System.out.println(getLevel(level)+dir.getName());
	level++;

	File[] files = dir.listFiles();
	for(int x=0; x<files.length; x++)
	{	    
	    if(files[x].isDirectory())  //判断是否是目录，如果是，则继续遍历
		showDir(files[x],level);
	    else
	        System.out.println(files[x]);
	}
    }
}