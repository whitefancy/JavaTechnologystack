package javacore2.net;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.Scanner;

/**
 * telnet time-a.nist.gov 13
 */
public class SocketTest {
    public static void main(String[] args) {
        try (Socket s = new Socket("time-a.nist.gov", 13);//打开一个套接字
             Scanner in = new Scanner(s.getInputStream(), "UTF-8")) {
            while (in.hasNextLine()) {
                String line = in.nextLine();
                System.out.println(line);
            }
            InetAddress address = InetAddress.getByName("time-a.nist.gov");
            System.out.println(address.getHostAddress());
            InetAddress[] addresses = InetAddress.getAllByName("www.baidu.com");
            Arrays.stream(addresses).map(InetAddress::getHostAddress).forEach(System.out::println);
            address = InetAddress.getLocalHost();
            System.out.println(address.getHostAddress());//172.20.10.8
            address = InetAddress.getByName("localhost");
            System.out.println(address.getHostAddress());//127.0.0.1

        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
