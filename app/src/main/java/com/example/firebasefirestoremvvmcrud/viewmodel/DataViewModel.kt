package com.example.firebasefirestoremvvmcrud.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.firebasefirestoremvvmcrud.model.Data
import com.example.firebasefirestoremvvmcrud.repository.DataRepository

class DataViewModel: ViewModel() {
    private val repository = DataRepository()
    private val dataList:MutableLiveData<List<Data>> = DataRepository.fetchdata()
}