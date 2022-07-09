package com.menadev.worldcup1.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcelable
import android.widget.Toast
import com.menadev.worldcup1.data.DataManger
import com.menadev.worldcup1.data.domain.Match
import com.menadev.worldcup1.databinding.ActivityMainBinding
import com.menadev.worldcup1.util.Constants
import com.menadev.worldcup1.util.CsvParser
import java.io.BufferedReader
import java.io.InputStreamReader

class MainActivity : AppCompatActivity(),MatchInteractionListener {
    lateinit var binding: ActivityMainBinding
    private val LOG_TAG = "MAIN_ACTIVITY"
    lateinit var adapter: MatchAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setup()
        addCallbacks()

    }

    private fun setup(){
        parseFile()
        adapter = MatchAdapter(DataManger.matches,this)
            binding.recyclerMatch.adapter = adapter



    }

    private fun addCallbacks(){
        binding.apply {
            fabAdd.setOnClickListener {
                addFinalMatch()
            }
            SpinnerImg.setOnClickListener {
                Intent(this@MainActivity,SpinnerActivity::class.java).also {
                    startActivity(it)
                }
            }

        }


    }
    private fun addFinalMatch(){
        val finalMatch = Match(
            HomeTeamName = "Egypt",
            awayTeamName = "Asia",
            year = "2022",
            homeTeamGoals = "4",
            awayTeamGoals = "4",
            city = "Egypt",
            stadium = "ElSalam Stadium"

        )
        DataManger.addMatchAtIndex(finalMatch,1)
        adapter.setData(DataManger.matches)

    }

    private fun parseFile(){
        val inputStream =assets.open("worldcup.csv")
        val buffer = BufferedReader(InputStreamReader(inputStream))
        val parser= CsvParser()
        buffer.forEachLine {
            val currentMatch = parser.parse(it)
            DataManger.addMatch(currentMatch)

        }
        bindMatch(DataManger.getCurrentMatch())

    }
    private fun bindMatch(match: Match){
        binding.apply {



        }
    }

    override fun onClickItem(match: Match) {

    }

    override fun onClickTeamName(name: String) {
        Toast.makeText(this, name, Toast.LENGTH_SHORT).show()
    }

    override fun deleteItem(index: Int) {
        DataManger.deleteMatchAt(index)
        adapter.setData(DataManger.matches)
    }



}










