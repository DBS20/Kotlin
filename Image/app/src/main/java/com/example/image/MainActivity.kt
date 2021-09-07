package com.example.image

import android.content.Intent
import android.graphics.ImageDecoder
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout

class MainActivity : AppCompatActivity() {

    private lateinit var prendas: Ropa

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        prendas = Ropa()
        index = 0
        initView()


    }

    //Vista:
    private lateinit var cl_Image: ConstraintLayout

    //Componentes:
    private lateinit var btn_Preview: Button
    private lateinit var btn_Next: Button
    private lateinit var imgv_Photo: ImageView
    private lateinit var txv_subtitulo: TextView



    //Lista de prendas
    private lateinit var ropa: ArrayList<Ropa>
    //Contador
    var index = 1

    //Función Visualización
    private fun initView() {

        //Binding por ID:
        cl_Image = findViewById(R.id.cl_Image)
        txv_subtitulo = findViewById(R.id.txv_MainActSubTitulo)
        btn_Preview = findViewById(R.id.btn_Preview)
        btn_Next = findViewById(R.id.btn_Next)
        imgv_Photo = findViewById(R.id.imgv_Photo)

        //Cargar lista Prendas de Clase Ropa:
        ropa = prendas.misPrendas()


        //Cargar elemento:
        setImagePrenda()



        //Click sobre imagen para pasar a la Vista ImageInfoActivity
        imgv_Photo.setOnClickListener{
            ImageInfo()
        }

        //Funcionalidad botones: Preview y Next
        btn_Preview.setOnClickListener {

            PreviewImage(it)
        }

        btn_Next.setOnClickListener {
            NextImage(it)
        }

    }



    //Asignación de Prenda
    fun setImagePrenda(){

        imgv_Photo.setImageResource(ropa[index].img!!.resource)
        txv_subtitulo.text = ropa[index].tipo.toString()
    }



    //Función de Previa-Imagen
    fun PreviewImage(view: View) {
        if (index==0) index = ropa.size-1
        else index--
        setImagePrenda()
    }

    //Función de Siguiente-Imagen
    fun NextImage(view: View) {
        if (index== ropa.size-1 ) index=0
        else index++
        setImagePrenda()

    }

    //Función que manda el componente elegido a la otra actividad
    fun ImageInfo()
    {
        val intent = Intent(this, ImageInfoActivity::class.java)
        intent.putExtra("lista",ropa[index])
        startActivity(intent)
    }


}