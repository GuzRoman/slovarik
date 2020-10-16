package apportunity.slovarik.view.fragments.translate

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import apportunity.slovarik.R
import apportunity.slovarik.viewmodel.TranslateViewModel

class TranslateFragment : Fragment() {

    companion object {
        fun newInstance() =
            TranslateFragment()
    }

    private lateinit var viewModel: TranslateViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.translate_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(TranslateViewModel::class.java)
    }

}
