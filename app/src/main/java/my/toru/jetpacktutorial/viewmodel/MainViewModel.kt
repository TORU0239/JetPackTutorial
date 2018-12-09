package my.toru.jetpacktutorial.viewmodel

import android.arch.lifecycle.ViewModel
import android.databinding.ObservableField
import android.util.Log
import android.view.View
import my.toru.jetpacktutorial.model.data.PostData
import my.toru.jetpacktutorial.model.remote.JetPackNetworkApi
import my.toru.jetpacktutorial.model.remote.RetrofitCallback
import my.toru.jetpacktutorial.ui.main.MainAdapter

class MainViewModel : ViewModel() {
    val progressObservable: ObservableField<Boolean> = ObservableField(true)
    val adapter:MainAdapter = MainAdapter()
    lateinit var ctxProvider: ContextProvider

    init {
        callAPI()
    }

    private fun callAPI(){
        val scb:(ArrayList<PostData>)->Unit = {
            Log.i(TAG, "size:: ${it.size}")
            adapter.list = it
            adapter.notifyDataSetChanged()
            progressObservable.set(false)
            ctxProvider.showToast("Finished!")
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

    fun testBtnClick(v: View){
        Log.w(TAG, "testBtnClick!")
        progressObservable.set(true)
        callAPI()
    }

    companion object {
        private val TAG = MainViewModel::class.java.simpleName
    }
}