package com.example.theme1kotlin.task2

import android.util.Log
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.Locale
import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KProperty

/*
* Написать свой делегат, который будет кешировать время запуска приложения.
* Раз в 3 секунды выводить закешированное значение в логи Не в UI потоке.
* */

class CachedTimeDelegate(
    private val time: Long
): ReadOnlyProperty<Any?, CachedTimeDelegate> {

    private var scope = CoroutineScope(Dispatchers.Default)
    private var job: Job? = null

    override fun getValue(thisRef: Any?, property: KProperty<*>): CachedTimeDelegate = this

    fun showStartTime() {
        val format = SimpleDateFormat("HH:mm:ss", Locale.getDefault())

        job?.cancel()

        job = scope.launch {
            while (isActive) {
                Log.d("StartAppTime", "App launch time: ${format.format(time)}")
                delay(3000)
            }
        }
    }

    fun cancelLogging() {
        job?.cancel()
        job = null
    }
}