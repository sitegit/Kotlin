package com.example.theme1kotlin

import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.theme1kotlin.task2.CachedTimeDelegate
import com.example.theme1kotlin.task3.Test3Class
import com.example.theme1kotlin.task3.findInt

object StartedTime {
    val time = System.currentTimeMillis()
}

class MainActivity : AppCompatActivity() {

    private val startedTime = StartedTime.time
    private val logger by CachedTimeDelegate(startedTime)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        createTask3()
    }

    override fun onStart() {
        super.onStart()
        logger.showStartTime()
    }

    override fun onStop() {
        super.onStop()
        logger.cancelLogging()
    }

    private fun createTask3() {
        val list: List<Any> = listOf(1, "Hello", listOf(2), true, 3.14f, 5, "World", false, Test3Class())

        findViewById<Button>(R.id.btnTask3).setOnClickListener {
            val n = list.findInt()
            Log.d("TAG", n.toString())
        }
    }
}