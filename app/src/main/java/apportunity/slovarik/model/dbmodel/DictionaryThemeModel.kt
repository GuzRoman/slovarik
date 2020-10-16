package apportunity.slovarik.model.dbmodel

import androidx.room.*


@Entity(tableName = "dictionary_table")
data class DictionaryThemeModel(
    val name: String,
    val bestStats: Int,

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "dictionary_id")
    val dictionaryId: Long

)