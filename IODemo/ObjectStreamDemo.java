
import java.io.*;

class Person implements Serializable  //Serializable�ӿ��޷�������Ϊ��ǽӿ�
{
	//�Զ���һ��UID�����ඨ��һ���̶���ʶ������Ϊ���෽��������л�;
	//Ĭ��UID�������Զ������������������Ϣ�ı���ı䡣
	public static final long serialVersionUID = 42L;

	String name;
	transient int age;  //��transient���κ󣬽����ܱ����л����������ڶ��ڴ���

	static String country = "cn";  //��̬�ǲ��ܱ����л���

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
		//writeObj();  //�ع�����
		readObj();  //��ȡ����
	}

	//����һ��readObj���������ڶ�ȡ����
	public static void readObj() throws Exception
	{
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream("obj.txt"));

		Person p = (Person) ois.readObject();

		System.out.println(p);
		ois.close();
	}

	//����һ��writeObj����������д�����
	public static void writeObj() throws IOException
	{
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("obj.txt"));
		
		oos.writeObject(new Person("Jhon",35,"Americ")); //�˴���Americû������

		oos.close();
	}
}
