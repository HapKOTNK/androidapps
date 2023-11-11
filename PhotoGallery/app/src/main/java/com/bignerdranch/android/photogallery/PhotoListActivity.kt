package com.bignerdranch.android.photogallery

import android.os.Bundle
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.room.Room
import com.bignerdranch.android.photogallery.database.PhotoDatabase
import com.bumptech.glide.Glide


class PhotoListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_photo_list)

        val linearLayout = findViewById<LinearLayout>(R.id.linearLayout)

        val db = Room.databaseBuilder(
            applicationContext,
            PhotoDatabase::class.java, "photo-db"
        ).build()

        Thread {
            val photos = db.photoDao().getAll()
            runOnUiThread {
                for (photo in photos) {
                    val imageView = ImageView(this)
                    Glide.with(this).load(photo.url).into(imageView)
                    linearLayout.addView(imageView)

                    val textView = TextView(this)
                    textView.text = photo.title
                    linearLayout.addView(textView)
                }
            }
        }.start()
    }
}