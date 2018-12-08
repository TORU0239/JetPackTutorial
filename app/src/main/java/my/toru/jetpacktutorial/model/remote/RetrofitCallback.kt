package my.toru.jetpacktutorial.model.remote

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RetrofitCallback<T>(private val successCB:(T)->Unit,
                          private val noResponseCB:()->Unit,
                          private val serverFailure:()->Unit): Callback<T> {
    override fun onResponse(call: Call<T>, response: Response<T>) {
        if(response.isSuccessful){
            response.body()?.let(successCB)
        }
        else{
            noResponseCB
        }
    }
    override fun onFailure(call: Call<T>, t: Throwable) {
        t.printStackTrace()
        serverFailure
    }
}