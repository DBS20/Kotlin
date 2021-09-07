package com.example.image

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout

class ImageInfoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_image_info)

        prenda = Ropa()
        setView()
    }


    //Vista:
    private lateinit var cl_ImageInfo: ConstraintLayout

    //Componentes:
    private lateinit var btn_View: Button
    private lateinit var imgv_Photo2: ImageView
    private lateinit var edtxv_ImageInfoActText: TextView
    private lateinit var prenda : Ropa



    private fun setView()
    {
        prenda = intent.getParcelableExtra("lista")?: Ropa()

        cl_ImageInfo = findViewById(R.id.cl_ImageInfo)
        imgv_Photo2 = findViewById(R.id.imgv_Photo2)
        edtxv_ImageInfoActText = findViewById(R.id.edtxv_ImageInfoActText)
        btn_View = findViewById(R.id.btn_View)


        //Click para ver la imagen
        btn_View.setOnClickListener{
            ImageView()
        }

        printData()
    }


    private fun printData()
    {
        imgv_Photo2.setImageResource(prenda.img!!.resource)
        edtxv_ImageInfoActText.text = "Tipo: ${prenda.tipo}\n\n"+
                "Estatus: ${prenda.estatus}\n\n"+
                "Precio: ${prenda.precio}\n\n"+
                "Tallas: ${prenda.talla}\n\n"+
                "Estilo: ${prenda.estilo}\n\n"+
                "Composición: ${prenda.composicion}\n\n"

    }

    fun ImageView()
    {
        val intent = Intent(this, ImageViewActivity::class.java)
        intent.putExtra("image",prenda)
        startActivity(intent)
    }
}

