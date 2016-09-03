/*
map���ϵ���չ֪ʶ��

map���ϱ�ʹ������Ϊ�߱�ӳ���ϵ��

��һ�������
"Ԥ�Ȱ�" "01" "Tom"
"Ԥ�Ȱ�" "02" "Jhon"

"��ҵ��" "01" "zhangsan"
"��ҵ��" "02" "lisi"

�ڶ��������
"Ԥ�Ȱ�" Student("01" "Tom")
"Ԥ�Ȱ�" Student("02" "Jhon")

"��ҵ��" Student("01" "zhangsan")
"��ҵ��" Student("02" "lisi")

һ��ѧУ�ж�����ң�ÿ����ʦ�������ơ�
*/

import java.util.*;
class Student
{
    private String id;
    private String name;
    Student(String id, String name)
    {
		this.id = id;
		this.name = name;
    }
    public String toString()
    {
		return id+":::"+name;
    }
}

class MapDemo6
{
    //�ڶ��������
    public static void demo()
    {
		HashMap<String,List<Student>> school = new HashMap<String,List<Student>>();
	
		List<Student> yure = new ArrayList<Student>();
		List<Student> jiuye = new ArrayList<Student>();

		school.put("yureban",yure);
		school.put("jiuyeban",jiuye);

		yure.add(new Student("01","zhangsan"));
		yure.add(new Student("02","wangwu"));
		jiuye.add(new Student("01","Tom"));
		jiuye.add(new Student("02","Jhon"));

		//����school���ϣ���ȡ���еĽ���
		Iterator<String> it = school.ketSet().iterator();
		while(it.hasNext())
		{
			String roomName = it.next();
			List<String,String> room = school.get(roomName);

			//��school�����еĽ��Ҵ�ӡ����	    
			System.out.println(roomName);
			getInfos(yure);
		}
	}
    public static void getInfos(List<Student> list)
    {
		Iterator<Student> it = List.Iterator();
		while(it.hasNext())
		{
			Student s = it.next();
			System.out.println(s);
		}
    }

    public static void main(String[] args)
    {
		demo();  //�ڶ��������

		//��һ�������
		/*
		HashMap<String,HashMap<String,String>> school= new HashMap<String,HashMap<String,String>>();
		HahMap<String,String> yure = new HashMap<String,String>();
		HahMap<String,String> jiuye = new HashMap<String,String>();

		school.put("yureban",yure);
		school.put("jiuyeban",jiuye);

		yure.put("01","Tom");
		yure.put("02","Jhon");
	
		jiuye.put("01","zhangsan");
		jiuye.put("02","lisi");	

		//����school���ϣ���ȡ���еĽ���
		Iterator<String> it = school.ketSet().iterator();
		while(it.hasNext())
		{
			String roomName = it.next();
			HashMap<String,String> room = school.get(roomName);

			//��school�����еĽ��Ҵ�ӡ����	    
			System.out.println(roomName);
			getStudentInfo(yure);
		}

		//��Ԥ�Ȱ��е�ѧ����Ϣ��ӡ����
		//getStudentInfo(yure);
		*/
    }
    public static void getStudentInfo(HashMap<String,String> roomMap)
    {
		hm.get(room);
		Iterator<String> it = roomMap.keySet().iterator();

		while(it.hasNext())
		{
			String id = it.next();
			String name = roomMap.get(id);
			System.out.println(id+":"+name);
		}
    }
}