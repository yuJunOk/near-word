package com.nearword.app.domain.usecase

import com.nearword.app.data.repo.WordRepository
import com.nearword.app.domain.model.Word
import kotlinx.coroutines.flow.Flow

class QueryWordUseCase(private val repo: WordRepository) {
    operator fun invoke(word: String): Flow<Word?> = repo.query(word)
}