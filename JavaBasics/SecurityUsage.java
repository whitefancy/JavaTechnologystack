package JavaBasics;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class SecurityUsage {
    public String getMd5(String data) throws NoSuchAlgorithmException {

        //如果您实际上希望答案以字符串而不是字节数组的形式返回，则始终可以执行以下操作：
        String plaintext = data;
        MessageDigest m = MessageDigest.getInstance("MD5");
        m.reset();
        m.update(plaintext.getBytes());
        byte[] digest = m.digest();
        BigInteger bigInt = new BigInteger(1, digest);
        String hashtext = bigInt.toString(16);
        // Now we need to zero pad it if you actually want the full 32 chars.
        while (hashtext.length() < 32) {
            hashtext = "0" + hashtext;
        }
        return hashtext;
    }

    public static void main(String[] args) {
        String data = "appName=p29&channel=xiaomi&channelUid=10001&extra=100008&gameVersion=0.0.10&ip=115.238.59.122&productId=1&roleLevel=14&roleName=南海孙伍长&serverId=10003&uid=101021test31";
        try {
            System.out.println(new SecurityUsage().getMd5(data));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }
    //MD5压缩
    //你需要java.security.MessageDigest。
    //调用MessageDigest.getInstance("MD5")以获取MessageDigest您可以使用的MD5实例。
    //通过执行以下操作之一来计算哈希：
    //将整个输入作为abyte[]并使用进行一次运算来计算哈希md.digest(bytes)。
    //订阅MessageDigest一个byte[]通过调用一次块md.update(bytes)。添加完输入字节后，请使用计算哈希值 md.digest()。
    //在byte[]返回的md.digest()是MD5哈希值。
    //MessageDigest类不是线程安全的。如果它们将由不同的线程使用，则只需创建一个新线程，而不是尝试重用它们。
    //使用字符串和crypto类时，请确保始终指定要使用字节表示形式的编码。如果仅使用string.getBytes()它，则将使用平台默认值。（并非所有平台都使用相同的默认值）
    //import java.security.*;
    //byte[] bytesOfMessage = yourString.getBytes("UTF-8");
    //MessageDigest md = MessageDigest.getInstance("MD5");
    //byte[] thedigest = md.digest(bytesOfMessage);
    //apache commons编解码器项目的DigestUtils类，该类提供了非常方便的方法来创建MD5或SHA摘要。
    //MD5”不是一种编码，它是一种消息摘要算法（不是在新应用程序中应使用的一种算法）。编码是一种算法对，可将字节转换为字符串，并将字符串转换为字节。一个示例为“ UTF-8”，“ US-ASCII”，“ ISO-8859-1”，“ UTF-16BE”等。请使用与计算该字符串的哈希值的其他各方相同的编码，否则您将获得不同的结果。
    //我刚刚下载了commons-codec.jar，并获得了像md5这样的完美PHP。这是手册。
    //只需将其导入您的项目并使用
    //String Url = "your_url";
    //System.out.println( DigestUtils.md5Hex( Url ) );
    //MessageDigest md5 = MessageDigest.getInstance("MD5");
    //md5.update(StandardCharsets.UTF_8.encode(string));
    //return String.format("%032x", new BigInteger(1, md5.digest()));
    //很高兴使用BigInteger获得十六进制值+1
    //import java.security.*;
    //import java.math.*;
    //public class MD5 {
    // public static void main(String args[]) throws Exception{
    // String s="This is a test";
    // MessageDigest m=MessageDigest.getInstance("MD5");
    // m.update(s.getBytes(),0,s.length());
    // System.out.println("MD5: "+new BigInteger(1,m.digest()).toString(16));
    // }
    //}
}
