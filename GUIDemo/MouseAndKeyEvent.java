
import java.awt.*;
import java.awt.event.*;

class MouseAndKeyEvent 
{
	//定义该图形中所需的组件的引用
	private Frame f;
	private Button but;
	private TextField tf;

	MouseAndKeyEvent() 
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

		tf = new TextField(10);  //设置文本框的行数，仅能设置行数
		but = new Button("my button");

		//将组件添加到frame中
		f.add(but);   //按钮
		f.add(tf);   //文本框

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

		but.addMouseListener(new MouseAdapter()
		{
			private int count = 1;
			private int clickCount = 1;

			//复写mouseEntered函数，用于监听鼠标进入事件，鼠标进入该区域调用一次
			public void mouseEntered(MouseEvent e)
			{
				System.out.println("鼠标进入该事件--"+count++);
			}
				
			//复写mouseClicked函数，用于监听鼠标点击事件
			public void mouseClicked(MouseEvent e)
			{
				//getClickCount方法用于获取点击次数
				if(e.getClickCount() == 2) 
					System.out.println("双击击动作--"+clickCount++);
			}
		});

		//给button添加一个键盘监听器
		but.addKeyListener(new KeyAdapter()
		{
			public void keyPresses(KeyEvent e)
			{
				//从键盘按ESC键即可退出程序
				if(e.getKeyCode() == KeyEvent.VK_ESCAPE)  
					System.exit(0);
				
				//isControlDown用于获取ctrl键是否被按下
				if(e.isControlDown() && e.getKeyCode() == KeyEvent.VK_ENTER)
					System.out.println("ctrl+enter is run!");

				//System.out.println(KeyEvent.getKeyText(e.getKeyCode())+"..."+e.getKeyCode());
			}
		});
		
		//给TextField添加一个键盘监听器
		tf.addKeyListener(new KeyAdapter()
		{
			//复写keyPressed方法，用于向文本框中输入数字，其他字符将不被显示
			public void keyPressed(KeyEvent e)
			{
				int code = e.getKeyCode();

				//此if语句用于判断键盘敲入的是否数字
				if(!(code >= KeyEvent.VK_0 && code <= KeyEvent.VK_9))
				{
					System.out.println(code+"....是非法的");
					e.consume();  //此语句用于将非数字的字符不输入到文本框中
				}
			}
		});
	}

	public static void main(String[] args) 
	{
		new MouseAndKeyEvent();
	}
}
