/*
ÿһ��ѧϰ���ö�Ӧ�Ĺ����أ�ѧ��Student����ַString;
ѧ�����ԣ����������䡣

ע�⣺������������ͬ����Ϊͬһ��ѧ������֤ѧ����Ψһ�ԡ�

1������ѧ����
2������map��������ѧ����Ϊ������ַ��Ϊֵ���룻
3����ȡmap�����е�Ԫ�ء�
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
			throw new ClassCastException("���Ͳ�ƥ��");

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

		//��һ��ȡ����ʽ keySet
	}
}
