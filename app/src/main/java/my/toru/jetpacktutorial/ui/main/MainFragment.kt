package my.toru.jetpacktutorial.ui.main

import android.arch.lifecycle.ViewModelProviders
import android.content.Context
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import my.toru.jetpacktutorial.R
import my.toru.jetpacktutorial.databinding.MainFragmentBinding
import my.toru.jetpacktutorial.viewmodel.ContextProvider
import my.toru.jetpacktutorial.viewmodel.MainViewModel

class MainFragment : Fragment() {
    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel
    private lateinit var databinding: MainFragmentBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        databinding = DataBindingUtil.inflate(inflater, R.layout.main_fragment, container, false)
        return databinding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        viewModel.ctxProvider = ContextProvider(activity as Context)
        databinding.mainViewModel = viewModel
    }
}