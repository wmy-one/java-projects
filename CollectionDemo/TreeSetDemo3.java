/*
练习：按照字符串长度进行排序。
字符串本身具备比较性，但是他的比较方式不是所需要的，
这时就只能使用比较器。
*/

import java.util.*;

class TreeSetDemo3 
{
	public static void main(String[] args) 
	{
		TreeSet ts = new TreeSet(new StrLenComparator());

		ts.add("abcd");
		ts.add("cc");
		ts.add("cba");
		ts.add("aaa");
		ts.add("z");
		ts.add("hellohaha");

		Iterator it = ts.iterator();
		while(it.hasNext())
		{
			System.out.println(it.next());
		}
	}
}

class StrLenComparator implements Comparator
{
	public int compare(Object o1,Object o2)
	{
		String s1 = (String)o1;
		String s2 = (String)o2;

		//方法一：使用判断条件进行比较
		/*
		if(s1.length() > s2.length())
			return 1;
		if(s1.length() == s2.length())
			return 0;
		*/
	
		//方法二：封装成对象，调用compareTo方法进行比较
		int num = new Integer(s1.length()).compareTo(new Integer(s2.length()));
		if(num ==0 )
			return s1.compareTo(s2);
		return num;
	}
}
