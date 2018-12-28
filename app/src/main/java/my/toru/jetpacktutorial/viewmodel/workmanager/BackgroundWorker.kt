package my.toru.jetpacktutorial.viewmodel.workmanager

import android.content.Context
import androidx.work.Worker
import androidx.work.WorkerParameters

class BackgroundWorker(ctx: Context,
                       workerParams:WorkerParameters) : Worker(ctx, workerParams) {

    override fun doWork(): Result {
        // TODO: define what you want to do
        return Result.success()
    }
}