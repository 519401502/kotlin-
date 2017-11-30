package uml

/**
 * Created by 18624915319 on 2017/11/27.
 */

class Bery{

}

open class Bird {

    lateinit var mBery: Bery

    fun group(): Unit {
        this.mBery = Bery()
    }

}

class Goose : Bird() {
}