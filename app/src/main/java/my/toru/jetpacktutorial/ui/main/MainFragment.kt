package my.toru.jetpacktutorial.ui.main

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.work.*
import my.toru.jetpacktutorial.R

class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.main_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        // TODO: Use the ViewModel
        simulatingNetwork { id, data ->
            callbackFunction(id, data)
        }
    }

    fun testCallback(){
        showToast("Test Callback for Worker")
    }

    fun callbackFunction(id:Int, data:String){
        Log.w("TORU", "id:: $id")
        showToast(data)
    }

    // simulating callback and network request
    inline fun simulatingNetwork(callback:(id:Int, data:String)->Unit){
        val data = "Network success!!"
        callback(1, data)
    }

    fun Fragment.showToast(str:String){
        Toast.makeText(this.context, str, Toast.LENGTH_SHORT).show()
    }
}