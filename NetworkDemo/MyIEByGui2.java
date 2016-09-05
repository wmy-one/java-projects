
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;

class MyIEByGUI2
{
	private Frame f;
	private TextField tf;
	private Button but;
	private TextArea ta;

	private Dialog d;
	private Label lab;
	private Button okBut;
	
	MyIEByGUI2()
	{
		init();
	}
	public void init()
	{
		//����frame�Ļ�������
		f = new Frame("My window");
		f.setBounds(300,100,600,500);
		f.setLayout(new FlowLayout());

		tf = new TextField(60); //ָ������Ϊ30��ֻ��ָ������
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
		f.add(buf);
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

		//ͨ�������ڲ��࣬��frame�е�button���action������
		but.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				//String text = tf.getText();  //��ȡ�ı��������������
				//ta.setText(text); //���ı����������������ӵ��ı�����
				//tf.setText("");  //����ı���
				try
				{
					showDir();
				}
				catch (Exception ex)
				{
				}			
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
	private void showDir() throws Exception
	{
		ta.setText("");
		String urlPath = tf.getText();
		URL url = new URL("http://192.168.253:8080/myweb/demo.html");

		URLConnection conn = url.openConnection(); //����Զ�����Ӷ���
		//System.out.println(conn);

		InputStream in = conn.getInputStream();
		byte[] buf = new byte[1024];
		int len = in.read(buf);

		ta.setText(new String(buf,0,len);

		//System.out.println(new String(buf,0,len));
	}

	public static void main(String[] args) 
	{
		MyIEByGUI2();
	}
}
