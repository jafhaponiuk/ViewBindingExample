package com.example.viewbinding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.viewbinding.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private val list = listOf("Spider-man", "Superman", "Iron man", "Black panther", "Hulk", "Thor")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Before ViewBinding
        // setContentView(R.layout.activity_main)
        // val button = findViewById<Button>(R.id.btnToast)
        // button.setOnClickListener { toast() }

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnShowFragment.setOnClickListener { openFragment() }
        binding.btnShowRV.setOnClickListener { showRecyclerView() }
    }

    private fun showRecyclerView() {
        binding.fragmentContainer.visibility = View.GONE
        binding.rvList.visibility = View.VISIBLE

        binding.rvList.setHasFixedSize(true)
        binding.rvList.layoutManager = LinearLayoutManager(this)
        val adapter = MyAdapter(list)
        binding.rvList.adapter = adapter
    }

    private fun openFragment() {
        binding.fragmentContainer.visibility = View.VISIBLE
        binding.rvList.visibility = View.GONE

        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.add(R.id.fragmentContainer, ExampleFragment())
        fragmentTransaction.commit()
    }
}