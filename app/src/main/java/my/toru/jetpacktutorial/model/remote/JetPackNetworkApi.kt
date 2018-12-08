package my.toru.jetpacktutorial.model.remote

import my.toru.jetpacktutorial.model.data.PostData
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.QueryMap
import retrofit2.http.Url
import java.util.concurrent.TimeUnit

interface JetPackNetworkApi {
    @GET
    fun getData(@QueryMap query:HashMap<String, String>): Call<PostData>

    @GET
    fun getFakeData(@Url url:String): Call<PostData>

    companion object {
        private const val URL = "https://jsonplaceholder.typicode.com/"
        val api:JetPackNetworkApi = Retrofit.Builder()
                .baseUrl(URL)
                .client(OkHttp3Initializer.okHttp3())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(JetPackNetworkApi::class.java)
    }
}

object OkHttp3Initializer{
    private fun initInterceptor():HttpLoggingInterceptor
            = HttpLoggingInterceptor()
            .setLevel(HttpLoggingInterceptor.Level.BODY)

    fun okHttp3():OkHttpClient = OkHttpClient.Builder()
            .addNetworkInterceptor(initInterceptor())
            .readTimeout(3000, TimeUnit.MICROSECONDS)
            .writeTimeout(3000, TimeUnit.MICROSECONDS)
            .build()
}


