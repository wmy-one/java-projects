/*
1、集合的出现
面向对象语言的体现形式是对象，为了对多个对象进行操作，就需要对对象进行存储，集合就是存储对象最常用的一种方式。

2、数组和集合的区别
数组可以存储对象，但长度是固定的，集合的长度可变；数组可以存储基本数据类型，集合只能存储对象，
集合中存储的都是对象的引用(地址)。

3、集合的特点
集合的长度是可变的，集合只能存储对象，集合可以存储不同类型的对象。

4、多个容器的出现
每个容器对数据的存储方式不同，这个存储方式可以称之为：数据结构。

5、迭代器的使用
迭代器就是集合中用于取出元素的方式；通过iterator()方法实现，该方法返回Iterator接口对象，
有hasNext()和next()方法，如果集合中有元素，hasNext返回true，而next用于取出集合中的元素。

6、collection接口
collection：
	|--List：元素有序，可以重复，因为该集合体系有索引；
	|--Set：元素无序，不可重复。

List特有的方法：凡是可以操作角标的方法都是该体系特有的方法。
add(index,element)、addAll(index,Collection)、reove(index)
set(index,element)、get(index)、subList(from,to)、listIterator()

List集合特有的迭代器listIterator是Iterator的子接口；在迭代时，不可以通过集合对象的方法
操作集合中的元素，因为将发生ConcurrentModificationException异常。

所以，在迭代时，只能使用迭代器的方法操作元素，但是Iterator的方法是有限的，只能对元素进行
判断、取出、删除操作，如果想要其他的操作如：添加、修改等，只能通过子接口listIterator。

该接口只能通过listIterator方法获取。

*/

import java.util.*;

class CollectionDemo
{
	public static void main(String[] args) 
	{
		//创建一个集合容器，使用Collection接口的子类：ArrayList
		ArrayList al1 = new ArrayList();
		
		//添加元素
		al1.add("java_01");
		al1.add("java_02");
		al1.add("java_03");
		al1.add("java_04");

		ArrayList al2 = new ArrayList();

		al2.add("java_01");
		al2.add("java_02");
		al2.add("java_05");
		al2.add("java_06");

		//取交集，al1中只会存放和al2中相同的元素
		al1.retainAll(al2);
		
		printFun("al1："+al1);
		pritnFun("al2："+al2);

		//打印原集合
		printFun("原集合："+al1);

		//删除元素
		al1.remove("java_02");
		//al1.clear();   //清空集合

		//判断集合
		printFun("al1中是否包含元素java_03："+al1.contains("java_03"));
		printFun("集合是否为空："+al1.isEmpty());
		

		//集合大小
		printFun("size："+al1.size());

		//打印改变后的集合
		printFun(al1);

		//获取集合中的元素
		getFun();

		//List特有的方法；在指定位置添加、删除、修改、获取元素
		al.add(1,"java_007");  //在指定位置添加元素
		al.remove(2);   //删除指定位置的元素
		al.set(2,"java_001");  //修改指定位置的元素
		al.get(3);    //获取指定位置的元素

		al.indexOf("java_02");   //获取对象对应的位置
		List sub = al.subList(1,3);   //获取原集合中的1到3的元素(不包括3)，返回List类型

		ListIterator li = al.listIterator();
		while(li.hasNext())   //li.hasPrevious() 表示前一个元素
		{
			Object obj = li.next();

			if(obj.equals("java_02"))
				//li.add("java_008");
				li.set("java_009");
		}

	}

	public static void printFun(Object obj)
	{
		System.out.println(obj);
	}
	
	public static void getFun()
	{
		//创建一个集合容器，使用Collection接口的子类：ArrayList
		ArrayList al = new ArrayList();
		
		//添加元素
		al.add("java_01");
		al.add("java_02");
		al.add("java_03");
		al.add("java_04");

		Iterator it = al.iterator(); //获取迭代器，用于取出集合中的元素
		
		//方法一：取出集合中的元素
		while(it.hasNext())
		{
			printFun(it.next());
		}

		//方式二：取出集合中的元素；for语句运行完，迭代器引用也将从内存中释放
		for(Iterator it = al.iterator(); it.hasNext(); )  //更节省内存
		{
			printFun(it.next());
		}

	}
}
