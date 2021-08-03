package com.zsy.app

class A constructor(a : Int , str : String) {

    constructor():this(123,"321"){
        println("constructor() ")
    }

    init {
        println("init() $a")
        println("init() $str")
    }

    companion object{
        init {
            println("companion object init() ")
        }
    }
}