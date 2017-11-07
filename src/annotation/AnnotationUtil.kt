package annotation

import javaText.Text
import java.io.BufferedReader
import java.io.InputStream
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL

/**
 * Created by 18624915319 on 2017/8/17.
 */
class AnnotationUtil {

    companion object {
        fun parse(className: Any): Unit {
            var class_: Any = className
            var cla = class_.javaClass
            var fileds = cla.declaredFields
            for (filed in fileds) {
                filed.isAccessible = true
                var annotations = filed.annotations
                for (annotation in annotations) {
                    if (annotation.annotationType() == IAnnotation::class.java) {
                        //                        var types = filed.genericType
                        //                        var obj = Class.forName(types.typeName)
                        //                        var instan = obj.newInstance()
                        //                        filed.set(class_, instan)
                        var any: Any = filed.get(className)
                        println(any)
                        filed.set(className, "67890")
                    }
                }
            }
        }
    }
}

fun main(args: Array<String>) {
    var text = arrayListOf(1, 2, 3, 4, 5)

}

fun text(): Unit {
    val (name, age) = TTT("", 1)
    var g = G<String>()
}




data class TTT(var s: String, var i: Int) {


}

class G(){

    var isOk: Boolean = true
        get() = true
        set(value) {
            field = value
        }

}

fun text(action: (v: String) -> String) {
    var s: String = action.invoke("666")

    println(s)
}