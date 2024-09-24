package com.example.tipcalculator

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.tipcalculator.databinding.ActivityMainBinding
import java.text.NumberFormat
import kotlin.math.ceil

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.bot.setOnClickListener { calculatethetip() }


    }

    @SuppressLint("StringFormatInvalid")
    private fun calculatethetip() {
        val cost = binding.TipTime.text.toString().toDouble()
        val chosenid = binding.tip.checkedRadioButtonId
        val tiper = when(chosenid) {
            R.id.twenty_percent -> 0.2
            R. id.eighteen_percent -> 0.18
            else -> 0.15
        }
        var tip = cost*tiper
        val roundup = binding.rtip.isChecked
        if (roundup) {
            tip = ceil(tip)
        }
        val curtip = NumberFormat.getCurrencyInstance().format(tip)
        binding.result.text = getString(R.string.Amount,curtip)
    }
}