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

    public static void mdain(String...args){
        long q = System.currentTimeMillis();
        for (int j=0; j< 100000000 ;j++) {
            int i = 5 << 3;
            int z = 5 << 3;
            int x = 5 << 3;
            int c = 5 << 3;
            int v = 5 << 3;
        }
        long w = System.currentTimeMillis();
        System.out.println(w - q);

        long a = System.currentTimeMillis();
        for (int j=0; j< 100000000 ;j++) {
            int i = 5 * 2 * 2 * 2;
            int v = 5 * 2 * 2 * 2;
            int b = 5 * 2 * 2 * 2;
            int n = 5 * 2 * 2 * 2;
            int m = 5 * 2 * 2 * 2;
        }
        long s = System.currentTimeMillis();
        System.out.println(s - a);
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