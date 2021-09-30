package com.example.bangladictionarydemo.Database_Maintain

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.bangladictionarydemo.Database_Maintain.DictionaryBangla


@Dao
interface DictionaryDao {
   @Insert(onConflict = OnConflictStrategy.IGNORE)
   suspend fun addWord(dictionary: DictionaryBangla)

   @Query("SELECT *FROM eng ORDER BY serial ASC")

   fun readAllData(): LiveData<List<DictionaryBangla>>

   @Query("SELECT * FROM eng WHERE word LIKE :searchQuery")

   fun searchWord(searchQuery: String): LiveData<List<DictionaryBangla>>

}