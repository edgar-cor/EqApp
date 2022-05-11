package com.example.earthquaken

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.earthquaken.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.eqRecycler.layoutManager = LinearLayoutManager(this)

        val eqList = mutableListOf<Earthquake>()
        eqList.add(Earthquake("1", "Mexico", 4.3, 222,-122.2,2.22))
        eqList.add(Earthquake("2", "Mexico", 2.2, 222,-111.2,2.22))
        eqList.add(Earthquake("3", "Mexico", 3.3, 222,-44.3,2.22))

        val adapter = EqAdapter()
        binding.eqRecycler.adapter = adapter
        adapter.submitList(eqList)

        if ( eqList.isEmpty() ) {
            binding.eqEmpetyView.visibility = View.VISIBLE
        }else {
            binding.eqEmpetyView.visibility = View.GONE
        }
    }
}