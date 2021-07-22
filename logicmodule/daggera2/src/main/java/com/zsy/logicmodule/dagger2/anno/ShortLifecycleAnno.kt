package com.zsy.logicmodule.dagger2.anno

import java.lang.annotation.Documented
import java.lang.annotation.Retention
import java.lang.annotation.RetentionPolicy
import javax.inject.Scope

@Scope
@Documented
@Retention(RetentionPolicy.RUNTIME)
annotation class ShortLifecycleAnno{

}