package com.nearword.app.data.repo

import com.nearword.app.data.db.WordDao
import com.nearword.app.domain.model.Word
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class WordRepository(private val dao: WordDao) {
    fun query(word: String): Flow<Word?> =
        dao.query(word).map { it?.let { Word(it.word, it.pronunciation, it.meaning) } }
}