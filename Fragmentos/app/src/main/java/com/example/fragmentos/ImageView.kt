package com.example.fragmentos

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.constraintlayout.widget.ConstraintLayout


class ImageView : Fragment(R.layout.fragment_image_view) {

    override fun onResume() {
        super.onResume()

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

        image = requireArguments().getParcelable("selected Image")?: Ropa()
        imgv_Photo3 = requireView().findViewById(R.id.imgv_Photo3)
        printImage()
    }

    fun printImage(){
        imgv_Photo3.setImageResource(image.img!!.resource)
    }

}