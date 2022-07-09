package com.menadev.worldcup1.util


import com.menadev.worldcup1.data.domain.Match
class CsvParser {
    fun parse(line:String): Match {
        val tokens = line.split(",")
        return Match(
            year = tokens[Constants.ColumnIndex.YEAR],
            stadium = tokens[Constants.ColumnIndex.STADIUM],
            city = tokens[Constants.ColumnIndex.CITY],
            HomeTeamName = tokens[Constants.ColumnIndex.HOME_TEAM_NAME],
            awayTeamName = tokens[Constants.ColumnIndex.AWAY_TEAM_NAME],
            homeTeamGoals= tokens[Constants.ColumnIndex.HOME_TEAM_GOALS],
            awayTeamGoals = tokens[Constants.ColumnIndex.AWAY_TEAM_GOALS],
            )
    }
}