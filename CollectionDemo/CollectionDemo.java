/*
1�����ϵĳ���
����������Ե�������ʽ�Ƕ���Ϊ�˶Զ��������в���������Ҫ�Զ�����д洢�����Ͼ��Ǵ洢������õ�һ�ַ�ʽ��

2������ͼ��ϵ�����
������Դ洢���󣬵������ǹ̶��ģ����ϵĳ��ȿɱ䣻������Դ洢�����������ͣ�����ֻ�ܴ洢����
�����д洢�Ķ��Ƕ��������(��ַ)��

3�����ϵ��ص�
���ϵĳ����ǿɱ�ģ�����ֻ�ܴ洢���󣬼��Ͽ��Դ洢��ͬ���͵Ķ���

4����������ĳ���
ÿ�����������ݵĴ洢��ʽ��ͬ������洢��ʽ���Գ�֮Ϊ�����ݽṹ��

5����������ʹ��
���������Ǽ���������ȡ��Ԫ�صķ�ʽ��ͨ��iterator()����ʵ�֣��÷�������Iterator�ӿڶ���
��hasNext()��next()�����������������Ԫ�أ�hasNext����true����next����ȡ�������е�Ԫ�ء�

6��collection�ӿ�
collection��
	|--List��Ԫ�����򣬿����ظ�����Ϊ�ü�����ϵ��������
	|--Set��Ԫ�����򣬲����ظ���

List���еķ��������ǿ��Բ����Ǳ�ķ������Ǹ���ϵ���еķ�����
add(index,element)��addAll(index,Collection)��reove(index)
set(index,element)��get(index)��subList(from,to)��listIterator()

List�������еĵ�����listIterator��Iterator���ӽӿڣ��ڵ���ʱ��������ͨ�����϶���ķ���
���������е�Ԫ�أ���Ϊ������ConcurrentModificationException�쳣��

���ԣ��ڵ���ʱ��ֻ��ʹ�õ������ķ�������Ԫ�أ�����Iterator�ķ��������޵ģ�ֻ�ܶ�Ԫ�ؽ���
�жϡ�ȡ����ɾ�������������Ҫ�����Ĳ����磺��ӡ��޸ĵȣ�ֻ��ͨ���ӽӿ�listIterator��

�ýӿ�ֻ��ͨ��listIterator������ȡ��

*/

import java.util.*;

class CollectionDemo
{
	public static void main(String[] args) 
	{
		//����һ������������ʹ��Collection�ӿڵ����ࣺArrayList
		ArrayList al1 = new ArrayList();
		
		//���Ԫ��
		al1.add("java_01");
		al1.add("java_02");
		al1.add("java_03");
		al1.add("java_04");

		ArrayList al2 = new ArrayList();

		al2.add("java_01");
		al2.add("java_02");
		al2.add("java_05");
		al2.add("java_06");

		//ȡ������al1��ֻ���ź�al2����ͬ��Ԫ��
		al1.retainAll(al2);
		
		printFun("al1��"+al1);
		pritnFun("al2��"+al2);

		//��ӡԭ����
		printFun("ԭ���ϣ�"+al1);

		//ɾ��Ԫ��
		al1.remove("java_02");
		//al1.clear();   //��ռ���

		//�жϼ���
		printFun("al1���Ƿ����Ԫ��java_03��"+al1.contains("java_03"));
		printFun("�����Ƿ�Ϊ�գ�"+al1.isEmpty());
		

		//���ϴ�С
		printFun("size��"+al1.size());

		//��ӡ�ı��ļ���
		printFun(al1);

		//��ȡ�����е�Ԫ��
		getFun();

		//List���еķ�������ָ��λ����ӡ�ɾ�����޸ġ���ȡԪ��
		al.add(1,"java_007");  //��ָ��λ�����Ԫ��
		al.remove(2);   //ɾ��ָ��λ�õ�Ԫ��
		al.set(2,"java_001");  //�޸�ָ��λ�õ�Ԫ��
		al.get(3);    //��ȡָ��λ�õ�Ԫ��

		al.indexOf("java_02");   //��ȡ�����Ӧ��λ��
		List sub = al.subList(1,3);   //��ȡԭ�����е�1��3��Ԫ��(������3)������List����

		ListIterator li = al.listIterator();
		while(li.hasNext())   //li.hasPrevious() ��ʾǰһ��Ԫ��
		{
			Object obj = li.next();

			if(obj.equals("java_02"))
				//li.add("java_008");
				li.set("java_009");
		}

	}

	public static void printFun(Object obj)
	{
		System.out.println(obj);
	}
	
	public static void getFun()
	{
		//����һ������������ʹ��Collection�ӿڵ����ࣺArrayList
		ArrayList al = new ArrayList();
		
		//���Ԫ��
		al.add("java_01");
		al.add("java_02");
		al.add("java_03");
		al.add("java_04");

		Iterator it = al.iterator(); //��ȡ������������ȡ�������е�Ԫ��
		
		//����һ��ȡ�������е�Ԫ��
		while(it.hasNext())
		{
			printFun(it.next());
		}

		//��ʽ����ȡ�������е�Ԫ�أ�for��������꣬����������Ҳ�����ڴ����ͷ�
		for(Iterator it = al.iterator(); it.hasNext(); )  //����ʡ�ڴ�
		{
			printFun(it.next());
		}

	}
}
