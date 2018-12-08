package my.toru.jetpacktutorial.model.remote

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.QueryMap

interface JetPackNetworkApi {
    @GET
    fun getData(@QueryMap query:HashMap<String, String>): Call<String>

    companion object {
        val api:JetPackNetworkApi = Retrofit.Builder()
                .baseUrl("")
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


