package apportunity.slovarik.view.fragments.itemtheme

import android.content.res.Resources
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import apportunity.slovarik.R
import apportunity.slovarik.model.dbmodel.DictionaryWithWords
import apportunity.slovarik.model.dbmodel.DictionaryWordModel
import apportunity.slovarik.view.fragments.addtheme.AddAdapter
import apportunity.slovarik.viewmodel.DictionaryViewModel
import apportunity.slovarik.viewmodel.ItemThemeViewModel
import kotlinx.android.synthetic.main.item_theme_fragment.view.*


class ItemThemeFragment : Fragment() {

    private lateinit var itemThemeViewModel: ItemThemeViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.item_theme_fragment, container, false)

        itemThemeViewModel = ViewModelProvider(this).get(ItemThemeViewModel::class.java)

        val listId = arguments?.get("ThemeId")

        val themeItemRecyclerView: RecyclerView = view.themeItemRecyclerView
        themeItemRecyclerView.layoutManager = LinearLayoutManager(requireContext())

        val list = itemThemeViewModel.getThemeWoords(listId.toString())

        val themeItemAdapter = AddAdapter(list.words)
        themeItemRecyclerView.adapter = themeItemAdapter

        return inflater.inflate(R.layout.item_theme_fragment, container, false)
    }



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


    }

}
