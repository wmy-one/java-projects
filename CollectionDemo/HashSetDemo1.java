/*
Set��Ԫ�������򣨴����ȡ����˳��һ��һ�£���Ԫ�ز����ظ���
  |--HashSet���ײ����ݽṹ�ǹ�ϣ��
     hashSet����α�֤Ԫ��Ψһ�Եģ�
     ��ͨ��Ԫ�ص�����������hashCode��equals����ɣ�
     ���Ԫ�ص�hashCodeֵ��ͬ���Ż��ж�equals�Ƿ�Ϊtrue��
     ���Ԫ�ص�hashCodeֵ��ͬ���������equals��

ע�⣺�����ж�Ԫ���Ƿ���ڣ��Լ�ɾ���Ȳ�����
      �����ķ�����Ԫ�ص�hashCode��equals����

  |--TreeSet

Set���ϵĹ��ܺ�Collection��һ�µġ�
*/

import java.util.*;

class HashSetDemo
{
	public staticvoid printFun(Object obj)
	{
		System.out.println(obj);
	}
	public static void main(String[] args)
	{
		HashSet hs = new HashSet();

		//��hashSet���������Ԫ��
		hs.add("java01");
		hs.add("java02");
		hs.add("java03");

		Iterator it = hs.iterator();
		while(it.hasNext())
		{
			printFun(it.next());
		}
	}
}