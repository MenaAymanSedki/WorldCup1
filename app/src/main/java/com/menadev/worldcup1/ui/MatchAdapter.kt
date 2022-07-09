package com.menadev.worldcup1.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.menadev.worldcup1.R
import com.menadev.worldcup1.data.domain.Match
import com.menadev.worldcup1.databinding.ItemMatchBinding
import com.menadev.worldcup1.databinding.ItemMatchesHeaderBinding

class MatchAdapter(private var list: List<Match>,private val listenr: MatchInteractionListener):RecyclerView.Adapter<MatchAdapter.MatchViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MatchViewHolder {
        val view= LayoutInflater.from(parent.context).inflate(R.layout.item_match,parent,false)
        return MatchViewHolder(view)
    }


    override fun onBindViewHolder(holder: MatchViewHolder, position: Int) {
        val currentMatch = list[position]
        holder.binding.apply {
            textTeam1.text = currentMatch.HomeTeamName
            textTeam2.text = currentMatch.awayTeamName
            ScoreTeam1.text = currentMatch.homeTeamGoals.toString()
            ScoreTeam2.text = currentMatch.awayTeamGoals.toString()
            textYear.text = currentMatch.year.toString()
            textTeam1.setOnClickListener {
                listenr.onClickTeamName(currentMatch.HomeTeamName)
            }
            textTeam2.setOnClickListener {
                listenr.onClickTeamName(currentMatch.awayTeamName)
            }
            iconDelete.setOnClickListener {
                listenr.deleteItem(position)

            }

            root.setOnClickListener {
                listenr.onClickItem(currentMatch)
            }





            if (currentMatch.homeTeamGoals> currentMatch.awayTeamGoals){
                ScoreTeam1.setTextColor(ContextCompat.getColor(holder.binding.root.context,R.color.green))
                ScoreTeam2.setTextColor(ContextCompat.getColor(holder.binding.root.context,R.color.purple_700))
            }else if (currentMatch.homeTeamGoals < currentMatch.awayTeamGoals){
                ScoreTeam1.setTextColor(ContextCompat.getColor(holder.binding.root.context,R.color.green))
                ScoreTeam2.setTextColor(ContextCompat.getColor(holder.binding.root.context,R.color.purple_700))

            }else{
                ScoreTeam2.setTextColor(ContextCompat.getColor(holder.binding.root.context,R.color.purple_700))
                ScoreTeam1.setTextColor(ContextCompat.getColor(holder.binding.root.context,R.color.purple_700))



            }
        }
    }

    override fun getItemCount() = list.size

    abstract class BaseViewHolder(viewItem: View):RecyclerView.ViewHolder(viewItem)

    class MatchViewHolder(viewItem: View):BaseViewHolder(viewItem) {
        val binding = ItemMatchBinding.bind(viewItem)
    }
    class HeaderViewHolder(viewItem: View):BaseViewHolder(viewItem) {
        val binding = ItemMatchesHeaderBinding.bind(viewItem)
    }


    fun setData(newList: List<Match>){
        val diffResult = DiffUtil.calculateDiff(MatchDiffUtil(list,newList))
        list = newList
        diffResult.dispatchUpdatesTo(this)

    }
}

