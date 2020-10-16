package apportunity.slovarik.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import apportunity.slovarik.model.dao.DictionaryDatabase
import apportunity.slovarik.model.dbmodel.DictionaryThemeModel
import apportunity.slovarik.model.dbmodel.DictionaryWithWords
import apportunity.slovarik.model.dbmodel.DictionaryWordModel
import apportunity.slovarik.model.repository.DictionaryRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.util.*

class AddViewModel(application: Application) : AndroidViewModel(application)  {

    private val readAllDictionaryThemes: LiveData<List<DictionaryWithWords>>
    private val repository: DictionaryRepository


    init {
        val dictionaryDAO = DictionaryDatabase.getDatabase(application).dictionaryDAO()
        repository = DictionaryRepository(dictionaryDAO)
        readAllDictionaryThemes = repository.readAllDictionaryThemes
    }

    fun addDictionaryTheme(theme: DictionaryThemeModel, words: List<DictionaryWordModel>){
        viewModelScope.launch(Dispatchers.IO) {
            repository.addDictionaryTheme(theme, words)
        }
    }


    fun textCorrector(word: String) = spaceDel(word).toLowerCase(Locale.ROOT)

    private fun spaceDel(word: String): String{
        var worInCharArray = word.toCharArray()
        var correctWord = ""
        for (char in worInCharArray)
            if (char != ' ') correctWord += char
        return correctWord
    }
}