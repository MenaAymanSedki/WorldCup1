package com.menadev.worldcup1.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import com.menadev.worldcup1.R
import com.menadev.worldcup1.databinding.ActivitySpinnerBinding

class SpinnerActivity : AppCompatActivity() {
    lateinit var binding: ActivitySpinnerBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySpinnerBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initSpinner()
    }

    private fun initSpinner() {
        val items = listOf("Egypt","Russia","USA","England","Estonia","Lebanon","Mena")
        val mAdapter = ArrayAdapter(this,R.layout.spinner_itme,items)
        binding.Spinner.apply {
            adapter = mAdapter
            onItemSelectedListener = object :AdapterView.OnItemSelectedListener,
                AdapterView.OnItemClickListener {
                override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                    Toast.makeText(this@SpinnerActivity, items[p2], Toast.LENGTH_SHORT).show()
                }

                override fun onNothingSelected(p0: AdapterView<*>?) {

                }

                override fun onItemClick(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {

                }

            }
        }
    }
}