package com.example.texttospeech

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Build
import android.speech.tts.TextToSpeech
import android.util.Log
import android.widget.EditText
import androidx.annotation.RequiresApi
import com.google.android.material.button.MaterialButton
import java.util.*

class MainActivity : AppCompatActivity(), TextToSpeech.OnInitListener {
    private var texttospeech: TextToSpeech?=null
    private lateinit var texttospeechbutton: MaterialButton
    private lateinit var textinput: EditText

    @SuppressLint("NewApi")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        texttospeechbutton=findViewById(R.id.convertbutton)
        textinput=findViewById(R.id.textinput)
        texttospeechbutton!!.isEnabled=false
        texttospeech= TextToSpeech(this,this)
        texttospeechbutton!!.setOnClickListener{ convertToSpeech() }

    }

    override fun onInit(status: Int) {
       if(status == TextToSpeech.SUCCESS){
           val result=texttospeech!!.setLanguage(Locale.US)
           if(result==TextToSpeech.LANG_MISSING_DATA || result == TextToSpeech.LANG_NOT_SUPPORTED){
               Log.e("TTS","Language Specified NOT SUPPORTED")
           }
           else{
               texttospeechbutton!!.isEnabled =true
           }
       }
        else{
            Log.e("TTS","initialization Failed")
       }
    }
    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    private fun convertToSpeech(){
        val text=textinput!!.text.toString()
        texttospeech!!.speak(text, TextToSpeech.QUEUE_FLUSH,null,"")

    }

    public override fun onDestroy() {
        if(texttospeech!=null){
            texttospeech!!.stop()
            texttospeech!!.shutdown()
        }
        super.onDestroy()
    }

}