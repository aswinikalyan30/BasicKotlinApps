package com.example.wallpaper

import android.app.WallpaperManager
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private lateinit var changeWallpaper: Button
    private var myWallpaperList = arrayOf(R.drawable.w1,R.drawable.w2,R.drawable.w3,R.drawable.w4)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        changeWallpaper = findViewById(R.id.ButtonID);
        changeWallpaper.setOnClickListener{setWallpaper()}
    }
    private fun setWallpaper() {
        Handler().postDelayed({
            for (i in myWallpaperList) {
                val bitmap: Bitmap =
                    BitmapFactory.decodeResource(resources, i)
                val wallpaperManager = WallpaperManager.getInstance(baseContext)
                wallpaperManager.setBitmap(bitmap)
            }
        },1000);

    }
}