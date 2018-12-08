package my.toru.jetpacktutorial.viewmodel

import android.databinding.BindingAdapter
import android.view.View

@BindingAdapter("android:visibility")
fun setVisibility(v: View, visible:Boolean){
    v.visibility = if(visible){
        View.VISIBLE
    }
    else{
        View.GONE
    }
}