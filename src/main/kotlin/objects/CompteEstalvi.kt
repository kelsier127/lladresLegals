package org.example.objects

import org.example.utilidades.readFloat

class CompteEstalvi : CompteBancari{

    private var interes:Int=4

    constructor():super(){}

    constructor(saldo:Double,propietari:Client):super(saldo, propietari){
        this.saldo=saldo
        this.propietari=propietari
    }

    override fun ingresar() {
        var aIngresar = readFloat("Introdueix quant tiner vols ingressar","Error al tipus de dada").toDouble()

        this.saldo+=(aIngresar-(aIngresar*interes/100.0))
    }

    fun getInteres():String{
        return "${interes}%"
    }

    fun setInteres(interes: Int){
        this.interes=interes
    }

    override fun toString(): String {
        return super.toString()+"Interes: ${this.interes}%"
    }


}