/**
 * Created by wmy_one on 2017/1/3.
 * 在这一节中，我将对上一节中学习的标准输入流和Console的用法，做一个简单的练习;
 * 本小节中，我将会编写一个简单的用户组管理系统，具体如下面的程序所示：
 * 注意：
 *      在Java的eclipse或其他IDE的控制台无法使用Console类；因为，该类只能用在标准输入流、
 *      输出流没有重定向的原始控制台中。
 */

import java.lang.*;
import java.util.*;

class User
{
    //创建用户名和密码
    public static void logInfo()
    {
        //无法使用Console类，该类只能用在标准输入流和输出流未被重定向的原始控制台中
        /*
        Console log = System.console();
        String username = log.readLine("UserName: ");
        char[] passwd = log.readPassword("Password: ");
        */
        Scanner log = new Scanner(System.in);
        System.out.print("User name: ");
        String username = log.nextLine();
        System.out.print("Password: ");
        int passwd = log.nextInt();

        System.out.println("---请添加用户信息!---");
    }

    public static String[][] infoSearch;  //用于操作存储的用户信息

    //添加用户信息
    public static void addInfo()
    {
        String[][] Info = new String[3][2];

        System.out.print("\n请输入需要创建的用户人数(1--10)：");
        Scanner people = new Scanner(System.in);
        int peopleNum = people.nextInt();

        for (int i=0; i<peopleNum; i++)
        {
            Scanner adin = new Scanner(System.in);
            System.out.print("请输入你的名字：");
            String name = adin.nextLine();
            System.out.print("请输入你的年龄：");
            int age = adin.nextInt();

            Info[i][0] = name;
            Info[i][1] = Integer.toString(age);
        }

        infoSearch = Info;
        System.out.println("***创建完毕!***");
    }

    //查询用户信息
    public static void searchInfo()
    {
        System.out.println("****请浏览用户信息****");
        System.out.println("**********************");
        System.out.println("****| name | age |****");
        System.out.println("****|------|-----|****");

        for (int j=0; j<infoSearch.length; j++)
        {
            System.out.printf("****|%-6s|%-5s|****\n",infoSearch[j][0],infoSearch[j][1]);
        }

        System.out.println("**********************");
    }

    //删除用户信息
    public static void delete()
    {
        System.out.println("\n原来的用户信息:");
        searchInfo();

        System.out.print("请输入要删除信息的用户名：");
        Scanner scanName = new Scanner(System.in);
        String delName = (String) scanName.next();

        //此处的for循环用于查询该用户名是否存在
        for (int i=0; i<infoSearch.length; i++)
        {
            if (infoSearch[i][0].equals(delName))
            {
                System.out.println("\n已找到此人，原始记录为：");
                System.out.println("**********************");
                System.out.println("****| name | age |****");
                System.out.println("****|------|-----|****");
                System.out.printf("****|%-6s|%-5s|****\n",infoSearch[i][0],infoSearch[i][1]);

                //下面的语句用于判断是否要删除该用户信息
                System.out.println("\n确定删除此人信息，请按：1；不删除请按：0");
                Scanner del = new Scanner(System.in);
                int num = del.nextInt();

                if (num == 1)    //此处的if语句用于删除用户信息
                {
                    for (int j=i; j<infoSearch.length-1; j++)
                    {
                        infoSearch[j] = infoSearch[j+1];
                    }

                    //下面的语句是为了保证调用searchInfo函数，显示的是删除后的用户信息
                    infoSearch = Arrays.copyOf(infoSearch, infoSearch.length-1);
                }
                else
                    break;
            }
        }

        System.out.println("浏览删除后的所有用户信息：");
        searchInfo();   //调用查询函数

        //下面的语句用于判断是否继续删除操作
        System.out.println("\n继续删除请按：1，不在删除请按：0");
        Scanner del = new Scanner(System.in);
        int renum = del.nextInt();
        switch (renum)
        {
            case 1:
                delete();
                break;
            case 0:
                break;
        }
    }
}

public class SecondDay {
    public static void main(String[] args)
    {
        String path = System.getProperty("SecondDay.java");
        /*
        * 问题：学习完标准输入流之后，我想实现一个简单的用户组管理系统，思路和步骤如下：
        * 思路：
        *       1）首先导入需要的Java包，并创建一个简单的用户菜单；
        *       2）创建用户组ID，并设置用户名和密码；
        *       3）向用户组中添加用户信息，并保存；
        *       4）退出并返回到菜单界面。
        * 步骤：
        *       1）通过import语句导入需要的util包，使用print语句创建菜单页；
        *       2）利用循环结构，使用自增运算符创建用户组ID，使用Console读取用户名和密码；
        *       3）通过标准输入流读取用户信息，使用数组保存用户信息；
        *       4）使用break语句返回到菜单界面。
        * */
        menu();
        System.out.print("请输入您的选择：");
        Scanner ain = new Scanner(System.in);

        //int aa = 0;  //表示用户组ID

        while (true)   //此处的while语句用于针对用户的不同选择，进行不同的处理
        {
            int select = ain.nextInt();
            switch (select)
            {
                case 1:
                    //aa++;        //用户组从一开始
                    User.logInfo();    //设置用户名和密码
                    User.addInfo();    //添加用户信息
                    break;
                case 2:
                    User.searchInfo();  //查询用户信息
                    break;
                case 3:
                    User.delete();     //删除用户信息
                    break;
                case 4:
                    System.exit(0);  //退出系统
            }

            //下面的语句用于判断是否继续操作用户信息
            System.out.print("是否继续进行(y or n)？");
            Scanner flag = new Scanner(System.in);
            String f = (String) flag.next();

            if (f.equals("y"))  //继续操作
            {
                menu();
                System.out.println("请再次输入您的选择：");
            }
            else
                System.exit(0);   //退出系统
        }
    }

    //创建一个菜单函数
    public static void menu()
    {
        System.out.println("--------菜 单--------");
        System.out.println("------1、登  录------");
        System.out.println("------2、查  询------");
        System.out.println("------3、删  除------");
        System.out.println("------4、退  出------");
        System.out.println("------欢迎光临!------");
    }

}


