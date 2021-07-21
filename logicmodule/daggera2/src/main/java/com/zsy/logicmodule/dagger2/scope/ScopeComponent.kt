package com.zsy.logicmodule.dagger2.scope

import com.zsy.logicmodule.dagger2.di.ApplicationComponent
import dagger.Component

@Component(modules = [ScopeModule::class],dependencies = [ApplicationComponent::class])
interface ScopeComponent {

}