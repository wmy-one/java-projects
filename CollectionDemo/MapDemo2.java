/*
每一个学习都用对应的归属地，学生Student，地址String;
学生属性：姓名，年龄。

注意：姓名和年龄相同的视为同一个学生，保证学生的唯一性。

1、描述学生；
2、定义map容器，将学生作为键，地址作为值存入；
3、获取map集合中的元素。
*/

import java.util.*;

class Student implements Comparable<Student>
{
	private String name;
	private int age;

	Student(String name, int age)
	{
		this.name = name;
		this.age = age;
	}

	public int compareTo(Student s)
	{
		int num = new Integer(this.age).compareTo(new Integer(s.age));

		if(num == 0)
			return this.name.compareTo(s.name);
		return num;
	}
	
	public int hashCode()
	{
		return name.hashCode()+age*34;
	}

	public boolean equals(Object obj)
	{
		if(!(obj instanceof Student))
			throw new ClassCastException("类型不匹配");

		Student s = (Student)obj;

		return this.name.equals(s.name) && this.age == s.age;
	}

	public String getName()
	{
		return name;
	}

	public int getAge()
	{
		return age;
	}
	public String toString()
	{
		return name+":"+age;
	}
}

class MapDemo2 
{
	public static void main(String[] args) 
	{
		HashMap<Student,String> hm = new HashMap<Student,String>();

		hm.put(new Student("Tom_1",21),"beijing");
		hm.put(new Student("Tom_2",22),"shanghai");
		hm.put(new Student("Tom_3",23),"nanjing");
		hm.put(new Student("Tom_4",24),"hefei");

		//第一种取出方式 keySet
	}
}
