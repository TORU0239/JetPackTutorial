package my.toru.jetpacktutorial.viewmodel.workmanager

import android.arch.lifecycle.ViewModel
import androidx.work.OneTimeWorkRequest
import androidx.work.WorkManager

class WorkManagerViewModel:ViewModel() {

    private val workManager:WorkManager = WorkManager.getInstance()


    fun doWork(){
        workManager.enqueue(OneTimeWorkRequest.from(BackgroundWorker::class.java))
    }

    override fun onCleared() {
        super.onCleared()
    }
}