
import java.awt.*;
import java.awt.event.*;

class FrameDemo
{
	//�����ͼ������������������
	private Frame f;
	private Button but;

	FrameDemo() 
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

		but = new Button("my button");

		//�������ӵ�frame��
		f.add(but);

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

		//ͨ�������ڲ��࣬�ð�ť�߱��˳�����Ĺ���
		/*
		��ť�����¼�Դ����ʱ��ѡ���ĸ��������أ�
		ͨ���رմ���ʾ���˽⵽����Ҫ֪���ĸ�����߱�ʲô�������м�������
		��Ҫ�鿴���������Ĺ��ܡ�
		ͨ������button��API���������ְ�ť֧��һ�����м�����addActionListener
		*/
		but.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				System.out.println("�����ť���˳�����");
				System.exit(0);
			}
		});
	}
}

class GUIDemo2 
{
	public static void main(String[] args) 
	{
		new FrameDemo();  //����frame����
	}
}
