package org.example.objects

import org.example.utilidades.readFloat

class CompteCorrent : CompteBancari{

    private var comisioManteniment:Double=20.0


    constructor():super(){}

    constructor(saldo:Double,propietari:Client):super(saldo, propietari){
        this.saldo=saldo-comisioManteniment
        this.propietari=propietari
    }

    override fun ingresar() {
        var aIngresar = readFloat("Introdueix quant tiner vols ingressar","Error al tipus de dada").toDouble()

        this.saldo+=aIngresar
    }

    fun retirarCorrent(){
        var retirar = readFloat("Quants diners vols retirar?","Error al tipus de dada!").toDouble()

        this.saldo-=retirar
    }

    override fun toString(): String {
        return super.toString()+"Comisio per Manteniment: $comisioManteniment"
    }
}