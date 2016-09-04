
import java.io.*;

class Person implements Serializable  //Serializable接口无方法，称为标记接口
{
	//自定义一个UID，给类定义一个固定标识，就是为了类方便进行序列化;
	//默认UID依据属性而定，随着类的属性信息改变而改变。
	public static final long serialVersionUID = 42L;

	String name;
	transient int age;  //被transient修饰后，将不能被序列化，仅仅存在堆内存中

	static String country = "cn";  //静态是不能被序列化的

	Person(String name, int age, String country)
	{
		this.name=name;
		this.age=age;
		this.country=country;
	}

	public String toString()
	{
		return name+":"+age+":"+country;
	}
}

class ObjectStreamDemo
{
	public static void main(String[] args) throws Exception
	{
		//writeObj();  //重构对象
		readObj();  //读取对象
	}

	//定义一个readObj方法，用于读取对象
	public static void readObj() throws Exception
	{
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream("obj.txt"));

		Person p = (Person) ois.readObject();

		System.out.println(p);
		ois.close();
	}

	//定义一个writeObj方法，用于写入对象
	public static void writeObj() throws IOException
	{
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("obj.txt"));
		
		oos.writeObject(new Person("Jhon",35,"Americ")); //此处的Americ没起作用

		oos.close();
	}
}
