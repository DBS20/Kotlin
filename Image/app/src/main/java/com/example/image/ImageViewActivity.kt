package com.example.image

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.constraintlayout.widget.ConstraintLayout

class ImageViewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_image_view)

        image = Ropa()
        setViewImage()
    }

    //Vista:
    private lateinit var cl_ImageView: ConstraintLayout

    //Componentes:
    private lateinit var imgv_Photo3: ImageView

    //Instancia
    private lateinit var image : Ropa

    fun setViewImage()
    {

        image = intent.getParcelableExtra("image")?: Ropa()
        imgv_Photo3 = findViewById(R.id.imgv_Photo3)
        printImage()
    }

    fun printImage(){
        imgv_Photo3.setImageResource(image.img!!.resource)
    }
}