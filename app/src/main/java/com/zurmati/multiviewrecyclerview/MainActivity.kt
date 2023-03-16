package com.zurmati.multiviewrecyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.zurmati.multiviewrecyclerview.adapter.MultiViewAdapter
import com.zurmati.multiviewrecyclerview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        val adapter = MultiViewAdapter(this, getItems())
        binding.recyclerView.adapter = adapter
    }


    fun getItems(): MutableList<Any> {
        return mutableListOf(
            "Hello guys! My name is Muhammad Bilal, I am an android developer with 4 years of experience.",
            "Hello guys! My name is Muhammad Bilal, I am an android developer with 4 years of experience.",
            "Hello guys! My name is Muhammad Bilal, I am an android developer with 4 years of experience.",
            R.drawable.channel,
            "Hello guys! My name is Muhammad Bilal, I am an android developer with 4 years of experience.",
            "Hello guys! My name is Muhammad Bilal, I am an android developer with 4 years of experience.",
            R.drawable.channel,
        )
    }
}