package apportunity.slovarik.model.repository

import androidx.lifecycle.LiveData
import apportunity.slovarik.model.dao.DictionaryDAO
import apportunity.slovarik.model.dbmodel.DictionaryThemeModel
import apportunity.slovarik.model.dbmodel.DictionaryWithWords
import apportunity.slovarik.model.dbmodel.DictionaryWordModel

class DictionaryRepository(private val dictionaryDAO: DictionaryDAO) {

    val readAllDictionaryThemes: LiveData<List<DictionaryWithWords>> = dictionaryDAO.readAllDictionaryThemesWithWords()

    fun getThemeWord(id: String): DictionaryWithWords {
        return dictionaryDAO.loadTheme(id)
    }

    suspend fun addDictionaryTheme(dictionaryTheme: DictionaryThemeModel, words: List<DictionaryWordModel>) {
        dictionaryDAO.addDictionaryThemeWithWords(dictionaryTheme, words)
    }

}