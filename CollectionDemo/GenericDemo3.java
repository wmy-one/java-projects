/*
练习：
     使用泛型概念，将字符串长度按照从大到小的顺序打印出来
*/

import java.util.*;

class Worker
{
}
class Student
{
}

//泛型前做法
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

//泛型类: 什么时候定义呢？
/*当类中要操作的引用数据类型不确定时，
早起定义Object来完成扩展，现在定义泛型来完成扩展。
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
		//泛型前
		/* 
		Tool t = new Tool();

		t.setWorker(new Worker());
		Worker w = (Worker)t.getObject();
		*/

		//泛型后：使用泛型类
		Utils<Worker> u = new Utils<Worker>();
		
		u.setObject(new Worker());
		Worker w = u.getObject();
	}
}

