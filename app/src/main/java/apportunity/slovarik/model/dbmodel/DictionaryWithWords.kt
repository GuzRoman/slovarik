package apportunity.slovarik.model.dbmodel

import androidx.room.Embedded
import androidx.room.Relation


data class DictionaryWithWords(
    @Embedded val dictionaryTheme: DictionaryThemeModel?,
    @Relation(parentColumn = "dictionary_id", entityColumn = "words_id")
    val words: List<DictionaryWordModel>
)