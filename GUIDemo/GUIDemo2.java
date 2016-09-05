
import java.awt.*;
import java.awt.event.*;

class FrameDemo
{
	//定义该图形中所需的组件的引用
	private Frame f;
	private Button but;

	FrameDemo() 
	{
		init();
	}

	//定义一个init函数，用于初始化frame对象
	public void init()
	{
		f = new Frame("my frame");

		//对frame进行基本设置
		f.setBounds(300,200,600,500);  //距左边300、上边200、长600、宽500
		f.setLayout(new FlowLayout());

		but = new Button("my button");

		//将组件添加到frame中
		f.add(but);

		//加载一下窗体上的事件
		myEvent();

		//显示窗体
		f.setVisible(true);
	}

	private void myEvent()
	{
		//通过定义匿名内部类，实现关闭窗口的功能
		f.addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent e)
			{
				System.exit(0);
			}
		});

		//通过匿名内部类，让按钮具备退出程序的功能
		/*
		按钮就是事件源；此时，选择哪个监听器呢？
		通过关闭窗体示例了解到，想要知道哪个组件具备什么样的特有监听器，
		需要查看该组件对象的功能。
		通过查阅button的API描述，发现按钮支持一个特有监听器addActionListener
		*/
		but.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				System.out.println("点击按钮，退出程序！");
				System.exit(0);
			}
		});
	}
}

class GUIDemo2 
{
	public static void main(String[] args) 
	{
		new FrameDemo();  //创建frame对象
	}
}
