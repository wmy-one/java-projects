
import java.awt.*;
import java.awt.event.*;
import java.io.*;

class  GUIDemo3
{
	//定义该图形中所需组件的引用
	private Frame f;
	private TextField tf;
	private Button but;
	private TextArea ta;
	private Dialog d;
	private Label lab;
	private Button okBut;
	
	GUIDemo3()
	{
		init();
	}
	public void init()
	{
		//设置frame的基本参数
		f = new Frame("My window");
		f.setBounds(300,100,600,500);
		f.setLayout(new FlowLayout());

		//定义组件
		tf = new TextField(60); //指定行数为60，只能指定行数
		but = new Button("转到");
		ta = new TextArea(25,70);  //可以指定列数和行数

		//true表示此对话框不关闭，无法关闭他所属的窗口
		d = new Dialog(f,"提示信息-self"，true); 
		d.setBounds(400,200,240,150);
		d.setLayout(new FlowLayout);

		lab = new Label();
		okBut = new Button("确定");

		//添加组件到dialog中
		d.add(lab);
		d.add(okBut);

		//将组件添加到frame中
		f.add(tf);
		f.add(but);
		f.add(ta);

		myEvent();
		f.setVisible(true);
	}

	private void myEvent()
	{
		//通过匿名内部类，给dialog中的button添加action监视器
		okBut.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				d.setVisible(false);
			}
		});

		//通过匿名内部类，给dialog对话框添加窗口监视器
		d.addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent e)
			{
				d.setVisible(false);
			}
		});

		//通过匿名内部类，给文本框添加键盘监视器，用于监听到Enter键就调用showDir
		tf.addKeyListener(new KeyAdapter()
		{
			public void keyPressed(KeyEvent e)
			{
				if(e.getKeyCode() == KeyEvent.VK_ENTER)
					showDir();
			}
		});

		//通过匿名内部类，给frame中的button添加action监视器
		but.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				//String text = tf.getText();  //获取文本框中输入的内容
				//ta.setText(text); //将文本框中输入的内容添加到文本域中
				//tf.setText("");  //清空文本框
				
				showDir();
			}
		});

		//通过匿名内部类，给frame添加窗口监视器
		f.addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent e)
			{
				System.exit(0);
			}
		});
	}
	
	//定义一个showDir函数，用于实现列出指定目录中的内容的功能；
	//并将这些内容输出到文本域中
	private void showDir()
	{
		String dirPath = tf.getText();  //获取文本框中输入的内容
		File dir = new File(dirPath);

		//判断输入了路径是否是目录，如果是目录将其中的文件输出到文本域中
		if(dir.exists() && dir.isDirectory())
		{
			ta.setText("");  //清空文本区域中的内容
			String[] names = dir.list();
			for(String name : names)
			{
				ta.append(name+"\r\n");
			}
		}
		else
		{
			String info = "您输入的信息："+dirPath+"是错误的，请重新输入！";
			lab.setText(info);  //设置dialog对话框中的提示信息
			d.setVisible(true);
		}
	}

	public static void main(String[] args) 
	{
		GUIDemo3();
	}
}
