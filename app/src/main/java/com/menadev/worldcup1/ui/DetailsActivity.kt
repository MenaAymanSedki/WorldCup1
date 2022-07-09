package com.menadev.worldcup1.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.menadev.worldcup1.R
import com.menadev.worldcup1.data.domain.Match
import com.menadev.worldcup1.databinding.ActivityDetailsBinding
import com.menadev.worldcup1.util.Constants

class DetailsActivity : AppCompatActivity() {
    lateinit var binding: ActivityDetailsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setup()

    }
    private fun setup(){
        val match: Match?=intent.getSerializableExtra(Constants.Key.MATCH) as Match?
        match?.let { bindMatch(it) }

    }

    private fun bindMatch(match: Match){
        binding.apply {
            textTeam1.text= match.HomeTeamName
            textTeam2.text = match.awayTeamName
            ScoreTeam1.text = match.homeTeamGoals.toString()
            ScoreTeam2.text = match.awayTeamGoals.toString()
            textYear.text = match.year.toString()
        }
    }


}