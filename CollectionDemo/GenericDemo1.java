/*
���ͣ�JDL1.5�汾�Ժ���������ԣ����ڽ����ȫ���⣬
��һ�����Ͱ�ȫ���ơ�

�ŵ㣺
1��������ʱ�ڳ��ֵ�����ClassCastException��ת�Ƶ��˱���ʱ�ڣ�
    �������Ա������⣬������ʱ��������٣���ð�ȫ��
2��������ǿ��ת�����鷳��

���͸�ʽ��ͨ��<>������Ҫ�����������������͡�

��ʹ��java�ṩ�Ķ���ʱ��ʲôʱ��д�����أ�
ͨ���ڼ��Ͽ���кܳ�����ֻҪ����<>��Ҫ���巺�͡�

��ʵ��<>���������������͵ģ���ʹ�ü���ʱ����������Ҫ�洢����������
��Ϊ�������ݵ�<>�м��ɡ�
*/

import java.util.*;

class GenericDemo 
{
	public static void main(String[] args) 
	{
		//����һ��ArryList�������洢��������String���ͣ�
		//�����޶������������͵�д�����Ƿ���
		ArrayList<String> al = new ArrayList<String>();

		al.add("abc01");
		al.add("abc02");
		al.add("abc03");

		//al.add(4); //��Ч�ڣ�al.add(new Integer(4));
		
		Iterator<String> it = al.iterator();
		while(it.hasNext())
		{
			String s = it.next(); //����ʹ��ǿת
			System.out.println(s+":"+s.length());
		}
	}
}
