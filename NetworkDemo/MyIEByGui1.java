
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;

class MyIEByGui
{
	private Frame f;
	private TextField tf;
	private Button but;
	private TextArea ta;

	private Dialog d;
	private Label lab;
	private Button okBut;
	
	MyIEByGui()
	{
		init();
	}
	public void init()
	{
		//设置frame的基本参数
		f = new Frame("My window");
		f.setBounds(300,100,600,500);
		f.setLayout(new FlowLayout());

		tf = new TextField(60); //指定行数为30，只能指定列数
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
		f.add(buf);
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
				try
				{
					if(e.getKeyCode() == KeyEvent.VK_ENTER)
						showDir();
				}
				catch (Exception ex)
				{
				}	
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
				try
				{
					showDir();
				}
				catch (Exception ex)
				{
				}			
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
	private void showDir() throws Exception
	{
		ta.setText("");  //清空文本域
		String url = tf.getText(); //http://192.168.253:8080/myweb/demo.html
		int index1 = url.indexOf("//")+2;
		int index2 = url.indexOf("/",index1);

		String str = url.substring(index1,index2);
		String[] arr = str.split(":");
		String host = arr[0];
		int port = Integer.parseInt(arr[1]);

		String path = url.substring(index2);
		//ta.setText(str+"..."+path);

		Socket s = new Socket(host,port);

		PrintWriter out = new PrintWriter(s.getOutputStream(),true);
		out.println("GET "+path+" HTTP/1.1");
		out.println("Accept */*");
		out.println("Accept-Language: zh-cn");
		out.println("Host: 192.168.1.253:11000");
		out.println("Connection: Keep-Alive");

		out.println();
		out.println();

		BufferedReader bufr = new BufferedReader(new InputStreamReader(s.getInputStream()));
	
		String line = null;
		while((line=bufr.readLine()) != null)
		{
			ta.append(line+"\r\n");;
		}
		s.close();
	}

	public static void main(String[] args) 
	{
		MyIEByGui();
	}
}
