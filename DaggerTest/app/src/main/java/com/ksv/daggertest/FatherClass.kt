package com.ksv.daggertest

class FatherClass(
    private val childClass: ChildClass
) {
    fun getDouble(): Double{
        val i = childClass.getInt()
        return i * 3.7
    }
}