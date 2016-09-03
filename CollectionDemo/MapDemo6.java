/*
map集合的扩展知识：

map集合被使用是因为具备映射关系。

第一种情况：
"预热班" "01" "Tom"
"预热班" "02" "Jhon"

"就业班" "01" "zhangsan"
"就业班" "02" "lisi"

第二种情况：
"预热班" Student("01" "Tom")
"预热班" Student("02" "Jhon")

"就业班" Student("01" "zhangsan")
"就业班" Student("02" "lisi")

一个学校有多个教室，每个教师都有名称。
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
    //第二种情况：
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

		//遍历school集合，获取所有的教室
		Iterator<String> it = school.ketSet().iterator();
		while(it.hasNext())
		{
			String roomName = it.next();
			List<String,String> room = school.get(roomName);

			//将school中所有的教室打印出来	    
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
		demo();  //第二种情况：

		//第一种情况：
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

		//遍历school集合，获取所有的教室
		Iterator<String> it = school.ketSet().iterator();
		while(it.hasNext())
		{
			String roomName = it.next();
			HashMap<String,String> room = school.get(roomName);

			//将school中所有的教室打印出来	    
			System.out.println(roomName);
			getStudentInfo(yure);
		}

		//将预热班中的学生信息打印出来
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