/*
java为GUI提供的对象都存在java.Awt和javax.Swing两个包中。
java.Awt(Abstract Window Toolkit，抽象窗口工具包)，
需要调用系统方法实现功能，属于重量级控件；

javax.Swing是在Awt的基础上，建立一套图形界面系统，提供更多的组件，
完全由java实现，增强了移植性，属于轻量级控件。

Container：为容器，是一个特殊的组件，该组件可以通过add方法添加其他组件进来。

容器中组件的排放方式，称为布局，常见的布局管理器：
FlowLayout（流式布局管理器）：从左到右进行排列，是Panel默认的布局管理器。
BorderLayout（边界布局管理器）：按照东南西北中的顺序，是Frame默认的布局管理器。
GridLayout（网格布局管理器）：规则的矩阵进行摆放组件。
CardLayout（卡片布局管理器）：和选项卡一样的格式摆放组件。
GridBagLayout（网格包布局管理器）：按照非规则的矩阵进行摆放矩阵。

用户对组件的操作，就是一个事件，那么产生事件的组件就是事件源。
事件监听机制：
外部动作———有监听器所监听的动作，作用于事件源上——>事件源(组件)——产生事件对象——>事件对象
——将事件对象传给事件处理方式——>监听器监听引发事件发送的动作(事件处理方式)——将监听器注册到事件源

事件监听机制的特点:
1、事件源；2、事件；3、监听器；4、事件处理。

事件源：就是awt包或者swing包中的那些图形界面组件；
事件：每一个事件源都有自己特有的对应事件和共性事件；
监听器：将可以触发某一个事件的动作（不只一个）都已经封装到了监听器中。

以上三者，在Java中都已经定义好了，直接获取其对象来用就可以了；
我们要做的事情是：就是对产生的动作进行处理。
*/
import java.awt.*;
import java.awt.event.*;

//方法一：
/*
class MyWin implements WindowListener
{
	/*
	覆盖7个方法，但是我只用到了关闭的动作；
	其他动作都没有用到，也必须复写，这样比较麻烦
	*/
}
*/

//方法二：
/*
因为WindowListener的子类WindowAdapter已经实现了WindowListener接口，
并覆盖了其中的所有方法，此时，只需继承自WindowAdapter并覆盖自己想要的方法即可。
*/
class MyWin extends WindowAdapter
{
	//复写WindowClosing方法，用于处理关闭窗口事件
	public void WindowClosing(WindowEvent e)  
	{
		System.out.println("Wondow is Closing !");
		System.exit(0);  //退出程序，也就是关闭窗口
	}

	//复写WindowActivated方法，用于处理激活窗口事件；前置窗口时，就调用一次此方法
	public void WindowActivated(WindowEvent e)
	{
		System.out.println("激活窗口！");
	}

	//复写WindowOpened方法，用于处理打开窗口事件，打开窗口时，调用此方法
	public void WindowOpened(WindowEvent e)
	{
		System.out.println("打开窗口！");
	}
}

class GUIDemo 
{
	public static void main(String[] args) 
	{
		/*
		创建图形界面：
		1、创建frame窗体；
		2、对窗体进行基本设置；比如：大小、位置、布局等；
		3、定义组件；
		4、将组件通过窗体的add方法添加到窗体中；
		5、让窗体显示，通过setVisible(true)实现。
		*/
		Frame f = new Frame("My awt");  //构造一个最初不可见的窗体
		f.setSize(500,400);    //设置窗体的长和宽；长500，宽400
		f.setLocation(300,200);   //设置窗体显示的位置，左300，上200
		f.setLayout(new FlowLayout());  //设置窗体布局

		Button b = new Button("First Button");
		f.add(b);  //将按钮组件添加到Frame窗体中
		
		//通过创建类并创建类对象，将窗口监视器注册到窗口
		f.addWindowListener(new MyWin());  

		//通过匿名内部类，实现将窗口监视器注册到窗口
		/*
		f.adaWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent e)
			{
				System.out.println("Wondow is Closing !");
				System.exit(0);  //退出程序，也就是关闭窗口
			}
		});
		*/

		f.setVisible(true);  //设置窗体可见

		System.out.println("Hello World!");
	}
}
