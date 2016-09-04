/*
1）装饰设计模式：
当想要对已有的对象进行功能增强时，可以定义类，将已有对象传入，
基于已有功能，并提供加强功能，此时，自定义的该类就称为装饰类。

装饰类的特点：
装饰类通常会通过构造方法接收被装饰对象，并基于被装饰对象的功能，提供更强的功能。

2）继承和装饰的区别：

//继承类的体系结构
MyReader //专门用于读取数据的类
	|--MyTextReader
		|--MyBufferedTextReader
	|--MyMediaReader
		|--MyBufferedMediaReader
	|--MyDataReader
		|--MyBufferedDataReader

class MyBufferedReader()
{
	MyBufferedReader(MyTextReader text)
	{}
	MyBufferedReader(MyMediaReader media)
	{}
}
上面的这个类扩展性较差，找到其参数的共同类型，通过多态的形式，可以提高扩展性。

class MyBufferedReader() extends MyReader
{
	Private MyReader r;
	MyBufferedReader(MyReader r)
	{}
}

//装饰类的体系结构
MyReader //专门用于读取数据的类
	|--MyTextReader
	|--MyMediaReader
	|--MyDataReader
	|--MyBufferedReader

装饰模式比继承灵活，避免了继承体系的臃肿；而且降低了类之间的关系。

装饰类因为增强已有对象，具备的功能和已有的是相同的，只不过提供了更强的功能；
所以装饰类和被装饰类通常都属于一个体系中的
*/

//定一个Person类，用于描述简单的人吃饭功能
class Person
{
	public void eatFun()
	{
		System.out.println("吃饭！");
	}
}

//定义一个SuperPerson类，用于增强Person类对象的功能
class SuperPerson
{
	SuperPerson(Person p)
	{
		this.p = p;
	}

	//定义一个superPerson方法，用于增强Person类对象的eatFun方法
	public void superEat()
	{
		System.out.println("开胃菜！");
		p.eatFun();
		System.out.println("甜点！");
		System.out.println("喝茶！");
	}
}

class PersonDemo
{
	public static void main(String[] args) 
	{
		Person p = new Person();  //定义一个Person类对象
		//p.eatFun();   //调用Person类对象已有的功能
		
		/*
		定义一个增强类对象，并将Person类对象作为参数，
		并调用增强类对象方法，用于获取增强后的功能。
		*/
		SuperPerson sp = new SuperPerson(p);  
		sp.superEat();
	}
}
