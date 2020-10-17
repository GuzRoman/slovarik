package apportunity.slovarik.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import apportunity.slovarik.model.dbmodel.DictionaryWithWords

class Communicator : ViewModel() {

    private val passedData = MutableLiveData<Any>()

    fun setDataCommunicator(data: DictionaryWithWords) {
        passedData.value = data
    }

    fun getValue(): DictionaryWithWords {
        return passedData.value as DictionaryWithWords
    }

}