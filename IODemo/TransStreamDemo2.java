/*
1、
源：键盘录入；
目的：控制台。

2、
需求：
想把键盘录入的数据存储到一个文件中。
源：键盘录入；
目的：文件。

3、
需求：想要讲一个文件的数据打印在控制台上。
源：文件；
目的：控制台

流操作的基本规律：
最痛苦的是流对象有很多，不知道该用哪一个。

1、明确源和目的
	源：输入流；InputStream、Reader；
	目的：输出流；OutputStream、Writer。

2、操作的数据是否是纯文本
	是：字符流；
	否：字节流。

3、当体系明确后，在明确要使用哪个具体的对象
通过设备来进行区分：
	源设备：内存、硬盘、键盘；
	目的设备：内存、硬盘、控制台。

-------------------------------------------

需求：
1、将一个文本文件中的数据存储到另一个文件中，复制文件。
	源：因为是源，所以使用读取流；InputStream、Reader；

	是不是操作文本文件：
	是！这时就可以选择Reader，这样体系就明确了。

	接下来明确要使用该体系中的哪个对象。
	明确设备：硬盘，上的一个文件。
	Reader体系中可以操作文件的对象是：FileReader
	
	是否需要提高效率：
	是！加入Reader体系中的缓冲区：BufferedReader

	FileReader fr = new FileReader("a.txt");
	BufferedReader bufr = new BufferedReader(fr);


	目的：因为是目的，所以使用输出流：OutputStream、Writer

	是不是操作纯文本文件：
	是！这时就可以选择Writer，这样体系就明确了。

	接下来明确要使用该体系中的哪个对象。
	明确设备：硬盘，一个文件。
	Writer体系中可以操作文件的对象是：FileWriter

	是否需要提高效率：
	是！加入Writer体系中的缓冲区：BufferedWriter

	FileWriter fw = new FileWriter("b.txt");
	BufferedWriter bufw = new BufferedWriter(fw);


练习：将一个图片文件中的数据存储到另一个文件中，复制文件。

-------------------------------------------------

2、将键盘录入的数据保存到一个文件中。
这个需求中有源和目的，分别分析：
	源：键盘录入；InputStream、Reader

	是不是纯文本：
	是！Reader

	设备：键盘；对应的对象是System.in；
	不是选择Reader吗？System.in对应的不是字节流吗？
	为了操作键盘的文件数据方便，转成字符流按照字符串操作时最方便的；
	所以既然明确了Reader，那么就将System.in转成字符流;
	用到了Reader体系中的转换流：InputStreamReader。

	是否需要提高效率：
	是！使用Reader体系中的缓冲区：BufferedReader

	InputStreamReader isr = new InputStreamReader(System.in);
	BufferedReader bufr = new BufferedReader(isr);

	
	目的：OutputStream、Writer
	是否是纯文本：是！Writer

	设备：硬盘，一个文件；使用FileWriter。

	是否需要提高效率：是！使用BufferedWriter
	
	FileWriter fw = new FileWriter("c.txt");
	BufferedWriter bufw = new BufferedWriter(fw);

*********************************************************

扩展：想要把录入的数据按照指定的编码表（utf-8），将数据存到文件中。
	
	目的：OutputStream、Writer
	是否是纯文本：是！Writer

	设备：硬盘，一个文件；使用FileWriter。
	但是FileWriter使用的默认编码表：GBK

	但是，存储时需要加入指定编码表（utf-8），而指定编码表只有转换流可以指定；
	所以要使用的对象是：OutputStreamWriter。
	而该转换流对象要接收一个字节输出流，而且还可以操作文件的字节输出流：FileOutputStream
	
	是否需要提高效率：是！使用BufferedWriter

	OutputStreamWriter osw = 
		new OutputStreamWriter(new FileOutputStream("d.txt"),"UTF-8");
	BufferedWriter bufw = new BufferedWriter(osw);

注意：转换流何时使用？字符和字节之间的桥梁，通常涉及到字符编码转换时，需要使用转换流。

练习：讲一个文本数据打印到控制台上。
*/

class TransStreamDemo2
{
	public static void main(String[] args) 
	{
		//System.setIn(new FileInputStream("test.txt"));  //设置输入流
		//System.setOut(new PrintStream("out.txt"));   //设置输出流

		//键盘录入最常见的写法
		BufferedReader bufr = new BufferedReader(new InputStreamReader(System.in));
		
		//从硬盘读取文件，将字节流转为字符流
		/*
		BufferedReader bufr = 
			new BufferedReader(new InputStreamReader(new FileInputStream("in.txt")));
		*/

		//将输出流转成字符流，并将键盘录入的数据大写，然后保存到文件中
		BufferedWriter bufw = 
			new BufferedWriter(new OutputStreamWriter(new FileOutputStream("out.txt")));

		String line = null;

		while((line=bufr.readLine()) != null)
		{
			if("over".equals(line))
				break;

			bufw.write(line.toUpperCase());  //写入缓冲区
			bufw.newLine();  //换行
			bufw.flush();    //将缓冲区中的数据写入磁盘
		}
		bufr.close();
	}
}
