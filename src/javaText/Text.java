package javaText;

import annotation.AnnotationUtil;
import annotation.IAnnotation;
import com.sun.tools.corba.se.idl.StringGen;
import com.sun.tools.javac.util.List;
import kotlin.reflect.jvm.internal.impl.load.kotlin.PackageClassUtils;
import redis.clients.jedis.Jedis;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by 18624915319 on 2017/7/29.
 */


public class Text {

    @IAnnotation
    public String string = "12345";

    public static void main(String...args){
//        System.out.println("sfs");
//        Jedis jedis = new Jedis("115.159.78.127", 6379);
//        jedis.auth("123456");
//        System.out.println("Connection to server sucessfully");
//        String s = jedis.set("xvhuichuang","sddfs");
//        System.out.println(s);
        System.out.println("~~~~");
        final Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                    System.out.println("执行完毕");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        thread.start();
        thread.suspend();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                    thread.resume();
                    System.out.println("已经解除线程挂起");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    public Text text(){
        //把对象传过去
        AnnotationUtil.Companion.parse(this);
        System.out.println(string);
        return this;
    }

    public void te(Object o){

    }

}