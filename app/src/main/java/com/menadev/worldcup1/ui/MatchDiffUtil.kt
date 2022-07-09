package com.menadev.worldcup1.ui

import androidx.recyclerview.widget.DiffUtil
import com.menadev.worldcup1.data.domain.Match

class MatchDiffUtil(val mOldList:List<Match>,val mNewList: List<Match>):DiffUtil.Callback() {

    override fun getOldListSize()= mOldList.size


    override fun getNewListSize()= mNewList.size


    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return (
                mOldList[oldItemPosition].HomeTeamName==mNewList[newItemPosition].HomeTeamName
                        && mOldList[oldItemPosition].awayTeamName==mNewList[newItemPosition].awayTeamName
                )
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
       return true
    }
}