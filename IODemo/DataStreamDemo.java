/*
DataInputStream��DataOutputStream��
�������ڲ��������������͵�����������
*/

import java.io.*;

class DataStreamDemo 
{
	public static void main(String[] args) throws IOException
	{
		//writeData();
		//readData();

		//ʹ��writeUTFDemo����д������ݣ�ֻ��ͨ��readUTFDemo������ȡ
		writeUTFDemo();  
		readUTFDemo();

		//OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream("utf.txt"),"utf-8");

		//osw.write("���");
		//osw.close();		 
	}

	//�Զ���һ��readUTFDemo���������ڶ�ȡʹ��writeUTFDemoд�������
	public static void readUTFDemo() throws IOException
	{
		DataInputStream dis = new DataInputStream(new FileInputStream("utfdata.txt"));

		String s = dis.readUTF();
		
		System.out.println(s);
		dis.close();
	}

	//�Զ���һ��writeUTFDemo����������д������������͵�����
	public static void writeUTFDemo() throws IOException
	{
		DataOutputStream dos = new DataOutputStream(new FileOutputStream("utfdata.txt"));

		dos.writeUTF("���");

		dos.close();
	}

	//�Զ���һ��readDemo���������ڲ��������������͵�����
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

	//�Զ���һ��writeDemo���������ڲ��������������͵�����
	public static void writeData() throws IOException
	{
		DataOutputStream dos = new DataOutputStream(new FileOutputStream("data.txt"));

		//д�������������
		dos.writeInt(123);  
		dos.writeBoolean(true);
		dos.writeDouble(3.14);

		dos.close();
	}
}
