package apportunity.slovarik.view.fragments.addtheme

import android.app.Application
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import apportunity.slovarik.R
import apportunity.slovarik.model.dbmodel.DictionaryThemeModel
import apportunity.slovarik.model.dbmodel.DictionaryWithWords
import apportunity.slovarik.model.dbmodel.DictionaryWordModel
import apportunity.slovarik.viewmodel.AddViewModel
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.add_dictionary_fragment.*
import kotlinx.android.synthetic.main.add_dictionary_fragment.view.*


class AddDictionaryFragment : Fragment() {

    private lateinit var addViewModel: AddViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        addViewModel = ViewModelProvider(this).get(AddViewModel::class.java)

        return inflater.inflate(R.layout.add_dictionary_fragment, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val addRecyclerView: RecyclerView = view.learnFragmentRecyclerView
        addRecyclerView.layoutManager = LinearLayoutManager(requireContext())

        val list = mutableListOf<DictionaryWordModel>()

        addButton.setOnClickListener {

            val native = addViewModel.textCorrector(edWord.text.toString())
            val transcription = addViewModel.textCorrector(edTranscription.text.toString())
            val translation = addViewModel.textCorrector(edTranslation.text.toString())

            if (native.isEmpty() || transcription.isEmpty() || translation.isEmpty()) {

                Toast.makeText(requireContext(), "Заполните все поля", Toast.LENGTH_SHORT)
                    .show()

            } else {

                val word = DictionaryWordModel(
                    native,
                    transcription,
                    translation, 0
                )

                list.add(word)

                val addAdapter = AddAdapter(list)

                addRecyclerView.adapter = addAdapter

                edWord.setText("")
                edTranscription.setText("")
                edTranslation.setText("")
            }
        }

        saveButton.setOnClickListener {
            insertDataToDataBase(list)
        }

    }

    private fun insertDataToDataBase(list: List<DictionaryWordModel>) {

        if (list.isEmpty() || edThemeName.text.toString().isEmpty()) {

            Toast.makeText(requireContext(), "Заполните все поля", Toast.LENGTH_SHORT)
                .show()

        } else {

            val newTheme = DictionaryThemeModel(
                edThemeName.text.toString(),
                0,
                0
            )

            addViewModel.addDictionaryTheme(newTheme, list)

            findNavController().navigate(R.id.action_addDictionaryFragment_to_dictionaryFragment)
        }
    }

}
