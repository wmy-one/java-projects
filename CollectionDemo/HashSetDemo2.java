/*
往hashSet集合中传入自定义对象；
姓名和年龄相同为同一个人，即重复元素。
*/

import java.util.*;

class Person
{
	private String name;
	private int age;
	Person(String name, int age)
	{
		this.name = name;
		this.age = age;
	}

	public String getName()
	{
		return name;
	}
	public int getAge()
	{
		return age;
	}

	public boolean equals(Object obj)
	{
		if(!(obj instanceof Person))
			return false;

		Person p = (Person)obj;
		System.out.prinln(this.name+"...equals..."+p.name);

		return this.name.equals(p.name) && this.age == p.age;
	}

	public int hashCode()
	{
		System.out.prinln(this.name+"...hashCode");
		return name.hashCode()+age*39;  //此处的39是为了避免hashCode值相同
	}
}

class HashSetDemo2
{
	public staticvoid printFun(Object obj)
	{
		System.out.println(obj);
	}

	public static void main(String[] args)
	{
		HashSet hs = new HashSet();

		//向hashSet集合中添加元素
		hs.add(new Person("a1",10));
		hs.add(new Person("a2",12));
		hs.add(new Person("a3",15));

		printFun(hs.contains(new Person("a1",10)));
		hs.remove(new Person("a3",15));

		Iterator it = hs.iterator();
		while(it.hasNext())
		{
			Person p = (Person)it.next();
			printFun(p.getNmae()+"::"+p.getAge());
		}
	}
}