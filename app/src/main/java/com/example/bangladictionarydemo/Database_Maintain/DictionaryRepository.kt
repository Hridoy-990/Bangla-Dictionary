package com.example.bangladictionarydemo.Database_Maintain

import androidx.lifecycle.LiveData
import com.example.bangladictionarydemo.Database_Maintain.DictionaryBangla
import com.example.bangladictionarydemo.Database_Maintain.DictionaryDao

class DictionaryRepository(private val dictionaryDao: DictionaryDao) {

    val readAllData: LiveData<List<DictionaryBangla>> = dictionaryDao.readAllData()

    suspend fun addWord(dictionary: DictionaryBangla) {
        dictionaryDao.addWord(dictionary)
    }

    fun searchWord(dictionary: String): LiveData<List<DictionaryBangla>> {
        return dictionaryDao.searchWord(dictionary)
    }
}