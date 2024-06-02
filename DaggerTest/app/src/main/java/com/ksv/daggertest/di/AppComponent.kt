package com.ksv.daggertest.di

import com.ksv.daggertest.GrandFatherClass
import dagger.Component

@Component(
    modules = [
        DataModule::class
    ]
)
interface AppComponent {
    fun grandFatherClass(): GrandFatherClass
}