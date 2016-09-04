/*
1����ȡ��������·ݵ�����
	˼·������ָ��������һ��ʱ����ǣ�c.set(year,2,1);  //ĳһ���3��1��
	c.add(Calendar.DAY_OF_MONTH,-1);  //3��1����ǰ��һ�죬����2�����һ��

2����ȡ������������ʱ��
	c.add(Calendar.DAY_OF_MONTH,-1);
*/
import java.util.*;

class CalendarDemo 
{
	public static void main(String[] args) 
	{
		Calendar c = Calendar.getInstance();

		//c.set(2018,2,25);
		c.add(Calendar.DAY_OF_MONTH,-1);

		printCalendar(c);
	}
	
	//����һ�����ڴ�ӡ�ĺ���
	public static void printFun(Object obj)
	{
		System.out.println(obj);
	}

	//����һ���������ڽ����õ����ڴ�ӡ����
	public static void printCalendar(Calendar c)
	{
		String [] mons = {"һ��","����","����","����",
						"����","����","����","����",
						"����","ʮ��","ʮһ��","ʮ����"};

		String [] weeks = {"","������","����һ","���ڶ�","������","������",
							"������","������"};

		Calendar c = Calendar.getInstance();

		int index = c.get(Calendar.MONTH);
		int index1 = c.get(Calendar.DAY_OF_MONTH);
		
		printFun(c.get(Calendar.YEAR)+"��");
		
		//printFun((c.get(Calendar.MONTH)+1)+"��");  //��ȡ���·��ǣ�0-11
		printFun(mons[index]);

		printFun(c.get(Calendar.DAY_OF_MONTH)+"��");

		//printFun(c.get(Calendar.DAY_OF_WEEK));
		printFun(weeks[index1]);
	}

	//��һ����������չʾ��ѧ�еĳ�������
	public static void showFun()
	{
		double d = Math.ceil(16.34);     //ceil���ش���ָ��ֵ����С����
		double d1 = Math.floor(16.34);  //floor����С��ָ��ֵ���������

		long L = Math.round(13.56);   //��������
		double d2 = Math.pow(2,3);   //pow����2��3����

		printFun("d="+d);
		printFun("d1="+d1);
		printFun("L="+L);
		printFun("d2="+d2);
		
		double dd = Math.random(); //�������һ��0.0-1.0֮�������������1.0
		printFun(dd);

		int dd1 = (int)(Math.random()*10+1);  //�������һ��1-10֮�����
		printFun(dd1);

		//����ķ�����Ҫ����java.util.Random
		Random r = new Random();
		int a = r.nextInt(10)+1;  //�������һ��1-10֮�����
		printFun(a);
	}
}
