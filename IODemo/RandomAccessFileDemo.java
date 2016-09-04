/*
该类不算是IO体系中的子类，而是直接继承Object。

但是它是IO包中的成员，因为它具备读和写功能；
内部封装了一个数组，而且通过指针对数组的元素进行操作。
可以通过getFilePointer获取指针位置，同时，可以通过seek改变指针的位置。

其实，它完成读写的原理就是内部封装了字节输入流和输出流。

通过构造函数可以看出，该类只能操作文件；而且操作文件还有模式：只读r、读写rw等

如果模式为只读（r），不会创建文件，会读取一个已存在的文件，如果文件不存在，则会出现异常；
如果模式为rw，操作的文件不存在，会自动创建，如果存在，则不会覆盖，而是直接写数据。
*/

import java.io.*;

class RandomAccessFileDemo 
{
	public static void main(String[] args) throws IOException
	{
		writeFile_2();  //写入数据

		readFile();  //读取数据
	}

	//定义一个readFile函数，用于随机读取数据
	public static void readFile() throws IOException
	{
		RandomAccessFile raf = new RandomAccessFile("ran.txt","r");

		//raf.write("Hello world".getBytes());  //这样写将报错：拒绝访问
		
		//调整对象指针
		//将指针移到脚标为8的地方，可指向前后，将从此处开始读取数据
		raf.seek(8*1);  

		//跳过指定的字节数，只能往前跳，不能往后跳；就是脚标增加的方向跳
		//raf.skipBytes(8);
		
		byte[] buf new byte[4];

		raf.read(buf);

		String s = new String(buf);
		int age = raf.readInt();

		System.out.println("name="+name);
		System.out.println("age="+age);
		raf.close();
	}
	
	//定义一个writeFile_2函数，用于随机读取写入数据
	public static void writeFile_2() throws IOException
	{
		RandomAccessFile raf = new RandomAccessFile("ran.txt","rw");
		
		raf.seek(8*3);
		raf.write("周期".getBytes());
		raf.writeInt(103);
		
		raf.close();
	}

	//定义一个writeFile函数，用于随机读取写入数据
	public static void writeFile() throws IOException
	{
		RandomAccessFile raf = new RandomAccessFile("ran.txt","rw");

		raf.write("Jhon".getBytes());

		//writeInt表示：用四个字节接收int类型数据，避免数据丢失；默认是一个字节接收
		raf.writeInt(258);  

		raf.write("Tom".getBytes());
		raf.writeInt(99); 

		raf.close();
	}
}
