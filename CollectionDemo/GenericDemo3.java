/*
��ϰ��
     ʹ�÷��͸�����ַ������Ȱ��մӴ�С��˳���ӡ����
*/

import java.util.*;

class Worker
{
}
class Student
{
}

//����ǰ����
class Tool
{
	private Object obj;
	public void setObject(Object obj)
	{
		this.obj = obj;
	}
	public Object getObject()
	{
		return obj;
	}
}

//������: ʲôʱ�����أ�
/*������Ҫ�����������������Ͳ�ȷ��ʱ��
������Object�������չ�����ڶ��巺���������չ��
*/
class Utils<Q>
{
	private Q =q;
	public void setObject(Q q)
	{
		this.q = q;
	}
	public Q getObject()
	{
		return q;
	}
}

class GenericDemo3 
{
	public static void main(String[] args) 
	{
		//����ǰ
		/* 
		Tool t = new Tool();

		t.setWorker(new Worker());
		Worker w = (Worker)t.getObject();
		*/

		//���ͺ�ʹ�÷�����
		Utils<Worker> u = new Utils<Worker>();
		
		u.setObject(new Worker());
		Worker w = u.getObject();
	}
}

