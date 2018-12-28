package my.toru.jetpacktutorial.viewmodel.workmanager

import android.content.Context
import android.util.Log
import androidx.work.Worker
import androidx.work.WorkerParameters

class BackgroundWorker(ctx: Context,
                       workerParams:WorkerParameters) : Worker(ctx, workerParams) {

    override fun doWork(): Result {
        // TODO: define what you want to do
        Log.w(TAG, "doWork::")
        return Result.success()
    }

    companion object {
        private val TAG = BackgroundWorker::class.java.simpleName
    }
}