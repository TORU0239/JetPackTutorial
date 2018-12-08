package my.toru.jetpacktutorial.model.remote

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.http.GET
import retrofit2.http.QueryMap

interface JetPackNetworkApi {
    @GET
    fun getData(@QueryMap query:HashMap<String, String>): Call<String>

    companion object {
        val api:JetPackNetworkApi = Retrofit.Builder()
                .baseUrl("")
                .addConverterFactory(Gson)
                .build()
                .create(JetPackNetworkApi::class.java)
    }
}

