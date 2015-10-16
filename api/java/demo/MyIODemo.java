package demo;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
/**
 * Java提供了FileInputStream以及FileOutputStream类来进行文件的读写操作。
 * FileInputStream的构造方法会接收输入文件的路径作为入参然后创建出一个文件的输入流。
 * 同样的，FileOutputStream的构造方法也会接收一个文件路径作为入参然后创建出文件的输出流。
 * 在处理完文件之后，一个很重要的操作就是要记得”close”掉这些流。
 * @author 董槟瑞
 * 2015年10月16日
 * 下午4:42:41
 */
public class MyIODemo {
	public static void main(String args[]) throws IOException {
        FileInputStream in = null;
        FileOutputStream out = null;

        try {
            in = new FileInputStream("E:\\GitHub\\eclipse\\br2zz\\api\\java\\demo\\json\\jsonDemoFile.json"); //读的文件
            out = new FileOutputStream("E:\\GitHub\\eclipse\\br2zz\\api\\java\\demo\\json\\OutputFile.txt");  //写入的文件

            int c;
            while((c = in.read()) != -1) {
                out.write(c);
            }
        } finally {
            if(in != null) {
                in.close();
            }
            if(out != null) {
                out.close();
            }
        }
    }
}
