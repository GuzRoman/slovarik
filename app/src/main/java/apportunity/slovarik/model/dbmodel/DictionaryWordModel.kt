package apportunity.slovarik.model.dbmodel

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "words_table")
data class DictionaryWordModel(
    var english: String,
    var transcription: String,
    var russian: String,

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "words_id")
    val wordsId: Long
)


