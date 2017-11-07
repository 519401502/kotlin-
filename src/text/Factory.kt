package text

import org.omg.CORBA.Object
import text.impl.XvSayImpl
import java.io.UnsupportedEncodingException
import java.lang.reflect.Field
import java.lang.reflect.Method
import kotlin.reflect.KClass

/**
 * Created by 18624915319 on 2017/7/26.
 */
class Factory {

    companion object {

        val Xv: String = "XvSayImpl"
        val Li: String = "LiSayImpl"

        fun create(name: String): ISay<*> {
            val className: Class<*> = Class.forName(name)
            val instance = className.newInstance()
            return instance as ISay<*>
        }
    }

    fun toAreaCode(word: String, lock: () -> Unit): String {

        if (word.length != 1) {
            return ""
        }
        var bs: ByteArray = ByteArray(0)
        try {
            bs = word.toByteArray("GB2312")
        } catch (e: UnsupportedEncodingException) {
            e.printStackTrace()
        }
        var areaCode = ""
        for (b in bs) {
            var s = 4
            val dd: Byte = 0x23
            val ddd: Byte = 0x44
            if (areaCode != null && areaCode != "") {

            }

        }
        return areaCode
    }


}

open class Bean {

    private fun text(): Unit {
        println("调用内部的text方法成功了")
    }
}

class PrivateTest {

}


fun main(args: Array<String>) : Unit {
    var clazz = Bean::class.java
    var bean : Bean = clazz.newInstance()
    var m : Method =clazz.getMethod("text", null);
    //下面这一步是必须的，必须先要设置访问权限为true
    m.isAccessible = true;
    m.invoke(bean);
//    var id: Field = clazz.getDeclaredField("id");
//    id.setAccessible(true);
//    var i = id.getInt(bean);
//    System.out.println(i);
}

abstract class Interface {
    var f: String = ""

    companion object {
        val s: String = ""
    }
}

class d : Interface() {
    var ss: String
        get() = throw UnsupportedOperationException()
        set(value) {
        }

    fun f(): Unit {
        println()

    }
}
