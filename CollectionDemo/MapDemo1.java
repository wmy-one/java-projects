/*
map集合的特点：
该集合存储键值对，一对一的往里存储，而且要保证键的唯一性。

1、添加：
    put(K key, 	V value)
    putAll(Map<? extends K, ?extends V>m)  //从指定映射中将所有映射关系复制到此映射中
2、删除：
    clear()清除所有映射关系；
    remove(Object key)
3、判断：
    containsValue(Object value)
    containsKey(Object key)
    isEmpty()
4、获取：
    get(Object key)、size()、values()

map集合的两种取出方法：
1、Set<k> keySet()：将map中所有的键存入set集合，因为set具备迭代器，
   可以通过迭代方法取出所有的键，再根据get方法，获取每一个键对应的值。

Map集合的取出原理：将map集合转成set集合，在通过迭代器取出。

2、Set<map.Entry<k,v>> entrySet()：将map集合中的映射关系存入到set集合中。

map.Entry：其实Entry也是一个接口，它是map接口中的一个内部接口:
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
  |--Hashtable：底层是哈希表数据结构，不可以存入null键null值。该集合是线程同步的。
  |--HashMap：底层是哈希表数据结构，运行使用null值和null键，该集合是不同步的。效率高
  |--TreeMap：底层是二叉树数据结构，线程不同步。可以用于给map集合中的键进行排序。

和set很像，其实，set底层就是使用了map集合。
*/

import java.util.*;

class MapDemo
{
	public static void main(String[] args)
	{
		Map<String,String> map = new HashMap<String,String>();

		//添加元素，如果添加时出现相同的键，后添加的值会覆盖原有键对应的值，
		//并且put方法会返回被覆盖的值。
		map.put("01","Tom_1");
		map.put("02","Tom_2");
		map.put("03","Tom_3");
		map.put("04","Tom_4");

		//使用containsKey方法用于判断map集合在是否有对应的键，如果有，返回true。
		System.out.println("containsKey:"+map.containsKey("002"));

		//使用remove方法将删除指定的键，并返回该键对应的值；如果没有对应的键，返回null
		//System.out.println("remove:"+map.remove("02"));

		//使用get方法获取map集合中指定键对应的值，如果键不存在，返回null
		System.out.println("get:"+map.get("02"));

		//HashMap的键和值可以使用null；可以通过get方法的返回值来判断一个键是否存在
		map.put(null,"haha");
		System.out.println("get:"+map.get(null));

		//获取map集合中所有的值
		Collection<String> coll = map.values();
		System.out.println(coll);
		
		//通过map集合的keySet()方法先获取map集合的所有键的set集合
		Set<String> keySet = map.keySet();

		//有了set集合，就可以获取其迭代器
		Iterator<String> it = keySet.iterator();

		while(it.hasNext())
		{
			String key = it.next();

			//有了键可以通过map集合的get方法获取其对应的值
			String value = map.get(key);
			System.out.println("keySet()-->"+"key:"+key+"，value:"+value);
		}

		//将map集合中的映射关系取出，存入到set集合中
		Set<Map.Entry<String,String>> entrySet = map.entrySet();

		//有了set集合，就可以获取其迭代器
		Iterator<Map.Entry<String,String>> it2 = entrySet.iterator();

		while(it2.hasNext())
		{
			Map.Entry<String,String> me = it2.next();

			//map集合中的映射关系是Map.Entry类型，并使用该类型的getKey和getValue方法，
			//获取关系中的键和值
			String key = me.getKey();  
			String value = me.getValue();

			System.out.println("entrySet()-->"+"key:"+key+"，value:"+value);
		}
	}
}