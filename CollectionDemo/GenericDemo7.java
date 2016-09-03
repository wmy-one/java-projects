
import java.util.*;

class GenericDemo7
{
	public static void main(String[] args) 
	{
		TreeSet<Student> ts = new TreeSet<Student>(new Comp());

		ts.add(new Student("S1"));
		ts.add(new Student("S3"));
		ts.add(new Student("S6"));
		ts.add(new Student("S2"));

		Iterator<Student> it = ts.iterator();

		while(it.hasNext())
		{
			System.out.println(it.next().getName());
		}


		TreeSet<Worker> ts1 = new TreeSet<Worker>(new Comp());

		ts1.add(new Worker("wS--1"));
		ts1.add(new Worker("wS--3"));
		ts1.add(new Worker("wS--6"));
		ts1.add(new Worker("wS--2"));

		Iterator<Worker> it1 = ts1.iterator();

		while(it1.hasNext())
		{
			System.out.println(it1.next().getName());
		}
	}
}

//此处需要给每个Person类的子类创建比较器，用于接收特定类型
/*
class StuComp implements Comparator<Student>
{
	public int compare(Student s1, Student s2)
	{
		return s2.getName().compareTo(s1.getName());
	}
}

class WorComp implements Comparator<Worker>
{
	public int compare(Worker w1, Worker w2)
	{
		return w2.getName().compareTo(w1.getName());
	}
}
*/

class Comp implements Comparator<Person>  //TreeSet<Comparator<? super E>>
{
	public int compare(Person p1, Person p2)
	{
		return p1.getName().compareTo(p2.getName());
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

class Worker extends Person
{
	Worker(String name)
	{
		super(name);
	}
}
