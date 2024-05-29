package com.example.lab_8

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.lab_8.databinding.RecycleViewBinding


class CatAdapter (private val items: List<Pair<String, String?>>,
                  private val onItemClick: (position: Int) -> Unit):
    RecyclerView.Adapter<CatAdapter.CatHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CatHolder {
        val binding = RecycleViewBinding.inflate(LayoutInflater.from(parent.context))
        return CatHolder(binding, onItemClick)
    }

    override fun onBindViewHolder(holder: CatHolder, position: Int) {
        val cat = items[position]
        holder.bind(cat.first, cat.second)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    class CatHolder(private val binding: RecycleViewBinding,
                    private val onItemClick: (position: Int) -> Unit) :
        RecyclerView.ViewHolder(binding.root) {
        init {
            binding.catButton.setOnClickListener {
                onItemClick(adapterPosition)
            }
        }

        fun bind(catBreed: String, imageUrl: String?) {
            Glide.with(binding.imageView)
                .load(imageUrl)
                .centerCrop()
                .placeholder(binding.imageView.drawable)
                .error(R.drawable.ic_launcher_background)
                .fallback(R.drawable.ic_launcher_foreground)
                .into(binding.imageView)
            binding.catButton.text = catBreed
        }
    }
}