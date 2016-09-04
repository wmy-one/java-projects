/*
�г�ָ��Ŀ¼���ļ������ļ��У�������Ŀ¼�е����ݣ�
Ҳ�����г�ָ��Ŀ¼���������ݡ�

��ΪĿ¼�л���Ŀ¼��ֻҪʹ��ͬһ���г�Ŀ¼���ܵĺ�����ɼ��ɣ�
���г������г��ֵĻ���Ŀ¼�Ļ����������ٴε��ñ����ܣ�
Ҳ���Ǻ�����������������ֱ�����ʽ�����߱���ַ�����Ϊ�ݹ顣

�ݹ�Ҫע�⣺
1���޶�������
2��Ҫע��ݹ�Ĵ��������������ڴ������
*/

import java.io.*;

class FileDemo3
{
    public static void main(String[] args)
    {
	File dir = new File("d:\\java");

	showDir(dir);       //�г�Ŀ¼����������
	showDir_2(dir,0);  //�г�Ŀ¼���������ݡ��������

	toBin(6);  //��ӡ6�Ķ����Ʊ�����ʽ
    }

    //����һ��toBin���������ڽ����յ���תΪ������
    public static void toBin(int num)
    {
	if(num > 0)
	{
	    toBin(num/2);  //���õݹ�ѭ������toBin���������г�2ģ2����
	    System.out.println(num%2);
	}
    }

    //����һ��showDir����������ʵ�ִ�ӡָ��Ŀ¼�¼�����Ŀ¼�µ������ļ�	
    public static void showDir(File dir)
    {
	File[] files = dir.listFiles();
	for(int x=0; x<files.length; x++)
	{
	    System.out.println(dir);
	    if(files[x].isDirectory())  //�ж��Ƿ���Ŀ¼������ǣ����������
		showDir(files[x]);
	    else
	        System.out.println(files[x]);
	}
    }

    //
    public static String getLevel(int level)
    {
	StringBuilder sd = new StringBuilder();
	sb.append("|--");

	for(int x=0; x<level; x++)
	{
	    //sb.append("|--");
	    sb.insert(0,"| ");
	}
	return sb.toString();
    }

    //�г�ָ��Ŀ¼�¼�����Ŀ¼�µ������ļ�����һ���Ĳ㼶	
    public static void showDir_2(File dir,int level)
    {
	System.out.println(getLevel(level)+dir.getName());
	level++;

	File[] files = dir.listFiles();
	for(int x=0; x<files.length; x++)
	{	    
	    if(files[x].isDirectory())  //�ж��Ƿ���Ŀ¼������ǣ����������
		showDir(files[x],level);
	    else
	        System.out.println(files[x]);
	}
    }
}