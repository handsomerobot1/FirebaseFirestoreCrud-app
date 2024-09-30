package com.example.firebasefirestoremvvmcrud.viewmodel

import android.provider.ContactsContract
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.firebasefirestoremvvmcrud.model.Data
import com.example.firebasefirestoremvvmcrud.repository.DataRepository

class DataViewModel: ViewModel() {
    private val dataRepository = DataRepository()
    private var _datalist: MutableLiveData<List<Data>> = dataRepository.fetchData()
    val dataList :LiveData<List<Data>> get() = _datalist

    fun addData(data: Data,onSuccess:()->Unit,onFalure:() ->Unit){
         dataRepository.addData(data)
             .addOnSuccessListener { onSuccess() }
             .addOnFailureListener{onFalure()}
    }
    fun updateData(data: Data){
        dataRepository.updateData(data)
    }
    fun deleteData(data: Data,onSuccess:()->Unit,onFalure:() ->Unit){
        dataRepository.deleteData(data)
            .addOnSuccessListener { onSuccess() }
            .addOnFailureListener{onFalure() }
    }


}