/*
泛型类定义的泛型，在整个类中有效，如果被方法使用，
那么泛型类的对象明确要操作的具体类型后，所有要操作
的类型就已经固定了。

为了让不同方法可以操作不同类型，而且类型还不确定,
那么可以将泛型定义在方法上。

特殊之处：
静态方法不可以访问类上定义的泛型，
如果静态方法操作的应用数据类型不确定，
可以将泛型定义在方法上。
*/

import java.util.*;

//仅仅将泛型定义在类上，应用到方法上
/*
class Demo<T>
{
	//使用泛型方法前：需要明确方法中的参数类型
	/*
	public void show(String t)
	{
		System.out.prinln("show:"+t);
	}
	public void print(String t)
	{
		System.out.prinln("print:"+t);
	}
	*/

	//泛型方法: 参数类型由调用者指定
	public void show(T t)
	{
		System.out.prinln("show:"+t);
	}
	public void print(T t)
	{
		System.out.prinln("print:"+t);
	}
}
*/


/*
class Demo  //仅仅将泛型定义在方法上
{	
	//泛型方法: 参数类型由调用者指定
	public <T> void show(T t)
	{
		System.out.prinln("show:"+t);
	}
	public <Q> void print(Q q)
	{
		System.out.prinln("print:"+q);
	}
}
*/


//泛型分别定义在类和方法上
class Demo<T> 
{	
	//泛型方法: 参数类型由调用者指定
	public void show(T t)
	{
		System.out.prinln("show:"+t);
	}
	public <Q> void print(Q q)
	{
		System.out.prinln("print:"+q);
	}

	public static <W> void method(W w)
	{
		System.out.println("method:"+w);
	}
}

class GenericDemo4 
{
	public static void main(String[] args) 
	{
		//仅仅将泛型定义在类上，应用到方法上
		/*
		Demo<String> d = new Demo<String>();
		
		d.show("Hello world!");
		d.print("Hello HeFei!");
		*/

		//仅仅将泛型定义在方法上
		/*
		Demo d = new Demo();

		d.show("Hello World!");
		d.show(new Integer(6));
		d.print("Hello HeFei!");
		*/

		//将泛型分别定义类和方法上
		Demo<String> d = new Demo<String>();
		
		d.show("Hello world!");
		//d.show(6);  //此语句将编译报错

		d.print("Hello HeFei!");
		d.show(6);  //此语句编译通过
		
		Demo.method("Hello");
	}
}

