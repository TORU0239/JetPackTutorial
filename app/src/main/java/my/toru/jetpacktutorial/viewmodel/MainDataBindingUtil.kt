package my.toru.jetpacktutorial.viewmodel

import android.databinding.BindingAdapter
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.RecyclerView
import android.view.View
import my.toru.jetpacktutorial.ui.main.MainAdapter

@BindingAdapter("android:visibility")
fun setVisibility(v: View, visible:Boolean){
    v.visibility = if(visible){
        View.VISIBLE
    }
    else{
        View.GONE
    }
}

@BindingAdapter("mainAdapter")
fun setMainAdapter(rcv: RecyclerView, adapter:MainAdapter){
    rcv.adapter = adapter
    adapter.notifyDataSetChanged()
    rcv.addItemDecoration(DividerItemDecoration(rcv.context, DividerItemDecoration.VERTICAL))
}