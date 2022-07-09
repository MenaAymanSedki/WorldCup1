package com.menadev.worldcup1.ui

import com.menadev.worldcup1.data.domain.Match

interface MatchInteractionListener {
    fun onClickItem(match: Match)
    fun onClickTeamName(name: String)
    fun deleteItem(index:Int)



}