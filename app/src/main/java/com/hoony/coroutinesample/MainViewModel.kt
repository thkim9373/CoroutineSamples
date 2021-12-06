package com.hoony.coroutinesample

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.joinAll
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext
import kotlin.random.Random

class MainViewModel : ViewModel() {

    fun launch(coroutineContext: CoroutineContext) {
        viewModelScope.launch(coroutineContext) {
            val startTime = System.currentTimeMillis()
            val jobList = mutableListOf<Job>()
            repeat(10000) {
                jobList.add(
                    launch {
                        val list = mutableListOf<Int>()
                        repeat(100) {
                            list.add(Random.nextInt())
                        }
                        list.sort()
                    }
                )
            }
            jobList.joinAll()
            Log.d(
                "Hoony",
                "launch on $coroutineContext finished : ${System.currentTimeMillis() - startTime}"
            )
        }
    }
}