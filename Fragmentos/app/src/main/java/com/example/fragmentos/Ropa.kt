package com.example.fragmentos

import android.os.Parcelable
import com.squareup.moshi.JsonClass
import kotlinx.parcelize.Parcelize

@JsonClass(generateAdapter = true)
@Parcelize
class Ropa (
    var img: Img?=null,
    var tipo: String = "", //tipo prenda
    var estatus: String ="", //Disponible - Proximamente
    var precio: Double = 0.0, //precio
    var talla: String ="", //XS - S - M - L - XL
    var estilo: String = "",  // casual - elegante - formal
    var composicion: String = "",
    var favorito:Boolean=false//poliester - algodón - spandex


): Parcelable {
    //Lista de prendas
    companion object {
        val listaprendas = arrayOf<Ropa>(
            Ropa(
                img=Img.blusa1,
                "Blusa Monocolor",
                "Disponible",
                100.05,
                "XS/S/M",
                "Casual",
                " 60% políester, 30% algodón y 10% spandex",
                false
            ),
            Ropa(
                img=Img.blusa2,
                "Top manga gigot",
                "Disponible",
                202.12,
                "XS/S/M/l",
                "Elegante",
                " 100% políester",
                false
            ),
            Ropa(
                img=Img.vestido1,
                "Vestido con cinturon",
                "Disponible",
                285.67,
                "S/M/L",
                "Elegante",
                " 100% políester",
                false
            ),
            Ropa(
                img=Img.blusa3,
                " -------- ",
                "Proximamente",
                00.00,
                " ",
                " ",
                " ",
                false
            ),
            Ropa(
                img=Img.vestido2,
                " -------- ",
                "Proximamente",
                00.00,
                " ",
                " ",
                " ",
                false
            )
            ,
            Ropa(
                img=Img.sudadera1,
                " -------- ",
                "Proximamente",
                00.00,
                " ",
                " ",
                " ",
                false
            )

        )
    }

    fun misPrendas() = listaprendas

    /*fun misPrendas() = listaprendas.firstOrNull() { (it.tipo == this.tipo &&
            it.estatus == this.estatus &&
            it.precio == this.precio &&
            it.talla == this.talla &&
            it.estilo == this.estilo &&
            it.composicion == this.composicion &&
            it.favorito == this.favorito)

    }*/


}