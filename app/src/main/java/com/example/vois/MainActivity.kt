package com.example.vois

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.speech.tts.TextToSpeech
import android.widget.Button
import android.widget.TextView
import java.util.*

class MainActivity : AppCompatActivity(), TextToSpeech.OnInitListener {

    private var tts: TextToSpeech? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tts = TextToSpeech(this,this)

        findViewById<Button>(R.id.button).setOnClickListener{speak()}
    }

    private fun speak(){
        val message: String = findViewById<TextView>(R.id.idtex).text.toString()
        tts!!.speak(message, TextToSpeech.QUEUE_FLUSH, null,"")
    }

    override fun onInit(status: Int) {
        if (status == TextToSpeech.SUCCESS){
            findViewById<TextView>(R.id.texview).text = getString(R.string.tts_active)
            tts!!.language = Locale("ES")
        } else {
            findViewById<TextView>(R.id.texview).text = getString(R.string.tts_noacttive)
        }
    }
}