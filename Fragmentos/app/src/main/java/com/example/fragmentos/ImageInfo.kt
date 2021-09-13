package com.example.fragmentos

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout


class ImageInfo : Fragment(R.layout.fragment_image_info) {

    override fun onResume() {
        super.onResume()

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

        prenda = requireArguments().getParcelable("selected Clothe")?: Ropa()

        cl_ImageInfo = requireView().findViewById(R.id.cl_ImageInfo)
        imgv_Photo2 = requireView().findViewById(R.id.imgv_Photo2)
        edtxv_ImageInfoActText = requireView().findViewById(R.id.edtxv_ImageInfoActText)
        btn_View = requireView().findViewById(R.id.btn_View)


        //Click para ver la imagen
        btn_View.setOnClickListener{
            ImageViewImage()
            sound(R.raw.foto)
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

    fun ImageViewImage()
    {
        (requireActivity() as MainActivity).replaceFragment(ImageView().apply {
            arguments = Bundle().apply {
                putParcelable("selected Image", prenda)
            }

        })
    }

    fun sound(sound: Int) = (requireActivity() as MainActivity).playSound(sound)

}