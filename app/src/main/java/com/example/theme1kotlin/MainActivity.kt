package com.example.theme1kotlin

import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.example.theme1kotlin.task2.CachedTimeDelegate
import com.example.theme1kotlin.task3.Test3Class
import com.example.theme1kotlin.task3.findInt
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private val cachedTime by CachedTimeDelegate()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        createTask2()
        createTask3()
    }

    private fun createTask2() {
        lifecycleScope.launch(Dispatchers.Default) {
            repeatOnLifecycle(Lifecycle.State.RESUMED) {
                while (true) {
                    Log.d("StartAppTime", "App launch time: $cachedTime")
                    delay(3000)
                }
            }
        }
    }

    private fun createTask3() {
        val list: List<Any> = listOf(1, "Hello", listOf(2), true, 3.14f, 5, "World", false, Test3Class())

        findViewById<Button>(R.id.btnTask3).setOnClickListener {
            val ints = list.findInt()
            val message = ints.takeIf { it.isNotEmpty() }
                ?.let { "Ints in list: ${it.joinToString(", ")}" }
                ?: "No ints in list"

            Log.d("TAG", message)
        }
    }
}