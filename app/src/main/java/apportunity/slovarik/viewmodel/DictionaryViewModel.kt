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


class DictionaryViewModel(application: Application) : AndroidViewModel(application) {

    val readAllDictionaryThemes: LiveData<List<DictionaryWithWords>>
    private val repository: DictionaryRepository

    init {
        val dictionaryDAO = DictionaryDatabase.getDatabase(application).dictionaryDAO()
        repository = DictionaryRepository(dictionaryDAO)
        readAllDictionaryThemes = repository.readAllDictionaryThemes
    }


}
