package com.nearword.app.data.db.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "englishwords")
data class WordEntity (
    @PrimaryKey(autoGenerate = true) val id: Int,
    val word: String? = null,
    val pronunciation: String? = null,
    val meaning: String? = null
)