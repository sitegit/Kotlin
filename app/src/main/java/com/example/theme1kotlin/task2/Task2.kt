package com.example.theme1kotlin.task2

import java.text.SimpleDateFormat
import java.util.Locale
import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KProperty

/*
* Написать свой делегат, который будет кешировать время запуска приложения.
* Раз в 3 секунды выводить закешированное значение в логи Не в UI потоке.
* */

class CachedTimeDelegate : ReadOnlyProperty<Any?, String> {
    override fun getValue(thisRef: Any?, property: KProperty<*>): String {
        val format = SimpleDateFormat("HH:mm:ss", Locale.getDefault())

        return format.format(LaunchTime.cachedTime)
    }
}

object LaunchTime {
    val cachedTime: Long by lazy { System.currentTimeMillis() }
}