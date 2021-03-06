package com.example.image

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.graphics.ImageDecoder
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import com.squareup.moshi.Moshi

class MainActivity : AppCompatActivity() {

    private lateinit var prendas: Ropa

    //Varibles para el uso de SharePreferences en conjunto con la libreria Moshi
    private val PREFS= "MY_PREFERENCES" // nombre de mi preferencia
    private val ROPA_PREFS= "FAV_PRENDA" // nombre prenda favorita
    private lateinit var preferences: SharedPreferences //variable global para cuando se vaya a utilizar
    private val moshi = Moshi.Builder().build()//constructor Moshi para parcear el objeto ROPA

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        preferences = getSharedPreferences(PREFS, Context.MODE_PRIVATE)
        prendas = getPrendaFav()
        prendas = Ropa()
        index = 0
        initView()


        if(prendas.tipo.isNotEmpty())
            Favorito()

    }

    //Obtener Prenda
    private fun getPrendaFav() =
        preferences.getString(ROPA_PREFS, null)?.let {
         return@let try{
            moshi.adapter(Ropa::class.java).fromJson(it)
         }catch (e: Exception){
             Ropa()
         }
        } ?: Ropa()





    //Guardar favorito
    private fun saveFav(prenda: Ropa?=null){
        /*if (prenda != null) {
            prenda.misPrendas()
        }*/
        preferences.edit().putString(ROPA_PREFS, moshi.adapter(Ropa::class.java).toJson(prenda)).apply()

    }

    //Vista:
    private lateinit var cl_Image: ConstraintLayout

    //Componentes:
    private lateinit var btn_Preview: Button
    private lateinit var btn_Next: Button
    private lateinit var imgv_Photo: ImageView
    private lateinit var txv_subtitulo: TextView
    private lateinit var btn_Fav: Button



    //Lista de prendas
    private lateinit var ropa: Array<Ropa>
    //Contador
    var index = 1
    //Boolean Fav
    var favoritoNOfavorito=false

    //Funci??n Visualizaci??n
    private fun initView() {

        //Binding por ID:
        cl_Image = findViewById(R.id.cl_Image)
        txv_subtitulo = findViewById(R.id.txv_MainActSubTitulo)
        btn_Preview = findViewById(R.id.btn_Preview)
        btn_Next = findViewById(R.id.btn_Next)
        imgv_Photo = findViewById(R.id.imgv_Photo)
        btn_Fav = findViewById(R.id.btn_Fav)

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

        //Favorito
        btn_Fav.setOnClickListener{
            Favorito()
        }

    }



    //Asignaci??n de Prenda
    fun setImagePrenda() {

        imgv_Photo.setImageResource(ropa[index].img!!.resource)
        txv_subtitulo.text = ropa[index].tipo.toString()

        if(ropa[index].favorito==false)
        {
            btn_Fav.hint="@string/nofav"
            favoritoNOfavorito=false
        }
        else
        {
            if(ropa[index].favorito==true)
            {
                btn_Fav.hint="@string/fav"
                favoritoNOfavorito=true
            }
        }



    }

    fun Favorito(){

        ropa[index]?.let {

            saveFav(it)
            if(favoritoNOfavorito==false)
            {
                favoritoNOfavorito=true
                btn_Fav.hint="@string/fav"
                ropa[index].favorito=true

            }
            else
            {
                if(favoritoNOfavorito==true)
                {
                    favoritoNOfavorito=false
                    btn_Fav.hint="@string/nofav"
                    ropa[index].favorito=false

                }
            }



        }
    }


    //Funci??n de Previa-Imagen
    fun PreviewImage(view: View) {
        if (index==0) index = ropa.size-1
        else index--
        setImagePrenda()
    }

    //Funci??n de Siguiente-Imagen
    fun NextImage(view: View) {
        if (index== ropa.size-1 ) index=0
        else index++
        setImagePrenda()

    }

    //Funci??n que manda el componente elegido a la otra actividad
    fun ImageInfo()
    {
        val intent = Intent(this, ImageInfoActivity::class.java)
        intent.putExtra("lista",ropa[index])
        startActivity(intent)
    }



}