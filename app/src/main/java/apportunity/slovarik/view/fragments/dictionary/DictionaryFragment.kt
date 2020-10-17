package apportunity.slovarik.view.fragments.dictionary

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import apportunity.slovarik.R
import apportunity.slovarik.model.dbmodel.DictionaryWithWords
import apportunity.slovarik.viewmodel.Communicator
import apportunity.slovarik.viewmodel.DictionaryViewModel
import kotlinx.android.synthetic.main.dictionary_fragment.view.*

class DictionaryFragment : Fragment(), DictionaryAdapter.onItemClickListener {

    private lateinit var dictionaryViewModel: DictionaryViewModel
    private lateinit var communicator: Communicator




    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.dictionary_fragment, container, false)
        view.addDictionaryBTN.setOnClickListener {
            findNavController().navigate(R.id.action_dictionaryFragment_to_addDictionaryFragment)
        }

        val dictionaryAdapter = DictionaryAdapter(this)

        val dictionaryRecyclerView: RecyclerView = view.recyclerViewDictionary

        dictionaryRecyclerView.adapter = dictionaryAdapter

        dictionaryRecyclerView.layoutManager = LinearLayoutManager(requireContext())

        dictionaryViewModel = ViewModelProvider(this).get(DictionaryViewModel::class.java)
        communicator = ViewModelProvider(this).get(Communicator::class.java)

        dictionaryViewModel.readAllDictionaryThemes.observe(viewLifecycleOwner, Observer {list ->
            dictionaryAdapter.setData(list)
        })


        return view
    }

    override fun onItemClick(theme: DictionaryWithWords) {
        communicator.setDataCommunicator(theme)
        findNavController().navigate(R.id.action_dictionaryFragment_to_itemThemeFragment)
    }


}
