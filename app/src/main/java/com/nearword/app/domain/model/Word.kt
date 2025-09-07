package com.nearword.app.domain.model

data class Word(
    val word: String?,         // 可空字段
    val pronunciation: String?, // 可空字段
    val meaning: String?       // 可空字段
)