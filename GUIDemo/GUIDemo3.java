
import java.awt.*;
import java.awt.event.*;
import java.io.*;

class  GUIDemo3
{
	//�����ͼ�����������������
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
		//����frame�Ļ�������
		f = new Frame("My window");
		f.setBounds(300,100,600,500);
		f.setLayout(new FlowLayout());

		//�������
		tf = new TextField(60); //ָ������Ϊ60��ֻ��ָ������
		but = new Button("ת��");
		ta = new TextArea(25,70);  //����ָ������������

		//true��ʾ�˶Ի��򲻹رգ��޷��ر��������Ĵ���
		d = new Dialog(f,"��ʾ��Ϣ-self"��true); 
		d.setBounds(400,200,240,150);
		d.setLayout(new FlowLayout);

		lab = new Label();
		okBut = new Button("ȷ��");

		//��������dialog��
		d.add(lab);
		d.add(okBut);

		//�������ӵ�frame��
		f.add(tf);
		f.add(but);
		f.add(ta);

		myEvent();
		f.setVisible(true);
	}

	private void myEvent()
	{
		//ͨ�������ڲ��࣬��dialog�е�button���action������
		okBut.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				d.setVisible(false);
			}
		});

		//ͨ�������ڲ��࣬��dialog�Ի�����Ӵ��ڼ�����
		d.addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent e)
			{
				d.setVisible(false);
			}
		});

		//ͨ�������ڲ��࣬���ı�����Ӽ��̼����������ڼ�����Enter���͵���showDir
		tf.addKeyListener(new KeyAdapter()
		{
			public void keyPressed(KeyEvent e)
			{
				if(e.getKeyCode() == KeyEvent.VK_ENTER)
					showDir();
			}
		});

		//ͨ�������ڲ��࣬��frame�е�button���action������
		but.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				//String text = tf.getText();  //��ȡ�ı��������������
				//ta.setText(text); //���ı����������������ӵ��ı�����
				//tf.setText("");  //����ı���
				
				showDir();
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
	
	//����һ��showDir����������ʵ���г�ָ��Ŀ¼�е����ݵĹ��ܣ�
	//������Щ����������ı�����
	private void showDir()
	{
		String dirPath = tf.getText();  //��ȡ�ı��������������
		File dir = new File(dirPath);

		//�ж�������·���Ƿ���Ŀ¼�������Ŀ¼�����е��ļ�������ı�����
		if(dir.exists() && dir.isDirectory())
		{
			ta.setText("");  //����ı������е�����
			String[] names = dir.list();
			for(String name : names)
			{
				ta.append(name+"\r\n");
			}
		}
		else
		{
			String info = "���������Ϣ��"+dirPath+"�Ǵ���ģ����������룡";
			lab.setText(info);  //����dialog�Ի����е���ʾ��Ϣ
			d.setVisible(true);
		}
	}

	public static void main(String[] args) 
	{
		GUIDemo3();
	}
}
