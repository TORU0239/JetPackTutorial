package my.toru.jetpacktutorial.ui.launch

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import my.toru.jetpacktutorial.R
import my.toru.jetpacktutorial.databinding.ActivityLaunchBinding
import my.toru.jetpacktutorial.viewmodel.common.ContextProvider
import my.toru.jetpacktutorial.viewmodel.launch.LaunchViewModel

class LaunchActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val databinding:ActivityLaunchBinding = DataBindingUtil.setContentView(this@LaunchActivity, R.layout.activity_launch)
        databinding.launchVM = LaunchViewModel(ContextProvider(this@LaunchActivity))
    }
}