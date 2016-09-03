/*
map���ϵ��ص㣺
�ü��ϴ洢��ֵ�ԣ�һ��һ������洢������Ҫ��֤����Ψһ�ԡ�

1����ӣ�
    put(K key, 	V value)
    putAll(Map<? extends K, ?extends V>m)  //��ָ��ӳ���н�����ӳ���ϵ���Ƶ���ӳ����
2��ɾ����
    clear()�������ӳ���ϵ��
    remove(Object key)
3���жϣ�
    containsValue(Object value)
    containsKey(Object key)
    isEmpty()
4����ȡ��
    get(Object key)��size()��values()

map���ϵ�����ȡ��������
1��Set<k> keySet()����map�����еļ�����set���ϣ���Ϊset�߱���������
   ����ͨ����������ȡ�����еļ����ٸ���get��������ȡÿһ������Ӧ��ֵ��

Map���ϵ�ȡ��ԭ����map����ת��set���ϣ���ͨ��������ȡ����

2��Set<map.Entry<k,v>> entrySet()����map�����е�ӳ���ϵ���뵽set�����С�

map.Entry����ʵEntryҲ��һ���ӿڣ�����map�ӿ��е�һ���ڲ��ӿ�:
interface Map
{
	public static interface Entry
	{
		public abstract Object getKey();
		public abstract Object getValue();
	}
}

class HashMap implements Map.Entry
{
	class HaHa implements Map.Entry
	{
		public Object getKey(){}
		public Object getValue(){}
	}
}

Map
  |--Hashtable���ײ��ǹ�ϣ�����ݽṹ�������Դ���null��nullֵ���ü������߳�ͬ���ġ�
  |--HashMap���ײ��ǹ�ϣ�����ݽṹ������ʹ��nullֵ��null�����ü����ǲ�ͬ���ġ�Ч�ʸ�
  |--TreeMap���ײ��Ƕ��������ݽṹ���̲߳�ͬ�����������ڸ�map�����еļ���������

��set������ʵ��set�ײ����ʹ����map���ϡ�
*/

import java.util.*;

class MapDemo
{
	public static void main(String[] args)
	{
		Map<String,String> map = new HashMap<String,String>();

		//���Ԫ�أ�������ʱ������ͬ�ļ�������ӵ�ֵ�Ḳ��ԭ�м���Ӧ��ֵ��
		//����put�����᷵�ر����ǵ�ֵ��
		map.put("01","Tom_1");
		map.put("02","Tom_2");
		map.put("03","Tom_3");
		map.put("04","Tom_4");

		//ʹ��containsKey���������ж�map�������Ƿ��ж�Ӧ�ļ�������У�����true��
		System.out.println("containsKey:"+map.containsKey("002"));

		//ʹ��remove������ɾ��ָ���ļ��������ظü���Ӧ��ֵ�����û�ж�Ӧ�ļ�������null
		//System.out.println("remove:"+map.remove("02"));

		//ʹ��get������ȡmap������ָ������Ӧ��ֵ������������ڣ�����null
		System.out.println("get:"+map.get("02"));

		//HashMap�ļ���ֵ����ʹ��null������ͨ��get�����ķ���ֵ���ж�һ�����Ƿ����
		map.put(null,"haha");
		System.out.println("get:"+map.get(null));

		//��ȡmap���������е�ֵ
		Collection<String> coll = map.values();
		System.out.println(coll);
		
		//ͨ��map���ϵ�keySet()�����Ȼ�ȡmap���ϵ����м���set����
		Set<String> keySet = map.keySet();

		//����set���ϣ��Ϳ��Ի�ȡ�������
		Iterator<String> it = keySet.iterator();

		while(it.hasNext())
		{
			String key = it.next();

			//���˼�����ͨ��map���ϵ�get������ȡ���Ӧ��ֵ
			String value = map.get(key);
			System.out.println("keySet()-->"+"key:"+key+"��value:"+value);
		}

		//��map�����е�ӳ���ϵȡ�������뵽set������
		Set<Map.Entry<String,String>> entrySet = map.entrySet();

		//����set���ϣ��Ϳ��Ի�ȡ�������
		Iterator<Map.Entry<String,String>> it2 = entrySet.iterator();

		while(it2.hasNext())
		{
			Map.Entry<String,String> me = it2.next();

			//map�����е�ӳ���ϵ��Map.Entry���ͣ���ʹ�ø����͵�getKey��getValue������
			//��ȡ��ϵ�еļ���ֵ
			String key = me.getKey();  
			String value = me.getValue();

			System.out.println("entrySet()-->"+"key:"+key+"��value:"+value);
		}
	}
}