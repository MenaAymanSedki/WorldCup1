package com.menadev.worldcup1.data

import com.menadev.worldcup1.data.domain.Match

object DataManger {
    private val matchesList = mutableListOf<Match>()
    val matches:List<Match>
    get()= matchesList.toList()
    private var matchIndex =0



    fun addMatch(match: Match){
        matchesList.add(match)
    }
    fun deleteMatchAt(index:Int){
        matchesList.removeAt(index)
    }
    fun addMatchAtIndex(match: Match, index: Int){
        matchesList.add(index,match)
    }


    fun getCurrentMatch():Match = matchesList[matchIndex]

    fun getNextMatch():Match{
        matchIndex++
        return matchesList[matchIndex]
    }

    fun getPreviousMatch():Match{
        matchIndex--
        return matchesList[matchIndex]
    }
}