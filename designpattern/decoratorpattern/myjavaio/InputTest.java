package designpattern.decoratorpattern.myjavaio;

import java.io.*;

public class InputTest {
    public static void main(String[] args) throws IOException {
        int c;
        try {
            String path = "C:\\Users\\BZM\\IdeaProjects\\ToolLib\\Proj_Java\\Mylib\\src\\test\\test.txt";
            InputStream in = new LowerCaseInputStream(new BufferedInputStream(new FileInputStream(path)));
            while ((c = in.read()) >= 0) {
                /*
                只用流来读取字符，一直到文件的尾端，每当读一个字符，就显示出来
                 */
                System.out.print((char) c);
            }
            in.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
