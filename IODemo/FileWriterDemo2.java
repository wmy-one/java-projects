/*
演示对已有文件的数据续写。
*/

import java.io.*;

class  FileWriterDemo2
{
	public static void main(String[] args) 
	{
		//传递一个true参数，代表不覆盖已有的文件，并在已有文件的末尾续写数据。
		FileWriter fw = null;
		try
		{
			fw = new FileWriter("Demo.txt",true);
			fw.write("Hello World !");
		}
		catch (IOException e)
		{
			System.out.println(e.toString());
		}
		finally
		{
			try
			{
				fw.close();  //此语句也将抛出IO异常
			}
			catch (IOException e)
			{
				System.out.println(e.toString());
			}
		}

		//创建一个文件读取流对象，和指定名称的文件相关联。
		//要保证该文件存在，否则，将发生FileNotFindException
		FileReader fr = new FileReader("Demo.txt");  //将会抛出IO异常

		//调用读取流对象的read方法，read()：一次读一个字符，并且会自动向下读，
		//读到末尾将返回-1
		while(true)
		{
			int ch = fr.read();
			if(ch == -1)
				break;
			System.out.println("ch="+(char)ch);
		}	
		fr.close();

		//第二种读取方式：通过字符数组进行读取
		FileReader fr1 = new FileReader("Demo.txt");  //将会抛出IO异常

		//定义一个字符数组，永固存储读取到的字符；
		//该read(char [])返回的是读取到的字符个数。
		char[] buf = new char[3];

		int num = fr1.read(buf);
		System.out.println("num="=num+"..."+new String(buf));

		fr1.close();
	}
}
