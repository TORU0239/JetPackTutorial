package my.toru.jetpacktutorial.viewmodel

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.support.v4.app.Fragment
import android.widget.Toast
import my.toru.jetpacktutorial.R
import my.toru.jetpacktutorial.ui.detail.DetailFragment

class ContextProvider(private val ctx: Context) {
    fun startActivity(intent: Intent){
        ctx.startActivity(intent)
    }

    fun showToast(res:String){
        Toast.makeText(ctx, res, Toast.LENGTH_SHORT).show()
    }

    fun startActivityResult(intent:Intent, requestCode:Int){
        if(ctx is Activity){
            ctx.startActivityForResult(intent, requestCode)
        }
    }

    fun moveToDetail(){
        val detail = DetailFragment.newInstance()
    }
}

class FragmentProvider(private val fragment:Fragment){
    fun startActivity(intent: Intent){
        fragment.startActivity(intent)
    }

    fun showToast(res:String){
        Toast.makeText(fragment.context, res, Toast.LENGTH_SHORT).show()
    }

    fun startActivityResult(intent:Intent, requestCode:Int){
        fragment.startActivityForResult(intent, requestCode)
    }

    fun moveToDetail(){
        val detail = DetailFragment.newInstance()
        fragment.fragmentManager?.
                beginTransaction()?.
                replace(R.id.container, detail)?.
                addToBackStack("Detail")?.
                commitAllowingStateLoss()
    }
}