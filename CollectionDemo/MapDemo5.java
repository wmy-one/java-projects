/*
��ϰ��
"sdfzxcasdfxcvdf"��ȡ�ַ����е���ĸ���ֵĴ�����

ϣ����ӡ�����a(1)c(2)...

ͨ��������֣�ÿһ����ĸ���ж�Ӧ�Ĵ�����
˵����ĸ�ʹ���֮�䶼��ӳ���ϵ��

˼·��
1�����ַ���ת�����ַ����飬��ΪҪ��ÿһ����ĸ���в�����
2������һ��map���ϣ���Ϊ��ӡ�������ĸ��˳������ʹ��treeMap���ϣ�
3�������ַ����飬��ÿһ����ĸ��Ϊ��ȥ��map���ϣ��������null,����ĸ��1����map�����У�
   ����������ز���null��˵������ĸ��map�������Ѿ����ڣ����ж�Ӧ�Ĵ�����
   ��ô�ͻ�ȡ�ô���������������Ȼ�󽫸���ĸ��������Ĵ������뵽map�����У�����ԭ�м���Ӧ��ֵ��
4����map�����е����ݱ��ָ�����ַ�����ʽ���ء�

ע�⣺��������ӳ���ϵʱ������ѡ��map���ϣ�
      ��Ϊmap�����д�ŵľ���ӳ���ϵ��

ʲôʱ��ʹ��map���ϣ�
������֮�������ӳ���ϵʱ��
*/

import java.util.*;

class MapDemo5
{
    public static void main(String[] args)
    {
		String s = charCount("asdzxcasdabc");
		System.out.println(s);
    }

    public static String charCount(String str)
    {
		char[] chs = str.toCharArray();
		TreeMap<Character,Integer> tm = new TreeMap<Character,Integer>();

		int count = 0;
		for(int i=0; i<chs.length; i++)
		{
			if(!(chs[i]>='a' && chs[i]<='z' || chs[i]>='A' && chs[i]<='Z'))
				continue;
			Tnteger value = tm.get(chs[i]);

			if(value != null)
				count = value;
			count++;
			tm.put(chs[i],count);

			count = 0;

			/*
			if(value == null)
			{
				tm.put(chs[i],1);
			}
			else
			{
				value = value +1;
				tm.put(chs[x],value)
			}
			*/
		}

		//System.out.println(tm);

		StringBuilder sb = new StringBuilder();
		Set<Map.Entry<Character,Integer>> entrySet = tm.entrySet();

		Iterator<Map.Entry<Character,Integer>> it = entrySet.iterator();
		while(it.hasNext())
		{
			Map.Entry<Character,Integer> me = it.next();
			Character ch = me.getKey();
			Integer value = me.getValue();
			sb.append(ch+"("+value+")");
		}	

		return sb.toString();
    }
}