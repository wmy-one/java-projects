/*
有五个学生，每个学生有3门课的成绩；从键盘输入以上数据（包括：姓名、三门课的成绩）；
输入格式：如：zhangsan, 30, 40, 60计算出总成绩；
并把学生的信息和计算出的总分数，按照高低顺序存放在磁盘文件中：study.txt。

1、描述学生对象；
2、定义一个可以操作学生对象的工具类；

思想：
1、通过获取键盘录入的一行数据，并将该行中的信息取出封装成学生对象；
2、因为学生对象有很多，此时就需要存储，使用的集合；因为要对学生的总分排序，
	所以可以使用TreeSet；
3、将集合中的信息写入到一个文件中。
*/

import java.io.*;
import java.util.*;

class Student implements Comparable<Student>
{
	private String name;
	private int ma,cn,en;
	private int sum;

	Student(String name, int ma, int cn, int en)
	{
		this.name=name;
		this.ma=ma;
		this.cn=cn;
		this.en=en;

		sum = ma + cn + en;
	}

	public int compareTo(Student s)
	{
		int num = new Integer(this.sum).compareTo(new Integer(s.sum));
		if(num=0)
			return this.name.compareTo(s.name)

		return num;
	}

	public String getName()
	{
		return name;
	}

	public int getSum()
	{
		return sum;
	}

	public int hashCode()
	{
		return name.hashCode()+sum*78;
	}

	public boolean equals(Object obj)
	{
		if(!(obj instanceof Student))
			throw new ClassCastException("类型不匹配");

		Student s = (Student) obj;
		return this.name.equals(s.name) && this.sum==s.sum.
	}

	public String toString()
	{
		return "Student["+name+", "+ma+", "+cn+", "+en+"]";
	}
}

class StudentInfoTool
{
	public static Set<Student> getStudents() throws IOException
	{
		return getStudents(null);
	}

	public static Set<Student> getStudents(Comparator<Student> cmp) throws IOException
	{
		BufferedReader bufr = 
			new BufferedReader(new InputStreamReader(System.in));

		String line=null;
		Set<Student> stus = null;

		if(cmp == null)
			stus=new TreeSet<Student>();
		else
			stus=new TreeSet<Student>(cmp);	

		while((line=bufr.readLine()) != null)
		{
			if("over".equals(line))
				break;

			String[] info = line.split(",");
			
			Student stu =  new Student(info[0],Integer.parseInt(info[1]),
								Integer.parseInt(info[2]),Integer.parseInt(info[3]));
			stus.add(stu);
		}

		bufr.close();
		return stus;
	}

	//定义一个write2File函数，用于将集合中的学生信息写入文件中
	public static void write2File(Set<Student> stus) throws IOException
	{
		BufferedWriter bufw = new BufferedWriter(new FileWriter("stuinfo.txt"));

		for(Student stu : stus)
		{
			bufw.write(stu.toString()+"\t");  //写入学生的名字和三门成绩
			bufw.write(stu.getSum()+"");     //写入总分

			bufw.newLine();
			bufw.flush();
		}

		bufw.close();
	}
}

class EncodeDemo2 
{
	public static void main(String[] args) 
	{
		/*
		将“联通”采用GBK进行编码，由于“联通”的二进制编码符合utf编码格式，
		将按照utf解码，这样将会出现乱码。
		*/
		String s = "联通"; 
		byte[] by = s.getBytes("gbk");

		for(byte b : by)
		{
			//将十进制转为二进制，因为编码后表现形式是负数，和255向与获取有效位
			System.out.println(Integer.toBinaryString(b&255));  
		}

		//从键盘录入学生的成绩，并将学生信息和成绩保存到文件中
		Comparatot<Student> cmp = Collection.reverseOrder();
		Set<Student> stus = StudentInfoTool.getStudents();

		StudentInfoTool.write2File(stus);
	}
}
