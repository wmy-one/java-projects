package mymenu;
import java.io.*;
import java.awt.*;
import java.awt.event.*;

class GUIDemo4 
{
	//�����ͼ������������������
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
		//��frame���л�������
		f = new Frame("my window");
		f.setBounds(300,100,500,600);
		//f.setLayout(new FlowLayout());

		bar = new MenuBar();
		ta = new TextArea();

		//������Ӧ�Ĳ˵���Ŀ
		fileMenu = new Menu("�ļ�");	
		openItem = new MenuItem("��");
		saveItem = new MenuItem("����");
		closeItem = new MenuItem("�˳�");

		//���˵���Ŀ��ӵ��˵���  
		fileMenu.add(openItem);  
		fileMenu.add(saveItem); 
		fileMenu.add(closeItem);
		bar.add(fileMenu);     //���˵���ӵ��˵���  

		//�������ӵ�frame��
		f.setMenuBar(bar);

		openDia = new FileDialog(f,"��Ҫ��",FileDialog.LOAD);
		saveDia = new FileDialog(f,"��Ҫ����",FileDialog.SAVE);

		f.add(ta);

		//����frame�����ϵ��¼�
		myEvent();

		//��ʾframe����
		f.setVisible(true);
	}

	private void myEvent()
	{
		//ͨ�������ڲ��࣬��saveItem��ӻ������
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
					throw new RuntimeException("д��ʧ��!");
				}	
			}
		});

		//ͨ�������ڲ��࣬��openItem��ӻ������
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
    				throw new RuntimeException("��ȡʧ��!");
				}
			}
		});

		//ͨ�������ڲ��࣬��closeItem��ӻ������
		closeItem.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				System.exit(0);
			}
		});

		//ͨ�������ڲ��࣬��frame��Ӵ��ڼ�����
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
