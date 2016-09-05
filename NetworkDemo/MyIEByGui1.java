
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
		ta.setText("");  //����ı���
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
