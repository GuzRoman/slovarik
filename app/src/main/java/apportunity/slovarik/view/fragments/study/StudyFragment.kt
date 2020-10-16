package apportunity.slovarik.view.fragments.study

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import apportunity.slovarik.R
import apportunity.slovarik.viewmodel.StudyViewModel

class StudyFragment : Fragment() {

    companion object {
        fun newInstance() =
            StudyFragment()
    }

    private lateinit var viewModel: StudyViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.study_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(StudyViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
