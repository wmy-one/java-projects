/*
练习：
     使用泛型概念，将字符串长度按照从大到小的顺序打印出来
*/

import java.util.*;

class GenericDemo2 
{
	public static void main(String[] args) 
	{
		//定义一个TreeSet容器，存储的数据是String类型，
		//这种限定容器参数类型的写法就是泛型
		TreeSet<String> ts = new TreeSet<String>(new LenComparator());

		ts.add("abcd");
		ts.add("cc");
		ts.add("cba");
		ts.add("aaa");
		ts.add("z");
		ts.add("hahaha");

		//调用iterator方法，返回在此集合元素上进行迭代的迭代器
		Iterator<String> it = ts.iterator();
		while(it.hasNext())
		{
			String s = it.next();  //不在使用强转
			System.out.println(s+":"+s.length());
		}
	}
}

class LenComparator implements Comparator
{
	public int compare(String o1, String o2)
	{
		//下面的语句，用于实现逆序输出，即，按照字符串长度从大到小的顺序
		int num = new Integer(o2.length()).compareTo(new Integer(o1.length()));

		if(num == 0)
			return o2.compareTo(o1);
		return num;
	}
}
