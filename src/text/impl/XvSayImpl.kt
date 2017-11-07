package text.impl

import text.ISay

/**
 * Created by 18624915319 on 2017/7/26.
 */
class XvSayImpl : ISay<String>{

    override fun say(t: String) {
        println(t)
    }

}