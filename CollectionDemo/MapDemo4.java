/*
需求：对学生对象的年龄进行升序排序。

因为数据是以键值对形式存在的，所以要使用可以排序的Map集合，TreeMap
*/

import java.util.*;

class Student implements Comparable<Student>
{
    private String name;
    private int age;

    Student(String name,int age)
    {
		this.name = name;
		this.age = age;
    }

    public int hashCode()
    {
		return name.hashCode()+age*34;
    }
    public boolean equals(Object obj)
    {
		if(!(obj instendceof Student))
			throw new ClassCastException("类型不匹配");
	    
		Student s = (Student)obj;
		return this.name.equals(s.name) && this.age == s.age;
    }
    public int compareTo(Student s)
    {
		int num = new Integer(this.age).compareTo(new Integer(s.age));
		if(num == 0)
			return this.name.compareTo(s.name);
		return num;
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

class StuNameComparator implements Comparator<Student>
{
    public int compare(Student s1, Student s2)
    {
		int num = s1.getName().compareTo(s2.getName());
		if(num == 0)
			return new Integer(s1.getAge()).compareTo(new Integer(s2.getAge()));

		return num;
    }
}

class MapDemo4
{
    public static void main(String[] args)
    {
		TreeMap<Student,String> tm = new TreeMap<Student,String>(new StuNameComparator());

		tm.put(new Student("Tom_1",23),beijing);
		tm.put(new Student("aTom_2",21),nanjing);
		tm.put(new Student("bTom_3",22),sahnghai);
		tm.put(new Student("Tom_4",24),hefei);

		Set<Map.Entry<Student,String>> entrySet = tm.entrySet();
		Iterator<Map.Entry<Student,String>> it = entrySet.iterator();

		while(it.hasNext())
		{
			Map.Entry<Student,String> me = it.next();

			Student stu = me.getKey();
			String addr = me.getValue();
			System.out.println(stu+"..."+addr);
		}
    }
}