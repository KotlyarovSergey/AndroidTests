package com.ksv.daggertest

class GrandFatherClass(
    private val fatherClass: FatherClass
) {
    fun getBoolean(): Boolean{
        return fatherClass.getDouble() > 185
    }
    fun getNumber(): Int{
        return fatherClass.getDouble().toInt()
    }
}