/*
�����ඨ��ķ��ͣ�������������Ч�����������ʹ�ã�
��ô������Ķ�����ȷҪ�����ľ������ͺ�����Ҫ����
�����;��Ѿ��̶��ˡ�

Ϊ���ò�ͬ�������Բ�����ͬ���ͣ��������ͻ���ȷ��,
��ô���Խ����Ͷ����ڷ����ϡ�

����֮����
��̬���������Է������϶���ķ��ͣ�
�����̬����������Ӧ���������Ͳ�ȷ����
���Խ����Ͷ����ڷ����ϡ�
*/

import java.util.*;

//���������Ͷ��������ϣ�Ӧ�õ�������
/*
class Demo<T>
{
	//ʹ�÷��ͷ���ǰ����Ҫ��ȷ�����еĲ�������
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

	//���ͷ���: ���������ɵ�����ָ��
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
class Demo  //���������Ͷ����ڷ�����
{	
	//���ͷ���: ���������ɵ�����ָ��
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


//���ͷֱ�������ͷ�����
class Demo<T> 
{	
	//���ͷ���: ���������ɵ�����ָ��
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
		//���������Ͷ��������ϣ�Ӧ�õ�������
		/*
		Demo<String> d = new Demo<String>();
		
		d.show("Hello world!");
		d.print("Hello HeFei!");
		*/

		//���������Ͷ����ڷ�����
		/*
		Demo d = new Demo();

		d.show("Hello World!");
		d.show(new Integer(6));
		d.print("Hello HeFei!");
		*/

		//�����ͷֱ�����ͷ�����
		Demo<String> d = new Demo<String>();
		
		d.show("Hello world!");
		//d.show(6);  //����佫���뱨��

		d.print("Hello HeFei!");
		d.show(6);  //��������ͨ��
		
		Demo.method("Hello");
	}
}

