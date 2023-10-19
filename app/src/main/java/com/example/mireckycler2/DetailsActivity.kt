package com.example.mireckycler2

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class DetailsActivity : AppCompatActivity() {
    var imageView: ImageView? = null
    var name: TextView? = null
    var alphaName: String? = null
    var alphaTag:kotlin.String? = null
    var alphaImage = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)
        var imageView: ImageView = findViewById<ImageView>(R.id.image)
        var name: TextView = findViewById<TextView>(R.id.name)
        var alphaName: String? = null
        var alphaTag:kotlin.String? = null
        var alphaImage = 0
        //get the intent
        alphaName = getIntent().getStringExtra("name");
        alphaImage = getIntent().getIntExtra("image",0);
        name.setText(alphaName)
        imageView.setImageResource(alphaImage)
    //now set the get values in the respective widgets
        //name.text(alphaName);

        //imageView.setImageResource(alphaImage);
    }
}