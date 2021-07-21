package com.zsy.logicmodule.dagger2.di

import javax.inject.Inject

class User {

    var name : String

    @Inject constructor():this("初始名字"){

    }

    constructor(name : String){
        this.name = name
    }
}