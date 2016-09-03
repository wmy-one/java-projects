
import java.uil.*;

/*
��Ԫ�������߱��Ƚ��ԣ����߾߱��ıȽ��Բ�������Ҫ�ģ�
��ʱ��Ҫ����������߱��Ƚ��ԣ������˱Ƚ�����
���Ƚ���������Ϊ�������ݸ�TreeSet���ϵĹ��캯����

���������򶼴���ʱ���ԱȽ���Ϊ����

����һ����ʵ��comparator�ӿڣ�����compare��������return 0��ΪԪ���Ƿ���ͬ��
*/
class Student implements Comparable //�ýӿ�ǿ����ѧ����߱��Ƚ��ԡ�
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
			throw new RuntimeException("����ѧ������");
	
		Student s = (Student)obj;
		//System.out.println(this.name+"...compareTo..."+s.name);

		if(this.age > s.age)  //�˶������ָ�����󣬷�������
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
		//������������
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

//����ʵ�ְ���������������
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