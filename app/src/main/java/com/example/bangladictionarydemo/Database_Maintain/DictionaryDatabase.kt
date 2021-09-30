package com.example.bangladictionarydemo.Database_Maintain

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [DictionaryBangla::class] , version = 400 , exportSchema = true)
abstract class DictionaryDatabase: RoomDatabase() {
    abstract fun dictionaryDao(): DictionaryDao
    companion object{
        @Volatile
        private var INSTANCE : DictionaryDatabase? = null
        fun getDatabase(context: Context) : DictionaryDatabase {
            val tempInstance = INSTANCE
            if(tempInstance != null){
                return  tempInstance
            }
            synchronized(this){
                val instance  = Room.databaseBuilder(
                    context.applicationContext,
                    DictionaryDatabase  :: class.java,
                    "eng"
                ).createFromAsset("databases/DictionaryDatabaseE2B.db").build()
                INSTANCE = instance
                return instance
                //.fallbackToDestructiveMigration()
            }
        }
    }
}