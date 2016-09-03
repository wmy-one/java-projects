/*
泛型：JDL1.5版本以后出现新特性，用于解决安全问题，
是一个类型安全机制。

优点：
1、将运行时期出现的问题ClassCastException，转移到了编译时期；
    方便程序员解决问题，让运行时期问题减少，变得安全。
2、避免了强制转换的麻烦。

泛型格式：通过<>来定义要操作的引用数据类型。

在使用java提供的对象时，什么时候写泛型呢？
通常在集合框架中很常见，只要见到<>就要定义泛型。

其实，<>就是用来接收类型的；当使用集合时，将集合中要存储的数据类型
作为参数传递到<>中即可。
*/

import java.util.*;

class GenericDemo 
{
	public static void main(String[] args) 
	{
		//定义一个ArryList容器，存储的数据是String类型，
		//这种限定容器参数类型的写法就是泛型
		ArrayList<String> al = new ArrayList<String>();

		al.add("abc01");
		al.add("abc02");
		al.add("abc03");

		//al.add(4); //等效于：al.add(new Integer(4));
		
		Iterator<String> it = al.iterator();
		while(it.hasNext())
		{
			String s = it.next(); //不在使用强转
			System.out.println(s+":"+s.length());
		}
	}
}
