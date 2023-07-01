package org.jesperancinha.manager.note.dao

import java.time.LocalDateTime

interface StoryDao {

}

interface WordDao {

}

data class Word(
    val word: String,
    val timestamp: LocalDateTime = LocalDateTime.now()
)