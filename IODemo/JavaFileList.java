/*
��һ��ָ��Ŀ¼�µ�Java�ļ��ľ���·�����洢��һ���ı��ļ��У�
����һ��Java�ļ��б��ļ���

˼·��
1����ָ����Ŀ¼���еݹ飻
2����ȡ�ݹ������Java�ļ���·����
3������Щ·���洢�������У�
4���������е�����д�뵽һ���ļ��С�
*/

import java.io.*;
import java.util.*;

class JavaFileList
{
    public static void main(String[] args) throws IOException
    {
	File dir = new File("d:\\javaTest");
	List<File> list = new ArrayList<File>();

	fileToList(dir,list);  //��ָ��Ŀ¼�µ����������б�洢�ڼ�����
	printFun(list.size());
	
	File f = new File(dir,"javalist.txt");
	writeToFile(list,file.toString());   //��ָ��Ŀ¼�µ����������б�д���ļ���
    }

    //����һ��printFun���������ڴ�ӡ���յĲ���
    public static void printFun(Object obj)
    {
	System.out.println(obj);
    }

    //����һ��fileToList������ʹ�ü���list�洢ָ��Ŀ¼�µ���������	
    public static void fileToList(File dir,List<File> list)
    {
	File[] files = dirlistFiles();
	
	for(File file : files)
	{
	    if(file.isDirectory())    //�ж��Ƿ���Ŀ¼
		fileToList(file,list);
	    else
	    {
		if(file.getName().endsWith(".java"))  //�ж��Ƿ�����.java��β���ļ�
		    list.add(file);
	    }
	}
    }

    public static void writeToFile(List<File> list,String javaListFile)
    {
	BufferedWriter bufw = null;
	try
	{
	    //����д��������ָ���ļ�JavaListFile������д�������ݴ洢�ڻ������У�
	    bufw = new BufferedWriter(new FileWriter(javaListFile));
	    
	    for(File f : list)
	    {
		String path = f.getAbsolutePath();  //��ȡ����·��
		bufw.write(path);  //д����
		bufw.newLine();  //����
		bufw.flush();  //�����������е�����д���ļ���
	    }
	}
	catch(IOException e)
	{
	    throw RuntimeException("д���ļ�ʧ�ܣ�");
	}
	finally
	{
	    try
	    {
		if(bufw != null)
		    bufw.close();
	    }
	    catch(IOException ex)
	    {
		throw ex;
	    }
	}
    }
}