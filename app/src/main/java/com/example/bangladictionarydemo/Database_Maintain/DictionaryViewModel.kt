package com.example.bangladictionarydemo.Database_Maintain

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DictionaryViewModel(application:Application):AndroidViewModel(application) {
    val readAllData: LiveData<List<DictionaryBangla>>
    private val repository : DictionaryRepository
    init {
        val dictionaryDao =  DictionaryDatabase.getDatabase(application).dictionaryDao()
        repository = DictionaryRepository(dictionaryDao)
        readAllData = repository.readAllData
    }
    fun addWord(dictionary: DictionaryBangla){
        viewModelScope.launch (Dispatchers.IO){
            repository.addWord(dictionary)
        }
    }
    fun searchWord(searchQuery: String): LiveData<List<DictionaryBangla>> {
        return repository.searchWord(searchQuery)
    }

}