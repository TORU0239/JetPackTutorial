package my.toru.jetpacktutorial.viewmodel.main

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import my.toru.jetpacktutorial.viewmodel.common.FragmentProvider

@Suppress("UNCHECKED_CAST")
class MainViewModelProviderFactory(private val fragmentProvider: FragmentProvider):ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MainViewModel(fragmentProvider) as T
    }
}