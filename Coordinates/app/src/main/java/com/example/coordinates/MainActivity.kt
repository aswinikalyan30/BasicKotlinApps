package com.example.coordinates

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import android.widget.TextView
import org.json.JSONObject
import java.io.IOException
import java.nio.charset.Charset
import javax.xml.parsers.DocumentBuilderFactory

class MainActivity : AppCompatActivity() {

    private lateinit var cityValue: TextView
    private lateinit var lat: TextView
    private lateinit var lon: TextView
    private lateinit var temp: TextView
    private lateinit var hum: TextView

    private lateinit var xmlButton: Button
    private lateinit var jsonButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        cityValue=findViewById(R.id.t1)
        lat=findViewById(R.id.t2)
        lon=findViewById(R.id.t3)
        temp=findViewById(R.id.t4)
        hum=findViewById(R.id.t5)

        xmlButton=findViewById(R.id.b1)
        jsonButton=findViewById(R.id.b2)



        jsonButton.setOnClickListener{ jsonParse() }
        xmlButton.setOnClickListener{ xmlParse() }


    }
    private fun jsonParse(){
        val obj=JSONObject(jparse())
        cityValue.text=obj.getString("cityName")
        lat.text=obj.getString("lat")
        lon.text=obj.getString("lon")
        temp.text=obj.getString("temp")
        hum.text=obj.getString("hum")


    }
    private fun jparse(): String {
        val json: String?

        try{

            val input=assets.open("myjson.json")
            val size = input.available()
            val buffer=ByteArray(size)
            input.read(buffer)
            input.close()
            val charset:Charset=Charsets.UTF_8
            json=String(buffer,charset)

        }catch(ex: IOException){
            return ""
        }

        return json
    }

    private fun xmlParse(){
        val input=assets.open("myxml.xml")
        var dbf=DocumentBuilderFactory.newInstance()
        val docbuild=dbf.newDocumentBuilder()
        val doc=docbuild.parse(input)
        cityValue.text=doc.getElementsByTagName("cityName").item(0).firstChild.nodeValue
        lat.text=doc.getElementsByTagName("lat").item(0).firstChild.nodeValue
        lon.text=doc.getElementsByTagName("lon").item(0).firstChild.nodeValue
        temp.text=doc.getElementsByTagName("temp").item(0).firstChild.nodeValue
        hum.text=doc.getElementsByTagName("hum").item(0).firstChild.nodeValue

    }

}