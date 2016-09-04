/*
常见的编码表：
ASCII：美国标准信息交换码；用一个字节的7位可以表示；
ISO8859-1：拉丁码表，欧洲码表；用一个字节的8位可以表示；
GB2312：中国的中文编码表。
GBK：中国的中文编码表升级，融合了更多的中文文字字符号。
Unicode：国际标准码，融合了各种文字。所以文字都用两个字节来表示，java使用的就是unicode
UTF-8：最多用三个字节来表示一个字符。

编码：字符串变成字节数组

解码：字节数组变成字符串

String-->byte[]：str.getBytes();

byte[]-->String：new String(byte[]);

*/

import java.io.*;

class EncodeStream 
{
	public static void main(String[] args) throws IOException
	{
		writeText();

		String s = "你好";

		//对b1进行gbk编码
		byte[] b1 = s.getBytes("GBK");  //指定编码格式，将抛出异常		
		System.out.println(Arrays.toString(b1));

		//对b1进行iso8859-1解码
		String s1 = new String(b1,"iso8859-1");  //将数组转为字符串，并制定编码表
		System.out.println("s1="+s1);

		//对s1进行iso8859-1编码
		byte[] b2 = s1.getBytes("iso8859-1");  //字符串变数组
		System.out.println(Array.toString(b2));

		//对b2进行gbk解码
		String s2 = new String(b2,"gbk");
		System.out.println("s2="+s2);
	}

	public static void writeText() throws IOException
	{
		//默认编码是GBK编码，下面指定的是UTF-8编码格式读取
		InputStreamReader isr = 
			new InputStreamReader(new FileOutputStream("utf.txt"),"UTF-8");

		char[] buf = new char[10];
		int len = isr.read(buf); //将“使用UTF-8编码从文件中读取数据
		
		String str = new String(buf,0,len);

		System.out.println(str);

		isr.close();
	}

	public static void writeText() throws IOException
	{
		//默认编码是GBK编码，下面指定的是UTF-8编码格式写入
		OutputStreamWriter ows = 
			new OutputStreamWriter(new FileOutputStream("utf.txt"),"UTF-8");

		ows.write("你好");  //将“你好”使用UTF-8编码写入文件

		ows.close();
	}
}
