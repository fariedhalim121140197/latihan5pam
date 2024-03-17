package com.example.latihan5pam121140197

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.latihan5pam121140197.databinding.AdapterMainBinding

class MainAdapter(private val results : List<MainModel>) : RecyclerView.Adapter<MainAdapter.ViewHolder>() {
    val binding = AdapterMainBinding
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = AdapterMainBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount() = results.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(holder){
            with(results[position]) {
                binding.topLearnerName.text = name
                val hours = "$hours learning hours, $country"
                binding.topLearnerTime.text = hours
                GlideApp.with(holder.itemView.context)
                    .load(badgeUrl)
                    .into(binding.topLearnerImage)

                holder.itemView.setOnClickListener {
                    Toast.makeText(holder.itemView.context, hours,
                        Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    /*{
        binding = AdapterMainBinding.bind(View)
        holder.bindingAdapter.binding.text = results[position].title
    }*/

    class ViewHolder(val view: AdapterMainBinding) : RecyclerView.ViewHolder(view)
}