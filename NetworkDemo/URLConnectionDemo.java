
import java.io.*;
import java.net .*;

class URLConnectionDemo 
{
	public static void main(String[] args) throws Exception
	{
		String urlPath = tf.getText();
		URL url = new URL("http://192.168.253:8080/myweb/demo.html");

		URLConnection conn = url.openConnection(); //返回远程连接对象
		System.out.println(conn);

		InputStream in = conn.getInputStream();
		byte[] buf = new byte[1024];
		int len = in.read(buf);

		System.out.println(new String(buf,0,len));
	}
}
