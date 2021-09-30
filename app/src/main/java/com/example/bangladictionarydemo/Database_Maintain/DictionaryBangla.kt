package com.example.bangladictionarydemo.Database_Maintain

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "eng")
data class DictionaryBangla(
    @PrimaryKey(autoGenerate = true)
    var serial: Int?,
    var  word : String?,
):Parcelable