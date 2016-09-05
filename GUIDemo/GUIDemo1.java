/*
javaΪGUI�ṩ�Ķ��󶼴���java.Awt��javax.Swing�������С�
java.Awt(Abstract Window Toolkit�����󴰿ڹ��߰�)��
��Ҫ����ϵͳ����ʵ�ֹ��ܣ������������ؼ���

javax.Swing����Awt�Ļ����ϣ�����һ��ͼ�ν���ϵͳ���ṩ����������
��ȫ��javaʵ�֣���ǿ����ֲ�ԣ������������ؼ���

Container��Ϊ��������һ���������������������ͨ��add��������������������

������������ŷŷ�ʽ����Ϊ���֣������Ĳ��ֹ�������
FlowLayout����ʽ���ֹ��������������ҽ������У���PanelĬ�ϵĲ��ֹ�������
BorderLayout���߽粼�ֹ������������ն��������е�˳����FrameĬ�ϵĲ��ֹ�������
GridLayout�����񲼾ֹ�������������ľ�����аڷ������
CardLayout����Ƭ���ֹ�����������ѡ�һ���ĸ�ʽ�ڷ������
GridBagLayout����������ֹ������������շǹ���ľ�����аڷž���

�û�������Ĳ���������һ���¼�����ô�����¼�����������¼�Դ��
�¼��������ƣ�
�ⲿ�����������м������������Ķ������������¼�Դ�ϡ���>�¼�Դ(���)���������¼����󡪡�>�¼�����
�������¼����󴫸��¼�����ʽ����>���������������¼����͵Ķ���(�¼�����ʽ)������������ע�ᵽ�¼�Դ

�¼��������Ƶ��ص�:
1���¼�Դ��2���¼���3����������4���¼�����

�¼�Դ������awt������swing���е���Щͼ�ν��������
�¼���ÿһ���¼�Դ�����Լ����еĶ�Ӧ�¼��͹����¼���
�������������Դ���ĳһ���¼��Ķ�������ֻһ�������Ѿ���װ���˼������С�

�������ߣ���Java�ж��Ѿ�������ˣ�ֱ�ӻ�ȡ��������þͿ����ˣ�
����Ҫ���������ǣ����ǶԲ����Ķ������д���
*/
import java.awt.*;
import java.awt.event.*;

//����һ��
/*
class MyWin implements WindowListener
{
	/*
	����7��������������ֻ�õ��˹رյĶ�����
	����������û���õ���Ҳ���븴д�������Ƚ��鷳
	*/
}
*/

//��������
/*
��ΪWindowListener������WindowAdapter�Ѿ�ʵ����WindowListener�ӿڣ�
�����������е����з�������ʱ��ֻ��̳���WindowAdapter�������Լ���Ҫ�ķ������ɡ�
*/
class MyWin extends WindowAdapter
{
	//��дWindowClosing���������ڴ���رմ����¼�
	public void WindowClosing(WindowEvent e)  
	{
		System.out.println("Wondow is Closing !");
		System.exit(0);  //�˳�����Ҳ���ǹرմ���
	}

	//��дWindowActivated���������ڴ�������¼���ǰ�ô���ʱ���͵���һ�δ˷���
	public void WindowActivated(WindowEvent e)
	{
		System.out.println("����ڣ�");
	}

	//��дWindowOpened���������ڴ���򿪴����¼����򿪴���ʱ�����ô˷���
	public void WindowOpened(WindowEvent e)
	{
		System.out.println("�򿪴��ڣ�");
	}
}

class GUIDemo 
{
	public static void main(String[] args) 
	{
		/*
		����ͼ�ν��棺
		1������frame���壻
		2���Դ�����л������ã����磺��С��λ�á����ֵȣ�
		3�����������
		4�������ͨ�������add������ӵ������У�
		5���ô�����ʾ��ͨ��setVisible(true)ʵ�֡�
		*/
		Frame f = new Frame("My awt");  //����һ��������ɼ��Ĵ���
		f.setSize(500,400);    //���ô���ĳ��Ϳ���500����400
		f.setLocation(300,200);   //���ô�����ʾ��λ�ã���300����200
		f.setLayout(new FlowLayout());  //���ô��岼��

		Button b = new Button("First Button");
		f.add(b);  //����ť�����ӵ�Frame������
		
		//ͨ�������ಢ��������󣬽����ڼ�����ע�ᵽ����
		f.addWindowListener(new MyWin());  

		//ͨ�������ڲ��࣬ʵ�ֽ����ڼ�����ע�ᵽ����
		/*
		f.adaWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent e)
			{
				System.out.println("Wondow is Closing !");
				System.exit(0);  //�˳�����Ҳ���ǹرմ���
			}
		});
		*/

		f.setVisible(true);  //���ô���ɼ�

		System.out.println("Hello World!");
	}
}
