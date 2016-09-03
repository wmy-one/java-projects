/*
��ϰ��
     ʹ�÷��͸�����ַ������Ȱ��մӴ�С��˳���ӡ����
*/

import java.util.*;

class GenericDemo2 
{
	public static void main(String[] args) 
	{
		//����һ��TreeSet�������洢��������String���ͣ�
		//�����޶������������͵�д�����Ƿ���
		TreeSet<String> ts = new TreeSet<String>(new LenComparator());

		ts.add("abcd");
		ts.add("cc");
		ts.add("cba");
		ts.add("aaa");
		ts.add("z");
		ts.add("hahaha");

		//����iterator�����������ڴ˼���Ԫ���Ͻ��е����ĵ�����
		Iterator<String> it = ts.iterator();
		while(it.hasNext())
		{
			String s = it.next();  //����ʹ��ǿת
			System.out.println(s+":"+s.length());
		}
	}
}

class LenComparator implements Comparator
{
	public int compare(String o1, String o2)
	{
		//�������䣬����ʵ��������������������ַ������ȴӴ�С��˳��
		int num = new Integer(o2.length()).compareTo(new Integer(o1.length()));

		if(num == 0)
			return o2.compareTo(o1);
		return num;
	}
}
