/*
1��װ�����ģʽ��
����Ҫ�����еĶ�����й�����ǿʱ�����Զ����࣬�����ж����룬
�������й��ܣ����ṩ��ǿ���ܣ���ʱ���Զ���ĸ���ͳ�Ϊװ���ࡣ

װ������ص㣺
װ����ͨ����ͨ�����췽�����ձ�װ�ζ��󣬲����ڱ�װ�ζ���Ĺ��ܣ��ṩ��ǿ�Ĺ��ܡ�

2���̳к�װ�ε�����

//�̳������ϵ�ṹ
MyReader //ר�����ڶ�ȡ���ݵ���
	|--MyTextReader
		|--MyBufferedTextReader
	|--MyMediaReader
		|--MyBufferedMediaReader
	|--MyDataReader
		|--MyBufferedDataReader

class MyBufferedReader()
{
	MyBufferedReader(MyTextReader text)
	{}
	MyBufferedReader(MyMediaReader media)
	{}
}
������������չ�Խϲ�ҵ�������Ĺ�ͬ���ͣ�ͨ����̬����ʽ�����������չ�ԡ�

class MyBufferedReader() extends MyReader
{
	Private MyReader r;
	MyBufferedReader(MyReader r)
	{}
}

//װ�������ϵ�ṹ
MyReader //ר�����ڶ�ȡ���ݵ���
	|--MyTextReader
	|--MyMediaReader
	|--MyDataReader
	|--MyBufferedReader

װ��ģʽ�ȼ̳��������˼̳���ϵ��ӷ�ף����ҽ�������֮��Ĺ�ϵ��

װ������Ϊ��ǿ���ж��󣬾߱��Ĺ��ܺ����е�����ͬ�ģ�ֻ�����ṩ�˸�ǿ�Ĺ��ܣ�
����װ����ͱ�װ����ͨ��������һ����ϵ�е�
*/

//��һ��Person�࣬���������򵥵��˳Է�����
class Person
{
	public void eatFun()
	{
		System.out.println("�Է���");
	}
}

//����һ��SuperPerson�࣬������ǿPerson�����Ĺ���
class SuperPerson
{
	SuperPerson(Person p)
	{
		this.p = p;
	}

	//����һ��superPerson������������ǿPerson������eatFun����
	public void superEat()
	{
		System.out.println("��θ�ˣ�");
		p.eatFun();
		System.out.println("��㣡");
		System.out.println("�Ȳ裡");
	}
}

class PersonDemo
{
	public static void main(String[] args) 
	{
		Person p = new Person();  //����һ��Person�����
		//p.eatFun();   //����Person��������еĹ���
		
		/*
		����һ����ǿ����󣬲���Person�������Ϊ������
		��������ǿ����󷽷������ڻ�ȡ��ǿ��Ĺ��ܡ�
		*/
		SuperPerson sp = new SuperPerson(p);  
		sp.superEat();
	}
}
