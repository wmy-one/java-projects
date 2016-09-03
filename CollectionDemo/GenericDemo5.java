
import java.util.*;

//泛型定义在接口上
interface Inter<T>
{
	void show(T t)
}

//方法一：
/*
class InterImpl implements Inter<String>
{
	public void show(String t)
	{
		System.out.prinln("show:"+t);
	}
}
*/

//方法二：
class InterImpl<T> implements Inter<T>
{
	public void show(T t)
	{
		System.out.prinln("show:"+t);
	}
}

class GenericDemo5 
{
	public static void main(String[] args) 
	{
		//方法一：
		/*
		InterImpl i = new InterImpl();
		
		i.show("Hello World!");
		*/

		//方法二：
		InterImpl<Integer> i = new InterImpl<Integer>();

		i.show(3);
	}
}

