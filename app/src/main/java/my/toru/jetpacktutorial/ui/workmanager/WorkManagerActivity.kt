package my.toru.jetpacktutorial.ui.workmanager

import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import my.toru.jetpacktutorial.R
import my.toru.jetpacktutorial.databinding.ActivityWorkManagerBinding
import my.toru.jetpacktutorial.viewmodel.workmanager.WorkManagerViewModel

class WorkManagerActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val databinding:ActivityWorkManagerBinding = DataBindingUtil.setContentView(this@WorkManagerActivity, R.layout.activity_work_manager)
        databinding.workVM = ViewModelProviders.of(this@WorkManagerActivity).get(WorkManagerViewModel::class.java)
    }
}