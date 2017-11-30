package javaText

import java.util.*

/**
 * Created by 18624915319 on 2017/11/18.
 */

fun maidn(args: Array<String>): Unit {
    var matching = false

    System.out.println("请输入主字符串")
    val mainStr: String = Scanner(System.`in`).nextLine()
    val mainStrNumber = mainStr.length
    var mainChars = CharArray(mainStrNumber)
    for(c in 0 .. mainStrNumber - 1){
        mainChars[c] = mainStr.get(c)
    }

    System.out.println("请输入子字符串")
    val sonStr: String = Scanner(System.`in`).nextLine()
    val sonStrNumber = sonStr.length
    var sonStrChars = CharArray(sonStrNumber)
    for(c in 0..sonStrNumber - 1){
        sonStrChars[c] = sonStr.get(c)
    }

    var t:Int = 2 and 2

    var plugNumber = 0
    //算法开始
    for(i: Int in 0..mainStrNumber - 1 - sonStrNumber){
        var mainC = mainChars[i + plugNumber]
        plugNumber = 0
        for(j in 0..sonStrNumber - 1){
            var sonC = sonStrChars[j]
            if(sonC == mainC){
                if(j == sonStrNumber - 1){
                    matching = true;
                    break
                }
                mainC = mainChars[i.plus(1)]
                if(mainC == sonStrChars[0] && plugNumber == 0){
                    ++plugNumber
                }
            } else {
                break
            }
        }
        if(matching){
            break
        }
    }
    if(matching){
        System.out.println("匹配成功")
    } else {
        System.out.println("匹配失败")
    }


}
