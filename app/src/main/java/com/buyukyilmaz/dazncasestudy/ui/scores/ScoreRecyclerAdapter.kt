package com.buyukyilmaz.dazncasestudy.ui.scores

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.buyukyilmaz.dazncasestudy.R
import com.buyukyilmaz.dazncasestudy.databinding.ItemScoreBinding
import com.buyukyilmaz.dazncasestudy.entity.Match

class ScoreRecyclerAdapter(private val items: List<Match>) : RecyclerView.Adapter<ScoreRecyclerAdapter.ViewHolder>() {

    private lateinit var context: Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        context = parent.context
        val view = LayoutInflater.from(context).inflate(R.layout.item_score, parent, false)
        val binding = ItemScoreBinding.bind(view)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount() = items.size

    inner class ViewHolder(private val binding: ItemScoreBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: Match) {

            if (adapterPosition.rem(2) == 0) {
                binding.root.setBackgroundColor(ContextCompat.getColor(context, R.color.white))
            } else {
                binding.root.setBackgroundColor(ContextCompat.getColor(context, R.color.lightGrey))
            }

            binding.tvTeamAScore.text = item.fts_A.toString()
            binding.tvTeamBScore.text = item.fts_B.toString()
            binding.tvTeamAName.text = item.team_A.display_name
            binding.tvTeamBName.text = item.team_B.display_name
        }
    }
}