/*
DataInputStream和DataOutputStream：
可以用于操作基本数据类型的数据流对象
*/

import java.io.*;

class DataStreamDemo 
{
	public static void main(String[] args) throws IOException
	{
		//writeData();
		//readData();

		//使用writeUTFDemo方法写入的数据，只能通过readUTFDemo方法读取
		writeUTFDemo();  
		readUTFDemo();

		//OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream("utf.txt"),"utf-8");

		//osw.write("你好");
		//osw.close();		 
	}

	//自定义一个readUTFDemo函数，用于读取使用writeUTFDemo写入的数据
	public static void readUTFDemo() throws IOException
	{
		DataInputStream dis = new DataInputStream(new FileInputStream("utfdata.txt"));

		String s = dis.readUTF();
		
		System.out.println(s);
		dis.close();
	}

	//自定义一个writeUTFDemo函数，用于写入基本数据类型的数据
	public static void writeUTFDemo() throws IOException
	{
		DataOutputStream dos = new DataOutputStream(new FileOutputStream("utfdata.txt"));

		dos.writeUTF("你好");

		dos.close();
	}

	//自定义一个readDemo函数，用于操作基本数据类型的数据
	public static void readData() throws IOException
	{
		DataInputStream dis = new DataInputStream(new FileInputStream("data.txt"));
		
		int num = dis.readInt();
		boolean b = dis.readBoolean();
		double d = dis.readDouble();

		System.out.println("num="+num);
		System.out.println("b="+b);
		System.out.println("d="+d);

		dis.close();
	}

	//自定义一个writeDemo函数，用于操作基本数据类型的数据
	public static void writeData() throws IOException
	{
		DataOutputStream dos = new DataOutputStream(new FileOutputStream("data.txt"));

		//写入基本数据类型
		dos.writeInt(123);  
		dos.writeBoolean(true);
		dos.writeDouble(3.14);

		dos.close();
	}
}
