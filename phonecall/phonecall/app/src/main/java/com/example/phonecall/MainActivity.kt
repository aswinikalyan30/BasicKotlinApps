package com.example.phonecall

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.text.Editable
import android.text.TextUtils
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private lateinit var Edi: TextView
    private lateinit var clear: Button
    private lateinit var call: Button
    private lateinit var save: Button
    private lateinit var n0: Button
    private lateinit var n1: Button
    private lateinit var n2: Button
    private lateinit var n3: Button
    private lateinit var n4: Button
    private lateinit var n5: Button
    private lateinit var n6: Button
    private lateinit var n7: Button
    private lateinit var n8: Button
    private lateinit var n9: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Edi=findViewById(R.id.call_text)
        call=findViewById(R.id.call)
        save=findViewById(R.id.save)
        clear=findViewById(R.id.AC)
        n0=findViewById(R.id.Zero)
        n1=findViewById(R.id.One)
        n2=findViewById(R.id.Two)
        n3=findViewById(R.id.Three)
        n4=findViewById(R.id.Four)
        n5=findViewById(R.id.Five)
        n6=findViewById(R.id.Six)
        n7=findViewById(R.id.Seven)
        n8=findViewById(R.id.Eight)
        n9=findViewById(R.id.Nine)
        n0.setOnClickListener {
            Edi.text = TextUtils.concat(Edi.text, "0")
        }
        n1.setOnClickListener{
            Edi.text= TextUtils.concat(Edi.text, "1")
        }
        n2.setOnClickListener{ Edi.text= TextUtils.concat(Edi.text, "2")
        }
        n3.setOnClickListener{
            Edi.text= TextUtils.concat(Edi.text, "3")
        }
        n4.setOnClickListener{
            Edi.text= TextUtils.concat(Edi.text, "4")
        }
        n5.setOnClickListener{
            Edi.text= TextUtils.concat(Edi.text, "5")
        }
        n6.setOnClickListener{
            Edi.text= TextUtils.concat(Edi.text, "6")
        }
        n7.setOnClickListener{
            Edi.text= TextUtils.concat(Edi.text, "7")
        }
        n8.setOnClickListener{
            Edi.text= TextUtils.concat(Edi.text, "8")
        }
        n9.setOnClickListener{
            Edi.text= TextUtils.concat(Edi.text, "9")
        }
        clear.setOnClickListener{
            Edi.text=("")
        }
        call.setOnClickListener{
            val intent =Intent(Intent.ACTION_DIAL,Uri.parse("tel:"+ "${Edi.text}"))
            startActivity(intent)
        }
        save.setOnClickListener{
            val intent=Intent(ContactsContract.Intents.SHOW_OR_CREATE_CONTACT, Uri.parse("tel:"+ "${Edi.text}"))
            intent.putExtra(ContactsContract.Intents.EXTRA_FORCE_CREATE,true)
            startActivity(intent)
        }
    }
}