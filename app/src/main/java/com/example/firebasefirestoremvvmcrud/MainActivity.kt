package com.example.firebasefirestoremvvmcrud

import android.app.Activity
import android.os.Bundle
import android.provider.ContactsContract.Data
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.example.firebasefirestoremvvmcrud.adapter.DataAdapter
import com.example.firebasefirestoremvvmcrud.databinding.ActivityMainBinding
import com.example.firebasefirestoremvvmcrud.repository.DataRepository
import com.example.firebasefirestoremvvmcrud.viewmodel.DataViewModel
import androidx.recyclerview.widget.LinearLayoutManager


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val dataViewModel:DataViewModel by viewModels ()
    private lateinit var adapter:DataAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        binding =ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        adapter = DataAdapter(listOf(),this)
        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager = LinearLayoutManager(this)

        dataViewModel.dataList.observe(this, Observer {
          binding.addBtn.setOnClickListener{
            val id = binding.id
          }
        })




    }
}