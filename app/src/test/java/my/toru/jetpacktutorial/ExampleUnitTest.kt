package my.toru.jetpacktutorial

import my.toru.jetpacktutorial.model.data.PostData
import my.toru.jetpacktutorial.model.remote.JetPackNetworkApi
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }

    private lateinit var url:String
    @Before
    fun initializeRetrofit(){
        url = "todos/1"
    }

    @Test
    fun testRetrofit(){
        JetPackNetworkApi.api.getFakeData(url).enqueue(object: Callback<ArrayList<PostData>>{
            override fun onResponse(call: Call<ArrayList<PostData>>, response: Response<ArrayList<PostData>>) {
                assertEquals(true, response.isSuccessful)
                assertEquals(true, response.code() == 200)
                assertEquals(true, response.body()?.size?.let {
                    it >= 0
                })
            }

            override fun onFailure(call: Call<ArrayList<PostData>>, t: Throwable) {
                t.printStackTrace()
            }
        })
    }
}
