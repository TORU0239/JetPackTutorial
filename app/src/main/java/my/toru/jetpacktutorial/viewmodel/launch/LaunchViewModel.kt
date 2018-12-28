package my.toru.jetpacktutorial.viewmodel.launch

import android.content.Intent
import android.view.View
import my.toru.jetpacktutorial.ui.main.MainActivity
import my.toru.jetpacktutorial.ui.workmanager.WorkManagerActivity
import my.toru.jetpacktutorial.viewmodel.common.ContextProvider

class LaunchViewModel(private val contextProvider: ContextProvider) {


    fun onGoToDataBinding(v: View){
        contextProvider.startActivity(Intent(contextProvider.ctx, MainActivity::class.java))
    }

    fun onGoToRoom(v:View){
        contextProvider.showToast("UNDER IMPLEMENTATION")
    }

    fun onGoToPaging(v:View){
        contextProvider.showToast("UNDER IMPLEMENTATION")
    }

    fun onGoToWorkManager(v:View){
        contextProvider.startActivity(Intent(contextProvider.ctx, WorkManagerActivity::class.java))
    }
}