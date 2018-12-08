package my.toru.jetpacktutorial.viewmodel

import android.arch.lifecycle.ViewModel
import android.databinding.ObservableField
import android.util.Log
import android.view.View
import my.toru.jetpacktutorial.model.data.PostData
import my.toru.jetpacktutorial.model.remote.JetPackNetworkApi
import my.toru.jetpacktutorial.model.remote.RetrofitCallback
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModel : ViewModel() {
    val progressObservable: ObservableField<Boolean> = ObservableField(true)

    init {
        callAPI()
    }

    private fun callAPI(){
//        JetPackNetworkApi.api.getFakeData("todos").enqueue(object: Callback<ArrayList<PostData>> {
//            override fun onResponse(call: Call<ArrayList<PostData>>, response: Response<ArrayList<PostData>>) {
//                progressObservable.set(false)
//                Log.i(TAG, "finished!!")
//            }
//            override fun onFailure(call: Call<ArrayList<PostData>>, t: Throwable) {
//                progressObservable.set(false)
//                t.printStackTrace()
//            }
//        })
        val scb:(ArrayList<PostData>)->Unit = {
            Log.i(TAG, "size:: ${it.size}")
        }

        val noDataCb:()->Unit = {
            Log.i(TAG, "No Data!!")
        }

        val serverFailure:()->Unit = {
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