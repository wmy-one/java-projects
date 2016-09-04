/*
���಻����IO��ϵ�е����࣬����ֱ�Ӽ̳�Object��

��������IO���еĳ�Ա����Ϊ���߱�����д���ܣ�
�ڲ���װ��һ�����飬����ͨ��ָ��������Ԫ�ؽ��в�����
����ͨ��getFilePointer��ȡָ��λ�ã�ͬʱ������ͨ��seek�ı�ָ���λ�á�

��ʵ������ɶ�д��ԭ������ڲ���װ���ֽ����������������

ͨ�����캯�����Կ���������ֻ�ܲ����ļ������Ҳ����ļ�����ģʽ��ֻ��r����дrw��

���ģʽΪֻ����r�������ᴴ���ļ������ȡһ���Ѵ��ڵ��ļ�������ļ������ڣ��������쳣��
���ģʽΪrw���������ļ������ڣ����Զ�������������ڣ��򲻻Ḳ�ǣ�����ֱ��д���ݡ�
*/

import java.io.*;

class RandomAccessFileDemo 
{
	public static void main(String[] args) throws IOException
	{
		writeFile_2();  //д������

		readFile();  //��ȡ����
	}

	//����һ��readFile���������������ȡ����
	public static void readFile() throws IOException
	{
		RandomAccessFile raf = new RandomAccessFile("ran.txt","r");

		//raf.write("Hello world".getBytes());  //����д�������ܾ�����
		
		//��������ָ��
		//��ָ���Ƶ��ű�Ϊ8�ĵط�����ָ��ǰ�󣬽��Ӵ˴���ʼ��ȡ����
		raf.seek(8*1);  

		//����ָ�����ֽ�����ֻ����ǰ�������������������ǽű����ӵķ�����
		//raf.skipBytes(8);
		
		byte[] buf new byte[4];

		raf.read(buf);

		String s = new String(buf);
		int age = raf.readInt();

		System.out.println("name="+name);
		System.out.println("age="+age);
		raf.close();
	}
	
	//����һ��writeFile_2���������������ȡд������
	public static void writeFile_2() throws IOException
	{
		RandomAccessFile raf = new RandomAccessFile("ran.txt","rw");
		
		raf.seek(8*3);
		raf.write("����".getBytes());
		raf.writeInt(103);
		
		raf.close();
	}

	//����һ��writeFile���������������ȡд������
	public static void writeFile() throws IOException
	{
		RandomAccessFile raf = new RandomAccessFile("ran.txt","rw");

		raf.write("Jhon".getBytes());

		//writeInt��ʾ�����ĸ��ֽڽ���int�������ݣ��������ݶ�ʧ��Ĭ����һ���ֽڽ���
		raf.writeInt(258);  

		raf.write("Tom".getBytes());
		raf.writeInt(99); 

		raf.close();
	}
}
