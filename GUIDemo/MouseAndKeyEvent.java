
import java.awt.*;
import java.awt.event.*;

class MouseAndKeyEvent 
{
	//�����ͼ������������������
	private Frame f;
	private Button but;
	private TextField tf;

	MouseAndKeyEvent() 
	{
		init();
	}

	//����һ��init���������ڳ�ʼ��frame����
	public void init()
	{
		f = new Frame("my frame");

		//��frame���л�������
		f.setBounds(300,200,600,500);  //�����300���ϱ�200����600����500
		f.setLayout(new FlowLayout());

		tf = new TextField(10);  //�����ı����������������������
		but = new Button("my button");

		//�������ӵ�frame��
		f.add(but);   //��ť
		f.add(tf);   //�ı���

		//����һ�´����ϵ��¼�
		myEvent();

		//��ʾ����
		f.setVisible(true);
	}

	private void myEvent()
	{
		//ͨ�����������ڲ��࣬ʵ�ֹرմ��ڵĹ���
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

			//��дmouseEntered���������ڼ����������¼�����������������һ��
			public void mouseEntered(MouseEvent e)
			{
				System.out.println("��������¼�--"+count++);
			}
				
			//��дmouseClicked���������ڼ���������¼�
			public void mouseClicked(MouseEvent e)
			{
				//getClickCount�������ڻ�ȡ�������
				if(e.getClickCount() == 2) 
					System.out.println("˫��������--"+clickCount++);
			}
		});

		//��button���һ�����̼�����
		but.addKeyListener(new KeyAdapter()
		{
			public void keyPresses(KeyEvent e)
			{
				//�Ӽ��̰�ESC�������˳�����
				if(e.getKeyCode() == KeyEvent.VK_ESCAPE)  
					System.exit(0);
				
				//isControlDown���ڻ�ȡctrl���Ƿ񱻰���
				if(e.isControlDown() && e.getKeyCode() == KeyEvent.VK_ENTER)
					System.out.println("ctrl+enter is run!");

				//System.out.println(KeyEvent.getKeyText(e.getKeyCode())+"..."+e.getKeyCode());
			}
		});
		
		//��TextField���һ�����̼�����
		tf.addKeyListener(new KeyAdapter()
		{
			//��дkeyPressed�������������ı������������֣������ַ���������ʾ
			public void keyPressed(KeyEvent e)
			{
				int code = e.getKeyCode();

				//��if��������жϼ���������Ƿ�����
				if(!(code >= KeyEvent.VK_0 && code <= KeyEvent.VK_9))
				{
					System.out.println(code+"....�ǷǷ���");
					e.consume();  //��������ڽ������ֵ��ַ������뵽�ı�����
				}
			}
		});
	}

	public static void main(String[] args) 
	{
		new MouseAndKeyEvent();
	}
}
