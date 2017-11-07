package text;

import com.sun.xml.internal.fastinfoset.sax.Properties;

import java.io.*;

/**
 * Created by 18624915319 on 2017/7/26.
 */
public class Text {

//    public static void main(String...args){
//        ISay say = Factory.Companion.create(Factory.Li);
//        say.say("我是徐会闯");
//    }

    public String toAreaCode(String word) {
        if(word.length()!=1){
            return "";
        }
        byte[] bs= new byte[0];
        try {
            bs = word.getBytes("GB2312");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        String areaCode="";
        for(byte b:bs){
            int code=Integer.parseInt(Integer.toHexString(b & 0xff),16);
            areaCode += (code-0x80-0x20);       /*transfer the machine code to area code*/
        }
        return areaCode;
    }

    public static void main(String[] args) {
//        getClass().getResourceAsStream("text");
        System.getProperty("text.properties");
        System.out.println(Text.class.getResource("/"));
        Text text = new Text();
//        InputStream stream = Text.class.getResourceAsStream("/text.properties");
        InputStream stream = Text.class.getResourceAsStream("/text.properties");
        java.util.Properties properties = new java.util.Properties();
        try {
            properties.load(new BufferedReader(new InputStreamReader(stream, "utf-8")));
            String name = properties.getProperty("name");
            String age = properties.getProperty("age");
            System.out.println(name + age);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
