package apportunity.slovarik.model.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import apportunity.slovarik.model.dbmodel.DictionaryThemeModel
import apportunity.slovarik.model.dbmodel.DictionaryWithWords
import apportunity.slovarik.model.dbmodel.DictionaryWordModel

@Dao
interface DictionaryDAO {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addDictionaryThemeWithWords(theme: DictionaryThemeModel, words: List<DictionaryWordModel>)

    @Transaction
    @Query("SELECT * FROM dictionary_table")
    fun readAllDictionaryThemesWithWords(): LiveData<List<DictionaryWithWords>>

    @Transaction
    @Query("SELECT * FROM dictionary_table WHERE dictionary_id == :themeId ")
    fun loadTheme(themeId : String) : DictionaryWithWords
}