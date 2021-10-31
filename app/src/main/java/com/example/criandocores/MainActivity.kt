package com.example.criandocores

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.SeekBar
import android.widget.TextView
import java.lang.Integer.toHexString
import java.util.*

class MainActivity : AppCompatActivity() {

    private lateinit var view: View
    private lateinit var tvNomeDaCor: TextView
    private lateinit var seekBarTOP: SeekBar
    private lateinit var seekBarMid: SeekBar
    private lateinit var seekBarBot: SeekBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        this.view = findViewById(R.id.view)
        this.tvNomeDaCor = findViewById(R.id.textView)
        this.seekBarTOP = findViewById(R.id.seekBarTOP)
        this.seekBarMid = findViewById(R.id.seekBarMid)
        this.seekBarBot = findViewById(R.id.seekBarBot)

        this.seekBarTOP.setOnSeekBarChangeListener(OnChange())
        this.seekBarMid.setOnSeekBarChangeListener(OnChange())
        this.seekBarBot.setOnSeekBarChangeListener(OnChange())
    }

    inner class OnChange:SeekBar.OnSeekBarChangeListener {
        private lateinit var view: View
        private  lateinit var tvNomeDaCor: TextView
        private lateinit var seekBarTOP: SeekBar
        private lateinit var seekBarMid: SeekBar
        private lateinit var seekBarBot: SeekBar


        override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
            this.view = findViewById(R.id.view)
            this.seekBarTOP = findViewById(R.id.seekBarTOP)
            this.seekBarMid = findViewById(R.id.seekBarMid)
            this.seekBarBot = findViewById(R.id.seekBarBot)
            this.tvNomeDaCor = findViewById(R.id.textView)

            this.view.setBackgroundColor(Color.rgb(this.seekBarTOP.progress, seekBarMid.progress, seekBarBot.progress))
//            this.tvNomeDaCor.setText("rgb(" + this.seekBarTOP.progress.toString() + ", " + this.seekBarMid.progress.toString() + ", " +  this.seekBarBot.progress.toString() + ")")
            this.tvNomeDaCor.setText("#" + toHexString(Color.rgb(this.seekBarTOP.progress, seekBarMid.progress, seekBarBot.progress)).toString().uppercase().substring(2))

        }
        override fun onStartTrackingTouch(seekBar: SeekBar?) {}
        override fun onStopTrackingTouch(seekBar: SeekBar?) {}
    }
}