package com.example.fragmentos


import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import com.squareup.moshi.Moshi


class ImageIn : Fragment(R.layout.fragment_image_in) {


    private lateinit var prendas: Ropa

    //Varibles para el uso de SharePreferences en conjunto con la libreria Moshi
    private val PREFS= "MY_PREFERENCES" // nombre de mi preferencia
    private val ROPA_PREFS= "FAV_PRENDA" // nombre prenda favorita
    private lateinit var preferences: SharedPreferences //variable global para cuando se vaya a utilizar
    private val moshi = Moshi.Builder().build()//constructor Moshi para parcear el objeto ROPA



    override fun onResume() {
        super.onResume()



        //preferences = getSharedPreferences(PREFS, Context.MODE_PRIVATE)
        //prendas = getPrendaFav()
        prendas = Ropa()
        index = 0
        initView()


        if(prendas.tipo.isNotEmpty())
            Favorito()


    }

    //Obtener Prenda
    /*private fun getPrendaFav() =
        preferences.getString(ROPA_PREFS, null)?.let {
            return@let try{
                moshi.adapter(Ropa::class.java).fromJson(it)
            }catch (e: Exception){
                Ropa()
            }
        } ?: Ropa()*/





    //Guardar favorito
    /*private fun saveFav(prenda: Ropa?=null){
        /*if (prenda != null) {
            prenda.misPrendas()
        }*/
        preferences.edit().putString(ROPA_PREFS, moshi.adapter(Ropa::class.java).toJson(prenda)).apply()

    }*/

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

    //Función Visualización
    private fun initView() {

        //Binding por ID:
        cl_Image = requireView().findViewById(R.id.cl_Image)
        txv_subtitulo = requireView().findViewById(R.id.txv_MainActSubTitulo)
        btn_Preview = requireView().findViewById(R.id.btn_Preview)
        btn_Next = requireView().findViewById(R.id.btn_Next)
        imgv_Photo = requireView().findViewById(R.id.imgv_Photo)
        btn_Fav = requireView().findViewById(R.id.btn_Fav)

        //Cargar lista Prendas de Clase Ropa:
        ropa = prendas.misPrendas()




        //Cargar elemento:
        setImagePrenda()



        //Click sobre imagen para pasar a la Vista ImageInfo
        imgv_Photo.setOnClickListener{
            (requireActivity() as MainActivity).replaceFragment(ImageInfo().apply {
                arguments = Bundle().apply {
                    putParcelable("selected Clothe", ropa[index])
                }

            })
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



    //Asignación de Prenda
    fun setImagePrenda() {

        imgv_Photo.setImageResource(ropa[index].img!!.resource)
        txv_subtitulo.text = ropa[index].tipo.toString()

        if(ropa[index].favorito==false)
        {
            btn_Fav.hint="NO"
            //btn_Fav.setBackgroundResource(R.drawable.ic_negra)
            favoritoNOfavorito=false
        }
        else
        {
            if(ropa[index].favorito==true)
            {
                btn_Fav.hint="FAV"
                //btn_Fav.setBackgroundResource(R.drawable.ic_amarilla)
                favoritoNOfavorito=true
            }
        }



    }

    fun Favorito(){

        ropa[index]?.let {

            //saveFav(it)
            if(favoritoNOfavorito==false)
            {
                favoritoNOfavorito=true
                btn_Fav.hint="FAV"
                //btn_Fav.setBackgroundResource(R.drawable.ic_amarilla)
                ropa[index].favorito=true

            }
            else
            {
                if(favoritoNOfavorito==true)
                {
                    favoritoNOfavorito=false
                    btn_Fav.hint="NO"
                    //btn_Fav.setBackgroundResource(R.drawable.ic_negra)
                    ropa[index].favorito=false

                }
            }



        }
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






}