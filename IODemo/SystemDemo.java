/*
1��System�����е����Ժͷ������Ǿ�̬�ģ����ܱ�ʵ������
out����׼�����Ĭ���ǿ���̨��
in����׼���룬Ĭ���Ǽ��̣�

����ϵͳ��һЩ��Ϣ����ȡϵͳ������Ϣ��Properties getProperties();

2��Runtime����
���ಢû���ṩ���캯����˵��������new����ֱ���뵽�����еķ������Ǿ�̬�ģ�
���ǲ���API���ָ����л��зǾ�̬������˵������϶����ṩ������ȡ�������
���Ҹ÷����Ǿ�̬�ģ�����ֵ�����Ǳ������ͣ�

������ص���Կ�������ʹ���˵������ģʽ����ɣ�
�÷�����static Runtime getRuntime();
*/

import java.util.*;  //System��Date����Ҫ����˰�
import java.text.*;  //Date����Ҫ����˰�

class SystemDemo 
{
	public static void main(String[] args) 
	{
		Properties prop = System.getProperties();
		
		/*
		��ΪProperties��Hashtable�����࣬Ҳ��Map���ϵ�һ���������
		��ʱ������ͨ��map�ķ���ȡ���ü����е�Ԫ�أ�
		�ü����д洢�Ķ����ַ�����û�з�ʡ���塣
		*/
		
		//��ȡ����������Ϣ
		for(Object obj : prop.keySet())
		{
			String value = (String)prop.get(obj);
			System.out.println(obj+"::"+value);
		}

		//�����ϵͳ���Զ���һЩ������Ϣ
		System.setProperty("mykey","myvalue");

		//��ȡָ��������Ϣ
		String value = System.getProperty("os.name");	
		System.out.println("value="+value);

		//�����jvm����ʱ����̬����һЩ������Ϣ
		String v = System.getProperty("wmy");
		System.out.println("v="+v);  //������dos��ʹ��-D<name>=<value> ��ȡ


		Runtime r = Runtime.getRuntime();
		//r.exec("C:\\winmine.exe");
		Process p = r.exec("C:\\winmine.exe");

		Thread.sleep(4000);  //�ȴ�4s
		p.destroy();  //ɱ������


		Date d = new Date();
		System.out.println(d);  //��ӡ��ʱ���ʽ����ȷ��ϣ����Щ��ʽ

		//��ģʽ��װ��SimpleDateformat������
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy��MM��dd�� E hh:mm:ss");

		//����format������ģʽ��ʽ��ָ��date����
		String time = sdf.format(d);

		System.out.println("time= "+time);

	}
}
