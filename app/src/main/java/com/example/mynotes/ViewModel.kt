package com.example.mynotes

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ViewModel(application: Application):AndroidViewModel(application) {
     val reposit :Repo
    val allData:LiveData<List<Word>>

    init {
        var dao =MyDataBase.getDatabase(application).getData()
         reposit =Repo(dao)
         allData =  reposit.allData

    }
    fun delete(word: Word) = viewModelScope.launch(Dispatchers.IO){
        reposit.delete(word)
    }
    fun  insert(word: Word) =viewModelScope.launch(Dispatchers.IO) {
        reposit.insert(word)
    }
}