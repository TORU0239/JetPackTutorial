package my.toru.jetpacktutorial.ui.main

import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import my.toru.jetpacktutorial.R
import my.toru.jetpacktutorial.databinding.MainFragmentBinding
import my.toru.jetpacktutorial.viewmodel.common.FragmentProvider
import my.toru.jetpacktutorial.viewmodel.main.MainViewModel
import my.toru.jetpacktutorial.viewmodel.main.MainViewModelProviderFactory

class MainFragment : Fragment() {
    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel
    private lateinit var dataBinding: MainFragmentBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        dataBinding = DataBindingUtil.inflate(inflater, R.layout.main_fragment, container, false)
        return dataBinding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this, MainViewModelProviderFactory(FragmentProvider(this@MainFragment))).get(MainViewModel::class.java)
        dataBinding.mainViewModel = viewModel
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        Log.i("MainFragment", "requestCode:: $requestCode")
        super.onActivityResult(requestCode, resultCode, data)
    }
}