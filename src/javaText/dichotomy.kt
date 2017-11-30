package javaText

import sun.rmi.runtime.Log

/**
 * Created by 18624915319 on 2017/11/19.
 */

//二分查找算法
fun main(args: Array<String>) {
    //初始化数据
    val array: IntArray = IntArray(20).apply {
        for (i in 0 until this.size) {
            set(i, i)
        }
    }
    //搜索的字段
    val search: Int = -1
    //开始搜索
    if (search(search, array)) {
        println("包含此值")
    } else {
        println("不包含此值")
    }
}

fun search(search: Int, array: IntArray): Boolean {
    var currentTag = array.size
    currentTag = centre(currentTag)
    var scale = currentTag
    while (true) {
        //定位中间数
        if(currentTag > array.size || currentTag < 0){
            return false
        }
        var tag = array.get(currentTag)
        if (tag == search) {
            return true
        } else if (tag > search) {
            scale = centre(scale)
            currentTag -= scale
        } else if (tag < search) {
            scale = centre(scale)
            currentTag += scale
            if(currentTag == array.size)
                currentTag -= 1
        }
    }
}

fun centre(number: Int): Int {
    var n = number
    return if ((n % 2) == 1) {
        // >>

        (n / 2) + 1
    } else {
        n / 2
    }
}

