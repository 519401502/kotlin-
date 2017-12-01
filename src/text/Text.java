package text;

import com.sun.xml.internal.fastinfoset.sax.Properties;

import java.io.*;
import java.util.Arrays;

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
        new Text().match();
        
    }

    private void match(){
        boolean isOk = false;
        String s = "fa.txt";
//        + 的使用
        isOk = s.matches("f+dsafa.txt");
//        * 的使用
        isOk = s.matches("f*dsafa.txt");
//        ? 的使用
        isOk = s.matches("ffff?dsafa.txt");
//        () 用于匹配字表达式
//        [] 标记一个中括号表达式的开始。
//        ^  标记匹配开始的位置
//        | 表达式
//        [] 表达式
//        [^as] 表达式
        isOk = s.matches("[^f,a]a.txt");

        System.out.println(isOk);
    }
}
