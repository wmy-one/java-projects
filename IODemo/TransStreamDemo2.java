/*
1��
Դ������¼�룻
Ŀ�ģ�����̨��

2��
����
��Ѽ���¼������ݴ洢��һ���ļ��С�
Դ������¼�룻
Ŀ�ģ��ļ���

3��
������Ҫ��һ���ļ������ݴ�ӡ�ڿ���̨�ϡ�
Դ���ļ���
Ŀ�ģ�����̨

�������Ļ������ɣ�
��ʹ������������кܶ࣬��֪��������һ����

1����ȷԴ��Ŀ��
	Դ����������InputStream��Reader��
	Ŀ�ģ��������OutputStream��Writer��

2�������������Ƿ��Ǵ��ı�
	�ǣ��ַ�����
	���ֽ�����

3������ϵ��ȷ������ȷҪʹ���ĸ�����Ķ���
ͨ���豸���������֣�
	Դ�豸���ڴ桢Ӳ�̡����̣�
	Ŀ���豸���ڴ桢Ӳ�̡�����̨��

-------------------------------------------

����
1����һ���ı��ļ��е����ݴ洢����һ���ļ��У������ļ���
	Դ����Ϊ��Դ������ʹ�ö�ȡ����InputStream��Reader��

	�ǲ��ǲ����ı��ļ���
	�ǣ���ʱ�Ϳ���ѡ��Reader��������ϵ����ȷ�ˡ�

	��������ȷҪʹ�ø���ϵ�е��ĸ�����
	��ȷ�豸��Ӳ�̣��ϵ�һ���ļ���
	Reader��ϵ�п��Բ����ļ��Ķ����ǣ�FileReader
	
	�Ƿ���Ҫ���Ч�ʣ�
	�ǣ�����Reader��ϵ�еĻ�������BufferedReader

	FileReader fr = new FileReader("a.txt");
	BufferedReader bufr = new BufferedReader(fr);


	Ŀ�ģ���Ϊ��Ŀ�ģ�����ʹ���������OutputStream��Writer

	�ǲ��ǲ������ı��ļ���
	�ǣ���ʱ�Ϳ���ѡ��Writer��������ϵ����ȷ�ˡ�

	��������ȷҪʹ�ø���ϵ�е��ĸ�����
	��ȷ�豸��Ӳ�̣�һ���ļ���
	Writer��ϵ�п��Բ����ļ��Ķ����ǣ�FileWriter

	�Ƿ���Ҫ���Ч�ʣ�
	�ǣ�����Writer��ϵ�еĻ�������BufferedWriter

	FileWriter fw = new FileWriter("b.txt");
	BufferedWriter bufw = new BufferedWriter(fw);


��ϰ����һ��ͼƬ�ļ��е����ݴ洢����һ���ļ��У������ļ���

-------------------------------------------------

2��������¼������ݱ��浽һ���ļ��С�
�����������Դ��Ŀ�ģ��ֱ������
	Դ������¼�룻InputStream��Reader

	�ǲ��Ǵ��ı���
	�ǣ�Reader

	�豸�����̣���Ӧ�Ķ�����System.in��
	����ѡ��Reader��System.in��Ӧ�Ĳ����ֽ�����
	Ϊ�˲������̵��ļ����ݷ��㣬ת���ַ��������ַ�������ʱ���ģ�
	���Լ�Ȼ��ȷ��Reader����ô�ͽ�System.inת���ַ���;
	�õ���Reader��ϵ�е�ת������InputStreamReader��

	�Ƿ���Ҫ���Ч�ʣ�
	�ǣ�ʹ��Reader��ϵ�еĻ�������BufferedReader

	InputStreamReader isr = new InputStreamReader(System.in);
	BufferedReader bufr = new BufferedReader(isr);

	
	Ŀ�ģ�OutputStream��Writer
	�Ƿ��Ǵ��ı����ǣ�Writer

	�豸��Ӳ�̣�һ���ļ���ʹ��FileWriter��

	�Ƿ���Ҫ���Ч�ʣ��ǣ�ʹ��BufferedWriter
	
	FileWriter fw = new FileWriter("c.txt");
	BufferedWriter bufw = new BufferedWriter(fw);

*********************************************************

��չ����Ҫ��¼������ݰ���ָ���ı����utf-8���������ݴ浽�ļ��С�
	
	Ŀ�ģ�OutputStream��Writer
	�Ƿ��Ǵ��ı����ǣ�Writer

	�豸��Ӳ�̣�һ���ļ���ʹ��FileWriter��
	����FileWriterʹ�õ�Ĭ�ϱ����GBK

	���ǣ��洢ʱ��Ҫ����ָ�������utf-8������ָ�������ֻ��ת��������ָ����
	����Ҫʹ�õĶ����ǣ�OutputStreamWriter��
	����ת��������Ҫ����һ���ֽ�����������һ����Բ����ļ����ֽ��������FileOutputStream
	
	�Ƿ���Ҫ���Ч�ʣ��ǣ�ʹ��BufferedWriter

	OutputStreamWriter osw = 
		new OutputStreamWriter(new FileOutputStream("d.txt"),"UTF-8");
	BufferedWriter bufw = new BufferedWriter(osw);

ע�⣺ת������ʱʹ�ã��ַ����ֽ�֮���������ͨ���漰���ַ�����ת��ʱ����Ҫʹ��ת������

��ϰ����һ���ı����ݴ�ӡ������̨�ϡ�
*/

class TransStreamDemo2
{
	public static void main(String[] args) 
	{
		//System.setIn(new FileInputStream("test.txt"));  //����������
		//System.setOut(new PrintStream("out.txt"));   //���������

		//����¼�������д��
		BufferedReader bufr = new BufferedReader(new InputStreamReader(System.in));
		
		//��Ӳ�̶�ȡ�ļ������ֽ���תΪ�ַ���
		/*
		BufferedReader bufr = 
			new BufferedReader(new InputStreamReader(new FileInputStream("in.txt")));
		*/

		//�������ת���ַ�������������¼������ݴ�д��Ȼ�󱣴浽�ļ���
		BufferedWriter bufw = 
			new BufferedWriter(new OutputStreamWriter(new FileOutputStream("out.txt")));

		String line = null;

		while((line=bufr.readLine()) != null)
		{
			if("over".equals(line))
				break;

			bufw.write(line.toUpperCase());  //д�뻺����
			bufw.newLine();  //����
			bufw.flush();    //���������е�����д�����
		}
		bufr.close();
	}
}
