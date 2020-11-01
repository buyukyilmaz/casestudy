package com.buyukyilmaz.dazncasestudy.ui.news.newslist

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.buyukyilmaz.dazncasestudy.R
import com.buyukyilmaz.dazncasestudy.databinding.ItemNewsBinding
import com.buyukyilmaz.dazncasestudy.entity.News
import java.text.SimpleDateFormat
import java.util.*

class NewsRecyclerAdapter(private val items: List<News>) : RecyclerView.Adapter<NewsRecyclerAdapter.ViewHolder>() {

    private lateinit var context: Context
    private var itemClickListener: ((News) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        context = parent.context
        val view = LayoutInflater.from(context).inflate(R.layout.item_news, parent, false)
        val binding = ItemNewsBinding.bind(view)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position])
        holder.itemView.setOnClickListener {
            itemClickListener?.invoke(items[position])
        }
    }

    override fun getItemCount() = items.size

    fun setItemClickListener(itemClickListener: (News) -> Unit) {
        this.itemClickListener = itemClickListener
    }

    inner class ViewHolder(private val binding: ItemNewsBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: News) {
            Glide.with(context).load(item.picUrl).into(binding.img)
            binding.tvTitle.text = item.title
            binding.tvDate.text = formatDate(item.date)
        }

        private fun formatDate(date: String): String {
            val parsedDateObj = SimpleDateFormat("dd.MM.yyyy HH:mm", Locale.US).parse(date)
            return SimpleDateFormat("dd MMM yyyy, HH:mm", Locale.US).format(parsedDateObj)
        }
    }
}