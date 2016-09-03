
import java.util.*;

//���Ͷ����ڽӿ���
interface Inter<T>
{
	void show(T t)
}

//����һ��
/*
class InterImpl implements Inter<String>
{
	public void show(String t)
	{
		System.out.prinln("show:"+t);
	}
}
*/

//��������
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
		//����һ��
		/*
		InterImpl i = new InterImpl();
		
		i.show("Hello World!");
		*/

		//��������
		InterImpl<Integer> i = new InterImpl<Integer>();

		i.show(3);
	}
}

