package javaText

import com.sun.tools.javac.code.Attribute
import com.sun.xml.internal.fastinfoset.sax.Properties
import java.lang.reflect.Field

import java.lang.reflect.InvocationTargetException
import java.lang.reflect.Method

/**
 * Created by 18624915319 on 2017/7/27.
 */
class Bean {

    infix public fun text(t: String) {
        println("测试成功")
    }


    class Text<T> {
        fun lunch(t: T): Unit{

        }
    }



}


class Bean2

data class Xxx(var name: String = "", var age: Int = 0)

fun Bean.tt(action: () -> Unit){
    val xx: Xxx = Xxx("xx", 22)
    xx.age = 21
    println(xx.toString())
    action.invoke()
}

fun mainn(args: Array<String>) {
    var j = System.currentTimeMillis()
    var d = 1 shl 4
    var z = System.currentTimeMillis()
    println("${d}时间 = ${z-j}")

    var q: Long = System.currentTimeMillis()
    println(q)

    var w = 0
    for(o in 0..1000000000)
         w= 2*2*2*2
    var e: Long= System.currentTimeMillis()
    println(e)
    println("${w}时间 = ${e-q}")
}

