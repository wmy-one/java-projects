/*
ɾ��һ�������ݵ�Ŀ¼��
ɾ��ԭ��
��window�У�ɾ��Ŀ¼������������ɾ���ġ�

��Ȼ�Ǵ�������ɾ��������Ҫ�õ��ݹ顣
*/

import java.io.*;

class RemoveDir
{
    public static void main(String[] args)
    {
	File dir = new File("d:\\testdir");  //ָ��Ŀ¼
	removeDir(dir);
    }

    //����һ��removeDir����������ɾ��ָ��Ŀ¼�µ���������	
    public static void removeDir(File dir)
    {
	File[] Files = dir.listFiles();

	//��ѭ������ɾ��ָ��Ŀ¼������Ŀ¼�µ������ļ�
	for(int x=0; x<files.length; x++)
	{
	    //��if������ڱ��������ļ�
	    if(!files[x].isHidden() && files[x].isDirectory())
		removeDir(files[x]);
	    else
		printFun(files[x].toString()+":-file-:"+files[x].delete());
	}
	
	printFun(dir+"::dir::"+dir.delete());  //ɾ��Ŀ¼
    }

    //����һ��printFun���������ڴ�ӡ���յĲ���
    public static void printFun(Object obj)
    {
	System.out.println(obj);
    }
}