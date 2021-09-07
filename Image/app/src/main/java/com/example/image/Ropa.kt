package com.example.image

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
class Ropa (
    var img: Img?=null,
    var tipo: String = "", //tipo prenda
    var estatus: String ="", //Disponible - Proximamente
    var precio: Double = 0.0, //precio
    var talla: String ="", //XS - S - M - L - XL
    var estilo: String = "",  // casual - elegante - formal
    var composicion: String = "",  //poliester - algodón - spandex


): Parcelable {
    //Lista de prendas
    companion object {
        val listaprendas = arrayListOf<Ropa>(
            Ropa(
                img=Img.blusa1,
                "Blusa Monocolor",
                "Disponible",
                100.05,
                "XS/S/M",
                "Casual",
                " 60% políester, 30% algodón y 10% spandex"
            ),
            Ropa(
                img=Img.blusa2,
                "Top manga gigot",
                "Disponible",
                202.12,
                "XS/S/M/l",
                "Elegante",
                " 100% políester"
            ),
            Ropa(
                img=Img.vestido1,
                "Vestido con cinturon",
                "Disponible",
                285.67,
                "S/M/L",
                "Elegante",
                " 100% políester"
            ),
            Ropa(
                img=Img.blusa3,
                " -------- ",
                "Proximamente",
                00.00,
                " ",
                " ",
                " "
            ),
            Ropa(
                img=Img.vestido2,
                " -------- ",
                "Proximamente",
                00.00,
                " ",
                " ",
                " "
            )
            ,
            Ropa(
                img=Img.sudadera1,
                " -------- ",
                "Proximamente",
                00.00,
                " ",
                " ",
                " "
            )

        )
    }

    fun misPrendas() = listaprendas

}