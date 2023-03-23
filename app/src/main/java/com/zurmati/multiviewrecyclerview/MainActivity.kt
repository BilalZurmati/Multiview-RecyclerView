package com.zurmati.multiviewrecyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.zurmati.multiviewrecyclerview.adapter.MultiViewAdapter
import com.zurmati.multiviewrecyclerview.databinding.ActivityMainBinding
import com.zurmati.multiviewrecyclerview.models.ImageModel
import com.zurmati.multiviewrecyclerview.models.TextModel

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
            TextModel("Muhammad Bilal", "Android Developer", R.drawable.man_standing_with_tennis_ball),
            TextModel("Muhammad Bilal", "Android Developer", R.drawable.man_standing_with_tennis_ball),
            ImageModel("This is just dummy description about this image", R.drawable.car),
            TextModel("Muhammad Bilal", "Android Developer", R.drawable.man_standing_with_tennis_ball),
            ImageModel("This is just dummy description about this image", R.drawable.channel),
            ImageModel("This is just dummy description about this image", R.drawable.channel),
            TextModel("Muhammad Bilal", "Android Developer", R.drawable.man_standing_with_tennis_ball),
        )
    }
}