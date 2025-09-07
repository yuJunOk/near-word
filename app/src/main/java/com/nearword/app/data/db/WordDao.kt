package com.nearword.app.data.db

import androidx.room.Dao
import androidx.room.Query
import com.nearword.app.data.db.entity.WordEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface WordDao {
    @Query("SELECT * FROM englishwords WHERE word = :word LIMIT 1")
    fun query(word: String): Flow<WordEntity?>
}