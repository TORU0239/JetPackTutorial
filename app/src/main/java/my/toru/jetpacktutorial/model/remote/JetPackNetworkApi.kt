package my.toru.jetpacktutorial.model.remote

import my.toru.jetpacktutorial.model.data.PostData
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.QueryMap
import retrofit2.http.Url

interface JetPackNetworkApi {
    @GET
    fun getData(@QueryMap query:HashMap<String, String>): Call<ArrayList<PostData>>

    @GET
    fun getFakeData(@Url url:String): Call<ArrayList<PostData>>

    companion object {
        private const val URL = "https://jsonplaceholder.typicode.com/"
        val api:JetPackNetworkApi = Retrofit.Builder()
                .baseUrl(URL)
                .client(OkHttp3Initializer.okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(JetPackNetworkApi::class.java)
    }
}

object OkHttp3Initializer{
     val okHttpClient:OkHttpClient

    init {
        okHttpClient = OkHttpClient().newBuilder()
                .addNetworkInterceptor(initInterceptor())
                .build()
    }

    private fun initInterceptor():HttpLoggingInterceptor
            = HttpLoggingInterceptor()
            .setLevel(HttpLoggingInterceptor.Level.BODY)
}