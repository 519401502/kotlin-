package text.impl

import jdk.jfr.events.SocketReadEvent
import org.apache.log4j.net.SocketServer
import text.ISay
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.ServerSocket
import java.net.Socket
import java.net.URL

/**
 * Created by 18624915319 on 2017/7/26.
 */
class LiSayImpl : ISay<String> {

    override fun say(t: String) {
        println(t)
    }


}

fun main(args: Array<String>) {
//    var url = URL("http://rw8e76.natappfree.cc/app/http?xv=xvhuichuang&hui=nice")
//    var httpUrlConnection: HttpURLConnection = url.openConnection() as HttpURLConnection
//    httpUrlConnection.apply {
//        connectTimeout = 8 * 1000
//        doInput = true
//        doOutput = true
//        requestMethod = "POST"
//        connect()
//    }
//    var input = httpUrlConnection.inputStream
//    var buffered = BufferedReader(InputStreamReader(input, "utf-8"))
//    var stringBuilder = StringBuilder()
//    var string: String? = buffered.readLine()
//    while(string != null){
//        stringBuilder.append(string)
//        string = buffered.readLine()
//    }
//    System.out.println("收到的服务器回应:" + stringBuilder.toString())

    var socket = Socket("http://rw8e76.natappfree.cc", 8888)
    var input = socket.inputStream
    var buffered = BufferedReader(InputStreamReader(input, "utf-8"))
    var string = buffered.readLine()
    System.out.println("得到的信息" + string)

}