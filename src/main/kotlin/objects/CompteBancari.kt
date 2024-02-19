package org.example.objects


abstract class CompteBancari {
    @JvmField protected var propietari:Client = Client()
    @JvmField protected var dataObertura:Data = Data()
    @JvmField protected var nomCompte:String = ""
    @JvmField protected var saldo:Double = 0.0

    constructor(){}

    constructor(saldo:Double,propietari:Client){
        this.saldo=saldo
        this.propietari=propietari
        crearNomCompte()
    }

    fun setDataObertura(dataObertura:Data){
        this.dataObertura=dataObertura
    }
    fun getDatbertura():Data{
        return dataObertura
    }

    private fun crearNomCompte(){

        var dni = propietari.getDni()

        var clau = ""

        for (i in dni.indices){
            if (dni[i].isDigit()){
                clau+=dni[i]
            }
        }

        var clauInt = clau.toInt()

        clauInt*=2

        this.nomCompte=clauInt.toString()
    }

    fun consultarSaldo(){
        println("Hi ha un total de ${this.saldo} euros.")
    }
    fun getNomCompte():String{
        return nomCompte
    }

    fun setSaldo(saldo:Double){
        this.saldo=saldo
    }
    fun getSaldo():Double{
        return saldo
    }

    fun setPropietari(propietari: Client){
        this.propietari=propietari
    }
    fun getPropietari():Client{
        return propietari
    }

    abstract fun ingresar()
    // dataObertura:Data,saldo:Double,propietari:Client
    override fun toString(): String {
        return  "\n" +
                "Nom Compte: $nomCompte\n" +
                "Data Obertura Compte: $dataObertura\n" +
                "Saldo disponible: $saldo\n" +
                "Propietari del compte: $propietari"
        }
    }