package my.toru.jetpacktutorial.viewmodel

import android.arch.lifecycle.ViewModel
import my.toru.jetpacktutorial.model.data.PostData
import my.toru.jetpacktutorial.model.remote.JetPackNetworkApi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModel : ViewModel() {
    // TODO: Implement the ViewModel

    fun callAPI(){
        JetPackNetworkApi.api.getFakeData("todos").enqueue(object: Callback<PostData> {
            override fun onResponse(call: Call<PostData>, response: Response<PostData>) {}
            override fun onFailure(call: Call<PostData>, t: Throwable) {
                t.printStackTrace()
            }
        })
    }
}