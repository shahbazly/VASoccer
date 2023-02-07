package dev.shahbazly.vasoccer.ui.main.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import dev.shahbazly.vasoccer.R
import dev.shahbazly.vasoccer.model.Match

class MatchAdapter : ListAdapter<Match, MatchViewHolder>(
    object : DiffUtil.ItemCallback<Match>() {
        override fun areItemsTheSame(oldItem: Match, newItem: Match): Boolean =
            oldItem.matchId == newItem.matchId

        override fun areContentsTheSame(oldItem: Match, newItem: Match): Boolean =
            oldItem == newItem
    }
) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        MatchViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_match, parent, false)
        )

    override fun onBindViewHolder(holder: MatchViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }
}
