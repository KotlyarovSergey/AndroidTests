package com.ksv.daggertest.di

import com.ksv.daggertest.ChildClass
import com.ksv.daggertest.FatherClass
import com.ksv.daggertest.GrandFatherClass
import dagger.Module
import dagger.Provides

@Module
class DataModule {

    @Provides
    fun providesChildClass(): ChildClass{
        return ChildClass()
    }


    @Provides
    fun providesFatherClass(childClass: ChildClass): FatherClass{

        return FatherClass(childClass)
    }

    @Provides
    fun providesGrandFatherClass(fatherClass: FatherClass): GrandFatherClass{
        return GrandFatherClass(fatherClass)
    }

}