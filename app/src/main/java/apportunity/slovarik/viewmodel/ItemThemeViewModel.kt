package apportunity.slovarik.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import apportunity.slovarik.model.dao.DictionaryDatabase
import apportunity.slovarik.model.dbmodel.DictionaryWithWords
import apportunity.slovarik.model.repository.DictionaryRepository

class ItemThemeViewModel(application: Application): AndroidViewModel(application) {
    private val repository: DictionaryRepository

    fun getThemeWoords(id: String): DictionaryWithWords{
        return repository.getThemeWord(id)
    }


    init {
        val dictionaryDAO = DictionaryDatabase.getDatabase(application).dictionaryDAO()
        repository = DictionaryRepository(dictionaryDAO)
    }

}