package my.toru.jetpacktutorial.viewmodel

import android.content.Context
import android.content.Intent
import android.widget.Toast

class ContextProvider(val ctx: Context) {
    fun startActivity(intent: Intent){
        ctx.startActivity(intent)
    }

    fun showToast(res:String){
        Toast.makeText(ctx, res, Toast.LENGTH_SHORT).show()
    }
}