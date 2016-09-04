/*
properties��hashtable�����ࣻҲ����˵���߱�map���ϵ��ص㣬
����������洢�ļ�ֵ�Զ����ַ������Ǽ����к�IO������ϵļ���������

�ö�����ص㣺
�������ڼ�ֵ����ʽ�������ļ���
�ڼ�������ʱ����Ҫ�����й̶���ʽ����=ֵ
*/

import java.io.*;
import java.util.*;

class PropertiesDemo
{
	public static void main(String[] args) throws IOException
	{
		setAndGet();
		method();
		loadDemo();
	}

	//��ʾ����ν����е����ݴ洢��������
	public static void loadDemo() throws IOException
	{
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream("info.txt");
		
		//�����е����ݼ��ؽ�����
		prop.load(fis);
		
		prop.setProperty("David","25");  //����ΪDavid��ֵ��Ϊ25�������ı��ڴ��е�����

		FileOutputStream fos = new FileOutputStream("info.txt");
		prop.store(fos,"zhushi"); //��propterty������Ϣ���浽�ļ��У������ע����Ϣ

		System.out.print(prop);  //��ӡ�����е�����
		prop.list(System.out);  //��������г���

		fos.close();
		fis.close();
	}	

	//��Ҫ��info.txt�м�ֵ���ݴ浽�����н��в�����˼·��
	/*
	1����һ������info.txt�ļ�������
	2����ȡһ�����ݣ������������á�=�������и
	3���Ⱥ������Ϊ�����ұ���Ϊֵ�������properties�����м��ɡ�
	*/
	public static void method() throws IOException
	{
		BufferedReader bufr = new BufferedReader(new FileReader("info.txt"));
		
		String line=null;

		Properties prop = new Properties();

		while((line=bufr.readLine()) != null)
		{
			String[] arr = line.split("=");
			//System.out.println(arr[0]+"..."+arr[1]);
			prop.setProperty(arr[0],arr[1]);
		}

		bufr.close();
		System.out.println(prop);
	}

	//���úͻ�ȡԪ��
	public static void setAndGet()
	{
		Properties prop = new Properties();

		prop.setProperty("Jhon","25");  //ͨ��setProperty����������������Ϣ
		prop.setProperty("Tom","30");
	
		//System.out.println(prop);
		String value = prop.getProperty("Jhon"); //ͨ��getProperty��ȡ��Ϊjohn��ֵ
		System.out.println(value);

		set<String> names = prop.stringPropertyName(); //���ؼ����ϡ���set��������ΪString
		for(String s : names)
		{
			System.out.println(s+":"+prop.getProperty(s));
		}
	}

	/*
	���ڼ�¼Ӧ�ó������д��������ʹ�ô����ѵ�����ʱ����ע����ʾ��

	�������뵽���Ǽ����������Ǽ����������ڳ����У����ų�������ж����ڴ��д��ڣ�
	�������������������Ÿ�Ӧ�ó�����˳����ü�����Ҳ���ڴ�����ʧ��

	��һ���������ĳ��������¿�ʼ��0�������ⲻ��������Ҫ�ġ�

	����ʹ�������ü�������ֵҲ���ڣ��´γ����������ȼ��ظü�������ֵ��
	����1�����´洢���������ԣ�Ҫ����һ�������ļ������ڼ�¼�������ʹ�ô�����

	�������ļ�ʹ�ü�ֵ�Ե���ʽ�����������Ķ����ݣ����������ݡ�

	��ֵ��������map���ϣ����������ļ���ʽ�洢��ʹ��io��������ômap+io -->properties��

	�����ļ�����ʵ��Ӧ�ó������ݵĹ���
	*/
	public static void method_1() throws IOException
	{
		Properties prop = new Properties();

		File f = new File("cpunt.properties"); //java�������ļ���׺�ǣ�xml��properties
		if(!f.exists())
			f.createNewFile();  //�����ļ�

		FileInputStream fis = new FileInputStream(f);

		prop.load(fis);  //�����е����ݼ��ؽ�����
		
		int count = 0;
		String value = prop.getProperty("time"); //��ȡ��Ϊtime��Ӧ��ֵ

		if(value != null)
		{
			count = Integer.perseInt(value);  //��StringתΪint
			if(count >=5)
			{
				System.out.println("���ã�ʹ�ô����ѵ�����ע�ᣡ");
			    return;
			}
		}

		count++;

		prop.setProperty("time",count+""); //�޸ļ���ֵ

		FileOutputStream fos = new FileOutputStream(f);

		prop.store(fos,"");  //��prop��Ϣ���浽�ļ���

		fos.close();
		fis.close();
	}
}
