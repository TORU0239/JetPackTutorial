package my.toru.jetpacktutorial.ui.main

import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import my.toru.jetpacktutorial.R
import my.toru.jetpacktutorial.databinding.MainAdapterBinding
import my.toru.jetpacktutorial.model.data.PostData

class MainAdapter(var callback:()->Unit): RecyclerView.Adapter<MainViewHolder>() {

    var list:ArrayList<PostData> = ArrayList()

    override fun onCreateViewHolder(container: ViewGroup, viewType: Int): MainViewHolder
            = MainViewHolder(DataBindingUtil.inflate(LayoutInflater.from(container.context),
                                R.layout.main_adapter,container, false))

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(viewHolder: MainViewHolder, position: Int) {
        viewHolder.bindingItem(list[position])
        viewHolder.itemView.setOnClickListener {
            callback()
        }
    }
}

class MainViewHolder(private val binding: MainAdapterBinding):RecyclerView.ViewHolder(binding.root){
    fun bindingItem(data:PostData){
        binding.postData = data
        binding.executePendingBindings()
    }
}