package my.toru.jetpacktutorial.viewmodel

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider

@Suppress("UNCHECKED_CAST")
class MainViewModelProviderFactory(private val fragmentProvider: FragmentProvider):ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MainViewModel(fragmentProvider) as T
    }
}