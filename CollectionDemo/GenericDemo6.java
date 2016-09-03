/*
?��ͨ�����Ҳ�������Ϊռλ����
���͵��޶���
? extends E�����Խ���E���ͻ��������ͣ����ޣ�
? super E�����Խ���E���ͻ���E�ĸ����ͣ����ޣ�
*/

import java.util.*;

class GenericDemo6 
{
	public static void main(String[] args) 
	{
		/*
		ArrayList<String> al = new ArrayList<String>();

		al.add("a1");
		al.add("a2");
		al.add("a3");

		ArrayList<Integer> al1 = new ArrayList<Integer>();

		al.add(1);
		al.add(2);
		al.add(3);
		
		printColl(al);
		printColl(al1);
		*/

		ArrayList<Person> al = new ArrayList<Person>();
		al.add(new Person("A1"));
		al.add(new Person("A2"));
		al.add(new Person("A3"));
		printColl(al);

		ArrayList<Student> al1 = new ArrayList<Student>();
		al.add(new Student("A--1"));
		al.add(new Student("A--2"));
		al.add(new Student("A--3"));
		printColl(al1); //ArrayList<Person> al = new ArrayList<Student>();
	}
	/*
	public static void printColl(ArrayList<?> al) //�˴��ģ���ʾ���Ͳ�ȷ��
	{
		Iterator<?> it = al.iterator();
		while(it,hasNext())
		{
			System.out.println(it.next());
		}
	}
	*/

	//�˴���? extends��ʾ�˷��͵Ľ��������޶�Ϊ��Person��������
	public static void printColl(ArrayList<? extends Person> al)
	{
		Iterator<? extends Person> it = al.iterator();
		while(it,hasNext())
		{
			System.out.println(it.next().getName());
		}
	}
}

class Person
{
	private String name;
	Person(String name)
	{
		this.name = name;
	}
	public String getName()
	{
		return name;
	}
}

class Student extends Person
{
	Student(String name)
	{
		super(name);
	}
}

/*
class Student implements Comparable<Person> //<? extends Person>
{
	public int compareTo(Person s)
	{
		this.getName();
	}
}

class Comp implements Comparator<Student>
{
	public int compare(Student s1, Student s2)
	{
		return s1.getName().compareTo(s2.getName());
	}
}

TreeSet<Student> ts new TreeSet<Student>(new Comp());
ts.add(new Studnet("s1"));
ts.add(new Studnet("s2"));
ts.add(new Studnet("s3"));
*/