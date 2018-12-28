package my.toru.jetpacktutorial.viewmodel.workmanager

import android.arch.lifecycle.ViewModel
import android.view.View
import androidx.work.OneTimeWorkRequest
import androidx.work.WorkManager

class WorkManagerViewModel:ViewModel() {

    private val workManager:WorkManager = WorkManager.getInstance()

    fun onWorkManager(v: View){
        doWork()
    }


    private fun doWork(){
        workManager.enqueue(OneTimeWorkRequest.from(BackgroundWorker::class.java))
    }

    override fun onCleared() {
        workManager.cancelAllWork()
        super.onCleared()
    }
}