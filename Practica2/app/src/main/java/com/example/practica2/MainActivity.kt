package com.example.practica2
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Listener
        //Nuevo
        findViewById<Button>(R.id.btn_Bebida).setOnClickListener(this::getBebidas)

        //Siguiente
        findViewById<Button>(R.id.btn_Siguiente).setOnClickListener {
            nextBebida(it)
        }

        //Anterior
        findViewById<Button>(R.id.btn_Anterior).setOnClickListener {
            previewBebida(it)
        }

        //Paquete
        findViewById<Button>(R.id.btn_Paquete).setOnClickListener {
            paqueteBebida(it)
        }

        //Tipo
        findViewById<Button>(R.id.btn_Tipo).setOnClickListener {
            tipoBebida(it)
        }
    }


    //Mi objeto BEBIDA
    class Bebida {
        var nombre: String = ""     //nombre bebida
        var precio: Double = 0.0 //precio
        var paquete: String =
            ""     //en paquete: bebida más galleta D:Disponible NA:no aplicable en la bebida
        var tipo: String = ""  //tipo: F(frio) C(caliente)

        constructor(nombre: String, precio: Double, paquete: String, tipo: String) {
            this.nombre = nombre
            this.precio = precio
            this.paquete = paquete
            this.tipo = tipo
        }
    }

    //Instancias:
    val bebida = Bebida("Explosion Chocolate", 78.15, "D", "F")
    val bebida2 = Bebida("Té frutos rojos", 53.23, "NA", "C")
    val bebida3 = Bebida("Cafe Capuccino", 47.50, "D", "C")

    //Lista: guardo mis instancias en una lista mutable
    val myMutableBebidas = arrayListOf<Bebida>(bebida, bebida2, bebida3)


    //Variables:
    //TEXTVIEW:
    lateinit var info: TextView
    var index: Int = 0
    var i = 0
    var mystatus = ""
    //Función setBebidas:
    fun setBebidad(i: Int) {
        val s = "Bebida: \n " +
                "ID: ${index}\n"+
                "Nombre: ${myMutableBebidas[i].nombre}\n " +
                "Precio: ${myMutableBebidas[i].precio}\n " +
                "Paquete: ${myMutableBebidas[i].paquete}\n " +
                "Tipo: ${myMutableBebidas[i].tipo}"
        info = findViewById(R.id.txt_Informacio)
        info.text = s.toString()
    }


    //Función getBebidas:
    fun getBebidas(view: View) {
        myMutableBebidas[index]
        i = index
        index++
        setBebidad(i)
    }

    fun nextBebida(view: View) {
        if (index < 2) {
            index++
        }
        else
        {
            if(index ==2)
            {
                index=0
            }
        }
        setBebidad(index)
    }

    fun previewBebida(view: View) {
        if (index >= 1) {
            index--
        }
        else
        {
            if(index ==0)
            {
                index=2
            }
        }
        setBebidad(index)
    }


    fun paqueteBebida(view: View) {


        if (myMutableBebidas[index].paquete == "D") {

            mystatus="D: Disponible para combo"
            Toast.makeText(this, mystatus, Toast.LENGTH_LONG).show()
        }else
        {
            if (myMutableBebidas[index].paquete == "NA") {
            mystatus="NA: No Aplicable"
            Toast.makeText(this, mystatus, Toast.LENGTH_LONG).show()}
        }
    }

    fun tipoBebida(view: View) {

        if (myMutableBebidas[index].tipo == "F") {

            mystatus="F: Bebida Fria"
            Toast.makeText(this, mystatus, Toast.LENGTH_LONG).show()
        }else
        {

            if (myMutableBebidas[index].tipo == "C")
            {
            mystatus="C: Bebida Caliente"
            Toast.makeText(this, mystatus, Toast.LENGTH_LONG).show()
            }

        }
    }
}