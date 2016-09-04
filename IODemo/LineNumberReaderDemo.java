
import java.io.*;

//����һ��MyLineNumberReader�࣬����ʵ��LineNumberReader�Ĺ��ܣ��Ż���Ĵ��룺
class MyLineNumberReader extends MyBufferedReader
{
	private Reader r;
	MyLineNumberReader(Reader r)
	{
		super(r);
	}
	
	//����һ��myReaderLine����������ʵ��һ�ζ�ȡһ�еĹ���
	public String myReadLine() throws IOException
	{
		lineNumber++;
		return super.myReadLine();
	}
	
	//����һ��setLineNumber���������������к�
	public void setLineNumber(int lineNumber)
	{
		this.lineNumber = lineNumber;
	}

	//����һ��getLineNumber���������ڻ�ȡ�к�
	public int getLineNumber()
	{
		return lineNumber;
	}
	
}

//����һ��MyLineNumberReader�࣬����ʵ��LineNumberReader�Ĺ��ܣ��Ż�ǰ�Ĵ��룺
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
		//lnr.setLineNumber(10);   //����һ��Ĭ����ʼ�к�
		while((line=lnr.readLine()) != null)
		{
			System.out.println(lnr.getLineNumber()+":"+line);
		}

		lnr.close();
	}
}
