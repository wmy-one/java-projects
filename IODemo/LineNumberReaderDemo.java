
import java.io.*;

//定义一个MyLineNumberReader类，用于实现LineNumberReader的功能；优化后的代码：
class MyLineNumberReader extends MyBufferedReader
{
	private Reader r;
	MyLineNumberReader(Reader r)
	{
		super(r);
	}
	
	//定义一个myReaderLine方法，用于实现一次读取一行的功能
	public String myReadLine() throws IOException
	{
		lineNumber++;
		return super.myReadLine();
	}
	
	//定义一个setLineNumber方法，用于设置行号
	public void setLineNumber(int lineNumber)
	{
		this.lineNumber = lineNumber;
	}

	//定义一个getLineNumber方法，用于获取行号
	public int getLineNumber()
	{
		return lineNumber;
	}
	
}

//定义一个MyLineNumberReader类，用于实现LineNumberReader的功能；优化前的代码：
/*
class MyLineNumberReader
{
	private Reader r;
	private int lineNumber;

	MyLineNumberReader(Reader r)
	{
		this.r=r;
	}
	
	public String myReadLine() throws IOException
	{
		lineNumber++;
		StringBuilder sb = new StringBuilder();

		int ch = 0;
		while((ch = r.read()) != -1)
		{
			if(ch == '\r')
				continue;
			if(ch == '\n')
				return sb.toString();
			else
				sb.append((char)ch);
		}

		if (sb.length() != 0)
		{
			return sb.toString();
		}
		return null;
	}

	public void setLineNumber(int lineNumber)
	{
		this.lineNumber = lineNumber;
	}
	public int getLineNumber()
	{
		return lineNumber;
	}
	public void myClose()
	{
		r.close();
	}
}
*/

class  LineNumberReaderDemo
{
	public static void main(String[] args) throws IOException
	{
		FileReader fr = new FileReader("text.txt");

		LineNumberReader lnr = new LineNumberReader(fr);

		String line = null;
		//lnr.setLineNumber(10);   //设置一个默认起始行号
		while((line=lnr.readLine()) != null)
		{
			System.out.println(lnr.getLineNumber()+":"+line);
		}

		lnr.close();
	}
}
