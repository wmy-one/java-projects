/*
set�����򣬲������ظ�Ԫ�أ�
  |--HashSet�����ݽṹ�ǹ�ϣ���߳��Ƿ�ͬ���ģ�
              ��֤Ԫ��Ψһ�Ե�ԭ���ж�Ԫ�ص�hashCodeֵ�Ƿ���ͬ��
	      �����ͬ����������ж�Ԫ�ص�equals�������Ƿ�Ϊtrue��

  |--TreeSet�����Զ�set�����е�Ԫ�ؽ�������
		  �ײ����ݽṹ�Ƕ���������֤Ԫ��Ψһ�Ե����ݣ�
		  ͨ������compareTo�������ж�return 0

TreeSet����ĵ�һ�ַ�ʽ����Ԫ������߱��Ƚ��ԣ�Ԫ��Ҫʵ��Comparable�ӿڣ�
����compareTo��������������Ҳ��ΪԪ�ص���Ȼ˳�򣬻��߽���Ĭ��˳��

TreeSet����ĵڶ��ַ�ʽ����Ԫ�������߱��Ƚ���ʱ�����߾߱��ıȽ��Բ�������Ҫ�ģ�
��ʱ����Ҫ�ü�������߱��Ƚ��ԡ��ڼ��ϳ�ʼ��ʱ�������˱ȽϷ�ʽ��

����
��TreeSet�����д洢�Զ������ѧ����
�밴��ѧ���������������

��ס������ʱ������Ҫ������ͬʱ��һ��Ҫ�ж�һ�´�Ҫ������
*/

import java.util.*;

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
		System.out.println(this.name+"...compareTo..."+s.name);

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


class TreeSetDemo
{
    public static void main(String[] args)
    {
		TreeSet ts = new TreeSet();

		ts.add(new Student("Tom01",21));
		ts.add(new Student("Jhon004",22));
		ts.add(new Student("lsi06",25));
		ts.add(new Student("lsi03",25));

		Iterator it = ts.iterator();
		while(it.hasNext())
		{
			Student stu = (Student)it.next();
			System.out.println(istu.getName()+"..."+stu.getAge());
		}
    }
}