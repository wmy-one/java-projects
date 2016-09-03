/*
每一个学生都有一个属性信息。
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

class MapDemo3
{
    public static void main(String[] args)
    {
		HashMap<Student, String> hm = new HashMap<Student, String>();
		hm.put(new Student("Tom_1",21),beijing);
		hm.put(new Student("Tom_2",22),nanjing);
		hm.put(new Student("Tom_3",23),sahnghai);
		hm.put(new Student("Tom_4",24),hefei);

		//第一种取出方式 keySet
		Set<Student> keySet = hm.keySet(); 
		Iterator<Student> it = keySet.iterator();

		while(it.hasNext())
		{
			Student stu = it.next();
			String addr = hm.get(stu);
			System.out.println(stu+"..."+addr);
		}

		//第二种取出方式 entrySet
		Set<Map.Entry<Student,String>> entrySet = hm.entrySet();
		Iterator<Map.Entry<Student,String>> iter = entrySet.iterator();

		while(iter.hasNext())
		{
			Map.Entry<Student,String> me = iter.next();
			Student stu = me.getKey();
			String addr = me.getValue();
			System.out.println(stu+"......"+addr);
		}
    }
}