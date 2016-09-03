
import java.uil.*;

/*
当元素自身不具备比较性，或者具备的比较性不是所需要的，
这时需要让容器自身具备比较性，定义了比较器，
将比较器对象作为参数传递给TreeSet集合的构造函数。

当两种排序都存在时，以比较器为主。

定义一个类实现comparator接口，覆盖compare方法，以return 0作为元素是否相同。
*/
class Student implements Comparable //该接口强制让学生类具备比较性。
{
    private String name;
    private int age;
    Student(String name, int age)
    {
		this.name = name;
		this.age = age;
    }
    public int compareTo(Object obj)
    {	
		if(!(obj instanceof Student))
			throw new RuntimeException("不是学生对象");
	
		Student s = (Student)obj;
		//System.out.println(this.name+"...compareTo..."+s.name);

		if(this.age > s.age)  //此对象大于指定对象，返回正数
			return 1;
		if(this.age == s.age)
		{
			return this.name.compareTo(s.name);
		}
 		return -1;
    }

    public String getName()
    {
		return name;
    }
    public int getAge()
    {
		return age;
    }
}


class TreeSetDemo2 
{
	public static void main(String[] args) 
	{
		//按照姓名排序
		TreeSet ts = new TreeSet(new MyCompare());

		ts.add(new Student("Tom01",21));
		ts.add(new Student("Jhon004",22));
		ts.add(new Student("lsi06",25));
		ts.add(new Student("lsi03",23));

		Iterator it = ts.iterator();
		while(it.hasNext())
		{
			Student stu = (Student)it.next();
			System.out.println(istu.getName()+"..."+stu.getAge());
		}
	}
}

//用于实现按照姓名进行排序
class MyCompare implements Comparator
{
	public int compare(Object o1, Object o2)
	{
		Student s1 = (Student)o1;
		Student s2 = (Student)o2;

		int num = s1.getName().compareTo(s2.getName());

		if(num == 0)
		{
			return new Integer(s1.getAge()).compareTo(new Integer(s2.getAge()));
			/*
			if(s1.getAge() > s2.getAge())
				return 1;
			if(s1.getAge() == s2.getAge())
				return 0;

			return -1;
			*/
		}
		return num;
	}
}