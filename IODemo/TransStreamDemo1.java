/*
读取键盘录入:
System.out：对应的是标准输出，控制台；
System.in：对应的是标准输入，键盘；

需求：
1、通过键盘录入数据；
2、当录入一行数据后，就将该数据进行打印；
3、如果录入的数据是over，就停止录入。
*/
import java.io.*;

class TransStreamDemo
{
	public static void main(String[] args) throws IOException
	{
		//方法一：实现键盘录入一行，并将该数据打印
		//定义InputStream引用，指向标准输入流对象
		InputStream in = System.in;

		//定义一个字符串缓冲区，用于存储录入的字符
		StringBuilder sb = new StringBuilder();
		
		while(true)
		{
			int ch = in.read();  //read方法将会抛出IO异常

			if(ch == '\r')
				continue;

			if(ch == '\n')
			{
				String s = sb.toString();
				if("over".equals == s)
					break;

				System.out.println(s.toUpperCase());
				sb.delete(0,sb.length());  //每次打印完一行后，清空缓冲区
			}
			else
				sb.append((char)ch); //将录入的字符添加到缓冲区
		}

		//方法二：
		/*
		通过上面的键盘录入一行数据并打印其大写，发现其实就是读取一行数据的原理，
		也就是readLine方法。

		能不能直接使用readLine方法来完成键盘录入一行数据的读取呢？
		readLine方法是字符流BufferedReader类中的方法；而键盘录入的read方法是
		字节流InputStream类中的方法。

		那么能不能将字节流转成字符流，在使用字符流缓冲区的readLine方法？
		通过查阅java API文档发现，InputStreamRead类是字节流通向字符流的桥梁，
		可以将字节流转为字符流来操作。
		*/
		
		/*
		//获取键盘录入对象
		InputStream in = System.in;

		//将字节流对象转成字符流对象，使用转换流：InputStreamReader
		InputStreamReader isr = new InputStreamReader(in);

		//为了提高效率，将字符流使用缓冲区技术进行高效操作，使用BufferedReader
		BufferedReader bufr = new BufferedReader(isr);
		*/

		//上面三条语句可以转为：下面的写法是键盘录入最常见的写法
		BufferedReader bufr = new BufferedReader(new InputStreamReader(System.in));
		

		/*
		//获取标准输出流对象
		OutputStream out = System.out;

		//将输出流对象转成字符流对象，使用转换流：OutputStreamWriter
		OutputStreamWriter osw = new OutputStreamWriter(out);

		//使用缓冲区技术提高字节流的操作效率，使用BufferedWriter
		BufferedWriter bufw = new BufferedWriter(osw);
		*/

		//上面三条语句可以转为：
		BufferedWriter bufw = new BufferedWriter(new OutputStreamWriter(System.out));

		String line = null;

		while((line=bufr.readLine()) != null)
		{
			if("over".equals(line))
				break;

			//System.out.println(line.toUpperCase());

			//将输出流转为字符流后，上面的输出语句可以写成下面三条语句：
			bufw.write(line.toUpperCase());  //写入缓冲区
			bufw.newLine();  //换行
			bufw.flush();   //将缓冲区中的数据打印出来
		}
		bufr.close();
	}
}
