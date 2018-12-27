package my.toru.jetpacktutorial.viewmodel.main

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModel
import android.databinding.ObservableField
import android.util.Log
import android.view.View
import my.toru.jetpacktutorial.model.data.PostData
import my.toru.jetpacktutorial.model.remote.JetPackNetworkApi
import my.toru.jetpacktutorial.model.remote.RetrofitCallback
import my.toru.jetpacktutorial.ui.main.MainAdapter
import my.toru.jetpacktutorial.viewmodel.common.FragmentProvider

class MainViewModel(private val fragmentProvider: FragmentProvider) : ViewModel() {
    val progressObservable: ObservableField<Boolean> = ObservableField(true)
    val adapter:MainAdapter = MainAdapter{
        fragmentProvider.showToast("Clicked!!")
        fragmentProvider.moveToDetail()
    }

    private val resultTextData:MutableLiveData<String> = MutableLiveData()

    init {
        callAPI()
        resultTextData.observe(fragmentProvider.fragment, Observer<String>{
            it?.let { str -> fragmentProvider.showToast(str) }
        })
    }

    private fun callAPI(){
        val scb:(ArrayList<PostData>)->Unit = {
            Log.i(TAG, "size:: ${it.size}")
            adapter.list = it
            progressObservable.set(false)
            resultTextData.value = "Finished"
        }

        val noDataCb:()->Unit = {
            progressObservable.set(false)
            Log.i(TAG, "No Data!!")
        }

        val serverFailure:()->Unit = {
            progressObservable.set(false)
            Log.i(TAG, "No Server!!")
        }

        JetPackNetworkApi.api.getFakeData("todos")
                .enqueue(RetrofitCallback<ArrayList<PostData>>(scb, noDataCb, serverFailure))
    }

    fun loadingAgainBtn(v: View){
        Log.w(TAG, "testBtnClick!")
        progressObservable.set(true)
        callAPI()
    }

    companion object {
        private val TAG = MainViewModel::class.java.simpleName
    }
}