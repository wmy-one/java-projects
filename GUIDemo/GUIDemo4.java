package mymenu;
import java.io.*;
import java.awt.*;
import java.awt.event.*;

class GUIDemo4 
{
	//定义该图形中所需的组件的引用
	private Frame f;
	private MenuBar bar;
	private TextArea ta;
    private Menu fileMenu;
    private MenuItem openItem,saveItem,closeItem;

    private FileDialog openDia,saveDia;
    private File file;
	
	GUIDemo4()
	{
		init();
	}

	public void init()
	{
		//对frame进行基本设置
		f = new Frame("my window");
		f.setBounds(300,100,500,600);
		//f.setLayout(new FlowLayout());

		bar = new MenuBar();
		ta = new TextArea();

		//定义相应的菜单条目
		fileMenu = new Menu("文件");	
		openItem = new MenuItem("打开");
		saveItem = new MenuItem("保存");
		closeItem = new MenuItem("退出");

		//将菜单条目添加到菜单中  
		fileMenu.add(openItem);  
		fileMenu.add(saveItem); 
		fileMenu.add(closeItem);
		bar.add(fileMenu);     //将菜单添加到菜单栏  

		//将组件添加到frame中
		f.setMenuBar(bar);

		openDia = new FileDialog(f,"我要打开",FileDialog.LOAD);
		saveDia = new FileDialog(f,"我要保存",FileDialog.SAVE);

		f.add(ta);

		//加载frame窗体上的事件
		myEvent();

		//显示frame窗体
		f.setVisible(true);
	}

	private void myEvent()
	{
		//通过匿名内部类，给saveItem添加活动监听器
		saveItem.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				if(file == null)
				{
					saveDia.setVisible(true);
					String dirPath = saveDia.getDirectory();
					String fileName = saveDia.getFile();
					if(dirPath == null || fileName == null)
						return;
		
					file = new File(dirPath,fileName);
				}
		
				try
				{
					BufferedWriter bufw = new BufferedWriter(new FileWriter(file));
			
					String text = ta.getText();
					bufw.write(text);
					bufw.flush();
					bufw.close();
				}
				catch(IOException ex)
				{
					throw new RuntimeException("写入失败!");
				}	
			}
		});

		//通过匿名内部类，给openItem添加活动监听器
		openItem.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				openDia.setVisible(true);
				String dirPath = openDia.getDirectory();
				String fileName = openDia.getFile();
			
				if(dirPath == null || fileName == null)
					return;

				ta.setText("");
				file = new File(dirPath,fileName);
		
				try
                {
					BufferedReader bufr = new BufferedReader(new FileReader(file));
		    
					String line = null;
					while((line=bufr.readLine()) != null)
					{
						ta.append(line+"\r\n");
					}
					bufr.close();
				}
				catch(IOException ex)
				{
    				throw new RuntimeException("读取失败!");
				}
			}
		});

		//通过匿名内部类，给closeItem添加活动监听器
		closeItem.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				System.exit(0);
			}
		});

		//通过匿名内部类，给frame添加窗口监听器
		f.addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent e)
			{
				System.exit(0);
			}
		});
	}

	public static void main(String[] args) 
	{
		new GUIDemo4();
	}
}
