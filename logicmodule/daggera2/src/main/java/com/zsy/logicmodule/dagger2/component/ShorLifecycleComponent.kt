package com.zsy.logicmodule.dagger2.component

import com.zsy.logicmodule.dagger2.anno.ShortLifecycleAnno
import com.zsy.logicmodule.dagger2.scope.ShortLifecycleModule
import dagger.Component
import dagger.Provides

@ShortLifecycleAnno
@Component(modules = [ShortLifecycleModule::class],dependencies = [ApplicationComponent::class])
interface ShorLifecycleComponent {


}