package com.zsy.app

class A {
    constructor(){
        println("constructor() ")
    }

    init {
        println("init() ")
    }

    companion object{
        init {
            println("companion object init() ")
        }
    }
}