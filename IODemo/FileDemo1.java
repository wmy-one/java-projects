/*
File�ࣺ
1���������ļ����ļ��з�װ�ɶ���
2��������ļ����ļ��е�������Ϣ���в�����
3��File���������Ϊ�������ݸ����Ĺ��캯����

File�ೣ��������
1������
	boolean createNewFile();  ��ָ��λ�ô����ļ�������ļ��Ѿ����ڣ�������������false;
			���������һ������������󴴽��ļ�ʱ�������ڣ��򸲸ǡ�

2��ɾ��
	boolean delete();ɾ��ʧ�ܣ�����false
	void deleteOnExit(); �ڳ����˳�ʱ��ɾ��ָ���ļ�

3���ж�
	boolean exists();  �ļ��Ƿ���ڣ�  isFile();   isDirectory();  
	isHidden();   isAbsolute(); 

4����ȡ��Ϣ
	getName();
	getPath():
	getParent():

	getAbsolutePath():
	long getLastModified():
	long length():
*/

class  FileDemo
{
	public static void main(String[] args) 
	{
		consMethod();
		method_1();
	}

	public static void method_3()
	{
		File f1 = new File("D:\\test.java");
		File f2 = new File("D:\\hahah.java");
		
		//�˷��������޸��ļ���������������ļ�����ͬһĿ¼��
		//��ɾ��f1������һ��ָ�����̴����ļ�
		printFun("rename:"+f1.renameTo(f2));
	}

	public static void method_2()
	{
		File f = new File("file.txt");

		printFun("path:"+f.getPath());
		printFun("abspath:"+f.getAbsolutePath());

		//���ؾ���·���еĸ�Ŀ¼�������ȡ�������·��������null;
		//������·��������һ��Ŀ¼����ô��Ŀ¼���Ƿ��ؽ��
		printFun("parent:"+f.getParent());  
			
	}

	//�ļ�����������ʹ��
	public static void method_1()
	{
		File f = new File("file.txt");
		printFun("create:"+f.createNewFile());  //�����ļ�
		printFun("delete:"+f.delete());   //ɾ���ļ�
	}

	//����File����
	public static void consMethod()
	{
		//��a.txt��װ��file���󣬿��Խ����еĻ�δ���ڵ��ļ����ļ��з�װ�ɶ���
		File f1 = new File("a.txt");

		//���ļ��к�Ŀ¼��Ϊ����������װ��File����
		File f2 = new File("D:\\test","b.txt");
		
		//�ֽ��ļ��з�װ��file��������Ϊ��������file
		File d = new File("D:\\test");
		File f3 = new File(d,"c.txt");

		printFun("f1:"+f1);
		printFun("f2:"+f2);
		printFun("f3:"+f3);
		
		//����������书����ͬ��ʹ��separator���ԣ�����ʵ��Ŀ¼�ָ����ƽ̨
		//File f4 = new File("D:\\test\\d.txt");
		File f4 = new File("D:"+File.separator+"test"+File.separator+"d.txt");
	}

	public static void printFun(Object obj)
	{
		System.out.println(obj);
	}
}
