/*
学习完BufferedReader类中特有方法readLine的原理后，
可以自定义一个类，包括一个功能和readLine一致的方法；来模拟一下BufferedReader。
*/

import java.io.*;

//定义一个类用于模拟readLine方法
class MyBufferedReader
{
	private FileReader fr;

	MyBufferedReader(FileReader fr)
	{
		this.fr = fr;
	}

	//可以一次读一行数据的方法
	public String myReadLine() throw IOException //此处将异常抛出是为了让调用者处理
	{
		/*
		定义一个临时容器，原BufferedReader封装的是字符数组，此处定义一个StringBuilder
		容器，因为，最终还是将数据转为字符串。
		*/
		StringBuilder sb = new StringBuilder();

		int ch = 0;

		/*
		此处的while循环用于判断是否读到换行符，Windows中的换行符是‘\r\n’，
		只有当读到一次‘\r’和‘\n’时，表示读到行结尾，此时，将缓冲区中的内容输出。
		*/
		while((ch=r.read() != -1))
		{
			if(ch == '\r')
				continue;
			if(ch == '\n')
				return sb.toString();
			else
				sb.append((char)ch);
		}
		
		//此处的判断语句用于处理，在文件最后一行没有使用换行符的情况
		if(sb.length() != 0)
			return sb.toString();

		return null;
	}
	
	//此处定义的myClose方法和FileReader中的close方法类似，用于关闭流资源
	public void myClose()
	{
		fr.chose();
	}
}


class  MyBufferedReaderDemo
{
	public static void main(String[] args) throw IOException
	{
		FileReader fr = new FileReader("buf.txt");

		MyBufferedReader mybuf = new MybufferedReader(fr);

		String line = null;

		while((line = mybuf.myReadLine() != null))
		{
			System.out.println("Line="+line);
		}

		mybuf.myClose();
	}
}
