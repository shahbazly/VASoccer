package dev.shahbazly.vasoccer.ui.main.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import coil.load
import coil.transform.CircleCropTransformation
import dev.shahbazly.vasoccer.databinding.ItemMatchBinding
import dev.shahbazly.vasoccer.model.Match

class MatchViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    private val binding = ItemMatchBinding.bind(view)

    fun bind(match: Match) {
        with(binding) {
            leagueTitleTextView.text = match.leagueName
            matchDateTextView.text = match.matchStartDate

            homeTeamTitleTextView.text = match.homeTeamName
            homeScoreTextView.text = "${match.homeTeamScore}"
            homeTeamImageView.load(match.homeTeamLogo) {
                crossfade(true)
                transformations(CircleCropTransformation())
            }

            awayTeamTitleTextView.text = match.awayTeamName
            awayScoreTextView.text = "${match.awayTeamScore}"
            awayTeamImageView.load(match.awayTeamLogo) {
                crossfade(true)
                transformations(CircleCropTransformation())
            }
        }
    }
}
