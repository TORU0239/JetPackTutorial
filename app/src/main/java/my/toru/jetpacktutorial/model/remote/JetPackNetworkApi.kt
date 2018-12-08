package my.toru.jetpacktutorial.model.remote

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.QueryMap
import retrofit2.http.Url

interface JetPackNetworkApi {
    @GET
    fun getData(@QueryMap query:HashMap<String, String>): Call<String>

    @GET
    fun getFakeData(@Url url:String): Call<String>

    companion object {
        val api:JetPackNetworkApi = Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .client(OkHttp3Initializer.okHttp3())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(JetPackNetworkApi::class.java)
    }
}

object OkHttp3Initializer{
    private fun initInterceptor():HttpLoggingInterceptor
            = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)

    fun okHttp3():OkHttpClient = OkHttpClient.Builder()
            .addNetworkInterceptor(initInterceptor())
            .build()
}


